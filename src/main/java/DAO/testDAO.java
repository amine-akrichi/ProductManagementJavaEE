package DAO;

import Model.Product;

public class testDAO {


    public static void main(String[] args) {
        ProductManagment productManagment =new ProductManagment();
        //productManagment.updateProduct(new Product("10000","Souris HP","F1",25));
        System.out.println(productManagment.productByMC("Souris"));
    }
}
