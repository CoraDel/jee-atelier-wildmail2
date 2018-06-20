package fr.wildcodeschool.wildmail;

import com.mysql.jdbc.Driver;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.PrimitiveIterator;

@WebServlet(name = "MailCreateServlet", urlPatterns = "/mailcreate")
public class MailCreateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String from =  request.getParameter("from");
        String to=  request.getParameter("to");
        String content =  request.getParameter("content");

        SingletonBDD singletonBDD = SingletonBDD.getInstance();
        try {
            PreparedStatement preparedStatement = singletonBDD.getConnection()
                    .prepareStatement("INSERT INTO mail VALUES(null, ?, ?, ?);");

            preparedStatement.setString(1, from);
            preparedStatement.setString(2, to);
            preparedStatement.setString(3, content);
            preparedStatement.executeUpdate();

            response.sendRedirect("/home");

        } catch (SQLException e) {
            e.printStackTrace();

            PrintWriter out = response.getWriter();
            out.println(e.getMessage());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        this.getServletContext()
                .getRequestDispatcher("/mail_create.jsp")
                .forward(request, response);

    }
}
