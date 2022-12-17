package com.green.tuna.comment;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.green.tuna.notice.Notice;
import com.green.tuna.notice.NoticeRepository;
import com.green.tuna.userData.UserData;
import com.green.tuna.userData.UserDataRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CommentService {
	
	private final CommentRepository commentRepository;
	private final NoticeRepository noticeRepository;
	private final UserDataRepository userDataRepository;
	
	
	// 댓글 등록
	public void createComment(NoticeComment contents, Principal principal, Integer noticeNo) {
		NoticeComment cmt = new NoticeComment();
		Optional<Notice> NT = this.noticeRepository.findByNoticeNo(noticeNo);
		Optional<UserData> UD = this.userDataRepository.findByid(principal.getName());
		
		cmt.setContents(contents.getContents());
		cmt.setCreateDate(LocalDateTime.now());
		cmt.setName(UD.get().getName());
//		cmt.setNoticeNo(0);
		cmt.setNotice(NT.get());
		cmt.setUserdata(UD.get());
		
		this.commentRepository.save(cmt);
		
		
	}
}
