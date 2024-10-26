package com.example.chain_of_responsibility.service1;

import org.springframework.stereotype.Service;

@Service("Refund")
public class Refund implements OrderServiceSQSStep {
	private OrderServiceSQSStep next;

	@Override
	public SQSOrder processSQS(SQSOrder sqsOrder) {
		sqsOrder.setStatus("Refund");
		System.out.println("Inside Refund order= "+sqsOrder);
		return next.processSQS(sqsOrder);
	}

	@Override
	public void setNextStep(OrderServiceSQSStep step) {
		this.next = step;
	}
	

}
