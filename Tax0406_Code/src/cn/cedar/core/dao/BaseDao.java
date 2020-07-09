package cn.cedar.core.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {
	//����
	public void save(T entity);
	//����
	public void update(T entity);
	//����idɾ��
	public void delete(Serializable id);
	//����id����
	public T findByObjectById(Serializable id);
	//�����б�
	public List<T> findObjects();
}
