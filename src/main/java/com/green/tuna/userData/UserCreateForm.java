package com.green.tuna.userData;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserCreateForm {

	@Size(min = 3, max = 25)
    @NotEmpty(message = "사용자ID는 필수항목입니다.")
	private String id;
	
	@NotEmpty(message = "비밀번호는 필수항목입니다.")
	private String pw1;
	
	@NotEmpty(message = "비밀번호 확인은 필수항목입니다.")
	private String pw2;
	
	@NotEmpty(message = "이름은 필수항목입니다.")
	private String name;
	
	@NotEmpty(message = "전화번호는 필수항목입니다.")
	private String mobile;
	
}
