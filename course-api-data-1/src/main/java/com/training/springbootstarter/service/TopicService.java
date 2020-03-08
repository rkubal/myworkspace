package com.training.springbootstarter.service;

import java.util.List;

import com.training.springbootstarter.model.Topic;

public interface TopicService {

	List<Topic> getAllTopics();
	Topic getTopicById(String id);
	void addNewTopic(Topic topic);
	void updateTopic(Topic topic, String id);
	void deleteTopic(String id);
}
