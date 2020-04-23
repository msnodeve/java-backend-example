package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.dto.User;
import com.service.UserService;
import com.service.UserServiceInterface;

@WebServlet("/user.do")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserServiceInterface userService;
	
	@Override
	public void init() throws ServletException {
		userService = new UserService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // 추 후 한글화 필터 적용 예정
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String root = request.getContextPath();
		String act = request.getParameter("act");
		String path = "/index.jsp";
		
		switch (act) {
		case "login":
			login(request, response);
			break;
		case "mvjoin":
			path = "/user/join.jsp";
			redirect(response, path, root);
			break;
		case "join":
			signIn(request, response);
			break;
		}
	}

	private void signIn(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "";
		
		String id = request.getParameter("userid");
		String pw = request.getParameter("userpwd");
		String email = request.getParameter("useremail");
		String address = request.getParameter("address");
		String tel = request.getParameter("tel");
		
		User user = new User(id, pw, email, address, tel);
		
		try {
			userService.signIn(user);
			path = "/index.jsp";
			redirect(response, path, request.getContextPath());
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "회원 가입 중 에러 발생");
			path = "/error/error.jsp";
			forward(request, response, path);
		}
	}
	
	private void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "/index.jsp";
		String id = request.getParameter("userid");
		String pw = request.getParameter("userpwd");
		
		try {
			User user = userService.login(id, pw);
			if(user != null) {
				HttpSession session = request.getSession();
				session.setAttribute("userinfo", user);
			}else {
				request.setAttribute("msg", "아이디 또는 비밀번호를 확인 해 주세요.");
			}
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "로그인 중 에러 발생");
			path = "/error/error.jsp";
			forward(request, response, path);
		}
		request.getRequestDispatcher(path).forward(request, response);
	}
	
	private void forward(HttpServletRequest request, HttpServletResponse response, String path)
			throws ServletException, IOException {
		request.getRequestDispatcher(path).forward(request, response);
	}

	private void redirect(HttpServletResponse response, String path, String root) throws IOException {
		response.sendRedirect(root + path);
	}
}
