package bbs.dao.impl;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import bbs.dao.IBaseDAO;
import bbs.dao.ITopicDAO;
import bbs.entity.Topic;

public class TopicDAO extends BaseHibernateDAO implements ITopicDAO {
	IBaseDAO baseDAO = new BaseDAO();

	public int findCountTopic(int boardId) {
		Session session = super.getSession();
		Criteria criteria = session.createCriteria(Topic.class);
		criteria.add(Restrictions.eq("boardId", boardId));//查询条件：等于boardId
		criteria.setProjection(Projections.rowCount());//统计记录行数
		Integer result = (Integer) criteria.uniqueResult();
		return result.intValue();
	}

	@SuppressWarnings("unchecked")
	public List<Topic> findTopicList(int page, int boardId) {
		Session session = super.getSession();
		Criteria criteria = session.createCriteria(Topic.class);
		int rowBegin = 0; // 开始行数，表示每页第一条记录在数据库中的行数
		if (page > 1) {
			rowBegin = (page - 1) * 10; // 按页数取得开始行数，设置每页可显示10条记录
		}
		criteria.setFirstResult(rowBegin);	//取第一条记录的行所在位置
		criteria.setMaxResults(10);			//取记录的行数
		criteria.add(Restrictions.eq("boardId", boardId));//查询条件：等于boardId
		criteria.addOrder(Order.desc("publishTime")); //排序条件：降序排
		return criteria.list();
	}

	public Topic findTopicById(int topicId) {
		return (Topic) super.findById(Topic.class, topicId);
	}

	public boolean addTopic(Topic topic) {
		Timestamp time = new Timestamp(System.currentTimeMillis());
		topic.setPublishTime(time);
		topic.setModifyTime(time);
		return super.add(topic);
	}

	public boolean deleteTopic(int topicId) {
		
		return super.delete(Topic.class, topicId);
	}

}
