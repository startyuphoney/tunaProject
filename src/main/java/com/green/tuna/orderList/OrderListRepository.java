package com.green.tuna.orderList;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderListRepository extends JpaRepository<OrderList, Integer>{
	Optional<OrderList> findByid(String id);
	List<OrderList> findByName(String name);
}
