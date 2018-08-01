package com.scotch.io.ehcache.service;

import java.util.List;

import com.scotch.io.ehcache.dto.TodoTask;

/**
 * 
 * @author nchopra
 *
 */
public interface TodoTaskService {
	public List<TodoTask> findAll();
}
