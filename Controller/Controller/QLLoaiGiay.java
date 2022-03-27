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

import bean.Adminbean;
import bean.Loaibean;
import bean.Giaybean;
import bo.Adminbo;
import bo.Loaibo;
import bo.Giaybo;

/**
 * Servlet implementation class QLLoaiGiay
 */
@WebServlet("/QLLoaiGiay")
public class QLLoaiGiay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QLLoaiGiay() {
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
			String ml= request.getParameter("ml");
			String key= request.getParameter("key");
			ArrayList<Loaibean> dsloai=lbo.getloai();
			ArrayList<Giaybean> dssach= sbo.getsach();
			//
			
			//
			if(ml!=null) dssach= sbo.TimLoai(dssach, ml);
			else
				if(key!=null) dssach=sbo.Tim(dssach, key);
			
     		session.setAttribute("dsloaiad", dsloai);
     		session.setAttribute("dssachad", dssach);   		
    		response.setContentType("text/html");
		    RequestDispatcher rd= request.getRequestDispatcher("QLLoaiGiay.jsp");
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