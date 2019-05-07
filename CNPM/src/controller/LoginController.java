package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model_LoginAccount.LoginDAO;

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

		action = request.getParameter("action"); // hành động đăng nhập
		// 1. login == Account (username, password)
		if (action.equals("account")) {
			String userName = request.getParameter("userName");
			String password = request.getParameter("pass");
			// kiểm tra trong database
			if (LoginDAO.checkInfo(userName, passWord)) {
				// 6.1 Nếu thông tin hợp lệ thì đăng nhập vào hệ thống
				PrintWriter pw = response.getWriter();
				pw.println("Logged in successfully</h2>");
				pw.println("Username: " + userName);
				pw.println("Password: " + password);
				// chuyển đến trang login thành công

			} else {
				// 7.1 Nếu thông tin không hợp lệ thì quay lại trag đăng nhập và cho phép nhập lại
				// thông báo login thất bại và chuyển đến trang đăng nhập lại
				RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
				request.setAttribute("message", "Login failed");
				rd.forward(request, response);
			}
		}
		// login == Facebook
		else if (action.equals("facebook")) {
			// code here
		}
		// login == Google
		else if (action.equals("google")) {
			// code here
		}
		

	}

}
