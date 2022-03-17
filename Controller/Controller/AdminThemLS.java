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
 * Servlet implementation class AdminThemLS
 */
@WebServlet("/AdminThemLS")
public class AdminThemLS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminThemLS() {
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
		    
		    String themloai=(String)request.getParameter("themloai");
		    
			String maloai=(String)request.getParameter("maloai");
			String tenloai=(String)request.getParameter("tenloai");
			//Lấy arraylist gh
			Loaibo lbo = new Loaibo();
			boolean xn=false;

			if(themloai!=null) {
				xn=lbo.themloai(maloai, tenloai);
				session.setAttribute("adthemls", xn);
				session.setAttribute("themphu", xn);
			}
			
			response.setContentType("text/html"); //set response cho session
		    RequestDispatcher rd= request.getRequestDispatcher("AdminQLLoaiGiay"); //set response cho request
		    rd.forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
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