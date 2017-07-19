package bbs.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import bbs.dao.IBaseDAO;
import bbs.dao.IBoardDAO;
import bbs.entity.Board;

public class BoardDAO extends BaseHibernateDAO implements IBoardDAO {
	IBaseDAO baseDAO = new BaseDAO();

	@SuppressWarnings("unchecked")
	public List<Board> findBoardList() {
		Session session = super.getSession();
		Criteria criteria = session.createCriteria(Board.class);
		return criteria.list();
	}

	public Board findBoardById(int boardId) {
		
		return (Board) super.findById(Board.class, boardId);
	}

}
