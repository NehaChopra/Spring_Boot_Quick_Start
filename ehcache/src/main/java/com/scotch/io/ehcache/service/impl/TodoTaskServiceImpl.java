package com.scotch.io.ehcache.service.impl;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
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
	
	/*
	 * Be aware, the Spring cache abstraction works by proxying your target class. 
	 * This means that calls within the same service will not be cached. 
	 * So if we had another method called findStuff() which was calling findAll(), the call will not be cached.
	 * 
	 * As from Spring 4.1, the cache abstraction has been significantly improved with the support of JSR-107 annotations and more customization options.
	 */
	@Override
	@Cacheable("tasks")
	public List<TodoTask> findAll(){
		LOGGER.info("Inside function findAll ............ Retrieving tasks !!");
      return Arrays.asList(new TodoTask(1L, "My first task", true), new TodoTask(2L, "My second task", false));
	}
}
