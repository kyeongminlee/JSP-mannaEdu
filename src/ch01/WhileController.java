package ch01;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WhileController
 */
// url 매핑을 자동으로 해주는 어노테이션
// @WebServlet("/WhileController")
// 서블릿 : 서버에서 실행되는 자바 프로그램
public class WhileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// get 방식으로 요청할 때 실행되는 코드
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int number = Integer.parseInt(request.getParameter("number"));
		int num = Integer.parseInt(request.getParameter("num"));
		int result = 1;
		for(int i = 1; i <= num; i++) {
			result *= number;
		}
		// 톰캣 콘솔창에 출력됨
		System.out.println("결과 : " + result);
		
		// while_result.jsp에서 공유할 수 있도록 값을 저장
		request.setAttribute("result", result);
		
		// request.getRequestDispatcher(url) : 이동할 url의 정보 분석 객체
		RequestDispatcher rd = 
				request.getRequestDispatcher("/ch01/while_result.jsp");
		
		// 화면이 while_result.jsp로 넘어감(주소는 그대로 유지됨)
		rd.forward(request, response);
	}
	
	// post 방식으로 요청할 때 실행되는 코드
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
