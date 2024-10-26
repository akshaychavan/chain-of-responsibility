package com.example.chain_of_responsibility.service1;

import org.springframework.stereotype.Service;

@Service("Redeem")
public class Redeem implements OrderServiceSQSStep {
	private OrderServiceSQSStep next;

	@Override
	public SQSOrder processSQS(SQSOrder sqsOrder) {
		sqsOrder.setStatus("Pending");
		sqsOrder.setAmountPendingSettle(sqsOrder.getAmount());
		System.out.println("Inside Redeem order= "+sqsOrder);
		return next.processSQS(sqsOrder);
	}

	@Override
	public void setNextStep(OrderServiceSQSStep step) {
		this.next = step;
	}
	
}
