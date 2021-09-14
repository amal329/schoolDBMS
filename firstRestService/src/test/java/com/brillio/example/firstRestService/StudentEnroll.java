package com.brillio.example.firstRestService;

import com.brillio.example.firstRestService.*;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

//@CucumberContextConfiguration
//@SpringBootTest(
//        classes={FirstRestServiceApplication.class, PostController.class},
//        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources")
public class StudentEnroll extends CucumberSpringConfiguration{
    @Autowired
    PostController controller = new PostController();
    StudentDTO student = new StudentDTO();

    String result;
    @Given("A student enrolls")
    public void aStudentEnrolls() {
//        controller
//        student
    }
    @When("The data is collected")
    public void theDataIsCollected() {
        student.setSid("111");
        student.setFname("Alpha");
        student.setLname("Beta");
        student.setAddress("nowhere, 123");
        student.setDob("1991-05-05");
        result = controller.insertStudent(student);
    }
    @Then("Data is added in the database")
    public void dataIsAddedInTheDatabase() {
        assertEquals(result, "Data is Inserted");
    }

    @Given("A Student leaves")
    public void aStudentLeaves() {
        result = controller.deleteStudent("111");
    }

    @Then("Data is removed from the database")
    public void dataIsRemovedFromTheDatabase() {
        assertEquals(result,"Data deleted successfully");
    }
}