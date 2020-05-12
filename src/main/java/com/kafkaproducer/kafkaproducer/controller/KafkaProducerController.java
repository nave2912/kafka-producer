package com.kafkaproducer.kafkaproducer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafkaproducer.kafkaproducer.entity.UserDetails;

@RestController
public class KafkaProducerController {
	
	@Autowired
	KafkaTemplate<String, UserDetails> kafkatemplate;
	final String TOPIC = "kafkaMessageBroker001";
	
	@GetMapping("/msg")
	public String kafkaMessage() {
		System.out.println("TOPIC" + TOPIC);
		kafkatemplate.send(TOPIC, new UserDetails(1,"kafkasender","kafkasender@gmail.com"));
		return "Message PublishedSuccessfully";
	}

	@GetMapping("/get")
	public String sampleGet() {

		return "Sample geT";
	}
}
