package com.android;

import java.util.ArrayList;
import java.util.List;


import android.app.Activity;
import android.app.ListActivity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

public class TrainActivity extends ListActivity {
	private Button Select;
	WiFiScanReceiver wifiScan;
	public WifiManager wifi;
	private BroadcastReceiver receiver;
	public List<Model> list;
	   @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	       
	        setContentView(R.layout.show_list);
	       
	       setUpView();
	       ArrayAdapter<Model> adapter = new InteractiveArrayAdapter(this,getModel());
			setListAdapter(adapter);
	    /*   wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
		  	if (receiver == null)
					receiver = new WiFiScanReceiver(this);

			registerReceiver(receiver, new IntentFilter(
					WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
			wifi.startScan();
	       setListAdapter(new ArrayAdapter<ScanResult>(this,R.layout.show_list, wifiScan.results ));*/
	    }
		private List<Model> getModel() {
	 list = new ArrayList<Model>();
	 wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
	  	if (receiver == null)
				receiver = new WiFiScanReceiver(this);

		registerReceiver(receiver, new IntentFilter(
				WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
		wifi.startScan();
	/*	list.add(get("Linux"));
		list.add(get("Windows7"));
		list.add(get("Suse"));
		list.add(get("Eclipse"));
		list.add(get("Ubuntu"));
		list.add(get("Solaris"));
		list.add(get("Android"));
		list.add(get("iPhone"));*/
		// Initially select one of the items
	//	list.get(1).setSelected(true);
		unregisterReceiver(receiver);
		return list;
	}
		private Model get(String s) {
			return new Model(s);
		}
		
	private void setUpView() {
		// TODO Auto-generated method stub
		 Select=(Button)findViewById(R.id.select);
	        
	        Select.setOnClickListener(new View.OnClickListener() {
				
				public void onClick(View arg0) {
			
				Intent intent=new Intent(TrainActivity.this,TrainPoints.class);
					startActivity(intent);
				}
			});
	}
	public void insertmodeldata(List<ScanResult> results) {
		// TODO Auto-generated method stub
		 for (ScanResult result : results) {
		     list.add(get(result.SSID));
		      //wifiDemo.update(result);
		    }
	}
}
