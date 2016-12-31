package com.android.main;

import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.net.Uri;


public class Webs extends Activity implements Runnable {
	
	public void run()
	{
		String url = "http://192.168.137.126/test.php";  
		Intent i = new Intent(Intent.ACTION_VIEW);  
		i.setData(Uri.parse(url));  
		startActivity(i);  
	}
	
	
	
}

