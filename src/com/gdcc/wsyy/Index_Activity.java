package com.gdcc.wsyy;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Index_Activity extends Activity {
	private static final int PHOTO_CAPTURE = 0x11;
	private static String photoPath = "/sdcard/AnBo/";
	private static String photoName = photoPath + "laolisb.jpg";
	Uri imageUri = Uri.fromFile(new File(Environment
			.getExternalStorageDirectory(), "image.jpg"));
	private Button photo, sc_photo;
	private ImageView img_photo;

	private String newName = "laoli.jpg";
	private String uploadFile = "/sdcard/AnBo/laolisb.jpg";
	private String actionUrl = "http://localhost:8888/Photo/photoServlet";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.index);
		photo = (Button) findViewById(R.id.photo);
		sc_photo = (Button) findViewById(R.id.sc_photo);
		sc_photo.setOnClickListener(new sc_photo());
		img_photo = (ImageView) findViewById(R.id.imt_photo);
		// android.os.NetworkOnMainThreadException
		StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
				.detectDiskReads()
				.detectDiskWrites()
				.detectNetwork() 
				.penaltyLog()
				.build());
		StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
				.detectLeakedSqlLiteObjects()
				.penaltyLog()
				.penaltyDeath()
				.build());

		photo.setOnClickListener(new photo());
	}

	class sc_photo implements View.OnClickListener {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			dialog();
		}

	}

	class photo implements View.OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
			File file = new File(photoPath);
			if (!file.exists()) { // ���ͼƬ��ŵ��ļ����Ƿ����
				file.mkdir(); // �����ڵĻ� �����ļ���
			}
			File photo = new File(photoName);
			imageUri = Uri.fromFile(photo);
			intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri); // �����ͽ��ļ��Ĵ洢��ʽ��uriָ������CameraӦ����
			startActivityForResult(intent, PHOTO_CAPTURE);

		}

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		String sdStatus = Environment.getExternalStorageState();
		switch (requestCode) {
		case PHOTO_CAPTURE:
			if (!sdStatus.equals(Environment.MEDIA_MOUNTED)) {
				Log.i("�ڴ濨����", "���������ڴ濨");
			} else {
				BitmapFactory.Options op = new BitmapFactory.Options();
				// ����ͼƬ�Ĵ�С
				Bitmap bitMap = BitmapFactory.decodeFile(photoName);
				int width = bitMap.getWidth();
				int height = bitMap.getHeight();
				// ������Ҫ�Ĵ�С
				int newWidth = 480;
				int newHeight = 640;
				// �������ű���
				float scaleWidth = ((float) newWidth) / width;
				float scaleHeight = ((float) newHeight) / height;
				// ȡ����Ҫ���ŵ�matrix����
				Matrix matrix = new Matrix();
				matrix.postScale(scaleWidth, scaleHeight);
				// �õ��µ�ͼƬ
				bitMap = Bitmap.createBitmap(bitMap, 0, 0, width, height,
						matrix, true);
				// canvas.drawBitmap(bitMap, 0, 0, paint)
				// ��ֹ�ڴ����
				op.inSampleSize = 4; // �������Խ��,ͼƬ��СԽС.
				Bitmap pic = null;
				pic = BitmapFactory.decodeFile(photoName, op);
				img_photo.setImageBitmap(pic); // ���ImageView��������ɺ���ʾͼƬ
				FileOutputStream b = null;
				;
				try {
					b = new FileOutputStream(photoName);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				if (pic != null) {
					pic.compress(Bitmap.CompressFormat.JPEG, 50, b);
				}
			}
			break;
		default:
			return;
		}
	}

	protected void dialog() {
		AlertDialog.Builder builder = new Builder(Index_Activity.this);
		builder.setMessage("ȷ���ϴ�ͼƬ��");

		builder.setTitle("��ʾ");

		builder.setPositiveButton("ȷ��", new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				uploadFile();
			}
		});
		builder.setNegativeButton("ȡ��", new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();

			}
		});
		builder.create().show();
	}

	/* �ϴ��ļ���Server�ķ��� */
	private void uploadFile() {
		System.out.print("���ڷ�������");
		String end = "\r\n";
		String twoHyphens = "--";
		String boundary = "*****";
		try {
			URL url = new URL(actionUrl);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			/* ����Input��Output����ʹ��Cache */
			con.setDoInput(true);
			con.setDoOutput(true);
			con.setUseCaches(false);
			/* ���ô��͵�method=POST */
			con.setRequestMethod("POST");
			/* setRequestProperty */
			con.setRequestProperty("Connection", "Keep-Alive");
			con.setRequestProperty("Charset", "UTF-8");
			con.setRequestProperty("Content-Type",
					"multipart/form-data;boundary=" + boundary);
			/* ����DataOutputStream */
			DataOutputStream ds = new DataOutputStream(con.getOutputStream());
			ds.writeBytes(twoHyphens + boundary + end);
			ds.writeBytes("Content-Disposition: form-data; "
					+ "name=\"file1\";filename=\"" + newName + "\"" + end);
			ds.writeBytes(end);
			/* ȡ���ļ���FileInputStream */
			FileInputStream fStream = new FileInputStream(uploadFile);
			/* ����ÿ��д��1024bytes */
			System.out.print("�Ѿ��ҵ��������ڷ��ͣ�");
			int bufferSize = 1024*10;
			byte[] buffer = new byte[bufferSize];
			int length = -1;
			/* ���ļ���ȡ������������ */
			while ((length = fStream.read(buffer)) != -1) {
				/* ������д��DataOutputStream�� */
				ds.write(buffer, 0, length);
			}
			ds.writeBytes(end);
			ds.writeBytes(twoHyphens + boundary + twoHyphens + end);
			/* close streams */
			fStream.close();
			ds.flush();
			/* ȡ��Response���� */
			InputStream is = con.getInputStream();
			int ch;
			StringBuffer b = new StringBuffer();
			while ((ch = is.read()) != -1) {
				b.append((char) ch);
			}
			/* ��Response��ʾ��Dialog */
			showDialog("�ϴ��ɹ�");
			/* �ر�DataOutputStream */
			ds.close();
		} catch (Exception e) {
			System.out.print("��������쳣��");
			showDialog("�ϴ�ʧ��");
			e.printStackTrace();
		}
	}
	/* ��ʾDialog��method */
	private void showDialog(String mess) {
		new AlertDialog.Builder(Index_Activity.this).setTitle("��ʾ")
				.setMessage(mess)
				.setNegativeButton("ȷ��", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
					}
				}).show();
	}

	//@Override
	/*public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.index_, menu);
		return true;
	}*/

}
