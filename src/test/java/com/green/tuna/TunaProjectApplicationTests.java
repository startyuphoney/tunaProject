package com.green.tuna;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.green.tuna.orderList.OrderList;
import com.green.tuna.orderList.OrderListRepository;

@SpringBootTest
class TunaProjectApplicationTests {

	@Autowired
	private OrderListRepository orderRepository;
	
	@Test
	void testJpa() {
		OrderList OL = new OrderList();
	
		this.orderRepository.save(OL);
	}

}
