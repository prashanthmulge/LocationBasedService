package project.droid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.util.Log;
import android.widget.TextView;
public class TestHttpPost
{
 //   TextView sig=(TextView)findViewById(R.id.Sig);
	int s1,s2,s3;
	String url="http://192.168.1.11/process.php";
	public TestHttpPost(int sig1,int sig2,int sig3)
	{
		s1=sig1;
		s2=sig2;
		s3=sig3;
	}
public  String executeHttpPost() throws Exception {
	url=url+"?signal1="+s1+"&&signal2="+s2+"&&signal3="+s3;
BufferedReader in = null;
try {
	Log.d(url, "1");
	Log.d("http client1", "1");
	Log.d(url, "1");
HttpClient client = new DefaultHttpClient();
Log.d("http client2", "2");
HttpPost request = new HttpPost(url);
List<NameValuePair> postParameters = new ArrayList<NameValuePair>();
//postParameters.add(new BasicNameValuePair("one", "valueGoesHere"));
//UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(
//postParameters);
//request.setEntity(formEntity);
Log.d("http client3", "3");
//HttpResponse response = client.execute(request);
HttpResponse response=client.execute(request);
Log.d("http client4", "4");
in = new BufferedReader(new InputStreamReader(response.getEntity()
.getContent()));
StringBuffer sb = new StringBuffer("");
String line = "";
String NL = System.getProperty("line.separator");
while ((line = in.readLine()) != null) {
sb.append(line + NL);
}
in.close();
String result = sb.toString();
Log.d(result, "in testhttp");
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