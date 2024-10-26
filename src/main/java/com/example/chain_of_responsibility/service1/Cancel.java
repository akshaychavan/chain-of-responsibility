package com.example.chain_of_responsibility.service1;

import org.springframework.stereotype.Service;

@Service("Cancel")
public class Cancel implements OrderServiceSQSStep {
	private OrderServiceSQSStep next;

	@Override
	public SQSOrder processSQS(SQSOrder sqsOrder) {
		sqsOrder.setStatus("Cancelled");
		System.out.println("Inside Cancel order= " + sqsOrder);
		return next.processSQS(sqsOrder);
	}

	@Override
	public void setNextStep(OrderServiceSQSStep step) {
		this.next = step;
	}
}
