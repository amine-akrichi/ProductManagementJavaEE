package Controller;

import DAO.SingletonConnection;
import Model.Product;
import DAO.ProductManagment;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;

@WebServlet("*.do")
public class ProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductManagment PM = new ProductManagment();
        String path = request.getServletPath();
        if (path.equals("/delete.do")){
            PM.deleteProduct(request.getParameter("ref"));
            request.setAttribute("productList", PM.ListProducts());
            request.getRequestDispatcher("productTable.jsp").forward(request,response);
        }
        if (path.equals("/modify.do")){
            request.setAttribute("product", PM.getProduct(request.getParameter("ref")));
            request.getRequestDispatcher("modifyProductForm.jsp").forward(request,response);
        }

        if (path.equals("/list.do")){
            request.setAttribute("productList", PM.ListProducts());
            request.getRequestDispatcher("productTable.jsp").forward(request,response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductManagment PM = new ProductManagment();
        String path = request.getServletPath();
        if (path.equals("/add.do")){
            String ref = request.getParameter("ref");
            String name = request.getParameter("name");
            String provider = request.getParameter("provider");
            String price  = request.getParameter("price");
            PM.save(new Product(ref,name,provider,Float.parseFloat(price)));
            request.setAttribute("productList", PM.ListProducts());
            request.getRequestDispatcher("productTable.jsp").forward(request,response);
        }

        if (path.equals("/modifyPost.do")){
            String ref = request.getParameter("ref");
            String name = request.getParameter("name");
            String provider = request.getParameter("provider");
            String price  = request.getParameter("price");
            System.out.println(PM.updateProduct(new Product(ref,name,provider,Float.parseFloat(price))));
            request.setAttribute("productList", PM.ListProducts());
            request.getRequestDispatcher("productTable.jsp").forward(request,response);
        }

        if (path.equals("/search.do")){
            String ref = request.getParameter("search");
            System.out.println(ref);
            System.out.println(PM.productByMC(ref));
            request.setAttribute("searchPL",PM.productByMC(ref));
            /*System.out.println(PM.updateProduct(new Product(ref,name,provider,Float.parseFloat(price))));*/
            request.getRequestDispatcher("productTable.jsp").forward(request,response);
        }
    }
}
