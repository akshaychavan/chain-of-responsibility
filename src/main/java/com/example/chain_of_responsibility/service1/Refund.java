package com.example.chain_of_responsibility.service1;

import org.springframework.stereotype.Service;

@Service("Refund")
//@org.springframework.core.annotation.Order(2)
public class Refund implements OrderStep {
	private OrderStep next;

	@Override
	public Order process(Order order) {
		order.setStatus("Refund");
		System.out.println("Inside Refund order= "+order);
		return next.process(order);
	}

	@Override
	public void setNextStep(OrderStep step) {
		this.next = step;
	}
	
	

}
