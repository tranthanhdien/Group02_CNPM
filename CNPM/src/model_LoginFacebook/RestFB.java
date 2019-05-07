package model_LoginFacebook;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Version;
import com.restfb.types.User;

public class RestFB {

	public static String getToken(String code) throws ClientProtocolException, IOException {
		String link = String.format(Constants.FACEBOOK_LINK_GET_TOKEN, Constants.FACEBOOK_APP_ID,
				Constants.FACEBOOK_APP_SECRET, Constants.FACEBOOK_REDIRECT_URL, code);
		String response = Request.Get(link).execute().returnContent().asString();
		JsonObject jobj = new Gson().fromJson(response, JsonObject.class);
		String accessToken = jobj.get("access_token").toString().replaceAll("\"", "");
		return accessToken;
	}

	public static User getUserInfo(String accessToken) {
		FacebookClient facebookClient = new DefaultFacebookClient(accessToken, Constants.FACEBOOK_APP_SECRET,
				Version.LATEST);
		return facebookClient.fetchObject("me", User.class);
	}
	public static void main(String[] args) throws ClientProtocolException, IOException {
		String code = "AQAIgqYfGUdn0Dn-40aWS6mLR5DNbVcuZzER1ZlIUSzvLKROQ41kCBtgBps8I4j-m0FHl_wIx68xAbCcQoV7oSxje3saBWQFSD6WPbOt2_EyFs0IW-4XT5sUwz24qbnelPxLVQpYAorUBPclx0GZqSNdtMEHFhg6kgEMUYidzdjFJ-gWEdp-JPXIkUemR48sDmMF6uxfU61Zl7jZYko3Bvv6NXWTqkHIiQizXa-XnRMWo2CdjJRQG6jRwvrnxanK3oEDEzbu5sQ-gEBW6qOx9x76jgpK_AWWgNJ9AeE_4AxyoTwgFNrp0evlmAg75hHBwnO572RVxL_2VkJbnKNjcpdX#_=_";
		String accessToken = getToken(code);
		User user = getUserInfo(accessToken);
		System.out.println(user.getId());
		System.out.println(user.getName());
		System.out.println(user.getEmail());
	}

}
