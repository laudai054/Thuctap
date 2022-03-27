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
import bean.khachhangbean;
import bo.ChiTietHoaDonbo;
import bo.HoaDonbo;

/**
 * Servlet implementation class HTThanhToan
 */
@WebServlet("/HTThanhToan")
public class HTThanhToan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HTThanhToan() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession(true);  
		khachhangbean khxn=(khachhangbean)session.getAttribute("dn");
		if(khxn==null) {
			session.setAttribute("khxn",(int)1);
			RequestDispatcher rd= request.getRequestDispatcher("HTGiay");
		    rd.forward(request, response);
		}
		
		try {
			HoaDonbo hdbo= new HoaDonbo();
			ChiTietHoaDonbo ctbo= new ChiTietHoaDonbo();
			
			String ml= request.getParameter("ml");
			khachhangbean kh=(khachhangbean)session.getAttribute("dn");
			ArrayList<HoaDonbean> dshoadon=hdbo.GetHd(kh.getMakh());
			
			ArrayList<ChiTietHoaDonbean> dsct=ctbo.getCT(kh.getMakh());
			

			session.setAttribute("dsHoaDonLS", dshoadon); //hoa don
			session.setAttribute("dsCTHD", dsct);			//ct hoa don
     		System.out.println("LichSu.java");	
    		response.setContentType("text/html");
		    RequestDispatcher rd= request.getRequestDispatcher("ThanhToan.jsp");
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