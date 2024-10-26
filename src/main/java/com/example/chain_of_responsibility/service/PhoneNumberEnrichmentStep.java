package com.example.chain_of_responsibility.service;

import java.util.Optional;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Order(0)
class PhoneNumberEnrichmentStep extends AbstractEnrichmentStep {

  @Override
  protected Optional<Message> enrichAndApplyNext(Message message) {
    return message.getValue("SESSIONID")
//        .flatMap(phoneNumberRepository::findPhoneNumber)
        .map(phoneNumber ->
            message.with("phoneNumber", "phoneNumber")
        );
  }
}