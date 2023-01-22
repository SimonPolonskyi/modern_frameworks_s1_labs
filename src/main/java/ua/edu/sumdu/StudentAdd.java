/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ua.edu.sumdu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author polonskiy
 */
@WebServlet(name = "StudentAdd", urlPatterns = {"/StudentAdd"})
public class StudentAdd extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
/*        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
*/            /* TODO output your page here. You may use following sample code. */
 /*            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet StudentAdd</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet StudentAdd at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
*/    

    HttpSession session = request.getSession();
    List<Student> students = (List<Student>)session.getAttribute("students");
    
    if (students==null){
        students = new LinkedList<Student>(); 
        session.setAttribute("students", students);
    }

    if (request.getParameter("name")!=""||request.getParameter("surname")!=""){
        String age ="0";
        if (!request.getParameter("age").isEmpty()&& request.getParameter("age")!=null )
            age = request.getParameter("age");
        Student student = new Student(request.getParameter("name"),
                                request.getParameter("surname"),
                                   age,
                                 request.getParameter("email"),
                                 request.getParameter("group"),
                                request.getParameter("faculty"));
        students.add(student);
    }
    response.sendRedirect("index.jsp");

}

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
