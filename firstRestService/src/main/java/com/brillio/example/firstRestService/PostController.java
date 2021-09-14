package com.brillio.example.firstRestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sdetail")
public class PostController {
    @Autowired
    StudentDAO studentDAO;

    @PostMapping("/insert")
    public String insertStudent(@RequestBody StudentDTO s){
        try{
            studentDAO.save(s);
            return "Data inserted successfully";
        }
        catch (Exception e){
            return e.getMessage();
        }
    }

    @PostMapping("/update")
    public String updateStudent(@RequestBody StudentDTO s){
        try{
            studentDAO.save(s);
            return "Data updated successfully";
        }
        catch (Exception e){
            return e.getMessage();
        }
    }

    @PostMapping("/patch")
    public String patchStudent(@RequestBody StudentDTO s){
        try{
            studentDAO.save(s);
            return "Data patched successfully";
        }
        catch (Exception e){
            return e.getMessage();
        }
    }

    @DeleteMapping("/delete/{sid}")
    public String deleteStudent(@PathVariable String sid){
        try{
            studentDAO.deleteById(sid);
            return "Data deleted successfully";
        }
        catch (Exception e){
            return e.getMessage();
        }
    }
}
