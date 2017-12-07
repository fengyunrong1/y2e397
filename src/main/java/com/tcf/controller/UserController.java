package com.tcf.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tcf.entity.SmbmsUser;
import com.tcf.service.SmbmsRoleService;
import com.tcf.service.SmbmsUserService;


@Controller
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private SmbmsUserService us;
	@Autowired
	private SmbmsRoleService rs;
	
	@RequestMapping(value="login.do")  //user/login.do
	public String login(SmbmsUser user,HttpSession session,Model model){
		SmbmsUser logined = us.login(user);
		System.out.println(logined);
		if(logined != null){
			session.setAttribute("user", logined);
			return "frame";
		}
		session.setAttribute("error", "用户名或者密码错误");
		model.addAttribute("url", "/login.jsp");
		return "to";
	}
	@RequestMapping("logout.do")
	public String logout(HttpSession session,Model model){
		session.removeAttribute("user");
		model.addAttribute("url", "/login.jsp");
		return "to";
	}
	private Integer pageSize = 5;
	@RequestMapping("userList.do")
	public String userList(String userName,Integer userRole,@RequestParam(defaultValue="1") Integer pageIndex,Model model){
		int rows = us.getUserRows(userName, userRole);
		int totalPageCount = rows%pageSize==0?rows/pageSize:rows/pageSize+1;
		model.addAttribute("userList", us.getsmUsers(userName, userRole, pageIndex, pageSize));
		model.addAttribute("totalCount", rows);
		model.addAttribute("currentPageNo", pageIndex);
		model.addAttribute("totalPageCount", totalPageCount);
		model.addAttribute("userName", userName);
		model.addAttribute("userRole", userRole);
		model.addAttribute("roleList", rs.getAllSmbmsRoles());
		/*int a = 10/0;*/
		return "userlist";
	}
	
	/*@ExceptionHandler(value=RuntimeException.class)
	public String exceptionHandle(RuntimeException e,HttpServletRequest req){
		req.setAttribute("e", e);
		return "error";
	}*/
	/*@ExceptionHandler({RuntimeException.class})
	public String exceptionHandle(RuntimeException e,HttpServletRequest req){
		req.setAttribute("e", e);
		return "error";
	}*/
}
