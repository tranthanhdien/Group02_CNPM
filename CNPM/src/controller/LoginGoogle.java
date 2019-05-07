package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model_LoginGoogle.GooglePojo;
import model_LoginGoogle.GoogleUtils;

@WebServlet("/LoginGoogle")
public class LoginGoogle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginGoogle() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String code = request.getParameter("code");
		if (code == null || code.isEmpty()) {
			RequestDispatcher dis = request.getRequestDispatcher("/login.jsp");
			dis.forward(request, response);
		} else {
			String accessToken = GoogleUtils.getToken(code);
			GooglePojo googlePojo = GoogleUtils.getUserInfo(accessToken);
			System.out.println(googlePojo.getId());
			System.out.println(googlePojo.getName());
			System.out.println(googlePojo.getEmail());
			request.setAttribute("id", googlePojo.getId());
			request.setAttribute("name", googlePojo.getName());
			request.setAttribute("email", googlePojo.getEmail());
			RequestDispatcher dis = request.getRequestDispatcher("/index.jsp");
			dis.forward(request, response);
		}

	}

}
