package com.green.tuna.comment;

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

import com.green.tuna.notice.Notice;
import com.green.tuna.userData.UserData;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "NOTICECOMMENT")
public class NoticeComment {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_SEQ")
	@SequenceGenerator(sequenceName = "comment_seq", allocationSize = 1, name = "comment_SEQ")
	private int commentNo;
	
	@Column(length = 4000)
	private String contents;
	
	@Column(length = 100)
	private LocalDateTime createDate;
	
	@Column(length = 100)
	private String name;
	
	// 게시물에 대한 정보
	@ManyToOne
	@NotNull
	private Notice notice;
	
	// 작성자에 대한 정보
	@ManyToOne
	@NotNull
	private UserData userdata;
	
}
