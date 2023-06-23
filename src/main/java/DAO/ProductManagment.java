package DAO;

import Model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductManagment implements IProductDAO{
    static Connection conn = SingletonConnection.getConnection();
    @Override
    public Product save(Product p) {
        //Connection conn = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO product VALUES (?,?,?,?) ;");
            ps.setString(1,p.getRef());
            ps.setString(2,p.getName());
            ps.setString(3,p.getProvider());
            ps.setFloat(4,p.getPrice());
            ps.executeUpdate();
            ps.close();
            return p;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public List<Product> ListProducts(){
        //Connection conn = SingletonConnection.getConnection();
        List<Product> PL = new ArrayList<>();

        try {
            PreparedStatement ps = conn.prepareStatement("SELECT Reference, Label,Supplier,Price FROM product;");
            ResultSet RS = ps.executeQuery();
            while (RS.next()){
                PL.add(new Product(RS.getString("Reference"),RS.getString("Label"),RS.getString("Supplier"),RS.getFloat("Price")));
            }
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return PL;
    }


    @Override
    public List<Product> productByMC(String mc) {
        //Connection conn = SingletonConnection.getConnection();
        List<Product> PL = new ArrayList<>();

        try {
            PreparedStatement ps = conn.prepareStatement("SELECT Reference, Label,Supplier,Price FROM product WHERE Label LIKE ? ;");
            ps.setString(1,"%"+mc+"%");
            ResultSet RS = ps.executeQuery();
            while (RS.next()){
                PL.add(new Product(RS.getString("Reference"),RS.getString("Label"),RS.getString("Supplier"),RS.getFloat("Price")));
            }
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return PL;
    }

    @Override
    public Product getProduct(String Ref) {
        //Connection conn = SingletonConnection.getConnection();
        Product P = null;
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT Reference, Label,Supplier,Price FROM product WHERE Reference = ? ;");
            ps.setString(1,Ref);
            ResultSet RS = ps.executeQuery();
            while (RS.next()){
                P = new Product(RS.getString("Reference"),RS.getString("Label"),RS.getString("Supplier"),RS.getFloat("Price"));
            }
             ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return P;
    }

    @Override
    public Product updateProduct(Product p) {

        try {
            PreparedStatement ps = conn.prepareStatement("UPDATE product SET Label = ? , Supplier = ? , Price = ? WHERE Reference = ?");

            ps.setString(1,p.getName());
            ps.setString(2, p.getProvider());
            ps.setFloat(3,p.getPrice());
            ps.setString(4,p.getRef());
            int RS = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }

    @Override
    public void deleteProduct(String Ref) {
        //Connection conn = SingletonConnection.getConnection();
            try {
                PreparedStatement ps = conn.prepareStatement("DELETE FROM product WHERE Reference = ?");

                ps.setString(1,Ref);
                int RS = ps.executeUpdate();
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
}
