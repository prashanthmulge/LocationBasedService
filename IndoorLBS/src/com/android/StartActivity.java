package com.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class StartActivity extends Activity {
	
	Button infodisp;
	Button skip;
	private EditText name;
	private EditText age;
	private EditText phone;
	private EditText interest;
	TestHttpPost testhttppost;
	  public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.wifilist);
	        setUpView();
	        name=(EditText)findViewById(R.id.name);
			age=(EditText)findViewById(R.id.age);
			phone=(EditText)findViewById(R.id.phone);
			interest=(EditText)findViewById(R.id.interest);
	      //  checkInfo();
	  }

	private void checkInfo() {
		// TODO Auto-generated method stub
		if(name.getText()!= null && age.getText()!= null && phone.getText()!= null && interest.getText()!= null)
		{
			Log.d("in check", "checkin http");
			String n=name.getText().toString(), a=age.getText().toString(),p=phone.getText().toString(),i=interest.getText().toString();
		//	testhttppost=new TestHttpPost(name.getText(),age.getText(),phone.getText(),interest.getText());
			testhttppost=new TestHttpPost(n,a,p,i);
			try {
			testhttppost.executeHttpPost();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//	Log.d("in check", "checkin http");
			//Intent intent=new Intent(StartActivity.this,Main2Activity.class);
		   // startActivity(intent);
		}
		else
		{
			Toast.makeText(this, "please fill all the information", Toast.LENGTH_SHORT);
		}
		
	}

	
	private void setUpView() {
		// TODO Auto-generated method stub
	 infodisp=(Button)findViewById(R.id.infodisplay);
	        
	        infodisp.setOnClickListener(new View.OnClickListener() {
				
				public void onClick(View arg0) {
			
				checkInfo();
				}
			});
 skip=(Button)findViewById(R.id.skip);
	        
	        infodisp.setOnClickListener(new View.OnClickListener() {
				
				public void onClick(View arg0) {
			
					Intent intent=new Intent(StartActivity.this,Main2Activity.class);
					startActivity(intent);
				}
			});
	}
}
