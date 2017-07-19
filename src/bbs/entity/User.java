package bbs.entity;

import java.sql.Timestamp;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
public class User implements java.io.Serializable {

	// Fields

	private Integer userId;
	private String userName;
	private String userPwd;
	private String head;
	private Timestamp regTime;
	private Boolean gender;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** full constructor */
	public User(String userName, String userPwd, String head,
			Timestamp regTime, Boolean gender) {
		this.userName = userName;
		this.userPwd = userPwd;
		this.head = head;
		this.regTime = regTime;
		this.gender = gender;
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return this.userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getHead() {
		return this.head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public Timestamp getRegTime() {
		return this.regTime;
	}

	public void setRegTime(Timestamp string) {
		this.regTime = string;
	}

	public Boolean getGender() {
		return this.gender;
	}

	public void setGender(Boolean gender) {
		this.gender = gender;
	}

}