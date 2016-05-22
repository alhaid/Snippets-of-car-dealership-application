package testpack;

public class User {
	int uid;
	String loginName;
	String loginPass;
	String fulName;
	public User() {
		super();
	}
	public User(int uid, String loginName, String loginPass, String fulName) {
		super();
		this.uid = uid;
		this.loginName = loginName;
		this.loginPass = loginPass;
		this.fulName = fulName;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getLoginPass() {
		return loginPass;
	}
	public void setLoginPass(String loginPass) {
		this.loginPass = loginPass;
	}
	public String getFulName() {
		return fulName;
	}
	public void setFulName(String fulName) {
		this.fulName = fulName;
	}
	
}
