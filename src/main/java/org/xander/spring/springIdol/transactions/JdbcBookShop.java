package org.xander.spring.springIdol.transactions;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class JdbcBookShop implements BookShop {
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void purchase(String isbn, String username) {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            conn.setAutoCommit(false);

            PreparedStatement stmt1 = conn.prepareStatement(
                    "SELECT PRICE FROM BOOK WHERE ISBN = ?");
            stmt1.setString(1, isbn);
            ResultSet rs = stmt1.executeQuery();
            rs.next();
            int price = rs.getInt("PRICE");
            stmt1.close();
            PreparedStatement stmt2 = conn.prepareStatement(
                    "UPDATE BOOK_STOCK SET STOCK = STOCK - 1 " +
                            "WHERE ISBN = ?");
            stmt2.setString(1, isbn);
            stmt2.executeUpdate();
            stmt2.close();

            PreparedStatement stmt2_5 = conn.prepareStatement(
                    "SELECT BALANCE FROM ACCOUNT " +
                            "WHERE USERNAME = ?");
            stmt2_5.setString(1, username);
            ResultSet rs1= stmt2_5.executeQuery();
            rs1.next();
            int price1 = rs1.getInt("BALANCE");
            stmt2_5.close();
            if(price1 < 30) throw new SQLException();


            PreparedStatement stmt3 = conn.prepareStatement(
                    "UPDATE ACCOUNT SET BALANCE = BALANCE - ? " +
                            "WHERE USERNAME = ?");
            stmt3.setInt(1, price);
            stmt3.setString(2, username);
            stmt3.executeUpdate();
            stmt3.close();

            conn.commit();
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException e1) {}
            }
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }
    }

}
