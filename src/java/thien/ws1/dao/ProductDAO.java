/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thien.ws1.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import thien.ws1.dto.Account;
import thien.ws1.dto.Category;
import thien.ws1.dto.Product;
import thien.ws1.utils.ConnectDB;

/**
 *
 * @author Thienlm30
 */
public class ProductDAO implements Accessible<Product> {

    private Connection connection = null;

    public ProductDAO() {
        ConnectDB connectDB = new ConnectDB();
        this.connection = connectDB.getConnection();
    }

    public ProductDAO(ServletContext sc) {
        ConnectDB connectDB = new ConnectDB(sc);
        this.connection = connectDB.getConnection();
    }

    @Override
    public int insertRec(Product obj) {
        int result = 0;
        try {
            if (connection != null) {
                String sql = "insert into [dbo].[products]([productId],[productName],[productImage],[brief],[postedDate],[typeId],[account],[unit],[price],[discount]) "
                        + "values(?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement pst = connection.prepareStatement(sql);
                pst.setString(1, obj.getProductId());
                pst.setString(2, obj.getProductName());
                pst.setString(3, obj.getProductImage());
                pst.setString(4, obj.getBrief());
                pst.setDate(5, (Date) obj.getPostedDate());
                pst.setInt(6, obj.getType().getTypeId());
                pst.setString(7, obj.getAccount().getAccount());
                pst.setString(8, obj.getUnit());
                pst.setInt(9, obj.getPrice());
                pst.setInt(10, obj.getDiscount());
                
                result = pst.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public int updateRec(Product obj) {
        int result = 0;
        try {
            if (connection != null) {
                String sql = "update [dbo].[products] set [productName] = ?,[productImage] = ?,[brief] = ?,[postedDate] = ?,[typeId] = ?,[account] = ?,[unit] = ?,[price] = ?,[discount] = ? where [productId] = ?";
                PreparedStatement pst = connection.prepareStatement(sql);
                pst.setString(1, obj.getProductName());
                pst.setString(2, obj.getProductImage());
                pst.setString(3, obj.getBrief());
                pst.setDate(4, (Date) obj.getPostedDate());
                pst.setInt(5, obj.getType().getTypeId());
                pst.setString(6, obj.getAccount().getAccount());
                pst.setString(7, obj.getUnit());
                pst.setInt(8, obj.getPrice());
                pst.setInt(9, obj.getDiscount());
                pst.setString(10, obj.getProductId());
                result = pst.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public int deleteRec(Product obj) {
        int result = 0;
        try {
            String sql = "delete from [dbo].[products] where [productId] = ?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, obj.getProductId());
            result = pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public Product getObjectById(String id
    ) {
        Product p = null;
        try {
            if (connection != null) {
                String sql = "SELECT [productId], [productName], [productImage],\n"
                        + "[brief], [postedDate], [typeId], [account], [unit],\n"
                        + "[price], [discount]\n"
                        + "FROM [dbo].[products] WHERE productId = ?";
                PreparedStatement pst = connection.prepareStatement(sql);
                pst.setString(1, id);
                ResultSet rs = pst.executeQuery();
                if (rs != null && rs.next()) {
                    String name = rs.getString("productName");
                    String img = rs.getString("productImage");
                    String brief = rs.getString("brief");
                    Date postedDate = (Date) rs.getDate("postedDate");
                    int typeId = rs.getInt("typeId");
                    CategoryDAO cd = new CategoryDAO();
                    Category c = cd.getObjectById(String.valueOf(typeId));
                    String acc = rs.getString("account");
                    AccountDAO ad = new AccountDAO();
                    Account account = ad.getObjectById(acc);
                    String unit = rs.getString("unit");
                    int price = rs.getInt("price");
                    int discount = rs.getInt("discount");
                    p = new Product(id, name, img, brief, postedDate, c, account, unit, price, discount);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return p;
    }

    @Override
    public List<Product> listAll() {
        List<Product> list = new ArrayList<>();
        try {
            if (connection != null) {
                String sql = "SELECT [productId], [productName], [productImage],\n"
                        + "[brief], [postedDate], [typeId], [account], [unit],\n"
                        + "[price], [discount]\n"
                        + "FROM [dbo].[products]";
                Statement st = connection.createStatement();
                ResultSet rs = st.executeQuery(sql);
                if (rs != null) {
                    while (rs.next()) {
                        String id = rs.getString("productId");
                        String name = rs.getString("productName");
                        String img = rs.getString("productImage");
                        String brief = rs.getString("brief");
                        Date postedDate = (Date) rs.getDate("postedDate");
                        int typeId = rs.getInt("typeId");
                        CategoryDAO cd = new CategoryDAO();
                        Category c = cd.getObjectById(String.valueOf(typeId));
                        String acc = rs.getString("account");
                        AccountDAO ad = new AccountDAO();
                        Account account = ad.getObjectById(acc);
                        String unit = rs.getString("unit");
                        int price = rs.getInt("price");
                        int discount = rs.getInt("discount");
                        Product p = new Product(id, name, img, brief, postedDate, c, account, unit, price, discount);
                        list.add(p);
                    }
                }
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

}
