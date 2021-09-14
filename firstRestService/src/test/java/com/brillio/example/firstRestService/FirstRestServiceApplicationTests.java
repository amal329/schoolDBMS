package com.brillio.example.firstRestService;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FirstRestServiceApplicationTests {

	@Autowired
	MyRestController controller;

	@Autowired
	PostController postController;

	@Test
	public void testDTOAvailableOrNot(){
		try{
		StudentDTO studentDTO = new StudentDTO();
		}
		catch(Exception e){
			fail();
		}
	}

	@Test
	public void testDTOAvailableOrNot1(){
		try{
			StudentDTO studentDTO = new StudentDTO();
			studentDTO.getAddress();
			studentDTO.getDob();
		}
		catch(Exception e){
			fail();
		}
	}

	@Test
	public void testController(){
		try{
			List<StudentDTO> l = controller.getStudent();
			if(l == null){
				throw new Exception();
			}
		}
		catch(Exception e){
			fail();
		}
	}

	@Test
	public void testController3(){
		try{
			List<StudentDTO> l = controller.getStudent();
			assertEquals(l.get(0).getSid(),"101");
		}
		catch(Exception e){
			fail();
		}
	}

	@Test
	public void testController2(){
		try{
			Optional<StudentDTO> s = controller.getAnyStudent("101");
			assertNotNull(s);
		}
		catch(Exception e){
			fail();
		}
	}

	@Test
	public void testController4(){
		try{
			StudentDTO s = new StudentDTO();
			s.setSid("200");
			s.setAddress("220 Kolkata");
			s.setDob("2000-01-01");
			s.setFname("James");
			s.setLname("Bond");

			String msg = postController.insertStudent(s);
			assertEquals(msg,"Data inserted successfully");
		}
		catch(Exception e){
			fail();
		}
	}

	@Test
	public void testController5(){
		try{
			Optional<StudentDTO> s = controller.getAnyStudent("5500");
			assertEquals(s.isPresent(),false);
		}
		catch(Exception e){
			fail();
		}
	}

	@Test
	public void testController6(){
		try{
			StudentDTO s = new StudentDTO();
			s.setSid("200");
			s.setAddress("220 London");
			s.setDob("2000-01-01");
			s.setFname("James");
			s.setLname("Bond");

			String msg = postController.updateStudent(s);
			assertEquals(msg,"Data updated successfully");
		}
		catch(Exception e){
			fail();
		}
	}

	@Test
	public void testController7(){
		try{
			StudentDTO s = new StudentDTO();
			s.setSid("200");
			s.setAddress("220 London");
			s.setDob("2000-01-01");
			s.setFname("James");
			s.setLname("Bond");

			String msg = postController.patchStudent(s);
			assertEquals(msg,"Data patched successfully");
		}
		catch(Exception e){
			fail();
		}
	}

	@Test
	public void testController8(){
		try{
			String msg = postController.deleteStudent("200");
			assertEquals(msg,"Data deleted successfully");
		}
		catch(Exception e){
			fail();
		}
	}
}
