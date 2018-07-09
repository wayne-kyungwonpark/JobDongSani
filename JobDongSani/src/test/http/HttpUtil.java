package test.http;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class HttpUtil {
	
	private static Logger logger = LoggerFactory.getLogger(HttpUtil.class);
	private static HttpClient httpClient = HttpClientBuilder.create().build();
	private static String url;
	private static String authCode;
	
	public HttpUtil() {}
	
	public static HttpResponse httpPost(List<NameValuePair> params) {
		HttpResponse httpResponse = null;
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Content-type", "text/plain;charset=UTF-8");
		if(authCode != null)
			httpPost.setHeader("Authorization", authCode);
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
			httpResponse = httpClient.execute(httpPost);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return httpResponse;
	}

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getAuthCode() {
		return authCode;
	}
	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}
}
