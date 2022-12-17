package com.green.tuna.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.green.tuna.comment.CommentService;
import com.green.tuna.comment.NoticeComment;

@Controller
@RequestMapping("/comment")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	
	// 게시글 디테일창에서 댓글 입력해서 댓글등록 눌렀을 때 작동
	@PostMapping("/createComment/{noticeNo}")
	public String createComment(NoticeComment contents, @PathVariable("noticeNo") Integer noticeNo, Principal principal) {
			
		this.commentService.createComment(contents, principal, noticeNo);
		
		
//		return String.format("redirect:/notice/detail/&s", noticeNo);
		return "redirect:/notice/detail/{noticeNo}";
	}

	
}
