package com.example.swaggerdemo9.contrller;

import com.example.swaggerdemo9.entry.Student;
import com.example.swaggerdemo9.jdbc.MySQLTest;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping(value="/student")
public class StudentController {
    @Autowired
    MySQLTest test;
    @ApiOperation(value = "根据学生ID查询学生",notes = "根据学生ID查询学生信息")
    @RequestMapping(value="/{id}",method = RequestMethod.GET )
    //http://localhost:8080/student/id?studentid=1直接界面访问
    //http://localhost:8080/swagger-ui.html#/ swagger页面
    public Student getStudentInfo(Integer studentid){
        return test.getStudent(studentid);
    }

    @ApiOperation(value = "查询所有学生",notes = "查询所有学生信息")
    @RequestMapping(value="/",method = RequestMethod.GET )
    public List<Student> getStudentList (){
        try {
            return test.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
