package com.example.chain_of_responsibility.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class EnrichmentStepFacade {
  private final EnrichmentStep chainHead;

  public EnrichmentStepFacade(List<EnrichmentStep> steps) {
    this.chainHead = ChainElement.buildChain(steps, new NoOpEnrichmentStep());
  }

  public Message enrich(Message message) {
    return chainHead.enrich(message);
  }
}