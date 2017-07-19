package bbs.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Topic entity. @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
public class Topic implements java.io.Serializable {

	// Fields

	private Integer topicId;
	private String title;
	private String content;
	private Timestamp publishTime;
	private Timestamp modifyTime;
	private Integer userId;
	private Integer boardId;

	public Set<?> getReplys() {
		return replys;
	}

	public void setReplys(Set<?> replys) {
		this.replys = replys;
	}

	private Set<?> replys = new HashSet<Reply>(0);

	/** default constructor */
	public Topic() {
	}

	/** full constructor */
	public Topic(String title, String content, Timestamp publishTime,
			Timestamp modifyTime, Integer userId, Integer boardId) {
		this.title = title;
		this.content = content;
		this.publishTime = publishTime;
		this.modifyTime = modifyTime;
		this.userId = userId;
		this.boardId = boardId;
	}

	// Property accessors

	public Integer getTopicId() {
		return this.topicId;
	}

	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
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

	public void setPublishTime(Timestamp timestamp) {
		this.publishTime = timestamp;
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

	public Integer getBoardId() {
		return this.boardId;
	}

	public void setBoardId(Integer boardId) {
		this.boardId = boardId;
	}

}