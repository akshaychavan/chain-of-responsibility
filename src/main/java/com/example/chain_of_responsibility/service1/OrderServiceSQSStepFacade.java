package com.example.chain_of_responsibility.service1;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceSQSStepFacade {
	private OrderServiceSQSStep chainHead;
	private final ApplicationContext context;

	public OrderServiceSQSStepFacade(ApplicationContext context) {
		this.context = context;
	}

	public SQSOrder processSQS(SQSOrder sqsOrder) {
		List<OrderServiceSQSStep> steps = Arrays.asList(sqsOrder.getTranTypeCodes().split(",")).stream()
				.map(code -> context.getBean(code, OrderServiceSQSStep.class)).toList();
		this.chainHead = ChainElement.buildChain(steps, new NoOpOrderServiceSQSStep());
		return chainHead.processSQS(sqsOrder);
	}
}