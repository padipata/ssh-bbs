package bbs.dao;

import java.util.List;

import bbs.entity.Topic;

public interface ITopicDAO {

	public boolean addTopic(Topic topic); // 新增主帖

	public boolean deleteTopic(int topicId); // 删除主帖

	public Topic findTopicById(int topicId); // 根据id查找主帖

	public List<Topic> findTopicList(int page, int boardId); // 查询版块相关主帖列表

	public int findCountTopic(int boardId); // 版块相关主帖数
}
