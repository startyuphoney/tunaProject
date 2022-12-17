package com.green.tuna.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.green.tuna.orderList.OrderList;
import com.green.tuna.orderList.OrderListService;
import com.green.tuna.userData.UserData;
import com.green.tuna.userData.UserDataService;

@Controller
public class MainController {
	
	
	@RequestMapping("/")
	public String Main() {
		return "index";
	}
	
	@RequestMapping("/index.html")
	public String Main2() {
		return "index";
	}
	
	@RequestMapping("/menu1.html")
	public String menu1() {
		return "menu1";
	}
	
	@RequestMapping("/menu2.html")
	public String menu2() {
		return "menu2";
	}
	
	
}
