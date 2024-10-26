package com.example.chain_of_responsibility.service1;

import org.springframework.stereotype.Service;

@Service("Cancel")
//@org.springframework.core.annotation.Order(3)
public class Cancel implements OrderStep {
	private OrderStep next;

	@Override
	public Order process(Order order) {
		order.setStatus("Cancelled");
		System.out.println("Inside Cancel order= " + order);
		return next.process(order);
	}

	@Override
	public void setNextStep(OrderStep step) {
		this.next = step;
	}

}
