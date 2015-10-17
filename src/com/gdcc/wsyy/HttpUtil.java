package com.gdcc.wsyy;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.widget.EditText;

public class HttpUtil {
	/* URL 常量  */
	public static final String URL = "http://localhost:8888/doctor/";
	
	/* 通过URL获得 httpGet对象  */
	public static HttpGet getHttpGet (String url)
	{
		HttpGet request = new HttpGet(url);
		return request;
	}
	
	/* 通过URL获得 httpPost对象  */
	public static HttpPost getHttpPost(String url)
	{
		HttpPost request = new HttpPost(url);
		return request;
	}
	
	/* 通过HttpGet获得 httpResponse对象  */
	public static HttpResponse getHttpResponse(HttpGet request) throws ClientProtocolException, IOException
	{
		HttpResponse response = new DefaultHttpClient().execute(request);
		return response;
	}
	
	/* 通过HttpPost获得 httpResponse对象  */
	public static HttpResponse getHttpResponse(HttpPost request) throws ClientProtocolException, IOException
	{
		HttpResponse response = new DefaultHttpClient().execute(request);
		return response;
	}
	
	
	/* 通过URL发送post请求, 返回请求结果     */
	public static String queryStringForPost(String url)
	{
		//获得HttpPost实例
		HttpPost request = HttpUtil.getHttpPost(url);
		String result = null;
		
		try
		{
			//获得HttpResponse实例
			HttpResponse response = HttpUtil.getHttpResponse(request);
			//判断请求是否成功
			if(response.getStatusLine().getStatusCode() == 200)
			{
				//返回请求结果
				result = EntityUtils.toString(response.getEntity());
				return result;
			}
		}catch(ClientProtocolException e)
		{
			e.printStackTrace();
			result = "网络异常";
			return result;
		}
		catch(IOException e)
		{
			e.printStackTrace();
			result = "网络异常";
			return result;
		}
		return null;
	}
	
	/* 通过HttpPost发送get请求, 返回请求结果     */
	public static String queryStringForGet(String url)
	{
		//获得HttpGet实例
		HttpGet request = HttpUtil.getHttpGet(url);
		String result = null;
		
		try
		{
			//获得HttpResponse实例
			HttpResponse response = HttpUtil.getHttpResponse(request);
			//判断请求是否成功
			if(response.getStatusLine().getStatusCode() == 200)
			{
				//返回请求结果
				result = EntityUtils.toString(response.getEntity());
				return result;
			}
		}catch(ClientProtocolException e)
		{
			e.printStackTrace();
			result = "网络异常";
			return result;
		}catch(IOException e)
		{
			e.printStackTrace();
			result = "网络异常";
			return result;
		}
		return null;
	}
	
	/* 通过HttpPost发送post请求, 返回请求结果     */
	public static String queryStringForPost(HttpPost request)
	{
		//返回的结果字符
		String result = "";
		
		try
		{
			//获得HttpResponse实例
			HttpResponse response = HttpUtil.getHttpResponse(request);
			//判断请求是否成功
			if(response.getStatusLine().getStatusCode() == 200)
			{
				//返回请求结果
				result = EntityUtils.toString(response.getEntity());
				return result;
			}
		}catch(ClientProtocolException e)
		{
			e.printStackTrace();
			result = "网络异常";
			return result;
		}catch(IOException e)
		{
			e.printStackTrace();
			result = "网络异常";
			return result;
		}
		
		return null;
	}

	private EditText txPassword;
	
	
}


