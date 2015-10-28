package com.gdcc.wsyy;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;





@SuppressLint("SetJavaScriptEnabled")
public class new_main extends Fragment {
	
	private WebSettings ws;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View view=inflater.inflate(R.layout.new_m_main,null);
		WebView wv=(WebView) view.findViewById(R.id.webView1);			       
//		ws.setSupportZoom(true);
//		ws.setBuiltInZoomControls(true);
//		ws.setJavaScriptEnabled(true);
		wv.setWebChromeClient(new WebChromeClient());
		wv.loadUrl("http://yd.sina.cn/media.d.html?vt=4&pos=42&media=awzuney3978837");
		wv.setWebViewClient(new WebViewClient());	
		return view;
	}
}
