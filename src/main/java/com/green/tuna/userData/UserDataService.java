package com.green.tuna.userData;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.ToString;


@Service
@ToString
public class UserDataService {

	@Autowired
	private UserDataRepository userDataRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public void create(UserCreateForm vo) {
		UserData UD = new UserData();
		
		UD.setId(vo.getId());
		UD.setPw(passwordEncoder.encode(vo.getPw1()));
		UD.setName(vo.getName());
		UD.setMobile(vo.getMobile());
		UD.setRole(1);
		this.userDataRepository.save(UD);
	}
	
	public void createUser(UserData vo) {
			UserData UD = new UserData();
			
			UD.setId(vo.getId());
			UD.setPw(passwordEncoder.encode(vo.getPw()));
			UD.setName(vo.getName());
			UD.setMobile(vo.getMobile());
			UD.setRole(1);
			this.userDataRepository.save(UD);
	}

	public Optional<UserData> findByid(String id) {
		return this.userDataRepository.findByid(id);
	}
	
	public List<UserData> getAll() {
		return this.userDataRepository.findAll();
	}
	
	public void roleIncrease(String id) {
		Optional<UserData> CUSTOMER = this.userDataRepository.findByid(id);
		UserData UD = CUSTOMER.get();
		UD.setRole(UD.getRole()+1);
		this.userDataRepository.save(UD);
	}
	
	public void roleDecrease(String id) {
		Optional<UserData> CUSTOMER = this.userDataRepository.findByid(id);
		UserData UD = CUSTOMER.get();
		UD.setRole(UD.getRole()-1);
		this.userDataRepository.save(UD);
	}
	
	public void dropUser(String id) {
		Optional<UserData> CUSTOMER = this.userDataRepository.findByid(id);
		UserData UD = CUSTOMER.get();
		this.userDataRepository.delete(UD);
	}
}
