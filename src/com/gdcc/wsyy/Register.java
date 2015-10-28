package com.gdcc.wsyy;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class Register extends Activity{
	private EditText username, password,cpassword;
	private Button register;
	  ImageView loginback;
	  protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			setContentView(R.layout.login_in);
			username = (EditText) findViewById(R.id.username);
			password = (EditText) findViewById(R.id.password);
			cpassword = (EditText) findViewById(R.id.cpassword);
	        register = (Button) findViewById(R.id.register);
	        loginback=(ImageView)findViewById(R.id.login_back);
	    register.setOnClickListener(new View.OnClickListener() {
	    	   public void onClick(View v){ 
	   	    } 
	   	});

	     register.setOnClickListener(new View.OnClickListener(){ 
	 	      @Override 

	       
				public void onClick(View v) {
	 	    	 if(validate())
					{
	 	    		System.out.println("shagua");
						//��¼
						if(login())
						{
							System.out.println("bendan");
							Intent intent = new Intent(Register.this, MainActivity.class);
							startActivity(intent);
							//login.this.finish();
						}
						else
						{
							showDialog("�û����������������������");
						}
					}
				}
			});
	       loginback.setOnClickListener(new OnClickListener()  
	       {  
	           @Override  
	           public void onClick(View v)  
	           {  
	           	finish();

	           	
	           }  
	       });  

		}


	private void showDialog(String msg) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage(msg).setPositiveButton("ȷ��",
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {

					}
				});
		AlertDialog ad = builder.create();
		ad.show();
	}
	/* ���û�����������зǿ���֤ */
	private boolean validate() {
		String name = username.getText().toString();
		if (name.equals("")) {
			showDialog("�û�������Ϊ��");
			return false;
		}
		String pwd = password.getText().toString();
		if (pwd.equals("")) {
			showDialog("���벻��Ϊ��");
			return false;
		}
		String cpwd = cpassword.getText().toString();
		if (cpwd.equals("")) {
			showDialog("������������");
			return false;
		}
		return true;
	}

	/* ���Ͳ�ѯ���� */
	private String query(String username, String password) {
		// SQL�ַ���
		String queryString = "username=" + username + "&password=" + password;
		// ��ѯ��URL
		String url = HttpUtil.URL + "login?" + queryString;
		Log.i("url", url);
		//��ѯ�����ؽ��
		return HttpUtil.queryStringForPost(url);
	}

	/* ��¼ */
	private boolean login() {
		String name = username.getText().toString().trim();
		String pwd = password.getText().toString().trim();
			//���ز�ѯ���
			String result = query(name, pwd);
			Log.i("result", result);
			//�Բ�ѯ�Ľ�������ж�
			if(result != null && result.equals("1"))
			{
				return true;
			}
			return false;
	}




	}

		






