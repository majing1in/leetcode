package com.xiaoma.httpclient;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.http.MediaType;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author xls
 */
public class HttpRequestBody implements Serializable {

    private static final long serialVersionUID = 5659170945717023595L;

    private byte[] body;

    private String contentType;

    private String encoding;

    public HttpRequestBody(byte[] body, String contentType, String encoding) {
        this.body = body;
        this.contentType = contentType;
        this.encoding = encoding;
    }

    public HttpRequestBody() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public byte[] getBody() {
        return body;
    }

    public void setBody(byte[] body) {
        this.body = body;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public static HttpRequestBody json(String json, String encoding) {
        try {
            return new HttpRequestBody(json.getBytes(encoding), MediaType.APPLICATION_JSON_VALUE, encoding);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException("illegal encoding " + encoding, e);
        }
    }

    public static HttpRequestBody xml(String xml, String encoding) {
        try {
            return new HttpRequestBody(xml.getBytes(encoding), MediaType.TEXT_HTML_VALUE, encoding);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException("illegal encoding " + encoding, e);
        }
    }

    public static HttpRequestBody custom(byte[] body, String contentType, String encoding) {
        return new HttpRequestBody(body, contentType, encoding);
    }

    public static HttpRequestBody form(Map<String, Object> params, String encoding) {
        List<NameValuePair> nameValuePairs = new ArrayList<>(params.size());
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            nameValuePairs.add(new BasicNameValuePair(entry.getKey(), String.valueOf(entry.getValue())));
        }
        try {
            return new HttpRequestBody(URLEncodedUtils.format(nameValuePairs, encoding).getBytes(encoding), MediaType.APPLICATION_FORM_URLENCODED_VALUE, encoding);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException("illegal encoding " + encoding, e);
        }
    }
}
