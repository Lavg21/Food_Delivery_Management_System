package presentation.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Clasa care implementeaza interfata pentru logare
 */
public class RegisterView extends JFrame {

    private JLabel titleLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;

    private JTextField usernameTextField;
    private JPasswordField passwordTextField;

    private JButton logInButton;
    private JButton registerButton;

    private JRadioButton clientRadioButton;
    private JRadioButton employeeRadioButton;
    private JRadioButton administratorRadioButton;

    /**
     * Constructor pentru clasa RegisterView
     */
    public RegisterView() {
        this.setBounds(100, 100, 458, 450);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        titleLabel = new JLabel("AUTHENTICATION");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        titleLabel.setBounds(92, 31, 260, 46);
        this.getContentPane().add(titleLabel);

        usernameLabel = new JLabel("USERNAME");
        usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        usernameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        usernameLabel.setBounds(10, 144, 107, 46);
        this.getContentPane().add(usernameLabel);

        passwordLabel = new JLabel("PASSWORD");
        passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
        passwordLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        passwordLabel.setBounds(10, 200, 107, 46);
        this.getContentPane().add(passwordLabel);

        usernameTextField = new JTextField();
        usernameTextField.setBounds(131, 144, 203, 34);
        this.getContentPane().add(usernameTextField);
        usernameTextField.setColumns(10);

        passwordTextField = new JPasswordField();
        passwordTextField.setColumns(10);
        passwordTextField.setBounds(131, 200, 203, 34);
        this.getContentPane().add(passwordTextField);

        registerButton = new JButton("REGISTER");
        registerButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        registerButton.setBounds(249, 340, 156, 38);
        this.getContentPane().add(registerButton);

        logInButton = new JButton("LOG IN");
        logInButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        logInButton.setBounds(34, 340, 156, 38);
        this.getContentPane().add(logInButton);

        clientRadioButton = new JRadioButton("CLIENT");
        clientRadioButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        clientRadioButton.setBounds(10, 262, 85, 50);
        this.getContentPane().add(clientRadioButton);

        employeeRadioButton = new JRadioButton("EMPLOYEE");
        employeeRadioButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        employeeRadioButton.setBounds(135, 262, 113, 50);
        this.getContentPane().add(employeeRadioButton);

        administratorRadioButton = new JRadioButton("ADMINISTRATOR");
        administratorRadioButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        administratorRadioButton.setBounds(284, 262, 156, 50);
        this.getContentPane().add(administratorRadioButton);

        // Afisare fereastra actuala
        this.setVisible(true);
    }

    /**
     * Metoda de adaugare a unui listener pe butonul de register
     *
     * @param actionListener actionListener
     */
    public void addRegisterListener(ActionListener actionListener) {

        this.registerButton.addActionListener(actionListener);
    }

    /**
     * Metoda de adaugare a unui listener pe butonul de log in
     *
     * @param actionListener actionListener
     */
    public void addLoginListener(ActionListener actionListener) {

        this.logInButton.addActionListener(actionListener);
    }

    /**
     * Metoda de get() pentru caseta username
     *
     * @return caseta username
     */
    public JTextField getUsernameTextField() {
        return usernameTextField;
    }

    /**
     * Metoda de get() pentru caseta parola
     *
     * @return caseta parola
     */
    public JPasswordField getPasswordTextField() {
        return passwordTextField;
    }

    /**
     * Metoda de get() pentru butonul client
     *
     * @return butonul client
     */
    public JRadioButton getClientRadioButton() {
        return clientRadioButton;
    }

    /**
     * Metoda de get() pentru butonul angajat
     *
     * @return butonul angajat
     */
    public JRadioButton getEmployeeRadioButton() {
        return employeeRadioButton;
    }

    /**
     * Metoda de get() pentru butonul administrator
     *
     * @return butonul administrator
     */
    public JRadioButton getAdministratorRadioButton() {
        return administratorRadioButton;
    }

}
