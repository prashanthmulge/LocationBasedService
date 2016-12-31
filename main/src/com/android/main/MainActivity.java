package com.android.main;


import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{
    /** Called when the activity is first created. */
	 private static final String TAG = "ServicesDemo";
	  Button buttonStart, buttonStop;
	 
	  @Override
	  public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.main);

	    buttonStart = (Button) findViewById(R.id.buttonStart);
	    buttonStop = (Button)  findViewById(R.id.buttonStop);

	    buttonStart.setOnClickListener(this);
	    buttonStop.setOnClickListener(this);
	  }
	  
	  /*
		public class checkwifi extends AsyncTask<String, Void, String> {
			 WifiManager wifi;
				BroadcastReceiver receiver;
			@Override
			protected String doInBackground(String... arg0) {
				// TODO Auto-generated method stub
				
				wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
				if (receiver == null)
					receiver = new WiFiScanReceiver(this);

				registerReceiver(receiver, new IntentFilter(
						WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
				return null;
			}
			public void update(ScanResult result) {
				// TODO Auto-generated method stub
			//	Toast.makeText(this, "gry", Toast.LENGTH_SHORT);
				Log.d(TAG, "onReceive() message: " + "inside");
			}
			
			
			
		}
	  */
	  
	  
	  

	  public void onClick(View src) {
	    switch (src.getId()) {
	    case R.id.buttonStart:
	      Log.d(TAG, "onClick: starting srvice");
	//      checkwifi task = new checkwifi();
	    startService(new Intent(this, MyService.class));
	    /*  new Thread(new Runnable(){

				public void run() {
					// TODO Auto-generated method stub
					String url = "http://192.168.0.115/test.php";  
					Intent i = new Intent(Intent.ACTION_VIEW);  
					i.setData(Uri.parse(url));  
					startActivity(i); 	
				}
				 
			 }).start();*/
	    //  startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("192.168.137.126/test.php")));
	      break;
	    case R.id.buttonStop:
	      Log.d(TAG, "onClick: stopping srvice");
	      stopService(new Intent(this, MyService.class));
	      break;
	    }
	  }
}