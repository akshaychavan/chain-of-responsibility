package com.example.chain_of_responsibility.service;

public class NoOpEnrichmentStep implements EnrichmentStep {

	@Override
	public Message enrich(Message message) {
		return message;
	}

	@Override
	public void setNext(EnrichmentStep step) {
		// no op
	}
}