package org.yixing.dao;

import org.yixing.entity.User;
/**
 * 
 * @author jerry
 * @Date 2012-12-6
 * @Email 1457049206@qq.com
 * �����ݿ���н����Ľӿ�
 */
public interface UserDao {
	/*ע��*/
	public Integer register(User user);
	/*��¼*/
	public User login(String username, String password);
}
