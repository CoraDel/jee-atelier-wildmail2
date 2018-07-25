package fr.wildcodeschool.wildmail;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import com.mysql.jdbc.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "HomeServlet", urlPatterns = "/home")
public class HomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("email")) {
                    email = cookie.getValue();
                }
            }
        }

        if (email != null && !email.isEmpty()) {
            // TODO : load email list from database here
            Class driverClass = null;
            try {
                driverClass = Class.forName("com.mysql.jdbc.Driver");
                Driver driver = (Driver) driverClass.newInstance();
                DriverManager.registerDriver(driver);
                Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/wildmail",
                        "root", "jecode4wcs");

                PreparedStatement preparedStatement = (PreparedStatement) connection
                        .prepareStatement("SELECT * FROM mail");
                ResultSet resultSet = preparedStatement.executeQuery();

                ArrayList<MailBean> mailList = new ArrayList<>();

                while (resultSet.next()) {
                    int id = resultSet.getInt("mail_id");
                    String from = resultSet.getString("from");
                    String to = resultSet.getString("to");
                    String content = resultSet.getString("content");

                    MailBean mailBean = new MailBean();
                    mailBean.setId(id);
                    mailBean.setFrom(from);
                    mailBean.setTo(to);
                    mailBean.setContent(content);
                    //Ajout de la bean dans la liste
                    mailList.add(mailBean);
                }
                request.setAttribute("mails", mailList);

            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
                e.printStackTrace();
            }

            this.getServletContext()
                    .getRequestDispatcher("/maillist.jsp")
                    .forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/login");
        }
    }
}
