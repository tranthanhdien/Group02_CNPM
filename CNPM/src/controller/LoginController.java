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
		// 5. Lấy thông tin từ Form 
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String userName = request.getParameter("userName");
		String password = request.getParameter("pass");
		// 5. Kiểm tra thông tin trong database
		LoginAccount account = new LoginAccount();
		if (account.login(userName, password)) {
			// 6.1 Nếu thông tin hợp lệ thì chuyển qua trang login thành công
			PrintWriter pw = response.getWriter();
			pw.println("Logged in successfully</h2>");
			pw.println("Username: " + userName);
			pw.println("Password: " + password);
		} else {
			// 7.1 Nếu thông tin không hợp lệ thì quay lại trag đăng nhập và cho phép nhập lại
			RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
			request.setAttribute("message", "Login failed, type again!");
			rd.forward(request, response);
		}

	}

}
