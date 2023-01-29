/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package sumdu.edu.ua.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.edu.sumdu.customexceptions.AgeException;
import ua.edu.sumdu.customexceptions.EmailException;
import ua.edu.sumdu.utils.Student;
import ua.edu.sumdu.utils.*;

/**
 *
 * @author polonskiy
 */
@Controller
public class StudentController {
    List<Student> students;
    ApplicationContext factory;
    Student student;    
    
    @ModelAttribute
    public void modelData(Model m){
        if(students==null){ 
            students = new LinkedList<Student>();
        }
        factory = new ClassPathXmlApplicationContext("/SpringXMLConfig.xml");
        student = (Student)factory.getBean("Student");
    }    
    
    @RequestMapping("/")
    public String home() {
        return "home";
    }
    
    @RequestMapping("StudentAdd")
    public String addStudent(HttpServletRequest request,Model m){
        HttpSession session=request.getSession();
        if (request.getParameter("name") != "" && request.getParameter("surname") != "") {
            Student student = (Student)factory.getBean("Student");        
            student.setName(request.getParameter("name"));
            student.setSurname(request.getParameter("surname"));
            student.setAge(request.getParameter("age"));
            student.setEmail(request.getParameter("email"));
            student.setGroup(request.getParameter("group"));
            student.setFaculty(request.getParameter("faculty"));
            students.add(student);
        }
        m.addAttribute("students", students);        
        return "home";
    }
    
    @PostMapping("calculateStats")
    public ModelAndView  calculateSt() throws EmailException, AgeException{ 
        ModelAndView modelNview = new ModelAndView();
        modelNview.setViewName("statout");

        StatsCalculator stat=StatsCalculator.getInstance();

        stat.setMinAge( Utils.calculateMinAge((LinkedList<Student>)students));
        stat.setMaxAge(Utils.calculateMaxAge((LinkedList<Student>)students));          
        stat.setAverageAge(Utils.calculateAverageAge((LinkedList<Student>) students));
        stat.setPopularMailDomain( Utils.calculatePopularDomain((LinkedList<Student>) students));
        stat.setSumDUMails(Utils.calculateSumduDomain((LinkedList<Student>)students));
 
          
        modelNview.addObject("stat",stat);

        return modelNview;
    }
        
    @GetMapping("filterFaculty")
    public String calculateSt(@RequestParam("filter") String faculty,Model m){ 
        List<Student> filtered = new LinkedList<Student>();
        for(Student st:students){
            if(st.getFaculty().toLowerCase().equals(faculty.toLowerCase())){
                filtered.add(st);
            }
        }
        m.addAttribute("filter", faculty);
        m.addAttribute("filtered", filtered);
        return "filteredlist";
    }  
    @GetMapping("filterGroup")
    public String calculateSt2(@RequestParam("filter") String group,Model m){ 
        List<Student> filtered = new LinkedList<Student>();
        for(Student st:students){
            if(st.getGroup().toLowerCase().equals(group.toLowerCase())){
                filtered.add(st);
            }
        }
        m.addAttribute("filter", group);
        m.addAttribute("filtered", filtered);
        return "filteredlist";
    }    
}
