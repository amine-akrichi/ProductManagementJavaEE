package Controller;

import DAO.ProductManagment;
import DAO.UserManagment;
import Model.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    UserManagment userManagment = new UserManagment();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession httpSession = request.getSession();

        if (userManagment.getUser(username).getPassword().equals(password)){
            ProductManagment PM = new ProductManagment();
            httpSession.setAttribute("loggedUser",userManagment.getUser(username));
            request.setAttribute("productList", PM.ListProducts());
            request.getRequestDispatcher("productTable.jsp").forward(request,response);

        }
        else{
            request.getRequestDispatcher("login.html").forward(request,response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
