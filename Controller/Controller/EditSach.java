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
 * Servlet implementation class EditSach
 */
@WebServlet("/EditSach")
public class EditSach extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditSach() {
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
	    
		String so=request.getParameter("slmua");
		String masach=(String)request.getParameter("MaSach");
		String CapNhat=request.getParameter("sub0");
		String Xoa=request.getParameter("sub1");
		GioHangbo gh1 = new GioHangbo();
		gh1=(GioHangbo)session.getAttribute("gh");                      //Lấy arraylist gh
		 
		                                                                                                        
		if(CapNhat!=null){					//Cập nhật sách
		        long so2=Long.parseLong(so);   
		        gh1.SetSL(masach,so2);
		        session.setAttribute("gh", gh1);
  
		}else{								//Xóa sách                                                             
			int count1=gh1.dem();
			gh1.xoa(masach);
		    session.setAttribute("gh", gh1);
		    if(count1==1) { 				//kiểm tra số sách còn lại nếu =1 nghĩa là đã hết vì đã gọi hàm xóa ở trên
				session.setAttribute("dem", (int)0);
				RequestDispatcher rd= request.getRequestDispatcher("HTGiay");
			    rd.forward(request, response);
		    }
		}
		response.setContentType("text/html"); //set response cho session
		
	    RequestDispatcher rd= request.getRequestDispatcher("giohang"); //set response cho request
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