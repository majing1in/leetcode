package com.xiaoma.code.demo1;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public class GetWithoutParameter {

    public static void main(String[] args) throws IOException {
        // 创建 httpclient 对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 创建 get 请求对象
        HttpGet httpGet = new HttpGet("https://www.tidebuy.com/c/Flat-Sandals-106197");
        CloseableHttpResponse response = null;
        try {
            // 执行 get 请求
            response = httpClient.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == 200) {
                System.out.println(JSON.toJSONString(response));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ObjectUtil.isNotNull(response)) {
                response.close();
            }
        }
        httpClient.close();
    }
}
