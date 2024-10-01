package com.fcai.SoftwareTesting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.fcai.SoftwareTesting.todo.Todo;
import com.fcai.SoftwareTesting.todo.TodoCreateRequest;
import com.fcai.SoftwareTesting.todo.TodoService;
import com.fcai.SoftwareTesting.todo.TodoServiceImpl;

@SpringBootTest
class SoftwareTestingApplicationTests {
	  TodoService todo = new TodoServiceImpl();
	
	@Test
	void contextLoads() {
	}
	@Test
	public void testcreate1(){  // test the first if in create method
		try {
		  todo.create(null); // give null instead of the title and desc
		}catch (IllegalArgumentException p) {
            assertEquals("Todo cannot be null", p.getMessage());
        }
	}
	

	@Test
	public void testcreate2() { // test the secound in create method 
		TodoCreateRequest todo_CRequest = new TodoCreateRequest("","the discription info");
		todo.create(todo_CRequest); // pass it empty title and disc
		TodoCreateRequest todo2 = new TodoCreateRequest();
		todo2.setDescription("the discription info");
		todo2.setTitle("");
		  assertEquals(todo,todo2);
	}
	 @Test
	    public void testcreate3() {// the 3 if when the discription is empty
	        TodoCreateRequest todo_CRequest = new TodoCreateRequest(" the title name", "");
	        todo.create(todo_CRequest);
	        TodoCreateRequest todo2 = new TodoCreateRequest();
			todo2.setTitle(" the title name");
			todo2.setDescription("");
			assertEquals(todo,todo2);
	    }

	 @Test 
	    public void estcreate4() { // give valid info 
	      TodoCreateRequest todo_CRequest = new TodoCreateRequest("the title name","the description info");
	      TodoServiceImpl todo1 = new TodoServiceImpl();  
	      todo1.create(todo_CRequest); // oass create request to create method
	       assertEquals(todo_CRequest.getDescription(),"the description info"); //compare the desc
	       assertEquals(todo_CRequest.getTitle(),"the title name"); //compare the title
	      
	 }
	

	 @Test
	 public void test_Read() { // try give null to id 
	         try {
	        	  todo.read(null); // test first if condition 
	        } catch (IllegalArgumentException p) {
	       assertEquals("Todo id cannot be null", p.getMessage()); // compare the exeption with the message 
	        }
	    }

	   @Test
	    public void test_Read2() { // test 2 if condition in read 
	        try {
	            todo.read(""); // empty id
	        } catch (IllegalArgumentException p) {
	       assertEquals("Todo id cannot be empty", p.getMessage()); // make sure from the output
	        }
	    }
	   @Test
	    public void test_Read3() { // try give valied input to id 
		   todo.setId("7"); 
	       Todo result = todo.read("7"); //  give string to read 
	       assertEquals(result, todo); 
	   }

	    @Test
	    public void test_update() { // try update after update id 
	    	 boolean completed = true; // try it when completed true
	         String i = "7";
	         todo.update(i, completed);
	         assertEquals(todo, todo.read(i));
	    }
	    @Test
	    public void test_delete() { // try  to delete unexistingId  to do 
	    	
	         TodoService todo3 = new TodoServiceImpl();
	         TodoCreateRequest todo_CRequest = new TodoCreateRequest("3","hiiii3");
	         todo3.create(todo_CRequest);
	        String unfindId = "7";  // given wrong id (not exist)
	        todo.delete(unfindId);
	        assertEquals(todo.read(unfindId),null);
	    }
	
}
