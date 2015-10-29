package com.example.zixun;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gdcc.wsyy.R;


public class newadapter extends BaseAdapter {

	private Context context;
	private List<Model> news;

	public newadapter(Context context, List<Model> news) {
		this.context = context;
		this.news = news;
	}

	@Override
	public int getCount() {

		return news.size();
	}

	@Override
	public Model getItem(int position) {

		return news.get(position);
	}

	@Override
	public long getItemId(int position) {

		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {

			convertView = LayoutInflater.from(context).inflate(
					R.layout.list_raw, null);
		}

		TextView tt = (TextView) convertView.findViewById(R.id.title);
		TextView kk = (TextView) convertView.findViewById(R.id.keywords);
		TextView idd = (TextView) convertView.findViewById(R.id.duration);
		ImageView img = (ImageView) convertView.findViewById(R.id.list_image);
		Model mm = news.get(position);
		tt.setText(mm.getTitle());
		kk.setText(mm.getKeywords());
		idd.setText(mm.getId());
		String imgurl = mm.getImg();
		String imgurl1 = "http://tnfs.tngou.net/image" + imgurl;
		// Toast.makeText(context,imgurl1,Toast.LENGTH_LONG).show();
		// HealApi.setimg(img, imgurl1);

		return convertView;
	}

}
