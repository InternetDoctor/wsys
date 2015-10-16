package doctor;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


/**

 *        与数据库交互的实现类
 */
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
	/* 注册 */
	public Integer register(User user) {
		try
		{
			System.out.println("dao");
			return (Integer) this.getHibernateTemplate().save(user);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	/* 登录 */
	@SuppressWarnings("unchecked")
	public User login(String username, String password) {
		String hql = "from doctor login where username= '" + username+"' and password='"+password+"'";
		
//		String hql1 = "from User u where u.username= ? and u.password = ?";
//		List<User> list1 = this.getHibernateTemplate().find(hql, new String[]{username, password});
		List<User> list = this.getHibernateTemplate().find(hql);
		if(list != null && list.size() >= 1)
		{
			return (User)list.get(0);
		}
		return null;
	}
}
