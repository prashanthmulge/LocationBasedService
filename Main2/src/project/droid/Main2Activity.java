package project.droid;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.http.client.methods.HttpPost;




import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends Activity {
    /** Called when the activity is first created. */
	WifiManager wifi;
	BroadcastReceiver receiver;
	TextView sig;
	 Spanned g;
	String s;
	TestHttpPost t;
	static Handler handler=new Handler();
	private Timer myTimer;
	TimerTask scanTask;
	int ap1c=0,ap2c=0,ap3c=0,ap1=0,ap2=0,ap3=0,i=0;
	
	private Runnable mUpdateTimeTask = new Runnable() {
		   public void run() {
		     
Log.d("handler running", "handlerrunning");
			   registerReceiver(receiver, new IntentFilter(
						WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
		   //   handler.removeCallbacks(scanTask);
		    //  handler.postAtTime(this, 3000);
			   Log.d("handler wifi", "wifi started");
		   }
		};
		/** Called when the activity is first created. */
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.main);
	        sig=(TextView)findViewById(R.id.Sig);
	       wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
	  	if (receiver == null)
				receiver = new WiFiScanReceiver(this);

		registerReceiver(receiver, new IntentFilter(
				WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
		wifi.startScan();
	/*   t=new TestHttpPost(71,50,75);
	  try {
		s=t.executeHttpPost();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   Spanned g= Html.fromHtml(s);
		sig.setText(g);
	  sig.setText("");
			Toast.makeText(this, "My Service update", Toast.LENGTH_LONG).show();
			
	/*		myTimer = new Timer();
			scanTask=new TimerTask() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
	                handler.post(new Runnable() {
		
	                    	public void run() {
		
	                    		registerReceiver(receiver, new IntentFilter(
	                					WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
		                                    }
	});		
				}
			};*/
			
		

			
			
		//	myTimer.schedule(scanTask,3000);
	    }
		public void update(List<ScanResult> results) {
			// TODO Auto-generated method stub
			//sig=(TextView)findViewById(R.id.Sig);
			Log.d("wifi", "update");
	//		Toast.makeText(this, "inside update", Toast.LENGTH_SHORT).show();
			i++;
		/*	t=new TestHttpPost(45, 63, 45);
			try {
				s=t.executeHttpPost();
				 g= Html.fromHtml(s);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//sig.append(g);
			sig.setText(g);*/
			for (ScanResult result : results)
			{
				//Toast.makeText(this, "in scan"+ap1c+ap2c+ap3c, Toast.LENGTH_SHORT).show();
				if( result.SSID.compareTo("AP1")==0 && ap1c<4)
				{
					Log.d(result.level+"", "ap1");
					ap1=ap1+result.level;
					ap1c++;
					Log.d(ap1c+":"+ap1, "ap1 added value"+ap1c);
				//	Toast.makeText(this, "inside update"+ap1c, Toast.LENGTH_SHORT).show();
				}
				else if(result.SSID.compareTo("AP2")==0 && ap2c<4)
				{
					Log.d(result.level+"", "ap2");
					ap2=ap2+result.level;
					ap2c++;
					Log.d(ap2+"", "ap2 added value"+ap2c);
				}
			
				else if(result.SSID.compareTo("INDOOR-01")==0 && ap3c<4)
				{
					Log.d(result.level+"", "ap3");
					ap3=ap3+result.level;
					ap3c++;
					Log.d(ap3+"", "ap3 added value"+ap3c);
				}
			}
			/*if(results.SSID=="AP1" && ap1c<4)
				{
					ap1=ap1+results.level;
					ap1c++;
				}
				else if(results.SSID=="AP2" && ap2c<4)
				{
					ap2=ap2+results.level;
					ap2c++;
				}
			
				else if(results.SSID=="AP3" && ap3c<4)
				{
					ap2=ap2+results.level;
					ap3c++;
				}
				*/
				if(ap1c==4&&ap2c==4&&ap3c==4){
					Log.d(""+ap1+" "+ap2+" "+ap3+"", "sum");
					ap1=Math.abs(ap1/4);
					ap2=Math.abs(ap2/4);
					ap3=Math.abs(ap3/4);
					Log.d(""+ap1+" "+ap2+" "+ap3+"", "value");
					Toast.makeText(this, "inside if", Toast.LENGTH_SHORT).show();
					t=new TestHttpPost(ap1,ap2,ap3);
					try {
						Log.d("executinh http", "this is http");
						s=t.executeHttpPost();
						Log.d("execute", "reunninghttp");
						 g= Html.fromHtml(s);
						 //Html.ImageGetter(s);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
				//		Log.d("in ex", e+"");
					}
					Log.d(g+"", "text");
					sig.setText(g);
				
					unregisterReceiver(receiver);
					handler.postDelayed(mUpdateTimeTask,200);
					Log.d("timer", "timerstarted");
					ap1c=0;ap2c=0;ap3c=0;
					ap1=0;ap2=0;ap3=0;
			//		handlercall();
					//myTimer.schedule(mUpdateTimeTask,3000);
					
				}
		wifi.startScan();
			
		}
	/*	private void handlercall() {
			// TODO Auto-generated method stub
			handler.postDelayed(mUpdateTimeTask, 3000);
			ap1c=0;ap2c=0;ap3c=0;
			ap1=0;ap2=0;ap3=0;
		}*/
	
		
	   
	
}