package bbs.entity;

public class ReplyListBean {
	private Reply reply;
	private User user;
	
	
	public ReplyListBean() {
		super();
	}
	public ReplyListBean(Reply reply, User user) {
		super();
		this.reply = reply;
		this.user = user;
	}
	public Reply getReply() {
		return reply;
	}
	public void setReply(Reply reply) {
		this.reply = reply;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}