package com.example.chain_of_responsibility.service1;

import org.springframework.stereotype.Service;

@Service("Settle")
public class Settle implements OrderServiceSQSStep {
	private OrderServiceSQSStep next;

	@Override
	public SQSOrder processSQS(SQSOrder sqsOrder) {
		sqsOrder.setStatus("Settle");
		sqsOrder.setAmountPendingSettle(0);
		sqsOrder.setAmountSettle(sqsOrder.getAmount());
		System.out.println("Inside Settle order= "+sqsOrder);
		return next.processSQS(sqsOrder);
	}

	@Override
	public void setNextStep(OrderServiceSQSStep step) {
		this.next = step;
	}
	
	

}
