package com.example.chain_of_responsibility.service;

import java.util.Optional;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Order(2)
class GeoLocationEnrichmentStep extends AbstractEnrichmentStep {

  @Override
  protected Optional<Message> enrichAndApplyNext(Message message) {
    return message.getValue("ip")
        .map(geo -> message.with("geo", "123122"));
  }
}