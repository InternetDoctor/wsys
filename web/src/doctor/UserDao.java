package doctor;

//import org.yixing.entity.User;
/**
 * 
 * 与数据库进行交互的接口
 */
public interface UserDao {
	/*注册*/
	public Integer register(User user);
	/*登录*/
	public User login(String username, String password);
}
