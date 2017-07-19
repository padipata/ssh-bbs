package bbs.dao.impl;

import bbs.dao.IBaseHibernateDAO;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BaseHibernateDAO implements IBaseHibernateDAO {
	
	public Session getSession() {
		return HibernateSessionFactory.getSession();
	}

	public boolean add(Object item) {
		/**
		1.打开session
		2.开始一个事物
		3.数据持久化操作
		4.提交事务
		5.关闭session
		*/
		Session session = this.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.merge(item);
			tx.commit();
		} catch (Exception e) {
			if(tx!=null){
				tx.rollback(); //事物回滚
			}
			return false;
		}finally{
			session.close();
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public boolean delete(Class classType, Integer id) {
		Session session = this.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(session.get(classType, id));
			tx.commit();
		} catch (Exception e) {
			if(tx!=null){
				tx.rollback(); //事物回滚
			}
			return false;
		}finally{
			session.close();
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public Object findById(Class classType, Integer id) {
		Session session = this.getSession();
		return session.get(classType, id);
	}

	public boolean update(Object item) {
		Session session = this.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(item);
			tx.commit();
		} catch (Exception e) {
			if(tx!=null){
				tx.rollback(); //事物回滚
			}
			return false;
		}finally{
			session.close();
		}
		return true;
	}
	
}