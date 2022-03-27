package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.khachhangbean;
import bo.khachhangbo;

/**
 * Servlet implementation class DangKy
 */
@WebServlet("/DangKy")
public class DangKy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DangKy() {
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
		khachhangbo khbo=new khachhangbo();
		String hoten=request.getParameter("hoten");
		String diachi=request.getParameter("diachi");
		String sdt=request.getParameter("sdt");
		String email=request.getParameter("email");
		String tendn=request.getParameter("tendn");
		String matkhau=request.getParameter("matkhau");		
		khachhangbean dky = null;
		try {
			System.out.println("dky1");
			dky = khbo.dangky(hoten, diachi, sdt, email, tendn, matkhau);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(dky!=null){
			System.out.println("dky2");
			session.setAttribute("dky", (khachhangbean)dky);	//set kt = 1
			session.setAttribute("ktdky", (long)0);	//set kt = 0
			response.sendRedirect("HTGiay");	
			
		}else{
			session.setAttribute("ktdky", (long)1);	//set kt = 0
			response.sendRedirect("HTGiay");
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