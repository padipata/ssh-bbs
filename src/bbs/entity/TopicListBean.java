package bbs.entity;

public class TopicListBean {
	private Topic topic;
	private User user;
	private Integer replyCount = 0;
	
	public TopicListBean() {
		super();
	}
	
	public TopicListBean(Topic topic, User user, Integer replyCount) {
		super();
		this.topic = topic;
		this.user = user;
		this.replyCount = replyCount;
	}
	
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getReplyCount() {
		return replyCount;
	}
	public void setReplyCount(Integer replyCount) {
		this.replyCount = replyCount;
	}
	
	
	
}
