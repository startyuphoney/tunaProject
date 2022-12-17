package com.green.tuna.orderList;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.green.tuna.userData.UserData;
import com.green.tuna.userData.UserDataRepository;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Service
@ToString
public class OrderListService {
//	@Autowired
	private final OrderListRepository orderListRepository;
	private final UserDataRepository userDataRepository; 
	
	public void createOrder(OrderListForm vo, Principal principal) {
		Optional<UserData> user = userDataRepository.findByid(principal.getName());
		// principal.getName(); 사용시 Name 컬럼이 아닌 이름이 id인 컬럼을 찾는다.
		// 그래서 레포지터리에서 findByid 만들어서 사용
		// 레포지터리가 기본제공하는	findById 사용하면 프라이머리키인 userNo 컬럼을 찾는다
		
		UserData UD = new UserData();
		OrderList OL = new OrderList();
		
		String aa = user.get().getName();
		String bb = user.get().getMobile();
		
//		OL.setId(vo.getId());
		OL.setReservationDate(vo.getReservationDate());
		OL.setReservationTime(vo.getReservationTime());
		OL.setReservationTraffic(vo.getReservationTraffic());
		OL.setReservationComment(vo.getReservationComment());
		OL.setName(aa);
		OL.setMobile(bb);
		OL.setUcreateDate(LocalDateTime.now());
		OL.setUserdata(user.get());
		
		this.orderListRepository.save(OL);
	}
	
	
	// 모든 예약정보 반환 //관리자전용
	public List<OrderList> getAll() {
		return this.orderListRepository.findAll();
	}
	
	
	// 로그인된 유저 예약목록만 반환해준다
	public List<OrderList> getUserData(Principal principal) {
		Optional<UserData> UD = userDataRepository.findByid(principal.getName());
		List<OrderList> OL = orderListRepository.findByName(UD.get().getName());
		return OL;
	}
	
	// 고객 예약 삭제
	public void dropReservation(int id) {
		Optional<OrderList> OL = this.orderListRepository.findById(id);
		
		this.orderListRepository.delete(OL.get());
		
	}
	
	
	
}
