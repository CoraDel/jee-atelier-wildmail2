package fr.wildcodeschool.wildmail;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import com.mysql.jdbc.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "MailContentServlet", urlPatterns = "/mailcontent")
public class MailContentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getParameterMap().containsKey("id");
        String idValue = request.getParameter("id");

        SingletonBDD singletonBDD = SingletonBDD.getInstance();

        try {
            PreparedStatement preparedStatement = (PreparedStatement) singletonBDD.getConnection()
                    .prepareStatement("SELECT * FROM mail where mail_id = ?");
            preparedStatement.setInt(1, Integer.parseInt(idValue));
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.getFetchSize() == 0){
                PrintWriter out = response.getWriter();
                out.println("No content found " + idValue);
            }

            while (resultSet.next()) {
                int id = resultSet.getInt("mail_id");
                String from = resultSet.getString("from");
                String to = resultSet.getString("to");
                String content = resultSet.getString("content");

                PrintWriter out = response.getWriter();
                out.println(from);
                out.println(to);
                out.println(content);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
