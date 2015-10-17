package doctor;



/**
 * 对Dao层和web层的数据进行验证的接口类
 */
public interface UserService {
	/*注册*/
	public boolean register(User user);
	/*登录*/
	public boolean login(String username, String password);
}
