package DAO;

import Model.Product;

import java.util.List;

public interface IProductDAO {
    public Product save(Product p);
    public List<Product> productByMC(String mc);
    public List<Product> ListProducts();
    public Product getProduct(String Ref);
    public Product updateProduct(Product p);
    public void deleteProduct(String Ref);

}
