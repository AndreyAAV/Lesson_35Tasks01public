package by.itclass.model.dao;

import by.itclass.model.entity.Purchase;
import by.itclass.model.exceptions.DAOException;

import java.util.ArrayList;
import java.util.List;

public interface IPurchaseDAO {

    List<Purchase> findAll() throws DAOException;

    void deletePurchases(String[] purchasesToDelete) throws DAOException;

    ArrayList<Purchase> sortPurchases (String firstRadio, String secondRadio) throws DAOException;

    void addPurchases (String purName, String purPrice, String purNumber) throws DAOException;
}
