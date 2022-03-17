package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ChiTietHoaDonbean;
import bean.HoaDonbean;
import bo.ChiTietHoaDonbo;
import bo.HoaDonbo;

/**
 * Servlet implementation class AdminQLCTHD
 */
@WebServlet("/AdminQLCTHD")
public class AdminQLCTHD extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminQLCTHD() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setCharacterEncoding("utf-8");
			request.setCharacterEncoding("utf-8");
			HttpSession session = request.getSession(true);

			String key= request.getParameter("key");
			ChiTietHoaDonbo cthdbo = new ChiTietHoaDonbo();
			ArrayList<ChiTietHoaDonbean> addscthd=cthdbo.getallCT();

     		session.setAttribute("addscthd", addscthd);   		
    		response.setContentType("text/html");
		    RequestDispatcher rd= request.getRequestDispatcher("AdminQLCTHD.jsp");
		    rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
