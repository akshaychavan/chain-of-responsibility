package com.example.chain_of_responsibility.service;

import java.util.Optional;

public abstract class AbstractEnrichmentStep implements EnrichmentStep {
	private EnrichmentStep next;

	@Override
	public final void setNext(EnrichmentStep step) {
		this.next = step;
	}

	@Override
	public final Message enrich(Message message) {
		try {
			return enrichAndApplyNext(message).map(enrichedMessage -> next.enrich(enrichedMessage))
					.orElseGet(() -> next.enrich(message));
		} catch (Exception e) {
//			log.error("Unexpected error during enrichment for msg {}", message, e);
			e.printStackTrace();
			return next.enrich(message);
		}
	}

	protected abstract Optional<Message> enrichAndApplyNext(Message message);
}