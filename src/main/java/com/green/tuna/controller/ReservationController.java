package com.green.tuna.controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.green.tuna.orderList.OrderList;
import com.green.tuna.orderList.OrderListForm;
import com.green.tuna.orderList.OrderListService;

@Controller
public class ReservationController {

	
	@Autowired
	private OrderListService orderListService;
	
	// 예약 템플릿 반환
	@GetMapping("/reservation")
	public String reservation(OrderListForm orderListForm) {
		return "reservationPage";
	}
	
	
	// 예약 템플릿에서 정보 받아와서 예약목록 생성
	@PostMapping("/reservation")
	public String createReservation(@Valid OrderListForm orderListForm, BindingResult bindingResult, Principal principal) {
			if(bindingResult.hasErrors()) {
				return "reservationPage";
			}
			
			this.orderListService.createOrder(orderListForm,principal);
		return "redirect:/";
	}
	 
	//	현재 로그인된 계정의 예약목록 조회
	@RequestMapping("/myReservation")
	public String myReservation(Model model,Principal principal) {
		
		List<OrderList> orderList = this.orderListService.getUserData(principal);
		model.addAttribute("orderList", orderList);
		return "myReservation";
	}
	
	
	//	예약 삭제
	@RequestMapping("/admin/dropReservation/{id}")
	public String dropReservation(@PathVariable("id") int id) {

		this.orderListService.dropReservation(id);
		
		return "redirect:/admin/reservationList";
	}
	
	
	
}
