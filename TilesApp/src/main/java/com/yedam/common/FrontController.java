package com.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.notice.command.*;


public class FrontController extends HttpServlet {
	
	private Map<String, Command> map;
	private String charset;
	
	public FrontController() {
		map = new HashMap<String, Command>();
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// init 치고 컨틀로 스페이스 해서 오버라이드
		
		charset = config.getInitParameter("charset");
		map.put("/main.do", new MainControl());
		map.put("/second.do", new SecondControl());
		
		//공지사항 0208 6교시
		map.put("/noticeList.do", new NoticeList());
		//상세보기 0208 6교시-2
		map.put("/noticeDetail.do", new NoticeDetail());
		//글등록화면 0208 8교시
		map.put("/noticeForm.do", new NoticeForm());
		//글등록처리 0208 8교시-2
		map.put("/noticeAdd.do", new NoticeAdd());
	}
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// service 치고 컨틀로 스페이스 해서 오버라이드
		req.setCharacterEncoding(charset);
		
		String uri = req.getRequestURI();
		String context = req.getContextPath();
		String page = uri.substring(context.length());
		System.out.println(page);
		
		Command command = map.get(page);
		String viewPage = command.exec(req, resp); //viewPage 는 main/main.tiles가 됨
		
		
		//0208 8교시-2
		if (viewPage.endsWith(".tiles")) {
			RequestDispatcher rd = req.getRequestDispatcher(viewPage);
			rd.forward(req, resp);

		} else if (viewPage.endsWith(".do")) {
			resp.sendRedirect(viewPage);
		}
		
		//notice/noticeList.tiles
		//0208 3교시-1 0208 8교시-2에서 글등록 시 .do로 가게 만들어서 가림. 위에 if구문으로 함.
//		RequestDispatcher rd = req.getRequestDispatcher(viewPage);
//		rd.forward(req, resp);
	}
}
