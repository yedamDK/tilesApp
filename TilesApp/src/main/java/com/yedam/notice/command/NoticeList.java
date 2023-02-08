package com.yedam.notice.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Command;
import com.yedam.notice.service.NoticeService;
import com.yedam.notice.service.NoticeServiceImpl;

public class NoticeList implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 0208 6교시 목록을 남겨줘야 jsp에서 읽어줌		
		NoticeService service = new NoticeServiceImpl();
		req.setAttribute("list", service.noticeList());
		
		
		return "notice/noticeList.tiles";
	}

}
