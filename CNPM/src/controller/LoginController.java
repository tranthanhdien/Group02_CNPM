package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.LoginDAO;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 5. Lấy thông tin từ Form và gọi pthuc kiểm tra trong database
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("pass");
		if (LoginDAO.checkInfo(userName, passWord)) {
			// 6.1 Nếu thông tin hợp lệ thì đăng nhập vào hệ thống
			PrintWriter pw = response.getWriter();
			pw.println("<h2 style=text-align: center>Logged in successfully</h2>");
			// chuyển đến trang login thành công

		} else {
			// 7.1 Nếu thông tin không hợp lệ thì quay lại trag đăng nhập và cho phép nhập lại
//			PrintWriter pw = response.getWriter();
//			pw.println("<h2>Login thất bại</h2>");
			// thông báo login thất bại và chuyển đến trang đăng nhập lại
			RequestDispatcher rd = request.getRequestDispatcher("/loginUI.jsp");
			request.setAttribute("message", "Login failed");
			rd.forward(request, response);
		}

	}

}
