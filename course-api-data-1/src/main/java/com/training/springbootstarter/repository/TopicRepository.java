package com.training.springbootstarter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

import com.training.springbootstarter.model.Topic;

public interface TopicRepository //extends CrudRepository<Topic, String>{
extends JpaRepository<Topic, String>{


}
