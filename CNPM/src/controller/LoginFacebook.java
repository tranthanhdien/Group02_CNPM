package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.restfb.types.User;

import model_LoginFacebook.RestFB;

@WebServlet("/LoginFacebook")
public class LoginFacebook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginFacebook() {
		super();
		// TODO Auto-generated constructor stub
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
			String accessToken = RestFB.getToken(code);
			User user = RestFB.getUserInfo(accessToken);
			System.out.println(user.getId());
			System.out.println(user.getName());
			System.out.println(user.getEmail());
			request.setAttribute("id", user.getId());
			request.setAttribute("name", user.getName());
			RequestDispatcher dis = request.getRequestDispatcher("/index.jsp");
			dis.forward(request, response);
		}
	}

}
