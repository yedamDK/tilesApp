package com.yedam.notice.mapper;

import java.util.List;

import com.yedam.notice.vo.NoticeVO;

public interface NoticeMapper {
	public List<NoticeVO> selectList();
	public NoticeVO searchOne(int nid);
	public int insertNotice(NoticeVO notice);
	public int updateNotice(NoticeVO notice);
	public int deleteNotice(int nid);
	//0208 6교시-2 조회수 증가
	public int increaseCnt(int nid);
	//댓글목록
	//댓글등록
}
