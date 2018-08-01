package com.scotch.io.ehcache.service.impl;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.scotch.io.ehcache.dto.TodoTask;
import com.scotch.io.ehcache.service.TodoTaskService;

/**
 * 
 * @author nchopra
 *
 */
@Service
public class TodoTaskServiceImpl implements TodoTaskService{
	private final Logger LOGGER = LoggerFactory.getLogger(getClass());
	
	public List<TodoTask> findAll(){
		LOGGER.info("Inside function findAll ............ Retrieving tasks !!");
      return Arrays.asList(new TodoTask(1L, "My first task", true), new TodoTask(2L, "My second task", false));
	}
}
