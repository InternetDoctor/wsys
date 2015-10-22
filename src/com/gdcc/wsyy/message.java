package com.gdcc.wsyy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class message extends Activity  implements OnClickListener {

	private Button btnStart;
	private Button btnStop;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.message);
		initView();
	}

	private void initView() {
		btnStart = (Button) findViewById(R.id.btnStart);
		btnStop = (Button) findViewById(R.id.btnStop);
		btnStart.setOnClickListener(this);
		btnStop.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		int id = v.getId();
		if (id == R.id.btnStart) {
			// ����Service
			Intent intent = new Intent();
			intent.setAction("ymw.MY_SERVICE");
			startService(intent);
		}
		if (id == R.id.btnStop) {
			// �ر�Service
			/*Intent intent = new Intent();*/
		//	intent.setAction("ymw.MY_SERVICE");
		      //stopService(intent);
			Intent intent = new Intent(message.this, MainActivity.class);
			startActivity(intent);
		}
	}

	@Override
	public void onBackPressed() {
		System.exit(0);
		super.onBackPressed();
	}

}
