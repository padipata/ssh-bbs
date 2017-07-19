package bbs.dao;

import java.util.List;

import bbs.entity.Reply;

public interface IReplyDAO {

	public boolean addReply(Reply reply); // 新增回帖

	public boolean deleteReply(int replyId); // 删除回帖

	public boolean updateReply(Reply reply); // 修改回帖

	public Reply findReplyById(int replyId); // 根据id查找回帖

	public List<Reply> findReplyList(int page, int topicId); // 查询主帖相关回帖列表

	public int findCountReply(int topicId); // 主帖相关回帖数
}
