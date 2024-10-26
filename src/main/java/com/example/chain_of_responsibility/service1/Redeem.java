package com.example.chain_of_responsibility.service1;

import org.springframework.stereotype.Service;

@Service("Redeem")
//@org.springframework.core.annotation.Order(0)
public class Redeem implements OrderStep {
	private OrderStep next;

	@Override
	public Order process(Order order) {
		order.setStatus("Pending");
		order.setAmountPendingSettle(order.getAmount());
		System.out.println("Inside Redeem order= "+order);
		return next.process(order);
	}

	@Override
	public void setNextStep(OrderStep step) {
		this.next = step;
	}
	
	

}
