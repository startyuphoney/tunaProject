package com.green.tuna.orderList;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import com.green.tuna.userData.UserData;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity(name = "ORDERLIST") 
public class OrderList {
	 
	
	
	 @Id
//	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RES_SEQ") 
	 @SequenceGenerator(sequenceName = "reservation_seq", allocationSize = 1, name = "RES_SEQ")
	 private Integer id;

	 @Column(length = 10)
	  private String reservationDate;

	 @Column(length = 30)
	  private String reservationTime;
	 
	 @Column(length = 30)
	  private int reservationTraffic;

	 @Column(length = 300)
	  private String reservationComment;
	 
	 @Column(length = 100)
	  private String name;
	  
	 @Column(length = 30)
	  private String mobile;
	 
	 @Column(length = 30)
	  private LocalDateTime ucreateDate;
	 
	 @ManyToOne
	 // 오더리스트 엔티티에서 참조값을 나타내는 컬럼이름을 name 뒤에 적어주면 된다.// 없는데 왜되는지??
//	 @JoinColumn(name = "USERDATA_USERNO")
	 @NotNull
	 private UserData userdata;
	  									
	  
}
