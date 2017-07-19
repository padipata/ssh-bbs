package bbs.dao;

import org.hibernate.Session;

public interface IBaseHibernateDAO {
	public Session getSession();
	public boolean add(Object item);
	public boolean update(Object item);
	@SuppressWarnings("unchecked")
	public boolean delete(Class classType, Integer id);
	@SuppressWarnings("unchecked")
	public Object findById(Class classType, Integer id);
}