package presentation.controllers;

import business.User;
import business.UserService;
import presentation.views.AdministratorView;
import presentation.views.ClientView;
import presentation.views.EmployeeView;
import presentation.views.RegisterView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clasa care implementeaza logica din spatele butoanelor de pe interfata
 */
public class RegisterController {

    private RegisterView view;

    private AdministratorView administratorView;
    private ClientView clientView;
    private EmployeeView employeeView;

    private UserService userService;

    /**
     * Constructor pentru clasa RegisterController
     *
     * @param view              view-ul
     * @param administratorView administrator view
     * @param clientView        client view
     * @param employeeView      employee view
     * @param userService       service-ul
     */
    public RegisterController(RegisterView view, AdministratorView administratorView, ClientView clientView, EmployeeView employeeView, UserService userService) {

        this.view = view;

        this.administratorView = administratorView;
        this.clientView = clientView;
        this.employeeView = employeeView;

        this.userService = userService;

        this.view.addRegisterListener(new RegisterListener());
        this.view.addLoginListener(new LoginListener());
    }

    /**
     * Clasa pentru implementarea logicii din spatele butonului de register
     */
    class RegisterListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {

                String username = view.getUsernameTextField().getText();
                if (username.equals(""))
                    throw new Exception("Username-ul nu poate fi vid!");

                String password = String.valueOf(view.getPasswordTextField().getPassword());
                if (password.equals(""))
                    throw new Exception("Parola nu poate fi vida!");

                if (userService.getUsers().containsKey(username))
                    throw new Exception("Exista deja un utilizator cu acest username!");

                boolean administrator = view.getAdministratorRadioButton().isSelected();
                boolean client, employee;
                String tip;

                if (!administrator) {

                    client = view.getClientRadioButton().isSelected();

                    if (!client) {

                        employee = view.getEmployeeRadioButton().isSelected();

                        if (!employee)
                            throw new Exception("Trebuie selectat un tip de utilizator!");

                        else
                            tip = "employee";
                    } else
                        tip = "client";
                } else
                    tip = "administrator";

                int mx = -1;
                for (User u : userService.getUsers().values()) {

                    if (u.getId() > mx)
                        mx = u.getId();
                }
                int id = mx + 1;

                User user = new User(id, username, password, tip);
                userService.addUser(user);

                System.out.println(userService.getUsers());
            } catch (Exception ex) {

                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }

    /**
     * Clasa pentru implementarea logicii din spatele butonului de log in
     */
    class LoginListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {

                String username = view.getUsernameTextField().getText();
                if (username.equals(""))
                    throw new Exception("Username-ul nu poate fi vid!");

                String password = String.valueOf(view.getPasswordTextField().getPassword());
                if (password.equals(""))
                    throw new Exception("Parola nu poate fi vida!");

                User user = userService.checkCredentials(username, password);

                if (user.getType().equals("administrator"))
                    administratorView.setVisible(true);

                else if (user.getType().equals("client")) {

                    clientView.setVisible(true);
                    clientView.setLoggedInClient(user);
                } else
                    employeeView.setVisible(true);

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }
}
