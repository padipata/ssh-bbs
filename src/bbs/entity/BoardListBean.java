package bbs.entity;

public class BoardListBean {
	private Board board;
	private User user;
	private Topic topic;
	private Integer topicCount;
	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
		this.board = board;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public Integer getTopicCount() {
		return topicCount;
	}
	public void setTopicCount(Integer topicCount) {
		this.topicCount = topicCount;
	}
	public BoardListBean(Board board, User user, Topic topic, Integer topicCount) {
		super();
		this.board = board;
		this.user = user;
		this.topic = topic;
		this.topicCount = topicCount;
	}
	public BoardListBean() {
		super();
	}
	
}
