package com.example.chain_of_responsibility.service1;


public class NoOpOrderStep implements OrderStep {

	@Override
	public Order process(Order order) {
		return order;
	}

	@Override
	public void setNextStep(OrderStep step) {
		// no op		
	}
}