package Model;

public class Product {
    private String ref;
    private String name;
    private String provider;
    private float price;

    public Product(String ref, String name, String provider, float price) {
        this.ref = ref;
        this.name = name;
        this.provider = provider;
        this.price = price;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "ref='" + ref + '\'' +
                ", name='" + name + '\'' +
                ", provider='" + provider + '\'' +
                ", price=" + price +
                '}';
    }
}
