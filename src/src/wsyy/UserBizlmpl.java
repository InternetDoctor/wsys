package wsyy;

public class UserBizlmpl implements UserBiz {
	private UserKou userkou=new Userfind();
	public User findUser(String name) {
		// TODO Auto-generated method stub
		return userkou.findUser(name);
	}

}
