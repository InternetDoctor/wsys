package doctor;

//import org.yixing.entity.User;
/**
 * 
 * �����ݿ���н����Ľӿ�
 */
public interface UserDao {
	/*ע��*/
	public Integer register(User user);
	/*��¼*/
	public User login(String username, String password);
}
