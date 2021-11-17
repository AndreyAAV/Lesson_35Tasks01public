package by.itclass.controllers;

import by.itclass.model.services.PurchaseService;
import com.google.protobuf.ServiceException;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RemovePurchaseController", value = "/RemovePurchaseController")
public class RemovePurchaseController extends HttpServlet {
    private PurchaseService purchaseService;

    public RemovePurchaseController() {
        purchaseService = new PurchaseService();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] ids = request.getParameterValues("ids");
        try {
            purchaseService.deletePurchases(ids);
            response.sendRedirect("/PurchaseController");
        } catch (ServiceException e) {
            request.setAttribute("exceptionMessage", "Ошибка удаления");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
}
