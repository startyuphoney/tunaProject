package com.green.tuna.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.tuna.notice.Notice;
import com.green.tuna.notice.NoticeService;

@Controller
@RequestMapping("/notice")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
//	// nav바에서 공지사항 클릭시
//	@GetMapping("/noticeList")
//	public String notice(Model model) {
//		List<Notice> noticeList = this.noticeService.getAll();
//		model.addAttribute("notice",noticeList);
//		
//		return "noticeList";
//	}
	
	// nav바에서 공지사항 클릭시 페이징
	@GetMapping("/noticeList")
	public String notice(Model model,@RequestParam(value="page", defaultValue="0") int page) {
		Page<Notice> paging= this.noticeService.getAll(page);
		model.addAttribute("paging",paging);
		
		return "noticeList";
	}
	
	// 공지 게시판에서 글 작성 클릭시 
	@GetMapping("/noticeForm")
	public String noticeForm(Notice notice) {
		
		return "noticeForm";
	}
	
	// 게시글 작성 폼에서 제출 눌렀을때
	@PostMapping("/createNotice")
	public String createNotice(Model model, Notice notice,Principal principal) {
		this.noticeService.createNotice(notice, principal);
		
		return "redirect:/notice/noticeList";
	}
	
	
	// 글 목록에서 제목 클릭했을시 디테일로 이동
	@RequestMapping(value = "/detail/{noticeNo}")
	public String noticeDetail(Model model, @PathVariable("noticeNo") Integer noticeNo) {
		Notice notice = this.noticeService.noticeDetail(noticeNo);
		model.addAttribute("notice",notice);
		
        return "noticeDetail";
    }
	

	
}
