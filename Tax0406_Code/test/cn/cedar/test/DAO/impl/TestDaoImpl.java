package cn.cedar.test.DAO.impl;

import java.io.Serializable;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.cedar.test.DAO.TestDao;
import cn.cedar.test.entity.Person;

public class TestDaoImpl extends HibernateDaoSupport implements TestDao {
	
	//����
	@Override
	public void save(Person person) {
		getHibernateTemplate().save(person);
	}
	//����
	@Override
	public Person findPerson(Serializable id) {
		return getHibernateTemplate().get(Person.class, id);
	}

}
