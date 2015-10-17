package doctor;

/*import org.yixing.dao.UserDao;
import org.yixing.entity.User;
import org.yixing.service.UserService;*/
/**
 * 对Dao层和web层的数据进行验证的实现类
 */
public class UserServiceImpl implements UserService {
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/*注册*/
	public boolean register(User user) {
		int result = userDao.register(user);
		if(result > 0)
		{
			System.out.println("service");
			return true;
		}
		return false;
	}
	
	/*登录*/
	public boolean login(String username, String password) {
		System.out.println(userDao.login(username, password));
		if(userDao.login(username, password) != null)
		{
			return true;
		}
		return false;
	}
}
