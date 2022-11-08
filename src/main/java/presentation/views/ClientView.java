package presentation.views;

import business.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Clasa care implementeaza interfata pentru client
 */
public class ClientView extends JFrame {

    private JLabel titleLabel;
    private JLabel productsLabel;
    private JLabel criteriaLabel;
    private JLabel keywordLabel;
    private JLabel orderLabel;

    private JTextField criteriaTextField;
    private JTextField keyTextField;
    private JTextField orderTextField;

    private JButton createButton;
    private JButton afisareButton;
    private JButton searchButton;

    private JTable productsTable;

    private JScrollPane tableScroll;

    private User loggedInClient;

    /**
     * Constructor pentru ClientView
     */
    public ClientView() {
        this.setBounds(100, 100, 1100, 550);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        titleLabel = new JLabel("CLIENT MENU");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        titleLabel.setBounds(377, 10, 313, 46);
        this.getContentPane().add(titleLabel);

        productsLabel = new JLabel("PRODUCTS");
        productsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        productsLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        productsLabel.setBounds(331, 76, 127, 46);
        this.getContentPane().add(productsLabel);

        criteriaLabel = new JLabel("CRITERIA");
        criteriaLabel.setHorizontalAlignment(SwingConstants.CENTER);
        criteriaLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        criteriaLabel.setBounds(840, 132, 71, 38);
        this.getContentPane().add(criteriaLabel);

        keywordLabel = new JLabel("KEYWORD");
        keywordLabel.setHorizontalAlignment(SwingConstants.CENTER);
        keywordLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        keywordLabel.setBounds(840, 191, 79, 38);
        this.getContentPane().add(keywordLabel);

        orderLabel = new JLabel("ORDER ID");
        orderLabel.setHorizontalAlignment(SwingConstants.CENTER);
        orderLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        orderLabel.setBounds(840, 326, 79, 38);
        this.getContentPane().add(orderLabel);

        criteriaTextField = new JTextField();
        criteriaTextField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        criteriaTextField.setColumns(10);
        criteriaTextField.setBounds(935, 132, 141, 34);
        this.getContentPane().add(criteriaTextField);

        keyTextField = new JTextField();
        keyTextField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        keyTextField.setColumns(10);
        keyTextField.setBounds(935, 195, 141, 34);
        this.getContentPane().add(keyTextField);

        orderTextField = new JTextField();
        orderTextField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        orderTextField.setColumns(10);
        orderTextField.setBounds(935, 326, 141, 34);
        this.getContentPane().add(orderTextField);

        productsTable = new JTable();
        productsTable.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        this.tableScroll = new JScrollPane(this.productsTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        this.tableScroll.setBounds(23, 132, 807, 336);
        this.tableScroll.setViewportView(this.productsTable);
        this.getContentPane().add(this.tableScroll);

        createButton = new JButton("CREATE");
        createButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        createButton.setBounds(935, 374, 141, 38);
        this.getContentPane().add(createButton);

        searchButton = new JButton("SEARCH");
        searchButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        searchButton.setBounds(935, 252, 141, 38);
        this.getContentPane().add(searchButton);

        afisareButton = new JButton("SHOW");
        afisareButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        afisareButton.setBounds(935, 441, 141, 38);
        this.getContentPane().add(afisareButton);

        // this.setVisible(true);
    }

    /**
     * Metoda de adaugare a unui listener pe butonul de creare
     *
     * @param actionListener actionListener
     */
    public void addCreareListener(ActionListener actionListener) {

        this.createButton.addActionListener(actionListener);
    }

    /**
     * Metoda de adaugare a unui listener pe butonul de cautare
     *
     * @param actionListener actionListener
     */
    public void addCautareListener(ActionListener actionListener) {

        this.searchButton.addActionListener(actionListener);
    }

    /**
     * Metoda de get() pentru caseta criteria
     *
     * @return caseta criteria
     */
    public JTextField getCriteriaTextField() {
        return criteriaTextField;
    }

    /**
     * Metoda de get() pentru caseta keyword
     *
     * @return caseta keyword
     */
    public JTextField getKeyTextField() {
        return keyTextField;
    }

    /**
     * Metoda de get() pentru caseta comanda
     *
     * @return caseta comanda
     */
    public JTextField getOrderTextField() {
        return orderTextField;
    }

    /**
     * Metoda de get() pentru tabel
     *
     * @return tabelul
     */
    public JTable getProductsTable() {
        return productsTable;
    }

    /**
     * Metoda de get() pentru un client care s-a logat
     *
     * @return clientul
     */
    public User getLoggedInClient() {

        return loggedInClient;
    }

    /**
     * Metoda de set() pentru un client care s-a logat
     * @param user useru-ul
     */
    public void setLoggedInClient(User user) {

        this.loggedInClient = user;
    }
}
