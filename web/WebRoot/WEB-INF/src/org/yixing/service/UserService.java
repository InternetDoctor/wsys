package org.yixing.service;

import org.yixing.entity.User;

/**
 * 
 * @author jerry
 * @Date 2012-12-6
 * @Email 1457049206@qq.com
 * ��Dao���web������ݽ�����֤�Ľӿ���
 */
public interface UserService {
	/*ע��*/
	public boolean register(User user);
	/*��¼*/
	public boolean login(String username, String password);
}
