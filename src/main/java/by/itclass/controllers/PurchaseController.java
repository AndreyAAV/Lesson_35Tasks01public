package by.itclass.controllers;

import by.itclass.model.entity.Purchase;
import by.itclass.model.services.PurchaseService;
import com.google.protobuf.ServiceException;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PurchaseController", value = "/PurchaseController", loadOnStartup = 1)
public class PurchaseController extends HttpServlet {
    private PurchaseService purchaseService;

    public PurchaseController() {
        purchaseService = new PurchaseService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Purchase> purchases = null;
        try {
            purchases = purchaseService.getAll();
            request.setAttribute("purchases", purchases);
        } catch (ServiceException e) {
            request.setAttribute("message", "Ошибка вывода информации");
            //e.printStackTrace();//Логирование
        }

        request.getRequestDispatcher("/index.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
