/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppe.Products;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import shoppe.Utils.DBHelper;

/**
 *
 * @author hj
 */
public class ProductsDAO {

    private List<ProductsDTO> productList;

    public List<ProductsDTO> getProductList() {
        return productList;
    }

    public void getProduct()
            throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
//        1. Thiết lập connection
            con = DBHelper.makeConnection();
            if (con != null) {
//          2. Tạo ra câu lệnh SQL
                String sql = "Select * "
                        + "From Products ";
//          3. Tạo statement object
                stm = con.prepareStatement(sql);

//          4. Excute query
                rs = stm.executeQuery();
//          5. ProcessF
                while (rs.next()) {
//                      1. get data từ resultset
                    int productID = rs.getInt("ProductID");
                    String productName = rs.getString("ProductName");

                    BigDecimal price = rs.getBigDecimal("Price").setScale(3);

                    String image = rs.getString("Image");
                    int discount = rs.getInt("Discount");
                    //  2. map data vô properties vô DTO
                    ProductsDTO result = new ProductsDTO(productID, productName, price, image, discount);
                    if (this.productList == null) {
                        this.productList = new ArrayList<ProductsDTO>();
                    }
                    this.productList.add(result);
                }
            }//end connection has opened      
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public List<ProductsDTO> getPaging(int index)
            throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
//        1. Thiết lập connection
            con = DBHelper.makeConnection();
            if (con != null) {
//          2. Tạo ra câu lệnh SQL
                String sql = "Select * "
                        + "from Products "
                        + "Order by ProductID "
                        + "OFFSET ? ROWS "
                        + "FETCH FIRST 5 ROWS ONLY";
//          3. Tạo statement object
                stm = con.prepareStatement(sql);
                stm.setInt(1, (index - 1) * 5);
//          4. Excute query
                rs = stm.executeQuery();
//          5. ProcessF
                while (rs.next()) {
//                      1. get data từ resultset
                    int productID = rs.getInt("ProductID");
                    String productName = rs.getString("ProductName");

                    BigDecimal price = rs.getBigDecimal("Price").setScale(3);

                    String image = rs.getString("Image");
                    int discount = rs.getInt("Discount");
                    //  2. map data vô properties vô DTO
                    ProductsDTO result = new ProductsDTO(productID, productName, price, image, discount);
                    if (this.productList == null) {
                        this.productList = new ArrayList<ProductsDTO>();
                    }
                    this.productList.add(result);
                }
                return this.productList;

            }//end connection has opened      
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return null;
    }

    public int getNumberPage()
            throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
//        1. Thiết lập connection
            con = DBHelper.makeConnection();
            if (con != null) {
//          2. Tạo ra câu lệnh SQL
                String sql = "Select count(*) "
                        + "From Products ";
//          3. Tạo statement object
                stm = con.prepareStatement(sql);
//          4. Excute query
                rs = stm.executeQuery();
//          5. ProcessF
                while (rs.next()) {
                    int total = rs.getInt(1);
                    int countPage = total / 5;
                    if (countPage % 5 != 0 && countPage % 2 != 0) {
                        countPage++;
                    }
                    return countPage;
                }
            }//end connection has opened      
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return 0;
    }
}
