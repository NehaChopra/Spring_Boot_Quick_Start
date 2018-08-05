package com.scotch.io.ehcache.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scotch.io.ehcache.dto.TodoTask;
import com.scotch.io.ehcache.service.TodoTaskService;

/**
 * 
 * @author nchopra
 *
 */
@RestController
public class TodoTaskController {

	private final Logger LOGGER = LoggerFactory.getLogger(getClass());
		
   @Autowired
   private TodoTaskService todoTaskService;
   
	@GetMapping("/api/todoTasks")
	public List<TodoTask> findAll() {
		LOGGER.info("Inside function findAll of TodoTaskController............ Retrieving tasks !!");
      return todoTaskService.findAll();
  }
}
