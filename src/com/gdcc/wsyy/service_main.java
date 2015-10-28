package com.gdcc.wsyy;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zixun.vvv;
import com.gdcc.wsyy.data.Changer;
import com.gdcc.wsyy.data.model;
import com.gdcc.wsyy.data.utils;

public class service_main extends Fragment {

	EditText SearEdit;
	ImageView SearchB;
	String bb;
	String yym;
	TextView FJYY, WENDA,CCSS,XLZX,JKTS;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.service_m_main, null);
		SearchB = (ImageView) view.findViewById(R.id.iv_search);
		SearEdit = (EditText) view.findViewById(R.id.et_search);
		FJYY = (TextView) view.findViewById(R.id.fjyy);
		WENDA = (TextView) view.findViewById(R.id.newda);
		CCSS = (TextView) view.findViewById(R.id.ccss);
		XLZX = (TextView) view.findViewById(R.id.XLZX);
		JKTS = (TextView) view.findViewById(R.id.JKTS);

		WENDA.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				Intent intentnn = new Intent(getActivity(), vvv.class);
                         intentnn.putExtra("title", "最近问答");
				         startActivity(intentnn);
			}
		});
		
		CCSS.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				Intent intentcs = new Intent(getActivity(), vvv.class);
                         intentcs.putExtra("title", "健康常识");
				         startActivity(intentcs);
			}
		});
		
		XLZX.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				Intent intentX = new Intent(getActivity(), vvv.class);
                         intentX.putExtra("title", "心理咨询");
				         startActivity(intentX);
			}
		});
		
		JKTS.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				Intent intentj = new Intent(getActivity(), vvv.class);
                         intentj.putExtra("title", "健康图书");
				         startActivity(intentj);
			}
		});
		
		
		
		
		

		// 加载地图
		FJYY.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent intent = new Intent(getActivity(),
						NearbyMapActivity.class);

				startActivity(intent);

			}
		});

		SearchB.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				yym = SearEdit.getText().toString();

				Changer changer = new Changer();
				try {
					bb = changer.Changerr(yym);

				} catch (UnsupportedEncodingException e1) {

					e1.printStackTrace();
				}
				Intent intentyy = new Intent(getActivity(), YyUI.class);
				intentyy.putExtra("yname", bb);
				startActivity(intentyy);

			}
		});

		return view;

	}

}
