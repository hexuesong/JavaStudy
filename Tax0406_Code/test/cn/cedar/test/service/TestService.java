package cn.cedar.test.service;

import java.io.Serializable;

import cn.cedar.test.entity.Person;

public interface TestService {
	// ���
	public void say();

	// ������Ա
	public void save(Person person);

	// ����ID��ѯ��Ա
	public Person findPerson(Serializable id);
}
