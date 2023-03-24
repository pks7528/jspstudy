package practice07;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PapagoServlet")
public class PapagoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 요청 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// 요청 파라미터
		String source = request.getParameter("source");		// 원본 언어 코드(ko, en, ja 중 하나)
		String target = request.getParameter("target");		// 목적 언어 코드(ko, en, ja 중 하나)
		String text = request.getParameter("text");			// 번역할 텍스트
		
		// 클라이언트 아이디, 시크릿 (네이버개발자센터에서 발급 받은 본인 정보 사용합니다.)
		String clientId = "RYDyUfaSZeFppITbRDy6";
		String clientSecret = "_RfgAHTqCW";
		
		// API 주소
		String apiURL = "https://openapi.naver.com/v1/papago/n2mt";
		
		// URL
		URL url = new URL(apiURL);
		
		// HttpURLConnection
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		
		// 요청 메소드
		con.setRequestMethod("POST");
		
		// 요청 헤더에 포함하는 내용
		con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		con.setRequestProperty("X-Naver-Client-Id", clientId);
		con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
