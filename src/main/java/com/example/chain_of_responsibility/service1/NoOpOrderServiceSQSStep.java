package com.example.chain_of_responsibility.service1;


public class NoOpOrderServiceSQSStep implements OrderServiceSQSStep {

	@Override
	public SQSOrder processSQS(SQSOrder sqsOrder) {
		return sqsOrder;
	}

	@Override
	public void setNextStep(OrderServiceSQSStep step) {
		// no op		
	}
}