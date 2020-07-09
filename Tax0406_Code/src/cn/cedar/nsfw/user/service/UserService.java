package cn.cedar.nsfw.user.service;

import java.io.Serializable;
import java.util.List;

import cn.cedar.nsfw.user.entity.User;

public interface UserService {
	// ����
	public void save(User user);

	// ����
	public void update(User user);

	// ����idɾ��
	public void delete(Serializable id);

	// ����id����
	public User findByObjectById(Serializable id);

	// �����б�
	public List<User> findObjects();
}
