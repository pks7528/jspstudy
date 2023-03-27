package ex11_upload_download;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		  	파일 업로드를 위한 작업
		  	1. http://servlets.com에 방문한다
		  	2. COS File Upload Library 메뉴에 있는 cos-22.05.zip 파일을 다운로드 받는다.
		  	3. 압축 해제 후 lib 디렉터리에 있는 cos.jar 파일을 프로젝트의 lib로 등록한다.
		*/
		
		/*
			cos.jar
			1. 파일 업로드가 필요한 경우에 사용하는 라이브러리이다.
			2. HttpServletRequest 클래스는 파일 업로드를 처리할 수 없다.
			3. MultipartRequest 클래스를 이용해서 파일 업로드를 처리할 수 있는데, cos.jar가 MultipartRequest 클래스를 지원한다.
		*/
		
		// 업로드 경로 (서버의 real path를 사용하거나 일반 경로를 사용할 수 있다.)
		String realPath = request.getServletContext().getRealPath("storage");
		File dir = new File(realPath);
		if(dir.exists() == false) {
			dir.mkdirs();
		}
				
		// 업로드 진행하기 (HttpServletRequest request를 이용해서 MultipartRequest 객체를 생성하면 업로드가 곧바로 진행된다.)
		MultipartRequest multipartRequest = new MultipartRequest(
				request, 			// HttpServletRequest
				realPath,			//업로드 경로
				1024 * 1024 * 10,	// 최대 크기
				"UTF-8",			// 인코딩
				new DefaultFileRenamePolicy()	// 파일명 중복 처리 정책 (파일명 뒤에 넘버링)
		);
		
		// 요청 파라미터 (MultipartRequest multipartRequest를 이용해서 파라미터를 가져와야 한다.)
		String uploader = multipartRequest.getParameter("uploader");
		String originName = multipartRequest.getOriginalFileName("filename");	// 원래 첨부 파일명
		String filesystemName = multipartRequest.getFilesystemName("filename");	// 저장된 첨부 파일명
		
		// 첨부 파일 정보
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
