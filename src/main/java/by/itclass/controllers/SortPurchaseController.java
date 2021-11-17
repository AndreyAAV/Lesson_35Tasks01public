package by.itclass.controllers;

import by.itclass.model.entity.Purchase;
import by.itclass.model.exceptions.ServiceException;
import by.itclass.model.services.PurchaseService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "SortPurchaseController", value = "/SortPurchaseController")
public class SortPurchaseController extends HttpServlet {
    private PurchaseService purchaseService;

    public SortPurchaseController() {
        purchaseService = new PurchaseService();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String currentRadioFirstChoose = request.getParameter("radio");
        String currentRadioSecondChoose = request.getParameter("radioSortChoose");
        ArrayList<Purchase> sortPurchases;
        try {
            sortPurchases = purchaseService.sortPurchases (currentRadioFirstChoose, currentRadioSecondChoose);
            request.setAttribute("purchases", sortPurchases);
        } catch (com.google.protobuf.ServiceException e) {
            request.setAttribute("exceptionMessage", "Ошибка сортировки");
        }
        request.getRequestDispatcher("/purchase.jsp").forward(request, response);

    }
}
