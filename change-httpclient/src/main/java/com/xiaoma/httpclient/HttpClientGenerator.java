package com.xiaoma.httpclient;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.DefaultHostnameVerifier;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.protocol.HttpContext;
import org.apache.http.ssl.SSLContexts;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.X509Certificate;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * httpclient 连接池封装类
 */
public class HttpClientGenerator {

    private static final HttpClientBuilder httpDefaultClientBuilder = HttpClients.custom();

    private static final HttpClientBuilder httpSocketClientBuilder = HttpClients.custom();

    public static void initConnectionManager()  {
        try {
            // 信任所有
            X509TrustManager trustManager = new X509TrustManager() {
                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                @Override
                public void checkClientTrusted(X509Certificate[] xcs, String str) {
                }

                @Override
                public void checkServerTrusted(X509Certificate[] xcs, String str) {
                }
            };
            SSLContext sslContext = SSLContext.getInstance(SSLConnectionSocketFactory.TLS);
            sslContext.init(null, new TrustManager[]{trustManager}, null);
            // ALLOW_ALL_HOSTNAME_VERIFIER:这个主机名验证器基本上是关闭主机名验证的,实现的是一个空操作，并且不会抛出javax.net.ssl.SSLException异常。
            Registry<ConnectionSocketFactory> reg = RegistryBuilder.<ConnectionSocketFactory>create()
                    .register("http", new MyConnectionSocketFactory())
                    .register("https", new SocksSSLConnectionSocketFactory(SSLContexts.createSystemDefault(),
                            new DefaultHostnameVerifier()))
                    .build();

            Registry<ConnectionSocketFactory> regDefault = RegistryBuilder.<ConnectionSocketFactory>create()
                    .register("http", PlainConnectionSocketFactory.INSTANCE)
                    .register("https", new SSLConnectionSocketFactory(sslContext, NoopHostnameVerifier.INSTANCE))
                    .build();
            PoolingHttpClientConnectionManager connectionDefaultManager = new PoolingHttpClientConnectionManager(regDefault);
            PoolingHttpClientConnectionManager connectionSocketManager = new PoolingHttpClientConnectionManager(reg);
            configHttpClientBuild(connectionDefaultManager, httpDefaultClientBuilder);
            configHttpClientBuild(connectionSocketManager, httpSocketClientBuilder);
            System.out.println("httpclient init done!");
        } catch (Exception e) {
            System.out.println("initConnectionManager error:" + JSON.toJSONString(e));
        }

    }

    private static void configHttpClientBuild(PoolingHttpClientConnectionManager connectionManager, HttpClientBuilder httpClientBuilder) {
        connectionManager.setDefaultMaxPerRoute(64);
        connectionManager.setMaxTotal(500);
        httpClientBuilder
                .setConnectionManager(connectionManager)
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectionRequestTimeout(60 * 1000)
                        .setConnectTimeout(60 * 1000)
                        .setSocketTimeout(60 * 1000)
                        .build())
                .evictExpiredConnections()
                .evictIdleConnections(10L, TimeUnit.SECONDS)
                .setDefaultSocketConfig(SocketConfig.custom()
                        .setSoKeepAlive(true)
                        .setTcpNoDelay(true)
                        .setSoTimeout(60 * 1000)
                        .build());
    }



    public static CloseableHttpClient getClient(Site site) {
        if (site.getUserAgent() != null) {

            httpSocketClientBuilder.setUserAgent(site.getUserAgent());
        } else {
            httpSocketClientBuilder.setUserAgent("");
        }
        return httpSocketClientBuilder.build();
    }

    public static CloseableHttpClient getClient(Site site, Proxy proxy) {

        if (proxy != null && proxy.getScheme().toUpperCase().contains(java.net.Proxy.Type.SOCKS.name())) {
            return HttpClientGenerator.getSocketClient(site, proxy);
        } else {
            return HttpClientGenerator.getDefaultClient(site, proxy);
        }

    }

    private static CloseableHttpClient getDefaultClient(Site site, Proxy proxy) {
        if(proxy != null) {
            HttpHost httpHostProxy = new HttpHost(proxy.getHost(), proxy.getPort(), proxy.getScheme());
            CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
            credentialsProvider.setCredentials(new AuthScope(httpHostProxy), new UsernamePasswordCredentials(proxy.getUsername(), proxy.getPassword()));
            httpDefaultClientBuilder.setDefaultCredentialsProvider(credentialsProvider);
            httpDefaultClientBuilder.setProxy(httpHostProxy);
        }
        if (site.getUserAgent() != null) {

            httpDefaultClientBuilder.setUserAgent(site.getUserAgent());
        } else {
            httpDefaultClientBuilder.setUserAgent("");
        }
        return httpDefaultClientBuilder.build();
    }

    private static CloseableHttpClient getSocketClient(Site site, Proxy proxy) {
        if (site.getUserAgent() != null) {

            httpSocketClientBuilder.setUserAgent(site.getUserAgent());
        } else {
            httpSocketClientBuilder.setUserAgent("");
        }
        return httpSocketClientBuilder.build();
    }


    static class MyConnectionSocketFactory extends PlainConnectionSocketFactory {
        @Override
        public Socket createSocket(final HttpContext context) throws IOException {
            InetSocketAddress socksAddr = (InetSocketAddress) context.getAttribute("socks.address");
            if (Objects.nonNull(socksAddr)) {
                java.net.Proxy proxy = new java.net.Proxy(java.net.Proxy.Type.SOCKS, socksAddr);
                return new Socket(proxy);
            } else {
                return new Socket();
            }
        }

        @Override
        public Socket connectSocket(int connectTimeout, Socket socket, HttpHost host, InetSocketAddress remoteAddress,
                                    InetSocketAddress localAddress, HttpContext context) throws IOException {
            // Convert address to unresolved
            InetSocketAddress unresolvedRemote = InetSocketAddress
                    .createUnresolved(host.getHostName(), remoteAddress.getPort());
            return super.connectSocket(connectTimeout, socket, host, unresolvedRemote, localAddress, context);
        }
    }

    static class SocksSSLConnectionSocketFactory extends SSLConnectionSocketFactory {

        public SocksSSLConnectionSocketFactory(SSLContext sslContext, HostnameVerifier hostnameVerifier) {
            super(sslContext, hostnameVerifier);
        }

        @Override
        public Socket createSocket(HttpContext context) throws IOException {
            InetSocketAddress socksAddr = (InetSocketAddress) context.getAttribute("socks.address");
            if (Objects.nonNull(socksAddr)) {
                java.net.Proxy proxy = new java.net.Proxy(java.net.Proxy.Type.SOCKS, socksAddr);
                return new Socket(proxy);
            } else {
                return super.createSocket(context);
            }
        }

        @Override
        public Socket connectSocket(int connectTimeout, Socket socket, HttpHost host, InetSocketAddress remoteAddress,
                                    InetSocketAddress localAddress, HttpContext context) throws IOException {
            InetSocketAddress socksAddr = (InetSocketAddress) context.getAttribute("socks.address");
            if (socksAddr != null) {//make proxy server to resolve host in http url
                remoteAddress = InetSocketAddress.createUnresolved(host.getHostName(), host.getPort());
            }
            return super.connectSocket(connectTimeout, socket, host, remoteAddress, localAddress, context);
        }
    }
}
