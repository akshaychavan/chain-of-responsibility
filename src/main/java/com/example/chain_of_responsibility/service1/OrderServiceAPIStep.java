package com.example.chain_of_responsibility.service1;

public interface OrderServiceAPIStep {
	Order processSQS(Order order);
}