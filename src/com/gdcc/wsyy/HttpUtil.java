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
	/* URL ����  */
	public static final String URL = "http://localhost:8888/doctor/";
	
	/* ͨ��URL��� httpGet����  */
	public static HttpGet getHttpGet (String url)
	{
		HttpGet request = new HttpGet(url);
		return request;
	}
	
	/* ͨ��URL��� httpPost����  */
	public static HttpPost getHttpPost(String url)
	{
		HttpPost request = new HttpPost(url);
		return request;
	}
	
	/* ͨ��HttpGet��� httpResponse����  */
	public static HttpResponse getHttpResponse(HttpGet request) throws ClientProtocolException, IOException
	{
		HttpResponse response = new DefaultHttpClient().execute(request);
		return response;
	}
	
	/* ͨ��HttpPost��� httpResponse����  */
	public static HttpResponse getHttpResponse(HttpPost request) throws ClientProtocolException, IOException
	{
		HttpResponse response = new DefaultHttpClient().execute(request);
		return response;
	}
	
	
	/* ͨ��URL����post����, ����������     */
	public static String queryStringForPost(String url)
	{
		//���HttpPostʵ��
		HttpPost request = HttpUtil.getHttpPost(url);
		String result = null;
		
		try
		{
			//���HttpResponseʵ��
			HttpResponse response = HttpUtil.getHttpResponse(request);
			//�ж������Ƿ�ɹ�
			if(response.getStatusLine().getStatusCode() == 200)
			{
				//����������
				result = EntityUtils.toString(response.getEntity());
				return result;
			}
		}catch(ClientProtocolException e)
		{
			e.printStackTrace();
			result = "�����쳣";
			return result;
		}
		catch(IOException e)
		{
			e.printStackTrace();
			result = "�����쳣";
			return result;
		}
		return null;
	}
	
	/* ͨ��HttpPost����get����, ����������     */
	public static String queryStringForGet(String url)
	{
		//���HttpGetʵ��
		HttpGet request = HttpUtil.getHttpGet(url);
		String result = null;
		
		try
		{
			//���HttpResponseʵ��
			HttpResponse response = HttpUtil.getHttpResponse(request);
			//�ж������Ƿ�ɹ�
			if(response.getStatusLine().getStatusCode() == 200)
			{
				//����������
				result = EntityUtils.toString(response.getEntity());
				return result;
			}
		}catch(ClientProtocolException e)
		{
			e.printStackTrace();
			result = "�����쳣";
			return result;
		}catch(IOException e)
		{
			e.printStackTrace();
			result = "�����쳣";
			return result;
		}
		return null;
	}
	
	/* ͨ��HttpPost����post����, ����������     */
	public static String queryStringForPost(HttpPost request)
	{
		//���صĽ���ַ�
		String result = "";
		
		try
		{
			//���HttpResponseʵ��
			HttpResponse response = HttpUtil.getHttpResponse(request);
			//�ж������Ƿ�ɹ�
			if(response.getStatusLine().getStatusCode() == 200)
			{
				//����������
				result = EntityUtils.toString(response.getEntity());
				return result;
			}
		}catch(ClientProtocolException e)
		{
			e.printStackTrace();
			result = "�����쳣";
			return result;
		}catch(IOException e)
		{
			e.printStackTrace();
			result = "�����쳣";
			return result;
		}
		
		return null;
	}

	private EditText txPassword;
	
	
}


