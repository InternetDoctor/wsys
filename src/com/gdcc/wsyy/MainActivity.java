package com.gdcc.wsyy;


import javax.security.auth.PrivateCredentialPermission;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class MainActivity extends FragmentActivity implements OnCheckedChangeListener {

	
	private RadioGroup group;
	 
	private RadioButton main_service;
	//管理fragment
	private FragmentManager framang;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		group=(RadioGroup)findViewById(R.id.main_bottom);
		main_service=(RadioButton)findViewById(R.id.main_home);
		
		framang=getSupportFragmentManager();
		
		main_service.setChecked(true);
		
		group.setOnCheckedChangeListener(this);
		
		//切换不同的fragment
		
		changeFragment(new service_main(), true);
		
		
	}



	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub
		
		switch (checkedId) {
		case R.id.main_home:
			changeFragment(new service_main(), true);
		           	break;
			
        case R.id.main_messgae:
        	changeFragment(new message_main(), true);
			          break;
			
        case R.id.main_move:
        	changeFragment(new new_main(), true);
	                  break;
			
			
        case R.id.main_me:
        	changeFragment(new me_main(), true);
            break;
		
				default:
			break;
		}
		
		
		
		
		
		
		
	}

	
	//切换不同的fragment
	
	public void changeFragment( Fragment fragment,boolean isFirst){
		
		android.support.v4.app.FragmentTransaction tran=framang.beginTransaction();
		
		tran.replace(R.id.main_content, fragment);
		
		tran.commit();
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
