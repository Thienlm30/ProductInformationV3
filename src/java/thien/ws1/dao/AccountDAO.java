/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thien.ws1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import thien.ws1.dto.Account;
import thien.ws1.utils.ConnectDB;

/**
 *
 * @author Thienlm30
 */
public class AccountDAO implements Accessible<Account> {

    private Connection connection = null;

    public AccountDAO() {
        ConnectDB connectDB = new ConnectDB();
        this.connection = connectDB.getConnection();
    }

    public AccountDAO(ServletContext sc) {
        ConnectDB connectDB = new ConnectDB(sc);
        this.connection = connectDB.getConnection();
    }

    @Override
    public int insertRec(Account obj) {
        int result = 0;
        try {
            if (connection != null) {
                String sql = "insert into dbo.Accounts(account,pass,lastName,firstName,birthday,gender,phone,isUse,roleInSystem) values(?,?,?,?,?,?,?,?,?)";
                PreparedStatement pst = connection.prepareStatement(sql);
                pst.setString(1, obj.getAccount());
                pst.setString(2, obj.getPass());
                pst.setNString(3, obj.getLastName());
                pst.setNString(4, obj.getFirstName());
                pst.setDate(5, (Date) obj.getBirthday());
                pst.setBoolean(6, obj.isGender());
                pst.setString(7, obj.getPhone());
                pst.setBoolean(8, obj.isIsUse());
                pst.setInt(9, obj.getRoleInSystem());
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
    public int updateRec(Account obj) {
        int result = 0;
        try {
            if (connection != null) {
                String sql = "update [dbo].[accounts] set [account] = ?, [pass] = ?, [lastName] = ?, [firstName] = ?, [birthday] = ?, [gender] = ?, [phone] = ?, [isUse] = ?, [roleInSystem] = ? where [account] = ?";
                PreparedStatement pst = connection.prepareStatement(sql);
                pst.setString(1, obj.getAccount());
                pst.setString(2, obj.getPass());
                pst.setNString(3, obj.getLastName());
                pst.setNString(4, obj.getFirstName());
                pst.setDate(5, (Date) obj.getBirthday());
                pst.setBoolean(6, obj.isGender());
                pst.setString(7, obj.getPhone());
                pst.setBoolean(8, obj.isIsUse());
                pst.setInt(9, obj.getRoleInSystem());
                pst.setString(10, obj.getAccount());
                result = pst.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    
    public int updateIsUse(String account, boolean isUse) {
        int result = 0;
        try {
            if (connection != null) {
                String sql = "update [dbo].[accounts] set [isUse] = ? where [account] = ?";
                PreparedStatement pst = connection.prepareStatement(sql);
                pst.setBoolean(1, isUse);
                pst.setString(2, account);
                result = pst.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public int deleteRec(Account obj) {
        int result = 0;
        try {
            if (connection != null) {
                String sql = "delete from [dbo].[accounts] where [account] = ?";
                PreparedStatement pst = connection.prepareStatement(sql);
                pst.setString(1, obj.getAccount());
                result = pst.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public Account getObjectById(String id) {
        Account acc = null;
        try {
            if (connection != null) {
                String sql = "SELECT [account], [pass], [lastName], [firstName],\n"
                        + "[birthday], [gender], [phone], [isUse], [roleInSystem]\n"
                        + "FROM [dbo].[accounts]\n"
                        + "WHERE [account] = ?";
                PreparedStatement pst = connection.prepareStatement(sql);
                pst.setString(1, id);
                ResultSet rs = pst.executeQuery();
                if (rs != null && rs.next()) {
                    String pass = rs.getString("pass");
                    String lastName = rs.getString("lastName");
                    String firstName = rs.getString("firstName");
                    Date birthday = rs.getDate("birthday");
                    boolean gender = rs.getBoolean("gender");
                    String phone = rs.getString("phone");
                    boolean isUse = rs.getBoolean("isUse");
                    int roleInSystem = rs.getInt("roleInSystem");
                    acc = new Account(id, pass, lastName, firstName, birthday, gender, phone, isUse, roleInSystem);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return acc;
    }

    @Override
    public List<Account> listAll() {
        List<Account> list = new ArrayList<>();
        try {
            if (connection != null) {
                String sql = "select account, pass, lastName, firstName, \n"
                        + "birthday, gender, phone, isUse, roleInSystem \n"
                        + "from accounts";
                Statement st = connection.createStatement();
                ResultSet rs = st.executeQuery(sql);
                if (rs != null) {
                    while (rs.next()) {
                        String account = rs.getString("account");
                        String pass = rs.getString("pass");
                        String lastName = rs.getString("lastName");
                        String firstName = rs.getString("firstName");
                        Date birthday = rs.getDate("birthday");
                        boolean gender = rs.getBoolean("gender");
                        String phone = rs.getString("phone");
                        boolean isUse = rs.getBoolean("isUse");
                        int roleInSystem = rs.getInt("roleInSystem");
                        Account acc = new Account(account, pass, lastName, firstName, birthday, gender, phone, isUse, roleInSystem);
                        list.add(acc);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}