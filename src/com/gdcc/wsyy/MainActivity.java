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
<<<<<<< HEAD
<<<<<<< HEAD
	//����fragment
	private FragmentManager framang;
	
	
	  
	
	
	
=======
	// ����fragment
	private FragmentManager framang;

>>>>>>> origin/master
=======
	//����fragment
	private FragmentManager framang;
	
	
	
>>>>>>> parent of 97e08b4... 第二次提交
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
<<<<<<< HEAD
<<<<<<< HEAD
	
=======
		
		
>>>>>>> parent of 97e08b4... 第二次提交
		group=(RadioGroup)findViewById(R.id.main_bottom);
		main_service=(RadioButton)findViewById(R.id.main_home);
		
		framang=getSupportFragmentManager();
		
<<<<<<< HEAD
=======

		group = (RadioGroup) findViewById(R.id.main_bottom);
		main_service = (RadioButton) findViewById(R.id.main_home);

		framang = getSupportFragmentManager();

>>>>>>> origin/master
=======
>>>>>>> parent of 97e08b4... 第二次提交
		main_service.setChecked(true);
		
		group.setOnCheckedChangeListener(this);
<<<<<<< HEAD
<<<<<<< HEAD
		
		//�л���ͬ��fragment
		
		changeFragment(new service_main(), true);
		
		
	}
=======
>>>>>>> origin/master

		// �л���ͬ��fragment

=======
		
		//�л���ͬ��fragment
		
>>>>>>> parent of 97e08b4... 第二次提交
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

<<<<<<< HEAD
<<<<<<< HEAD
	
	//�л���ͬ��fragment
=======
	
	//�л���ͬ��fragment
>>>>>>> parent of 97e08b4... 第二次提交
	
	public void changeFragment( Fragment fragment,boolean isFirst){
		
		android.support.v4.app.FragmentTransaction tran=framang.beginTransaction();
		
<<<<<<< HEAD
=======
	// �л���ͬ��fragment

	public void changeFragment(Fragment fragment, boolean isFirst) {

		android.support.v4.app.FragmentTransaction tran = framang
				.beginTransaction();

>>>>>>> origin/master
=======
>>>>>>> parent of 97e08b4... 第二次提交
		tran.replace(R.id.main_content, fragment);
		
		tran.commit();
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
