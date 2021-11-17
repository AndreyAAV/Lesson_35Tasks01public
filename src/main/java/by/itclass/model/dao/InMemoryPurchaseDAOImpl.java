package by.itclass.model.dao;

import by.itclass.model.entity.Purchase;
import by.itclass.model.exceptions.DAOException;

import java.util.ArrayList;
import java.util.List;

public class InMemoryPurchaseDAOImpl implements IPurchaseDAO {

//    @Override
//    public Purchase findFyId(int id) throws DAOException {
//        return null;
//    }

    @Override
    public List<Purchase> findAll() throws DAOException {
        return null;
    }

    @Override
    public void deletePurchases(String[] purchasesToDelete) throws DAOException {

    }

    @Override
    public ArrayList<Purchase> sortPurchases (String firstRadio, String secondRadio) throws DAOException {
        return null;
    }

    @Override
    public void addPurchases(String name_purchase, String price_purchase, String sum_purchase) throws DAOException {

    }


}
