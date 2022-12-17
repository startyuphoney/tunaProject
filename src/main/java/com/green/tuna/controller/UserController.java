package com.green.tuna.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.tuna.userData.UserCreateForm;
import com.green.tuna.userData.UserData;
import com.green.tuna.userData.UserDataService;

@Controller
public class UserController {

	@Autowired
	private UserDataService userDataService;
	
	
//	@RequestMapping("/register")
	
//	유효성 검사를 위한 객체를 만들고 회원가입 템플릿을 반환한다
	@GetMapping("/register")
	public String register(UserCreateForm userCreateForm) {
		

		return "registerBootstrap";
	}
	
	@PostMapping("/register")
	public String register(@Valid UserCreateForm userCreateForm, BindingResult bindingResult) {
		
	  if (bindingResult.hasErrors()) {
            return "registerBootstrap";
        }

        if (!userCreateForm.getPw1().equals(userCreateForm.getPw2())) {
            bindingResult.rejectValue("pw2", "passwordInCorrect", 
                    "2개의 패스워드가 일치하지 않습니다.");
            return "registerBootstrap";
        }

        try {
        	userDataService.create(userCreateForm);
        }
        catch(DataIntegrityViolationException e) {
//            e.printStackTrace();  // 에러 정보를 자세하게 콘솔에 출력해준다
            bindingResult.reject("signupFailed", "이미 등록된 사용자입니다.");
            return "registerBootstrap";
        }
        catch(Exception e) {
            e.printStackTrace();
            bindingResult.reject("signupFailed", e.getMessage()); // 정의하지 않은 에러 정보를 웹에서 출력해준다 .
            return "registerBootstrap";
        }
        return "redirect:/";
	
	}
	
	
	@GetMapping("/login")
	public String loginPage() {
		return "login_form";
	}
	
	@RequestMapping("/createUser")
	public String createuser(UserData vo) {
		
		userDataService.createUser(vo);
		
		return "index";
	}

	
	
}
