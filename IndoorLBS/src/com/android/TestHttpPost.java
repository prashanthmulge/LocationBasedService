package com.android;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.text.Editable;
import android.util.Log;
import android.widget.TextView;
public class TestHttpPost
{
 //   TextView sig=(TextView)findViewById(R.id.Sig);
	int s1,s2,s3, flag;
	String url="http://192.168.1.2";
	String name,phone,age,interest,Url;
	HttpPost request;
	public TestHttpPost(int sig1,int sig2,int sig3)
	{
		s1=sig1;
		s2=sig2;
		s3=sig3;
		flag=0;
		
	}
public TestHttpPost(String n, String a, String p,
			String i) {
		// TODO Auto-generated constructor stub
	this.name=n;
	this.age=a;
	this.phone=p;
	this.interest=i;
	flag=1;
	Log.d("inside construt","check");
	Url=url+"insert.php/"+"?name="+name+"&&age="+age+"&&phone2="+phone+"&&interest="+interest;
/*	try {
		sendData(name,age,phone,interest);
		//Log.d(s+":", "executed");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
	
	}
/*
private void sendData(String name2, String age2, String phone2, String interest2) throws Exception {
	// TODO Auto-generated method stub
	
	BufferedReader in = null;
	try {
		HttpClient client = new DefaultHttpClient();
		HttpPost request = new HttpPost("http:192.168.1.2/dataprocess.php?"+"name="+name2+"&&age="+age2+"&&phone2="+phone2+"&&interest="+interest2);
		//List<NameValuePair> postParameters = new ArrayList<NameValuePair>();
		//postParameters.add(new BasicNameValuePair("one", "valueGoesHere"));
		//UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(
		//postParameters);
		//request.setEntity(formEntity);
		Log.d("http exec", "executing process");
		 	client.execute(request);
		Log.d("response", "getting response");
		
		Log.d("returning", "result");
		
		
	}
	finally{
		
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		
	}

}*/
public  String executeHttpPost() throws Exception {
	url=url+"/process.php"+"?signal1="+s1+"&&signal2="+s2+"&&signal3="+s3;
	//Url=url+"?name="+name+"&&age="+age+"&&phone2="+phone+"&&interest="+interest;
	BufferedReader in = null;
	try {
		HttpClient client = new DefaultHttpClient();
	if(flag == 1)
	{
		url=Url;
		 request = new HttpPost(url);
	}	
	else{
		 request = new HttpPost(url);
	}
	List<NameValuePair> postParameters = new ArrayList<NameValuePair>();
		//postParameters.add(new BasicNameValuePair("one", "valueGoesHere"));
		//UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(
		//postParameters);
		//request.setEntity(formEntity);
		HttpResponse response = client.execute(request);
		in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		StringBuffer sb = new StringBuffer("");
		String line = "";
		String NL = System.getProperty("line.separator");
		while ((line = in.readLine()) != null) {
			sb.append(line + NL);
		}
		in.close();
		String result = sb.toString();
		return result;
		
	} finally {
		if (in != null) {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	}
	}	