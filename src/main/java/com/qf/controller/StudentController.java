package com.qf.controller;

import com.qf.pojo.BaseResult;
import com.qf.pojo.Student;
import com.qf.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    public BaseResult findAll(@RequestParam("page")Integer page, @RequestParam("limit")Integer size){
        return studentService.findAll(page,size);
    }

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public BaseResult insert(@RequestBody Student student){
        return studentService.insert(student);
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public BaseResult update(@RequestBody Student student){
        return studentService.update(student);
    }

    @RequestMapping(value = "/del",method = RequestMethod.POST)
    public BaseResult del(@RequestBody Map map){
        return studentService.del((Integer)map.get("id"));
    }
}
