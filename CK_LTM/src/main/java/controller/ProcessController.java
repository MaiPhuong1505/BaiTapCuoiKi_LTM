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
		response.setContentType("text/html");
		Xuli p = null;
		PrintWriter out = response.getWriter();
		
		if (p==null) {
			p = new Xuli(n);
			p.start();
		}
		if (p.i!=n)
			response.setIntHeader("Refresh", 1);
		out.print("<html><head></head><body>");
		out.print(p.result);
		out.print("</body></html>");
//		RequestDispatcher rd = getServletContext().getRequestDispatcher("/Welcome.jsp");
//		rd.forward(request, response);
//		response.sendRedirect("/CK_LTM/Welcome");
	}
}
class Xuli extends Thread
{
	int n;
	int i=0;
	String result = "";
	public Xuli(int n)
	{
		this.n = n;
	}
	public void run()
	{
		ArrayList<Integer> a = new ArrayList<Integer>();
	    long x =0;
	    a.add(1);
		for(int i = 2; i <= n; i++)
		{
			for(int j = 0; j < a.size(); j++)
			{
				long y = x;
				x = (a.get(j)*i + x)/10;
				int z = (int)(a.get(j)*i + y)%10;
				a.set(j,z); 
			}
			while(x != 0)
			{
				int z = (int)x%10;
				a.add(z);
				x/=10;
			}
		}
		for(int i = a.size() -1; i >= 0; i--)
		{
			result += a.get(i);
		}
		System.out.println(result);
	}
}