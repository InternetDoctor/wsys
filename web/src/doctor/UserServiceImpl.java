package doctor;

/*import org.yixing.dao.UserDao;
import org.yixing.entity.User;
import org.yixing.service.UserService;*/
/**
 * ��Dao���web������ݽ�����֤��ʵ����
 */
public class UserServiceImpl implements UserService {
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/*ע��*/
	public boolean register(User user) {
		int result = userDao.register(user);
		if(result > 0)
		{
			System.out.println("service");
			return true;
		}
		return false;
	}
	
	/*��¼*/
	public boolean login(String username, String password) {
		System.out.println(userDao.login(username, password));
		if(userDao.login(username, password) != null)
		{
			return true;
		}
		return false;
	}
}
