package com.poc.kafka.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.kafka.model.User;

@RestController
@RequestMapping("kafka")
public class UserResource {

	@Autowired
	KafkaTemplate<String, User> kakfaTemplate;
	
	private static final String TOPIC = "Kafka_Sample";
	
	@GetMapping("/publish/{name}")
	public String publish(@PathVariable("name") final String name) {
		kakfaTemplate.send(TOPIC, new User(name,"IT"));
		return "Published Succesfully !";
	}
}
