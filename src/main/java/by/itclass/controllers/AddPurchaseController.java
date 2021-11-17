package by.itclass.controllers;

import by.itclass.model.services.PurchaseService;
import com.google.protobuf.ServiceException;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddPurchaseController", value = "/AddPurchaseController")
public class AddPurchaseController extends HttpServlet {

    private PurchaseService purchaseService;

    public AddPurchaseController() {
        purchaseService = new PurchaseService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String purName = request.getParameter("PurchaseName");
        String purPrice = request.getParameter("PurchasePrice");
        String purNumber = request.getParameter("PurchaseNumber");
        try {
            purchaseService.addPurchase(purName, purNumber, purPrice);
            response.sendRedirect("/PurchaseController");
        } catch (com.google.protobuf.ServiceException e) {
            request.setAttribute("exceptionMessage", "Ошибка добавления");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
//        request.getRequestDispatcher("/index.jsp")
//                .forward(request, response);

    }
}
