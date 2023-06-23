package Controller;

import DAO.UserManagment;
import Model.Product;
import Model.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("*.user")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserManagment userManagment = new UserManagment();
        String path = request.getServletPath();

        System.out.println(path);
        if (path.equals("/delete.user")){
            userManagment.deleteUser(request.getParameter("username"));
            request.setAttribute("usersList", userManagment.ListUsers());
            request.getRequestDispatcher("usersTable.jsp").forward(request,response);
        }
        if (path.equals("/modify.user")){
            System.out.println(userManagment.getUser(request.getParameter("username")));
            request.setAttribute("user", userManagment.getUser(request.getParameter("username")));
            request.getRequestDispatcher("modifyUserForm.jsp").forward(request,response);
        }

        if (path.equals("/list.user")){
            request.setAttribute("usersList", userManagment.ListUsers());
            request.getRequestDispatcher("usersTable.jsp").forward(request,response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserManagment userManagment = new UserManagment();
        String path = request.getServletPath();
        System.out.println(path);

        if (path.equals("/add.user")){
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            //boolean admin = Boolean.parseBoolean(request.getParameter("admin"));
            userManagment.save(new User(username,password,false));
            request.getRequestDispatcher("usersTable.jsp").forward(request,response);
        }

        if (path.equals("/modifyUser.user")){
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            boolean admin = Boolean.parseBoolean(request.getParameter("admin"));
            userManagment.updateUser(new User(username,password,admin));
            request.getRequestDispatcher("usersTable.jsp").forward(request,response);
        }

        if (path.equals("/search.user")){
            String username = request.getParameter("search");
            System.out.println(username);

            request.setAttribute("searchUser",userManagment.userByUsername(username));
            //System.out.println(PM.updateProduct(new Product(ref,name,provider,Float.parseFloat(price))));
            request.getRequestDispatcher("usersTable.jsp").forward(request,response);
        }
    }
}
