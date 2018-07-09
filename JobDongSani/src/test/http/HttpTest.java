package test.http;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class HttpTest {

	public static void main(String[] args) {
		String url = "http://221.148.199.15:10040/externalapi/v1/sms/sendSMS";
		String authHeader = "Bearer eyJhbGciOiJSUzI1NiJ9.eyJzdmNfdGd0X3NlcSI6IiIsInVzZXJfbmFtZSI6ImFpck1hcCIsInB1Yl90aW1lIjoxNTIzODU1MDYxNzc5LCJtYnJfaWQiOiJhaXJNYXAiLCJtYnJfc2VxIjoiMTAwMDAwMjUyNSIsIm1icl9jbGFzIjoiMDAwMyIsImF1dGhvcml0aWVzIjpbIlJPTEVfT1BFTkFQSSIsIlJPTEVfVVNFUiJdLCJwbGF0Zm9ybSI6IjNNUCIsInRoZW1lX2NkIjoiIiwiY2xpZW50X2lkIjoiR2xvc2NvbVNTTCIsImF1ZCI6WyJJT1QtQVBJIl0sInVuaXRfc3ZjX2NkIjoiIiwic2NvcGUiOlsidHJ1c3QiXSwiZHN0cl9jZCI6IiIsImNvbXBhbnkiOiJLdCIsIm1icl9ubSI6ImFwaSIsImV4cCI6MTUyNDQ1NTA2MSwianRpIjoiYWYyNGIxOTMtOTE0YS00YjQyLWI5YzktZmZhMGVkZWMzZDEyIn0.L1nJlxc0AW4zY2upscgAT_YDgODtWWFvg7u3XwKjJXIuGYosnd-Zc-2SOcuEljNzBr4IetpIqKfhmaf1pJiq1W_cFgBN8lb-9rAFeOSYj4ktS-Y1hLOnEC68fY5qKJzoz1GI7IqjbvnDlklFBQdMWcP4QC_Hzzf28NWlzprNHQ0T9M4EZobUCscRA8s4jxd9KZ2BoQ23W0Ka5JFy-j_xUuwe_sVKYGSLYwO0GAskCB_h9DBJBblnjA798JwvSw94SA66e5XRzUyoXvw8SqCuz4OwEDx6xH2ktAVnZmIvGx7gIWlMfyjN0dXpWc06zDP9oOAVoxIeobBz96dXHISmlQ";
		HttpUtil httpUtil = new HttpUtil();
		httpUtil.setUrl(url);
		httpUtil.setAuthCode(authHeader);
		List<NameValuePair> params = new ArrayList<NameValuePair>();
//		List<String> recipientNumberList = new ArrayList<String>();
//		recipientNumberList.add("01073006681");
//		System.out.println(recipientNumberList.toString());
		params.add(new BasicNameValuePair("title", "title"));
		params.add(new BasicNameValuePair("message", "SMS test"));
		params.add(new BasicNameValuePair("callerNumber", "0234954277"));
		params.add(new BasicNameValuePair("recipientNumberList", "[\"01073006681\"]"));
		params.add(new BasicNameValuePair("messageType", "1"));
		params.add(new BasicNameValuePair("districtCode", "001"));
		params.add(new BasicNameValuePair("themeCode", "ENV"));
		params.add(new BasicNameValuePair("serviceCode", "301"));
		params.add(new BasicNameValuePair("domain", "airMap"));
		params.add(new BasicNameValuePair("typeCode", "10"));
	}
//	"title":"title",
//	  "message":"SMS test",
//	  "callerNumber":"0234954277",
//	  "recipientNumberList":["01073006681"],
//	  "messageType":"1",
//	  "districtCode":"001",
//	  "themeCode":"ENV",
//	  "serviceCode":"301",
//	  "domain":"airMap",
//	  "typeCode":"10"
	
}
