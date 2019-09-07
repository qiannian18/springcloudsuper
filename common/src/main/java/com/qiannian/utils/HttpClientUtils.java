package com.qiannian.utils;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import com.alibaba.fastjson.JSONObject;

/**
 * @author chensiyu
 */
public class HttpClientUtils {

    public static String doGet(String url, Map<String, String> param,
                               Map<String, String> header) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String resultString = "";
        CloseableHttpResponse respons = null;
        try {
            URIBuilder uriBuilder = new URIBuilder(url);
            if (param != null) {
                for (String s : param.keySet()) {
                    uriBuilder.addParameter(s, param.get(s));
                }
            }
            URI uri = uriBuilder.build();
            HttpGet httpGet = new HttpGet(uri);
            if (header != null) {
                for (String key : header.keySet()) {
                    httpGet.setHeader(key, header.get(key));
                }
            }
            respons = httpClient.execute(httpGet);
            resultString = EntityUtils.toString(respons.getEntity(), "UTF-8");

        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (respons != null) {
                    respons.close();
                }
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return resultString;
    }

    /**
     * post json 格式
     *
     * @param url
     * @param param
     * @param header
     * @param isJson
     * @return
     */
    public static String doPost(String url, Map<String, String> param,
                                Map<String, String> header, boolean isJson) {
        System.out.println(url);
        CloseableHttpClient httpClient = HttpClients.createDefault();
        RequestConfig config = RequestConfig.custom().setConnectTimeout(5000)
                .setConnectionRequestTimeout(5000).setSocketTimeout(10000)
                .build();
        CloseableHttpResponse response = null;
        String resultString = "";
        try {
            HttpPost httpPost = new HttpPost(url);
            httpPost.setConfig(config);

            if (param != null) {
                if (isJson) {
                    StringEntity stringEntity = new StringEntity(
                            JSONObject.toJSONString(param), "UTF-8");
                    httpPost.setEntity(stringEntity);
                } else {
                    List<NameValuePair> paramList = new ArrayList<NameValuePair>();
                    for (String key : param.keySet()) {
                        paramList.add(new BasicNameValuePair(key,
                                (String) param.get(key)));
                    }
                    UrlEncodedFormEntity entity = new UrlEncodedFormEntity(
                            paramList);
                    httpPost.setEntity(entity);
                }
            }
            if (header != null) {
                for (String key : header.keySet()) {
                    httpPost.setHeader(key, header.get(key));
                }
            }
            response = httpClient.execute(httpPost);
            resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return resultString;
    }

    /**
     * 新版本的http
     *
     * @param url
     * @param param
     * @param header
     * @param isJson
     * @return
     */
    public static String doPostNew(String url, Map<String, String> param, Map<String, String> header, boolean isJson) {

        CloseableHttpClient httpClient = null;
        HttpPost httpPost = null;
        String resultString = null;
        try {
            CookieStore cookieStore = new BasicCookieStore();
            httpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
            httpPost = new HttpPost(url);
            ArrayList<NameValuePair> list = new ArrayList<NameValuePair>();
            if (param != null) {
                if (isJson) {
                    StringEntity stringEntity = new StringEntity(
                            JSONObject.toJSONString(param), "UTF-8");
                    httpPost.setEntity(stringEntity);
                } else {
                    for (String key : param.keySet()) {
                        httpPost.setHeader(key, param.get(key));
                    }
                    UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, "UTF-8");
                    httpPost.setEntity(entity);
                }

            }
            if (header != null) {
                for (String key : header.keySet()) {
                    httpPost.setHeader(key, header.get(key));
                }
            }
            CloseableHttpResponse response = httpClient.execute(httpPost);
            resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
            List<Cookie> cookies = cookieStore.getCookies();
            System.out.println("这是返回的cookie=="+cookies.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultString;
    }


}
