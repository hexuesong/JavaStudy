package cn.cedar.test.DAO;

import java.io.Serializable;

import cn.cedar.test.entity.Person;

public interface TestDao {
	// ������Ա
	public void save(Person person);

	// ����ID��ѯ��Ա
	public Person findPerson(Serializable id);
}
