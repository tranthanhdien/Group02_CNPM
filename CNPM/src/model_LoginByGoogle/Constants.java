package model_LoginByGoogle;
  
// Class Dùng để lưu client_id, client_secret, redirect_uri của ứng dung Demo Login Google
public class Constants {
	public static String GOOGLE_CLIENT_ID = "745032533472-rmlgld6ab5t3u2vrv03vuo6d3m3f6s2e.apps.googleusercontent.com";
	public static String GOOGLE_CLIENT_SECRET = "mpOTbzjtQQhNKDKef9crMHcE";
	public static String GOOGLE_REDIRECT_URI = "http://localhost:8080";
	public static String GOOGLE_LINK_GET_TOKEN = "https://accounts.google.com/o/oauth2/token";
	public static String GOOGLE_LINK_GET_USER_INFO = "https://www.googleapis.com/oauth2/v1/userinfo?access_token=";
	public static String GOOGLE_GRANT_TYPE = "authorization_code";
}
