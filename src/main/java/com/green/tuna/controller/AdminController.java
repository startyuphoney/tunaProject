package com.green.tuna.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.green.tuna.orderList.OrderList;
import com.green.tuna.orderList.OrderListService;
import com.green.tuna.userData.UserData;
import com.green.tuna.userData.UserDataService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private OrderListService orderListService;
	
	@Autowired
	private UserDataService userDataService;

	@RequestMapping("")
	public String adminPage() {
		return "adminPage";
	}
	
	
//	예약목록 출력
	@RequestMapping("/reservationList")
	public String adminOrderList(Model model) {
		
		List<OrderList> orderList = this.orderListService.getAll();
		model.addAttribute("orderList", orderList);
		
		return "adminReservationList";
	}
	
//	유저목록 출력
	@RequestMapping("/userList")
	public String adminUserList(Model model) {
		List<UserData> userList = this.userDataService.getAll();
		model.addAttribute("userList", userList);
		return "adminUserList";
	}
	
//	유저 권한 등업
	@RequestMapping(value = "/roleIncrease/{id}")
	public String roleIncrease(@PathVariable("id") String id) {
		this.userDataService.roleIncrease(id);
		
		return "redirect:/admin/userList";
	}
	
//	유저 권한 강등
	@RequestMapping(value = "/roleDecrease/{id}")
	public String roleDecrease(@PathVariable("id") String id) {
		this.userDataService.roleDecrease(id);
		
		return "redirect:/admin/userList";
	}
	
//	유저 삭제
	@RequestMapping(value = "/dropUser/{id}")
	public String dropUser(@PathVariable("id") String id) {
		this.userDataService.dropUser(id);
		
		return "redirect:/admin/userList";
	}
	
	
}
