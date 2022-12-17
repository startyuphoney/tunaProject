package com.green.tuna.userData;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDataRepository extends JpaRepository<UserData, Integer>{
	 Optional<UserData> findByName(String name);
	 Optional<UserData> findByid(String id);
}
