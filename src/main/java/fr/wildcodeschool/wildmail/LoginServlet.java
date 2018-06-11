package fr.wildcodeschool.wildmail;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String emailValue = request.getParameter("emailValue");

        if (emailValue == null || emailValue.isEmpty()) {
            request.setAttribute("error", "Please fill email field");
            this.getServletContext()
                    .getRequestDispatcher("/login.jsp")
                    .forward(request, response);
        } else {
            // TODO : write in cookies instead of session
            request.getSession().setAttribute("email", emailValue);
            response.sendRedirect(request.getContextPath() + "/home");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO : load from cookies instead of session
        String email = (String) request.getSession().getAttribute("email");
        if (email != null && !email.isEmpty()) {
            response.sendRedirect(request.getContextPath() + "/home");
        } else {
            this.getServletContext()
                    .getRequestDispatcher("/login.jsp")
                    .forward(request, response);
        }
    }
}
