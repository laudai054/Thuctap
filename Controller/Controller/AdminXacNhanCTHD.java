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

import bean.HoaDonbean;
import bo.ChiTietHoaDonbo;
import bo.HoaDonbo;

/**
 * Servlet implementation class AdminXacNhanCTHD
 */
@WebServlet("/AdminXacNhanCTHD")
public class AdminXacNhanCTHD extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminXacNhanCTHD() {
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

			String MaCTHD= request.getParameter("mact");
			ChiTietHoaDonbo hdbo = new ChiTietHoaDonbo();
			boolean xn;
			xn=hdbo.xacnhan(MaCTHD);
     		session.setAttribute("xacnhan", xn);   		
    		response.setContentType("text/html");
    		
		    RequestDispatcher rd= request.getRequestDispatcher("AdminQLCTHD");
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