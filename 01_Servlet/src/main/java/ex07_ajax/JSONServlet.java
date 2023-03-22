package ex07_ajax;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

/*
	Dynamic Web Project에서 외부 라이브러리(*.jar)를 사용하는 방법
	
	방법1. CATALINA_HOME\lib 디렉터리에 사용할 라이브러리를 추가한다.
	방법2. 컨텍스트(프로젝트)에 사용할 라이브러리를 추가한다. (수업에서 사용할 방법)
		   src/main/webapp/WEB-INF/lib 디렉터리에 외부 라이브러리 추가
*/
@WebServlet("/JSONServlet")
public class JSONServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 요청 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// 요청 파라미터
		String name = request.getParameter("name");
		String strAge = request.getParameter("age");
		int age = 0;
		if(strAge != null && strAge.isEmpty() == false) {
			age = Integer.parseInt(strAge);
		}
		
		// 응답할 JSON 데이터
		JSONObject obj = new JSONObject();
		obj.put("name", name);
		obj.put("age", age);
		
		System.out.println(obj.toString());		// {"name": "마돈나", "age": 50}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
