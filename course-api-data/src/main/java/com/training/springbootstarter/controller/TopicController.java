package com.training.springbootstarter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.training.springbootstarter.model.Topic;
import com.training.springbootstarter.service.TopicService;

@RestController
public class TopicController {
	@Autowired
	TopicService topicService;
	
	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}
	
	@RequestMapping("/topics/{id}")
	public Topic getTopicById(@PathVariable String id) {
		return topicService.getTopicById(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/topics")
	public void addNewTopic(@RequestBody Topic topic) {
		 topicService.addNewTopic(topic);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "topics/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		topicService.updateTopic(topic, id); 
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "topics/{id}")
	public void ddeleteTopic(@PathVariable String id) {
		topicService.deleteTopic(id);
	}
}
