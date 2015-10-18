package com.gdcc.wsyy;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

public class NotificationService extends Service {

	// 鑾峰彇娑堟伅绾跨▼
	private MessageThread messageThread = null;

	// 鐐瑰嚮鏌ョ湅
	private Intent messageIntent = null;
	private PendingIntent messagePendingIntent = null;

	// 閫氱煡鏍忔秷鎭�
	private int messageNotificationID = 1000;
	private Notification messageNotification = null;
	private NotificationManager messageNotificatioManager = null;

	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// 鍒濆鍖�
		messageNotification = new Notification();
		messageNotification.icon = R.drawable.ic_launcher;
		messageNotification.tickerText = "新消息";
		messageNotification.defaults = Notification.DEFAULT_SOUND;
		messageNotificatioManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

		messageIntent = new Intent(this, message_main.class);
		messagePendingIntent = PendingIntent.getActivity(this, 0,
				messageIntent, 0);

		// 寮�惎绾跨▼
		messageThread = new MessageThread();
		messageThread.isRunning = true;
		messageThread.start();

		return super.onStartCommand(intent, flags, startId);
	}

	/**
	 * 浠庢湇鍔″櫒绔幏鍙栨秷鎭�
	 * 
	 */
	class MessageThread extends Thread {
		// 璁剧疆鏄惁寰幆鎺ㄩ�
		public boolean isRunning = true;

		public void run() {
			// while (isRunning) {
			try {
				// 闂撮殧鏃堕棿
				Thread.sleep(1000);
				// 鑾峰彇鏈嶅姟鍣ㄦ秷鎭�
				String serverMessage = getServerMessage();
				if (serverMessage != null && !"".equals(serverMessage)) {
					// 鏇存柊閫氱煡鏍�
					messageNotification.setLatestEventInfo(
							getApplicationContext(), "新消息","你有一个新消息"
									+ serverMessage, messagePendingIntent);
					messageNotificatioManager.notify(messageNotificationID,
							messageNotification);
					// 姣忔閫氱煡瀹岋紝閫氱煡ID閫掑涓�笅锛岄伩鍏嶆秷鎭鐩栨帀
					messageNotificationID++;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// }
		}
	}

	@Override
	public void onDestroy() {
		// System.exit(0);
		messageThread.isRunning = false;
		super.onDestroy();
	}

	/**
	 * 妯℃嫙鍙戦�娑堟伅
	 * 
	 * @return 杩斿洖鏈嶅姟鍣ㄨ鎺ㄩ�鐨勬秷鎭紝鍚﹀垯濡傛灉涓虹┖鐨勮瘽锛屼笉鎺ㄩ�
	 */
	public String getServerMessage() {
		return "NEWS!";
	}
}