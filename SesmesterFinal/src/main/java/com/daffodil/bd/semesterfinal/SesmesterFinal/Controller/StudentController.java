package com.daffodil.bd.semesterfinal.SesmesterFinal.Controller;
import com.daffodil.bd.semesterfinal.SesmesterFinal.Entity.Teacher;
import com.daffodil.bd.semesterfinal.SesmesterFinal.Service.StudentService;
import com.daffodil.bd.semesterfinal.SesmesterFinal.Service.TeacherNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller()
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/student")
    public String ShowAllStudent(Model model) {
        List<Teacher> list = studentService.teacherList();
        model.addAttribute("list", list);
        return "studentlist";
    }
    @GetMapping("newstudent")
    public String showhome(Model model){
        model.getAttribute("teacher");
        return "studentsave";
    }
    @PostMapping("/studentsave")
    public String covert( Teacher teacher) throws TeacherNotFoundException {
        studentService.get(teacher.getId());
        return "redirect:/teacher";
    }
    @GetMapping ("/studentedit/{id}")
    public String StudentEdit(@PathVariable("id") Integer id, Model model) {
        try {
            Teacher teacher = studentService.get(id);
            model.addAttribute("teacher", teacher);
            return "studentlist";
        } catch (TeacherNotFoundException e) {
            e.printStackTrace();
        }
        return "redirect:/teacher";


    }
}
