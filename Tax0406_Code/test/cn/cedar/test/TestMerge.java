package cn.cedar.test;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.cedar.test.entity.Person;
import cn.cedar.test.service.TestService;

public class TestMerge {
	
	ClassPathXmlApplicationContext ctx;

	@Before
	public void loadCtx() {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	@Test
	public void testSpring() {
		TestService ts = (TestService)ctx.getBean("testService");
		ts.say();
	}
	
	@Test
	public void testHibernate() {
		SessionFactory sf = (SessionFactory)ctx.getBean("sessionFactory");
		
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		//保存人员
		session.save(new Person("��Ա6"));
		transaction.commit();
		session.close();
	}
	
	@Test
	public void testServiceAndDao() {
		TestService ts = (TestService)ctx.getBean("testService");
		ts.save(new Person("��Ա2"));
		//System.out.println(ts.findPerson("4028eea54c8cdb1f014c8cdb20ab0000").getName());
	}
	
	@Test
	public void testTransationReadOnly() {//��������
		TestService ts = (TestService)ctx.getBean("testService");
		System.out.println(ts.findPerson("4028eea54c8cdb1f014c8cdb20ab0000").getName());
	}
	
	@Test
	public void testTransationRollback() {//
		TestService ts = (TestService)ctx.getBean("testService");
		ts.save(new Person("��Ա4"));
	}

}
