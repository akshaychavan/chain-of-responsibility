package com.example.chain_of_responsibility.service1;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class OrderStepFacade {
	private OrderStep chainHead;
	private final ApplicationContext context;

	public OrderStepFacade(ApplicationContext context) {
		this.context = context;
	}

	public Order process(Order order) {
		List<OrderStep> steps = Arrays.asList(order.getTranTypeCodes().split(",")).stream().map(code -> context.getBean(code, OrderStep.class)).toList();
		this.chainHead = com.example.chain_of_responsibility.service1.ChainElement.buildChain(steps,
				new NoOpOrderStep());
		return chainHead.process(order);
	}
}