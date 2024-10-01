package com.fcai.SoftwareTesting.todo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TodoCreateRequest {

    private String title;
    private String description;
    
  
   public  TodoCreateRequest(){}
  public  TodoCreateRequest(String title,String description){
    	this.title=title;
    	this.description=description;
    	
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }
}
