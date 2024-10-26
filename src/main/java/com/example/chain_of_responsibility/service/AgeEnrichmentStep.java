package com.example.chain_of_responsibility.service;

import java.util.Optional;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Order(1)
class AgeEnrichmentStep extends AbstractEnrichmentStep {

	@Override
	protected Optional<Message> enrichAndApplyNext(Message message) {
		return message.getValue("userId")
				.map(age -> message.with("age", "12"));
	}
}