package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.Loaibo;

/**
 * Servlet implementation class AdminXoaLoaiGiay
 */
@WebServlet("/AdminXoaLoaiGiay")
public class AdminXoaLoaiGiay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminXoaLoaiGiay() {
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
	    
		String maloai=(String)request.getParameter("xlg");                      //Lấy arraylist gh
		Loaibo sbo = new Loaibo();
		try {
			sbo.xoaloai(maloai);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setContentType("text/html"); //set response cho session
		session.setAttribute("xoa", true);
		
	    RequestDispatcher rd= request.getRequestDispatcher("AdminQLLoaiGiay"); //set response cho request
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
