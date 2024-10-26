package com.example.chain_of_responsibility.service1;

public interface OrderServiceSQSStep extends ChainElement<OrderServiceSQSStep> {
	SQSOrder processSQS(SQSOrder sqsOrder);
}