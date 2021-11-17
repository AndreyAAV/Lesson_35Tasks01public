package by.itclass.model.services;

import by.itclass.model.dao.IPurchaseDAO;
import by.itclass.model.dao.MysqlPurchaseDAOImpl;
import by.itclass.model.entity.Purchase;
import by.itclass.model.exceptions.DAOException;
import com.google.protobuf.ServiceException;

import java.util.ArrayList;
import java.util.List;

public class PurchaseService {

    private IPurchaseDAO purchaseDAO;

    public PurchaseService() {
        purchaseDAO = new MysqlPurchaseDAOImpl();
    }

//    public Purchase getById(String id) throws ServiceException {
//        Purchase purchase = null;
//        try {
//            int idPurchase = Integer.parseInt(id);
//            purchase = purchaseDAO.findFyId(idPurchase);
//        } catch (NumberFormatException | DAOException e) {
//            throw new ServiceException(e);
//        }
//
//        return purchase;
//    }


    public List<Purchase> getAll() throws ServiceException {
        List<Purchase> purchases = null;
        try {
            purchases = purchaseDAO.findAll();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        return purchases;
    }

    public void deletePurchases(String[] purchasesToDelete) throws ServiceException {
        try {
            purchaseDAO.deletePurchases(purchasesToDelete);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public void addPurchase (String purName, String purPrice, String purNumber) throws ServiceException {
        try {
            purchaseDAO.addPurchases(purName, purPrice, purNumber);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public ArrayList<Purchase> sortPurchases (String firstRadio, String secondRadio) throws ServiceException {
        ArrayList<Purchase> sortPurchases;
        try {
            sortPurchases = purchaseDAO.sortPurchases(firstRadio, secondRadio);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return sortPurchases;
    }

}
