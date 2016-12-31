package com.android;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class IndoorLBSActivity extends Activity {
    /** Called when the activity is first created. */
	
	private Button Initiate;
	private Button Train;
	WifiManager wifi;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
             
     setUpVews();
     checkWifi();
    }

	private void checkWifi() {
		// TODO Auto-generated method stub
		wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
		if ((wifi.isWifiEnabled() == true)) {

		    Toast.makeText(this,"MOBILE Is Connected TO WI-FI!", Toast.LENGTH_LONG );
		    		}
		else{
		     AlertDialog.Builder WIFIOFF = new Builder(IndoorLBSActivity.this);
             WIFIOFF.setCancelable(false);
              WIFIOFF.setTitle("Connection Error");
              WIFIOFF.setMessage(" Please Enable Your WIFI/INTERNET !");
              WIFIOFF.setPositiveButton("Ok",
              new DialogInterface.OnClickListener() {
          public void onClick(DialogInterface dialog,int which) {
           startActivity(new Intent( Settings.ACTION_WIFI_SETTINGS));

                          }
                      });
              WIFIOFF.show();
		}
	}

	private void setUpVews() {
		// TODO Auto-generated method stub
		   Initiate=(Button)findViewById(R.id.initiate);
	        Train=(Button)findViewById(R.id.train);
	        
	        Initiate.setOnClickListener(new View.OnClickListener() {
				
				public void onClick(View arg0) {
			
					Intent intent=new Intent(IndoorLBSActivity.this,StartActivity.class);
					startActivity(intent);
				}
			});
  Train.setOnClickListener(new View.OnClickListener() {
				
				public void onClick(View arg0) {
			Log.d("clicked", "train");
					Intent intent=new Intent(IndoorLBSActivity.this,TrainActivity.class);
					startActivity(intent);
				}
			});
	}
}