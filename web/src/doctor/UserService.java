package doctor;



/**
 * ��Dao���web������ݽ�����֤�Ľӿ���
 */
public interface UserService {
	/*ע��*/
	public boolean register(User user);
	/*��¼*/
	public boolean login(String username, String password);
}
