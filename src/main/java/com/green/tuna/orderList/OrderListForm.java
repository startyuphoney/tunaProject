package com.green.tuna.orderList;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderListForm {
	
	@NotEmpty(message = "예약날짜는 필수항목입니다.")
	private String reservationDate;
	
	@NotEmpty(message = "예약시간은 필수항목입니다.")
	private String reservationTime;
	
    @Min(value = 2, message = "최소 예약 인원은 2명 입니다")
    @Max(value = 10,  message = "최대 예약 인원은 10명 입니다")
	private int reservationTraffic;
	
	private String reservationComment;
	
}
