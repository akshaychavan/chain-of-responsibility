package com.example.chain_of_responsibility.service1;

import org.springframework.stereotype.Service;

@Service("Settle")
//@org.springframework.core.annotation.Order(1)
public class Settle implements OrderStep {
	private OrderStep next;

	@Override
	public Order process(Order order) {
		order.setStatus("Settle");
		order.setAmountPendingSettle(0);
		order.setAmountSettle(order.getAmount());
		System.out.println("Inside Settle order= "+order);
		return next.process(order);
	}

	@Override
	public void setNextStep(OrderStep step) {
		this.next = step;
	}
	
	

}
