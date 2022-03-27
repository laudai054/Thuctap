package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.GioHangbo;

/**
 * Servlet implementation class giohang
 */
@WebServlet("/giohang")
public class giohang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public giohang() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
	    request.setCharacterEncoding("utf-8");
	    HttpSession session = request.getSession(true);
	    String masach=request.getParameter("ms");
	    String tensach=request.getParameter("ts");
	    String tacgia=request.getParameter("tg");
	    String giatam=request.getParameter("gia");
	    String anh=request.getParameter("a");
	    //Neu nguoi dung mua lan dau tien
	    GioHangbo gh=null;
	    if(session.getAttribute("gh")==null){
	    	gh= new GioHangbo();
	    	session.setAttribute("gh", gh);
	    }
	    if(masach!=null){
	    //b1: gan session vao bien
	     gh=(GioHangbo)session.getAttribute("gh");
	     gh.Them(masach, tensach, tacgia, anh, Long.parseLong(giatam), (long)1);//b2
	     session.setAttribute("gh", gh);
	    }
	    
	    //set biến dem sách
	    GioHangbo ghdem= new GioHangbo();
	    ghdem=(GioHangbo)session.getAttribute("gh");
	    int dem=0;
		dem=ghdem.dem();	
		session.setAttribute("dem", (int)dem);
	    	    
	    response.setContentType("text/html"); //set response cho session
	    
	    RequestDispatcher rd= request.getRequestDispatcher("HTgio.jsp"); //set response cho request
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