package com.green.tuna.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.green.tuna.userData.UserData;
import com.green.tuna.userData.UserDataRepository;
import com.green.tuna.userData.UserRole;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserSecurityService implements UserDetailsService{
	
	private final UserDataRepository userDataRepository;
	
	@Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
		
		System.out.println("@@@@@@@@@@@@@@@@@@@@@"+id);
		
        Optional<UserData> _userData = this.userDataRepository.findByid(id);
        if (_userData.isEmpty()) {
            throw new UsernameNotFoundException("사용자를 찾을수 없습니다.");
        }
        UserData userData = _userData.get();
        List<GrantedAuthority> authorities = new ArrayList<>();
        if ("admin".equals(id)) {
            authorities.add(new SimpleGrantedAuthority(UserRole.ADMIN.getValue()));
        } if(userData.getRole() == 1){
            authorities.add(new SimpleGrantedAuthority(UserRole.USER.getValue()));
        }if(userData.getRole() >= 2){
            authorities.add(new SimpleGrantedAuthority(UserRole.ADMIN.getValue()));
        }
        return new User(userData.getId(), userData.getPw(), authorities);
    }
}
