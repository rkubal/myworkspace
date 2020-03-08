/**
 * 
 */
package com.training.springbootstarter.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.springbootstarter.model.Topic;
import com.training.springbootstarter.repository.TopicRepository;
import com.training.springbootstarter.service.TopicService;

/**
 * @author swapn
 *
 */
@Service
public class TopicServiceImpl implements TopicService {
	@Autowired
	TopicRepository topicRepository;
	//Arrays.aslist creates immutable object which cannot be modified on a post call and we get error, 
	//so we had to convert it into a list so that the list can be edited.
	List<Topic> topics = new ArrayList<Topic> (Arrays.asList(new Topic("Spring", "MVC-boot", "framework"),
			new Topic("java", "core", "coding"), new Topic("sql", "plsql", "database"), new Topic("j2ee", "jsp", "ui")));

	@Override
	public List<Topic> getAllTopics() {
		List<Topic> topics = new ArrayList<Topic>();
		//topicRepository.findAll().forEach(t->topics.add(t));
		topicRepository.findAll().forEach(topics::add);//alternative way to do it
		return topics;
	}

	@Override
	public Topic getTopicById(String id) {
		return topicRepository.findById(id).get();
				//topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	@Override
	public void addNewTopic(Topic topic) {
		topicRepository.save(topic);
		
	}

	@Override
	public void updateTopic(Topic topic, String id) {
		topicRepository.save(topic);
//		for(int i=0;i<topics.size();i++) {
//			Topic t = topics.get(i);
//			if(t.getId().equals(id)) {
//				topics.set(i, topic);
//			}
//		}
		//the below commented code will not work if we change the id, 
		//also t=topic does not make sense.
//		for(Topic t : topics) {
//			if(t.getId().equals(id)) {
//				t = topic;
//				return;
//			}
//		}
		
	}

	@Override
	public void deleteTopic(String id) {
		topicRepository.deleteById(id);
		return;
	}

}
