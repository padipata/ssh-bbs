package bbs.entity;

import java.sql.Timestamp;

/**
 * Reply entity. @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
public class Reply implements java.io.Serializable {

	// Fields

	private Integer replyId;
	private String title;
	private String content;
	private Timestamp publishTime;
	private Timestamp modifyTime;
	private Integer userId;
	private Integer topicId;

	// Constructors

	/** default constructor */
	public Reply() {
	}

	/** full constructor */
	public Reply(String title, String content, Timestamp publishTime,
			Timestamp modifyTime, Integer userId, Integer topicId) {
		this.title = title;
		this.content = content;
		this.publishTime = publishTime;
		this.modifyTime = modifyTime;
		this.userId = userId;
		this.topicId = topicId;
	}

	// Property accessors

	public Integer getReplyId() {
		return this.replyId;
	}

	public void setReplyId(Integer replyId) {
		this.replyId = replyId;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getPublishTime() {
		return this.publishTime;
	}

	public void setPublishTime(Timestamp string) {
		this.publishTime = string;
	}

	public Timestamp getModifyTime() {
		return this.modifyTime;
	}

	public void setModifyTime(Timestamp string) {
		this.modifyTime = string;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getTopicId() {
		return this.topicId;
	}

	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}

}