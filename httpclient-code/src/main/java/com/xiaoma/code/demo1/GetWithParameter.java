package com.xiaoma.code.demo1;

import com.alibaba.fastjson.JSON;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class GetWithParameter {

    public static void main(String[] args) throws IOException, URISyntaxException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet();
        URIBuilder builder = new URIBuilder("https://browserapi.manomano.fr/api/v1/products/17833277/models");
        List<NameValuePair> valuePairs = new ArrayList<>();
        BasicNameValuePair pair1 = new BasicNameValuePair("platform", "fr");
        BasicNameValuePair pair2 = new BasicNameValuePair("is_pro", "false");
        BasicNameValuePair pair3 = new BasicNameValuePair("model_id", "17831279");
        BasicNameValuePair pair4 = new BasicNameValuePair("use_rhino", "true");
        valuePairs.add(pair1);
        valuePairs.add(pair2);
        valuePairs.add(pair3);
        valuePairs.add(pair4);
        builder.addParameters(valuePairs);
        httpGet.setURI(builder.build());
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == 200) {
                System.out.println(JSON.toJSONString(response));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                response.close();
            }
        }
        httpClient.close();
    }
}
