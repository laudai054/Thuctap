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
import bo.HoaDonbo;
import bean.Loaibean;
import bean.Giaybean;
import bo.Loaibo;
import bo.Giaybo;

/**
 * Servlet implementation class AdminQLDonHang
 */
@WebServlet("/AdminQLDonHang")
public class AdminQLDonHang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminQLDonHang() {
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
			HoaDonbo hdbo = new HoaDonbo();
			ArrayList<HoaDonbean> dshd=hdbo.GetallHd();

     		session.setAttribute("addshd", dshd);   		
    		response.setContentType("text/html");
		    RequestDispatcher rd= request.getRequestDispatcher("AdminQLDonHang.jsp");
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