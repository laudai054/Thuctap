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

import bean.GioHangbean;
import bean.khachhangbean;
import bean.Loaibean;
import bean.Giaybean;
import bo.ChiTietHoaDonbo;
import bo.GioHangbo;
import bo.HoaDonbo;
import bo.Loaibo;
import bo.Giaybo;
import dao.ChiTietHoaDondao;
import dao.HoaDondao;

/**
 * Servlet implementation class XacNhanDatMua
 */
@WebServlet("/XacNhanDatMua")
public class XacNhanDatMua extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XacNhanDatMua() {
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
			}
			else {
				GioHangbo gh=null;
				gh= new GioHangbo();
		    	gh=(GioHangbo)session.getAttribute("gh");
		    	HoaDonbo hdbo= new HoaDonbo();
		    	ChiTietHoaDonbo cthdb= new ChiTietHoaDonbo();
		    	try {
					hdbo.ThemHd(khxn.getMakh(), false);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	for(GioHangbean g1: gh.ds){
		    		System.out.println("XNDM loop");
		    		try {
						cthdb.ThemCthd(g1.getMasach(), g1.getSlmua());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    	}
		    	session.setAttribute("gh",null);
			}
		    RequestDispatcher rd= request.getRequestDispatcher("giohang");
		    rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}