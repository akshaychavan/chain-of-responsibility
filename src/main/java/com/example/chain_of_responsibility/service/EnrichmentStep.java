package com.example.chain_of_responsibility.service;

public interface EnrichmentStep extends ChainElement<EnrichmentStep> {
	Message enrich(Message message);
}