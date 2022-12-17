package com.green.tuna.notice;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice, Integer>{
	List<Notice> findByName(String name);
	Optional<Notice> findByNoticeNo(Integer no);
	Page<Notice> findAll(Pageable pageable);
}
