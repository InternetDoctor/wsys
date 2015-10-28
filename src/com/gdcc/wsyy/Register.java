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
						//登录
						if(login())
						{
							System.out.println("bendan");
							Intent intent = new Intent(Register.this, MainActivity.class);
							startActivity(intent);
							//login.this.finish();
						}
						else
						{
							showDialog("用户名或密码错误，请重新输入");
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
		builder.setMessage(msg).setPositiveButton("确定",
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {

					}
				});
		AlertDialog ad = builder.create();
		ad.show();
	}
	/* 对用户名和密码进行非空验证 */
	private boolean validate() {
		String name = username.getText().toString();
		if (name.equals("")) {
			showDialog("用户名不能为空");
			return false;
		}
		String pwd = password.getText().toString();
		if (pwd.equals("")) {
			showDialog("密码不能为空");
			return false;
		}
		String cpwd = cpassword.getText().toString();
		if (cpwd.equals("")) {
			showDialog("请再输入密码");
			return false;
		}
		return true;
	}

	/* 发送查询请求 */
	private String query(String username, String password) {
		// SQL字符串
		String queryString = "username=" + username + "&password=" + password;
		// 查询的URL
		String url = HttpUtil.URL + "login?" + queryString;
		Log.i("url", url);
		//查询并返回结果
		return HttpUtil.queryStringForPost(url);
	}

	/* 登录 */
	private boolean login() {
		String name = username.getText().toString().trim();
		String pwd = password.getText().toString().trim();
			//返回查询结果
			String result = query(name, pwd);
			Log.i("result", result);
			//对查询的结果进行判断
			if(result != null && result.equals("1"))
			{
				return true;
			}
			return false;
	}




	}

		






