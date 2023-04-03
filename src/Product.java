import java.io.Serializable;

public class Product implements Serializable {
    private int productId;
    private String productName;
    private String hangSanxuat;
    private float price;

    public Product() {
    }

    public Product(int productId, String productName, String hangSanxuat, float price) {
        this.productId = productId;
        this.productName = productName;
        this.hangSanxuat = hangSanxuat;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getHangSanxuat() {
        return hangSanxuat;
    }

    public void setHangSanxuat(String hangSanxuat) {
        this.hangSanxuat = hangSanxuat;
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
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", hangSanxuat='" + hangSanxuat + '\'' +
                ", price=" + price +
                '}';
    }
}
