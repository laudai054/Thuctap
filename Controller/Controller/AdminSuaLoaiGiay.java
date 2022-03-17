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

import bean.Loaibean;
import bean.Giaybean;
import bo.ChiTietHoaDonbo;
import bo.Loaibo;
import bo.Giaybo;

/**
 * Servlet implementation class AdminSuaLoaiGiay
 */
@WebServlet("/AdminSuaLoaiGiay")
public class AdminSuaLoaiGiay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSuaLoaiGiay() {
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
			Loaibo lbo= new Loaibo();
			Giaybo sbo= new Giaybo();
			String maloai= request.getParameter("maloai");
			String tenloai= request.getParameter("tenloai");
			
			lbo.SuaLoai(maloai, tenloai);
			System.out.println("abc");
    		response.setContentType("text/html");
		    RequestDispatcher rd= request.getRequestDispatcher("AdminQLLoaiGiay");
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
