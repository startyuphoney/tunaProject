package com.green.tuna.notice;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.green.tuna.userData.UserData;
import com.green.tuna.userData.UserDataRepository;

@Service
public class NoticeService {

	@Autowired
	private NoticeRepository noticeRepository;
	@Autowired
	private UserDataRepository userDataRepository;
	
	
//	게시판에 글 추가
	public void createNotice(Notice notice,Principal principal) {
		
		Notice NT = new Notice();
		Optional<UserData> nn = this.userDataRepository.findByid(principal.getName());
		
		NT.setTitle(notice.getTitle());
		NT.setContent(notice.getContent());
		NT.setCreateDate(LocalDateTime.now());
		NT.setName(nn.get().getName());
		NT.setUserdata(nn.get());
		
		this.noticeRepository.save(NT);
	}
	
	
////	게시판 모든 글 반환
//	public List<Notice> getAll() {
//		
//		return this.noticeRepository.findAll();
//	}
	
		
	//게시판 모든 글 페이지로 반환 
	public Page<Notice> getAll(int page) {
		List<Sort.Order> sorts = new ArrayList<>();
		sorts.add(Sort.Order.desc("createDate"));
		
		
		Pageable pageable = PageRequest.of(page,10,Sort.by(sorts));
		return this.noticeRepository.findAll(pageable);
	}
	
	
	// 질문 번호로 질문객체 찾아오기
	public Notice noticeDetail(Integer no) {
		Optional<Notice> notice = this.noticeRepository.findByNoticeNo(no);
		
		return notice.get();
		
	}
	
	
	
	
}
