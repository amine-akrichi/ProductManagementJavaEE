package Test;

import DAO.ProductManagment;
import DAO.UserManagment;
import Model.Product;
import Model.User;

import java.util.Iterator;

public class Test {
    public static void main(String[] args) {
        UserManagment userManagment =  new UserManagment();
        System.out.println(userManagment.ListUsers());
        userManagment.save(new User("amine555","amine", false));
    }
}
