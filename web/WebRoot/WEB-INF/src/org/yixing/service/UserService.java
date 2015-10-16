package org.yixing.service;

import org.yixing.entity.User;

/**
 * 
 * @author jerry
 * @Date 2012-12-6
 * @Email 1457049206@qq.com
 * 对Dao层和web层的数据进行验证的接口类
 */
public interface UserService {
	/*注册*/
	public boolean register(User user);
	/*登录*/
	public boolean login(String username, String password);
}
