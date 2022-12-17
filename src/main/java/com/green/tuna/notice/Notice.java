package com.green.tuna.notice;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import com.green.tuna.comment.NoticeComment;
import com.green.tuna.userData.UserData;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "NOTICE")
public class Notice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notice_SEQ")
	@SequenceGenerator(sequenceName = "notice_seq", allocationSize = 1, name = "notice_SEQ")
	@Column(name = "NOTICENO")
	private Integer noticeNo;
	
	@Column(length = 100)
	private String title;
	
	@Column(length = 4000)
	private String content;
	
	@Column(length = 100)
	private LocalDateTime createDate;
	
	@Column(length = 100)
	private String name;
	
	@ManyToOne
//	@JoinColumn(name = "USERDATA_USERNO")
	@NotNull
	private UserData userdata;
	
	@OneToMany(mappedBy = "notice", cascade = CascadeType.REMOVE)
	private List<NoticeComment> commentList;
}
