package com.yedam.notice.service;

import java.util.List;

import javax.websocket.Session;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.notice.mapper.NoticeMapper;
import com.yedam.notice.vo.NoticeVO;

public class NoticeServiceImpl implements NoticeService {
	//0208 6교시
	SqlSession Session = DataSource.getInstance().openSession(true);
	NoticeMapper mapper = Session.getMapper(NoticeMapper.class);
	// 두 줄을 인터페이스 이름만 부름으로 해결
	// NoticeService service = new NoticeServiceImpl();
	// session.selectOne("com.yedam.notice.mapper.NoticeMapper.getNotice")

	@Override
	public List<NoticeVO> noticeList() {
		return mapper.selectList();
	}

	@Override
	public NoticeVO getNotice(int nid) {
		mapper.increaseCnt(nid); // 조회수증가 0208 6교시-2
		return mapper.searchOne(nid);
	}

	@Override
	public int addNotice(NoticeVO notice) {
		return mapper.insertNotice(notice);
	}

	@Override
	public int modNotice(NoticeVO notice) {
		return mapper.updateNotice(notice);
	}

	@Override
	public int remNotice(int nid) {
		return mapper.deleteNotice(nid);
	}

}
