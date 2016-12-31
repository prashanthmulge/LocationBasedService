package com.android.main;

//import code.droid.WiFiScanReceiver;
import com.android.main.WiFiScanReceiver;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.net.Uri;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {
	private static final String TAG = "MyService";
	//MediaPlayer player;
	WifiManager wifi;
	BroadcastReceiver receiver;
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
	
	@Override
	public void onCreate() {
		Toast.makeText(this, "My Service Created", Toast.LENGTH_LONG).show();
		Log.d(TAG, "onCreate");
		wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
		if (receiver == null)
	//		receiver = new WiFiScanReceiver(this);

		registerReceiver(receiver, new IntentFilter(
				WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
	//	player = MediaPlayer.create(this, R.);
		//player.setLooping(false); // Set looping
	}

	@Override
	public void onDestroy() {
		Toast.makeText(this, "My Service Stopped", Toast.LENGTH_LONG).show();
		Log.d(TAG, "onDestroy");
	//	player.stop();
		unregisterReceiver(receiver);
	}
	
	@Override
	public void onStart(Intent intent, int startid) {
		// super.onStart(intent, startid);
         //startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("192.168.137.126/test.php")));
		Toast.makeText(this, "My Service Started", Toast.LENGTH_LONG).show();
		Log.d(TAG, "onStart");
		wifi.startScan();
		/*Thread t=new Thread()
		{
			public void run()
			{
				String url = "http://192.168.0.115/test.php";  
				Intent i = new Intent(Intent.ACTION_VIEW);  
				i.setData(Uri.parse(url));  
				startActivity(i);
			}
		};*/
		//t.start();
	/*	 new Thread(new Runnable(){

				public void run() {
					// TODO Auto-generated method stub
					String url = "http://192.168.0.115/test.php";  
					Intent i = new Intent(Intent.ACTION_VIEW);  
					i.setData(Uri.parse(url));  
					startActivity(i); 	
				}
				 
			 }).start();*/
		//Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse("192.168.137.126/test.php"));
//	startActivity(i);
		//new Webs();
	//	player.start();
		
	}

	public void update(ScanResult result) {
		// TODO Auto-generated method stub
		Toast.makeText(this, "My Service update", Toast.LENGTH_LONG).show();
		//new Webs();
	}
}