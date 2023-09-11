/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppe.Products;

import java.math.BigDecimal;


/**
 *
 * @author hj
 */
public class ProductsDTO {

    private int productID;
    private String productName;
    private BigDecimal price;
    private String image;
    private int discount;

    public ProductsDTO() {
    }

    public ProductsDTO(int productID, String productName, BigDecimal price, String image, int discount) {

        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.image = image;
        this.discount = discount;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public BigDecimal getPriceDiscount() {
        return  (this.getPrice().subtract(this.getPrice().multiply(BigDecimal.valueOf(this.getDiscount() * 0.01)))).setScale(3);
    }

}
