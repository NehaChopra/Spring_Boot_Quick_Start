package com.scotch.io.ehcache.dto;

/**
 * 
 * @author nchopra
 *
 */
public class TodoTask {
   private Long id;
   private String task;
   private boolean completed;
	
   public TodoTask() {}
   
   public TodoTask(Long id, String task, boolean completed) {
   	this.id = id;
   	this.task = task;
   	this.completed = completed;
   }
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public boolean isCompleted() {
		return completed;
	}
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	
	@Override
	public String toString() {
		return "TodoTask [id=" + id + ", task=" + task + ", completed="
				+ completed + "]";
	}
	
}
