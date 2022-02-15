package com.sbrf.servlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;

//@WebServlet(name = "name")
//public class Servlet extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        HttpSession session = req.getSession();
//        Integer counter = (Integer) session.getAttribute("counter");
//        if (counter == null) {
//            counter = 0;
//        }
//        else {
//            counter++;
//        }
//        session.setAttribute("counter", counter);
//        String name = req.getParameter("name");
//        resp.setContentType("text/html");
//        PrintWriter printWriter = resp.getWriter();
//        if (name != null) {
//            printWriter.write("Привет, " + name + "<br>");
//        }
//        printWriter.write("Counter = " + counter);
//        printWriter.close();
//    }
//}
@WebServlet(name = "name")
public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        AtomicInteger counter;
        if (session.getAttribute("counter") == null){
            counter = new AtomicInteger(0);
            session.setAttribute("counter", counter.get());
        }
        else {
            counter = new AtomicInteger( (int) session.getAttribute("counter") );
            session.setAttribute("counter", counter.incrementAndGet());
        }

        String name = req.getParameter("name");
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        if (name != null) {
            printWriter.write("Привет, " + name + "<br>");
        }
        printWriter.write("Counter = " + session.getAttribute("counter"));
        printWriter.close();
    }
}