package com.orhonit.common.utils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * HttpClient工具包
 * @author 池永福
 * @date 2018年3月28日 上午8:58:05
 */
public class HttpClientUtil {

	
	/**
	 * 发送get请求
	 * @param url 请求地址
	 * @param data	请求数据
	 * @return	String 
	 */
	public static String sendGet(String url, String data) {
		
		// 创建一个httpclient对象
		CloseableHttpClient http = HttpClients.createDefault();
		// 创建一个Httpget请求对象
		HttpGet get = new HttpGet();
		URI uri = null;
		try {
			uri = new URI(url);
		} catch (URISyntaxException e) {
			return null;
		}
		// get请求设置url
		get.setURI(uri);
		String responseString = null;
		try {
			// 通过httpclient对象执行get请求
			CloseableHttpResponse response = http.execute(get);
			// 接收返回对象 httpEntity
			HttpEntity entity = response.getEntity();
			// 通过EntityUtils获取响应内容
			responseString = EntityUtils.toString(entity);
		} catch (ClientProtocolException e) {
		} catch (IOException e) {
		}
		return responseString;
	}

	
	/**
	 * 发送post请求
	 * @param reqURL
	 * @param data
	 * @param encodeCharset
	 * @param authorization
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static String sendPost(String reqURL, String data, String encodeCharset,String authorization){
		HttpPost httpPost = new HttpPost(reqURL);
        HttpClient client = HttpClients.createDefault();
        HttpResponse response = null;
        String result = "";
        try {
        	//post设置data
             StringEntity entity = new StringEntity(data, encodeCharset);
             //设置contextTyle为json
             entity.setContentType("application/json");
             httpPost.setEntity(entity);
             httpPost.setHeader("Authorization",authorization.trim());
             response = client.execute(httpPost);
             result = EntityUtils.toString(response.getEntity(), encodeCharset);
        } catch (Exception e) {
        }finally{
            client.getConnectionManager().shutdown();
        }
        return result;
	}

}
