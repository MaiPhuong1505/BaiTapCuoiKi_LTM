package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.DAO;

/**
 * Servlet implementation class ProcessController
 */
@WebServlet("/Welcome")
public class ProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/Welcome.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hello");
		int n = Integer.parseInt(request.getParameter("number"));
		DAO d = new DAO();
		d.caculate_factorial(n);
		response.setContentType("text/html");
//		Xuligiaithua p = null;
		PrintWriter out = response.getWriter();
//		
//		if (p==null) {
//			p = new Xuligiaithua(n);
//			p.start();
//		}
//		if (p.i!=n)
//			response.setIntHeader("Refresh", 1);
		out.print("<html><head></head><body>");
//		out.print(p.result);
		out.print("Hello");
		out.print("</body></html>");
//		calculate_exponent e = new calculate_exponent(300, 500);
//		e.start();
//		RequestDispatcher rd = getServletContext().getRequestDispatcher("/Welcome.jsp");
//		rd.forward(request, response);
//		response.sendRedirect("/CK_LTM/Welcome");
	}
}