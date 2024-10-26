package com.example.chain_of_responsibility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;

import com.example.chain_of_responsibility.service1.Order;
import com.example.chain_of_responsibility.service1.OrderStepFacade;

@SpringBootApplication
public class ChainOfResponsibilityApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChainOfResponsibilityApplication.class, args);
	}

//	@Autowired
//	private EnrichmentStepFacade enrichmentStepFacade;

	@Autowired
	private OrderStepFacade orderStepFacade;

	@EventListener(ApplicationStartedEvent.class)
	public void onStart() {
//		System.out.println("Result message: " + enrichmentStepFacade.enrich(
//				new Message(
//						Map.of(
//								"ip", "10.10.10.10",
//								"userId", "someId",
//								"SESSIONID", "dfsjklfdjsafsdfadfa"
//						)
//				)
//		));
		System.out.println("Result order: " + orderStepFacade.process(new Order("ordr##1", 100.0, "Redeem,Settle,Refund")));
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("Result order: " + orderStepFacade.process(new Order("ordr##2", 100.0, "Redeem,Cancel")));
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("Result order: " + orderStepFacade.process(new Order("ordr##3", 100.0, "Redeem,Refund")));
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("Result order: " + orderStepFacade.process(new Order("ordr##4", 100.0, "Settle,Refund")));
	}

}
