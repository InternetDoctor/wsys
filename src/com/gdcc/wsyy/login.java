package com.gdcc.wsyy; 

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
<<<<<<< HEAD
<<<<<<< HEAD
import org.apache.http.impl.conn.DefaultClientConnection;

import com.gdcc.wsyy.data.utils;

import android.app.Activity;
import android.app.Dialog;
=======

import android.app.Activity;
>>>>>>> origin/master
=======
import org.apache.http.impl.conn.DefaultClientConnection;

import com.gdcc.wsyy.data.utils;

import android.app.Activity;
<<<<<<< HEAD
import android.app.Dialog;
>>>>>>> parent of 97e08b4... 第二次提交
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
<<<<<<< HEAD
<<<<<<< HEAD
import android.view.accessibility.CaptioningManager.CaptioningChangeListener;
=======
>>>>>>> origin/master
=======
import android.view.accessibility.CaptioningManager.CaptioningChangeListener;
>>>>>>> parent of 97e08b4... 第二次提交
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
<<<<<<< HEAD
=======

<<<<<<< HEAD
import com.gdcc.wsyy.data.Biaozhi;
import com.gdcc.wsyy.data.utils;
>>>>>>> origin/master

=======
>>>>>>> parent of 97e08b4... 第二次提交
public class login extends Activity {
	
	Button loginButton;
	EditText loginId;
	EditText loginPsw;
    ImageView loginback;
	private static ProgressDialog dialog;
    
<<<<<<< HEAD
<<<<<<< HEAD
    
    Handler han= new Handler(){
    
    	public void handleMessage(android.os.Message msg) {
			Toast.makeText(login.this,(String)msg.obj,0).show();
		}
    };
    
    
=======
	public String ID;
	public String psw;
=======
>>>>>>> parent of 97e08b4... 第二次提交
    
    Handler han= new Handler(){
    
    	public void handleMessage(android.os.Message msg) {
			Toast.makeText(login.this,(String)msg.obj,0).show();
		}
    };
    
    
=======
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

<<<<<<< HEAD
=======
public class login extends Activity {
	
	
	
	ImageView loginback;
>>>>>>> parent of 97e08b4... 第二次提交
>>>>>>> origin/master
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_in);
		loginback=(ImageView)findViewById(R.id.login_back);
<<<<<<< HEAD

		loginButton=(Button)findViewById(R.id.denglub);
		
		
		loginButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v1) {
				
				loginId=(EditText)findViewById(R.id.LoginId);
				loginPsw=(EditText)findViewById(R.id.LoginPsw);

<<<<<<< HEAD
<<<<<<< HEAD
				final	String ID=loginId.getText().toString();
				final	String psw=loginPsw.getText().toString();
=======
				 ID=loginId.getText().toString();
				 psw=loginPsw.getText().toString();
>>>>>>> origin/master
=======
				final	String ID=loginId.getText().toString();
				final	String psw=loginPsw.getText().toString();
>>>>>>> parent of 97e08b4... 第二次提交
				
				/**
				 * 输入值验证
				 * 
				 */
				
				/**
				 * loading
				 * 
				 */
				
				if (dialog==null) {
					
					dialog=new ProgressDialog(login.this);
					
				} 
					dialog.setTitle("请等待");
					dialog.setMessage("登陆中...");
					dialog.setCancelable(false);
					//dialog.show();		
					
					
					
					
					
				Thread th=new Thread(){

					@Override
					public void run() {

						String path="http://pc-201502130051:8080/wsyyweb/servlet/loginServlet?LoginName="+ID+"&LoginPassword="+psw;
						
						HttpClient hc=new DefaultHttpClient();
						
						HttpGet hg=new HttpGet(path);
						
					     try {
							HttpResponse hr=hc.execute(hg);
							if (hr.getStatusLine().getStatusCode()==200) {
								//取得实体
								HttpEntity he=hr.getEntity();
								//取得实体的输入流
							InputStream is=	he.getContent();
							
							String text=utils.getTextFromStream(is);
							//发送信息，让主线程更新UI
							Message msg=han.obtainMessage();
							msg.obj=text;
							han.sendMessage(msg);
<<<<<<< HEAD
<<<<<<< HEAD
							
								
							}
=======
					}
>>>>>>> origin/master
=======
							
								
							}
>>>>>>> parent of 97e08b4... 第二次提交
			
						} catch (ClientProtocolException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
					}
					
				};
				th.start();
<<<<<<< HEAD
<<<<<<< HEAD
			
      	
            }  
        });  
		
		
		
		
		
		
		
		
		
		
		
		
		
		
=======
				startActivity(new Intent(login.this,MainActivity.class));
				    
            } 
				
        });  

>>>>>>> origin/master
=======
			
      	
            }  
        });  
		
		
		
		
		
		
		
		
		
		
		
		
		
		
>>>>>>> parent of 97e08b4... 第二次提交
			
=======
>>>>>>> origin/master
		loginback.setOnClickListener(new OnClickListener()  
        {  
            @Override  
            public void onClick(View v)  
            {  
            	finish();
       
            	
            }  
        });  
<<<<<<< HEAD
<<<<<<< HEAD
		
		
=======
		
<<<<<<< HEAD

=======
>>>>>>> origin/master
>>>>>>> parent of 97e08b4... 第二次提交
		
		
		
		
		
<<<<<<< HEAD
			}
			
			
			
			
		}
	

=======
	
=======
<<<<<<< HEAD
>>>>>>> parent of 97e08b4... 第二次提交
			}
			
			
			
			
		}
	

<<<<<<< HEAD
		
		};

=======
=======
	}
	
	
	
>>>>>>> parent of 97e08b4... 第二次提交
}
>>>>>>> origin/master
