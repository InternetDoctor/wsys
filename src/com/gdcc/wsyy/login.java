package com.gdcc.wsyy;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.ComponentName;
import android.content.DialogInterface;
//import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

public class login extends Activity {
	private EditText username, password;
	private Button denglub;
	  ImageView loginback;
	  TextView registerback;
	 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_in);
		username = (EditText) findViewById(R.id.username);
		password = (EditText) findViewById(R.id.password);
        denglub = (Button) findViewById(R.id.denglub);
        loginback=(ImageView)findViewById(R.id.login_back);
        registerback=(TextView)findViewById(R.id.register);
       denglub.setOnClickListener(new View.OnClickListener() {
    	   public void onClick(View v){ 
   	    } 
   	});
      

       denglub.setOnClickListener(new View.OnClickListener(){ 
 	      @Override 

       
			public void onClick(View v) {
 	    	 if(validate())
				{
 	    		System.out.println("shagua");
					//登录
					if(login())
					{
						System.out.println("bendan");
						Intent intent = new Intent(login.this, MainActivity.class);
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

       registerback.setOnClickListener(new OnClickListener()  
       {  
    	 //  System.out.println("11");
           @Override  
           public void onClick(View v)  
           { 
        	   System.out.println("11");
        	   Intent intent = new Intent(login.this, Register.class);
				startActivity(intent);

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

	



	