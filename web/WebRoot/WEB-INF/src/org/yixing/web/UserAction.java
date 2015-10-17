package org.yixing.web;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.yixing.entity.User;
import org.yixing.service.UserService;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 
 * @author jerry
 * @Date 2012-12-6
 * @Email 1457049206@qq.com
 * 
 * ������ת��
 */
public class UserAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private User user;
	private UserService userService;
	
	private boolean flag = false;
	
	public void setUser(User user) {
		this.user = user;
	}
	public User getUser() {
		return user;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	/*public UserAction() {
		user = new User();
	}*/
	/*ע��*/
	public String register() throws Exception {
		System.out.println("action");
		flag = userService.register(user);
		if(flag == true)
		{
			return SUCCESS;
		}
		return ERROR;
	}
	
	/*��¼*/
	public String login() throws Exception {
		
		/*	
		flag = userService.login(user.username, user.password);
		if(flag == true)
		{
			return SUCCESS;
		}
		return ERROR;*/
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		
		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		flag = userService.login(username, password);
		if(flag == true)
		{
			out.print("1");
		}else
		{
			out.print("0");
		}
		//ˢ����
		out.flush();
		//�ر���
		out.close();
		
		return null;
	}
}
