package com.fcai.SoftwareTesting.todo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Todo {
    private String id;
    private String title;
    private String description;
    private boolean completed;
    
    public Todo(){}
    Todo(String title,String description){
    	this.title=title;
    	this.description=description;
    }
	public void setCompleted(boolean completed2) {
		// TODO Auto-generated method stub
		
	}
}
