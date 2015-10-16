package org.yixing.dao;

import org.yixing.entity.User;
/**
 * 
 * @author jerry
 * @Date 2012-12-6
 * @Email 1457049206@qq.com
 * 与数据库进行交互的接口
 */
public interface UserDao {
	/*注册*/
	public Integer register(User user);
	/*登录*/
	public User login(String username, String password);
}
