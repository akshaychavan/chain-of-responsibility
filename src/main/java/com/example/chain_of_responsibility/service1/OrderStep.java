package com.example.chain_of_responsibility.service1;

public interface OrderStep extends ChainElement<OrderStep> {
	Order process(Order order);
}