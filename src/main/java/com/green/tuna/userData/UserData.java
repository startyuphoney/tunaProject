package com.green.tuna.userData;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.green.tuna.comment.NoticeComment;
import com.green.tuna.notice.Notice;
import com.green.tuna.orderList.OrderList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "USERDATA")
public class UserData {
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USERNO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_SEQ")
	@SequenceGenerator(sequenceName = "user_seq", allocationSize = 1, name = "USER_SEQ")
	private Integer userNo;
	
	@Column(length = 100, unique = true, nullable = false)
	private String id;
	
	@Column(length = 100)
	private String pw;
	
	@Column(length = 100)
	private String name;
	
	@Column(length = 30)
	private String mobile;
	
	@Column(length = 30)
	private int role;
	
	@OneToMany(mappedBy = "userdata", cascade = CascadeType.REMOVE)
    private List<OrderList> orderList;
	
	@OneToMany(mappedBy = "userdata", cascade = CascadeType.REMOVE)
	private List<Notice> noticeList;
	
	@OneToMany(mappedBy = "userdata", cascade = CascadeType.REMOVE)
	private List<NoticeComment> commentList;
}