package model_LoginAccount;

public class User {
	private String id;
	private String name;
	private String userName;
	private String passWord;


	public User(String userName, String passWord) {
		super();
		this.userName = userName;
		this.passWord = passWord;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassWord() {
		return passWord;
	}

	@Override
	public String toString() {
		return this.userName + "\t" + this.passWord;
	}
}
