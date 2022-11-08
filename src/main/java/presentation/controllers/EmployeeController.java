package presentation.controllers;

import business.DeliveryService;
import business.Order;
import presentation.Observer;
import presentation.views.EmployeeView;

/**
 * Clasa care implementeaza logica din spatele butoanelor de pe interfata
 */
public class EmployeeController implements Observer {

    private EmployeeView view;
    private DeliveryService deliveryService;

    /**
     * Constructor pentru clasa EmployeeController
     *
     * @param view            view-ul
     * @param deliveryService service-ul
     */
    public EmployeeController(EmployeeView view, DeliveryService deliveryService) {

        this.view = view;

        this.deliveryService = deliveryService;
        this.deliveryService.addObserver(this);
    }

    /**
     * Metoda de notificare pentru o noua comanda
     *
     * @param order comanda
     */
    @Override
    public void update(Order order) {

        String oldText = view.getOrderTextArea().getText();

        String content = "NEW ORDER:\nID: " + order.getOrderID() + "\nClient ID: " + order.getClientID() + "\nDate Order: " + order.getOrderDate();
        String newText = oldText + "\n" + order.getOrderID() + "\n" + content;

        view.getOrderTextArea().setText(newText);
    }
}
