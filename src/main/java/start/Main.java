package start;

import business.DeliveryService;
import business.UserService;
import presentation.controllers.AdministratorController;
import presentation.controllers.ClientController;
import presentation.controllers.EmployeeController;
import presentation.controllers.RegisterController;
import presentation.views.AdministratorView;
import presentation.views.ClientView;
import presentation.views.EmployeeView;
import presentation.views.RegisterView;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Clasa in care se va executa programul
 */
public class Main {

    private Map<String, String> administrators = new HashMap<>();

    private Map<String, String> clients = new HashMap<>();

    private Map<String, String> employees = new HashMap<>();

    /**
     * Metoda in care se va executa programul
     *
     * @param args argumentele din linia de comanda
     * @throws IOException exceptie
     */
    public static void main(String[] args) throws Exception {

        DeliveryService deliveryService = new DeliveryService();
        deliveryService.importProducts();
        deliveryService.generateOrders();

        UserService userService = new UserService();

        RegisterView registerView = new RegisterView();

        AdministratorView administratorView = new AdministratorView();
        EmployeeView employeeView = new EmployeeView();
        ClientView clientView = new ClientView();

        AdministratorController administratorController = new AdministratorController(administratorView, deliveryService);
        ClientController clientController = new ClientController(clientView, deliveryService);
        EmployeeController employeeController = new EmployeeController(employeeView, deliveryService);
        RegisterController registerController = new RegisterController(registerView, administratorView, clientView, employeeView, userService);
    }
}
