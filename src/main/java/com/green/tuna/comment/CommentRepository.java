package com.green.tuna.comment;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.green.tuna.notice.Notice;

public interface CommentRepository extends JpaRepository<NoticeComment, Integer>{
	List<NoticeComment> findByName(String name);
}
