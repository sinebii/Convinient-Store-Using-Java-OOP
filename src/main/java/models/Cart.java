package models;

public class Cart {
    private String productName;
    private int productQuantity;

    public Cart() {
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cart{");
        sb.append("productName='").append(productName).append('\'');
        sb.append(", productQuantity=").append(productQuantity);
        sb.append('}');
        return sb.toString();
    }
}
