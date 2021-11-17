package by.itclass.model.dao;

import by.itclass.model.db.ConnectionManager;
import by.itclass.model.entity.Purchase;
import by.itclass.model.exceptions.DAOException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MysqlPurchaseDAOImpl implements IPurchaseDAO {

//    @Override
//    public ArrayList<Purchase> findAll(int id) throws DAOException {
//        Connection cn = null;
//        Statement st = null;
//        ResultSet rs = null;
//        ArrayList<Purchase> purchases = new ArrayList<>();
//
//        try {
//            cn = ConnectionManager.getConnection();
//            st = cn.createStatement();
//            rs = st.executeQuery("select * from purchase");
//            while (rs.next()) {
//                int id = Integer.parseInt(rs.getString(1));
//                String name = rs.getString(2);
//                String price = rs.getString(3);
//                String number = rs.getString(4);
//
//                purchases.add(new Purchase(id, name, Double.parseDouble(price), Integer.parseInt(number)));
//            }
//        } catch (NumberFormatException | SQLException e) {
//            throw new DAOException(e);
//        }
//        finally {
//            ConnectionManager.closeConnection();
//            ConnectionManager.closeStatement(st);
//        }
//        return purchases;
//    }

    @Override
    public ArrayList<Purchase> findAll() throws DAOException {
        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;

        ArrayList<Purchase> purchases = new ArrayList<>();

        try {
            cn = ConnectionManager.getConnection();
            st = cn.createStatement();
            rs = st.executeQuery("select * from purchase");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name_purchase = rs.getString("name_purchase");
                double price_purchase = rs.getDouble("price_purchase");
                int sum_purchase = rs.getInt("sum_purchase");
                double cost = rs.getDouble("cost");
                purchases.add(new Purchase(id, name_purchase, price_purchase, sum_purchase));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            ConnectionManager.closeResultSet(rs);
            ConnectionManager.closeStatement(st);
            ConnectionManager.closeConnection();
        }

        return purchases;
    }

    @Override
    public void deletePurchases(String[] purchasesToDelete) throws DAOException {
        Connection cn = null;
        Statement st = null;
        PreparedStatement preparedSt = null;
        try {
            cn = ConnectionManager.getConnection();
            st = cn.createStatement();
            preparedSt = cn.prepareStatement("delete from purchase where id = ?");
            for (int i = 0; i < purchasesToDelete.length; i++) {
                preparedSt.setString(1, purchasesToDelete[i]);
                preparedSt.executeUpdate();
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        finally {
            ConnectionManager.closeConnection();
            ConnectionManager.closeStatement(st);
        }
    }

    public ArrayList<Purchase> sortPurchases(String firstRadio, String secondRadio) throws DAOException {
        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;
        ArrayList<Purchase> sortPurchases = new ArrayList<>();
        try {
            cn = ConnectionManager.getConnection();
            st = cn.createStatement();
            if (!firstRadio.equals("price")) {
                rs = st.executeQuery("select * from purchaseinfo order by " + firstRadio + " " + secondRadio);
            }
            else {
                rs = st.executeQuery("select * from purchaseinfo order by " + firstRadio + " * number" + " " + secondRadio);
            }
            while (rs.next()) {
                //String name_purchase, double price_purchase, int sum_purchase
                String id = rs.getString(1);
                String name_purchase = rs.getString(2);
                String price_purchase = rs.getString(3);
                String sum_purchase = rs.getString(4);
                //String number = rs.getString(4);

                sortPurchases.add(new Purchase(Integer.parseInt(id),  name_purchase, Double.parseDouble(price_purchase), Integer.parseInt(sum_purchase)));
            }
        } catch (NumberFormatException | NullPointerException | SQLException e) {
            throw new DAOException(e);
        }
        finally {
            ConnectionManager.closeConnection();
            ConnectionManager.closeStatement(st);
        }
        return sortPurchases;
    }

    @Override
    public void addPurchases(String name_purchase, String price_purchase, String sum_purchase) throws DAOException {
        Connection cn = null;
        PreparedStatement preparedSt = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            cn = ConnectionManager.getConnection();
            preparedSt = cn.prepareStatement("insert into purchase(id, name, price, number) values(?, ?, ?, ?) ");
            st = cn.createStatement();
            rs = st.executeQuery("select max(id) from purchase");
            int newId = 0;
            while (rs.next()) {
                if (rs.getString(1) == null) {
                    break;
                }
                else {
                    newId = Integer.parseInt(rs.getString(1));
                }
            }
            preparedSt.setString(1, String.valueOf(++newId));
            preparedSt.setString(2, name_purchase);
            preparedSt.setString(3, price_purchase);
            preparedSt.setString(4, sum_purchase);
            preparedSt.execute();

        } catch (NumberFormatException | SQLException e) {
            throw new DAOException(e);
        }
        finally {
            ConnectionManager.closeConnection();
            ConnectionManager.closeStatement(preparedSt);
        }
    }
}
