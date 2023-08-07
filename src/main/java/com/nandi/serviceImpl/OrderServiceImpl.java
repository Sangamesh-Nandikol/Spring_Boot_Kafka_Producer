package com.nandi.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.nandi.constants.AppConstant;
import com.nandi.model.Order;
import com.nandi.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private KafkaTemplate<String, Order> kafkaTemplate;

	@Override
	public String addMsg(Order order) {
		kafkaTemplate.send(AppConstant.TOPIC,order);

		return "message published to kafka topic";
	}

}
