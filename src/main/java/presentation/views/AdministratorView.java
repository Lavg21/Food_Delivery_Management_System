package presentation.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Clasa care implementeaza interfata pentru administrator
 */
public class AdministratorView extends JFrame {

    private JLabel titleLabel;
    private JLabel productLabel;
    private JLabel titlePLabel;
    private JLabel ratingLabel;
    private JLabel caloriesLabel;
    private JLabel proteinLabel;
    private JLabel fatLabel;
    private JLabel sodiumLabel;
    private JLabel priceLabel;
    private JLabel productsLabel;
    private JLabel menuLabel;
    private JLabel reportLabel;
    private JLabel parameter1Label;
    private JLabel parameter2Label;

    private JTextField titleTextField;
    private JTextField ratingTextField;
    private JTextField caloriesTextField;
    private JTextField proteinTextField;
    private JTextField fatTextField;
    private JTextField sodiumTextField;
    private JTextField priceTextField;
    private JTextField menuTextField;
    private JTextField reportTextField;
    private JTextField parameter1TextField;
    private JTextField parameter2TextField;

    private JButton addButton;
    private JButton modifyButton;
    private JButton deleteButton;
    private JButton createButton;
    private JButton reportButton;

    private JTable productsTable;

    private JScrollPane tableScroll;

    /**
     * Constructor pentru clasa AdministratorView
     */
    public AdministratorView() {

        this.setBounds(100, 100, 1100, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        titleLabel = new JLabel("ADMINISTRATOR MENU");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        titleLabel.setBounds(377, 10, 313, 46);
        this.getContentPane().add(titleLabel);

        productLabel = new JLabel("PRODUCT");
        productLabel.setHorizontalAlignment(SwingConstants.CENTER);
        productLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        productLabel.setBounds(10, 131, 107, 46);
        this.getContentPane().add(productLabel);

        titlePLabel = new JLabel("TITLE");
        titlePLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titlePLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        titlePLabel.setBounds(151, 87, 107, 46);
        this.getContentPane().add(titlePLabel);

        ratingLabel = new JLabel("RATING");
        ratingLabel.setHorizontalAlignment(SwingConstants.CENTER);
        ratingLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        ratingLabel.setBounds(301, 87, 69, 46);
        this.getContentPane().add(ratingLabel);

        caloriesLabel = new JLabel("CALORIES");
        caloriesLabel.setHorizontalAlignment(SwingConstants.CENTER);
        caloriesLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        caloriesLabel.setBounds(397, 87, 81, 46);
        this.getContentPane().add(caloriesLabel);

        proteinLabel = new JLabel("PROTEIN");
        proteinLabel.setHorizontalAlignment(SwingConstants.CENTER);
        proteinLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        proteinLabel.setBounds(497, 87, 81, 46);
        this.getContentPane().add(proteinLabel);

        fatLabel = new JLabel("FAT");
        fatLabel.setHorizontalAlignment(SwingConstants.CENTER);
        fatLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        fatLabel.setBounds(588, 87, 81, 46);
        this.getContentPane().add(fatLabel);

        sodiumLabel = new JLabel("SODIUM");
        sodiumLabel.setHorizontalAlignment(SwingConstants.CENTER);
        sodiumLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        sodiumLabel.setBounds(679, 87, 81, 46);
        this.getContentPane().add(sodiumLabel);

        priceLabel = new JLabel("PRICE");
        priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        priceLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        priceLabel.setBounds(766, 87, 81, 46);
        this.getContentPane().add(priceLabel);

        productsLabel = new JLabel("PRODUCTS");
        productsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        productsLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        productsLabel.setBounds(341, 199, 127, 46);
        this.getContentPane().add(productsLabel);

        menuLabel = new JLabel("MENU TITLE");
        menuLabel.setHorizontalAlignment(SwingConstants.CENTER);
        menuLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        menuLabel.setBounds(893, 250, 107, 46);
        this.getContentPane().add(menuLabel);

        reportLabel = new JLabel("REPORT NR");
        reportLabel.setHorizontalAlignment(SwingConstants.CENTER);
        reportLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        reportLabel.setBounds(893, 410, 107, 46);
        this.getContentPane().add(reportLabel);

        parameter1Label = new JLabel("PARAMETER 1");
        parameter1Label.setHorizontalAlignment(SwingConstants.CENTER);
        parameter1Label.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        parameter1Label.setBounds(893, 506, 107, 46);
        this.getContentPane().add(parameter1Label);

        parameter2Label = new JLabel("PARAMETER 2");
        parameter2Label.setHorizontalAlignment(SwingConstants.CENTER);
        parameter2Label.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        parameter2Label.setBounds(893, 606, 107, 46);
        this.getContentPane().add(parameter2Label);

        titleTextField = new JTextField();
        titleTextField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        titleTextField.setBounds(136, 143, 138, 34);
        this.getContentPane().add(titleTextField);
        titleTextField.setColumns(10);

        ratingTextField = new JTextField();
        ratingTextField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        ratingTextField.setColumns(10);
        ratingTextField.setBounds(301, 143, 69, 34);
        this.getContentPane().add(ratingTextField);

        caloriesTextField = new JTextField();
        caloriesTextField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        caloriesTextField.setColumns(10);
        caloriesTextField.setBounds(397, 143, 71, 34);
        this.getContentPane().add(caloriesTextField);

        proteinTextField = new JTextField();
        proteinTextField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        proteinTextField.setColumns(10);
        proteinTextField.setBounds(497, 143, 71, 34);
        this.getContentPane().add(proteinTextField);

        fatTextField = new JTextField();
        fatTextField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        fatTextField.setColumns(10);
        fatTextField.setBounds(589, 143, 71, 34);
        this.getContentPane().add(fatTextField);

        sodiumTextField = new JTextField();
        sodiumTextField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        sodiumTextField.setColumns(10);
        sodiumTextField.setBounds(680, 143, 71, 34);
        this.getContentPane().add(sodiumTextField);

        priceTextField = new JTextField();
        priceTextField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        priceTextField.setColumns(10);
        priceTextField.setBounds(776, 143, 71, 34);
        this.getContentPane().add(priceTextField);

        menuTextField = new JTextField();
        menuTextField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        menuTextField.setColumns(10);
        menuTextField.setBounds(878, 300, 156, 34);
        this.getContentPane().add(menuTextField);

        reportTextField = new JTextField();
        reportTextField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        reportTextField.setColumns(10);
        reportTextField.setBounds(878, 457, 156, 34);
        this.getContentPane().add(reportTextField);

        parameter1TextField = new JTextField();
        parameter1TextField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        parameter1TextField.setColumns(10);
        parameter1TextField.setBounds(878, 556, 156, 34);
        this.getContentPane().add(parameter1TextField);

        parameter2TextField = new JTextField();
        parameter2TextField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        parameter2TextField.setColumns(10);
        parameter2TextField.setBounds(878, 656, 156, 34);
        this.getContentPane().add(parameter2TextField);

        addButton = new JButton("ADD");
        addButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        addButton.setBounds(878, 90, 156, 38);
        this.getContentPane().add(addButton);

        modifyButton = new JButton("MODIFY");
        modifyButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        modifyButton.setBounds(878, 138, 156, 38);
        this.getContentPane().add(modifyButton);

        deleteButton = new JButton("DELETE");
        deleteButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        deleteButton.setBounds(878, 184, 156, 38);
        this.getContentPane().add(deleteButton);

        createButton = new JButton("CREATE");
        createButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        createButton.setBounds(878, 353, 156, 38);
        this.getContentPane().add(createButton);

        reportButton = new JButton("REPORT");
        reportButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        reportButton.setBounds(878, 706, 156, 38);
        this.getContentPane().add(reportButton);

        productsTable = new JTable();
        productsTable.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        this.tableScroll = new JScrollPane(this.productsTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        this.tableScroll.setBounds(40, 250, 807, 500);
        this.tableScroll.setViewportView(this.productsTable);
        this.getContentPane().add(this.tableScroll);

        // Afisare fereastra actuala
        // this.setVisible(true);
    }

    /**
     * Metoda de adaugare a unui listener pe butonul de adaugare
     *
     * @param actionListener actionListener
     */
    public void addAdaugareListener(ActionListener actionListener) {

        this.addButton.addActionListener(actionListener);
    }

    /**
     * Metoda de adaugare a unui listener pe butonul de modificare
     *
     * @param actionListener actionListener
     */
    public void addModificareListener(ActionListener actionListener) {

        this.modifyButton.addActionListener(actionListener);
    }

    /**
     * Metoda de adaugare a unui listener pe butonul de stergere
     *
     * @param actionListener actionListener
     */
    public void addStergereListener(ActionListener actionListener) {

        this.deleteButton.addActionListener(actionListener);
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
     * Metoda de adaugare a unui listener pe butonul de raport
     *
     * @param actionListener actionListener
     */
    public void addRaportListener(ActionListener actionListener) {

        this.reportButton.addActionListener(actionListener);
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
     * Metoda de get() pentru caseta titlu
     *
     * @return caseta titlu
     */
    public JTextField getTitleTextField() {
        return titleTextField;
    }

    /**
     * Metoda de get() pentru caseta rating
     *
     * @return caseta rating
     */
    public JTextField getRatingTextField() {
        return ratingTextField;
    }

    /**
     * Metoda de get() pentru caseta calorii
     *
     * @return caseta calorii
     */
    public JTextField getCaloriesTextField() {
        return caloriesTextField;
    }

    /**
     * Metoda de get() pentru caseta proteine
     *
     * @return caseta proteine
     */
    public JTextField getProteinTextField() {
        return proteinTextField;
    }

    /**
     * Metoda de get() pentru caseta grasimi
     *
     * @return caseta grasimi
     */
    public JTextField getFatTextField() {
        return fatTextField;
    }

    /**
     * Metoda de get() pentru caseta sodiu
     *
     * @return caseta sodiu
     */
    public JTextField getSodiumTextField() {
        return sodiumTextField;
    }

    /**
     * Metoda de get() pentru caseta pret
     *
     * @return caseta pret
     */
    public JTextField getPriceTextField() {
        return priceTextField;
    }

    /**
     * Metoda de get() pentru caseta meniu
     *
     * @return caseta meniu
     */
    public JTextField getMenuTextField() {
        return menuTextField;
    }

    /**
     * Metoda de get() pentru caseta raport
     *
     * @return caseta raport
     */
    public JTextField getReportTextField() {
        return reportTextField;
    }

    /**
     * Metoda de get() pentru caseta parametru1
     *
     * @return caseta caseta parametru1
     */
    public JTextField getParameter1TextField() {
        return parameter1TextField;
    }

    /**
     * Metoda de get() pentru caseta parametru2
     *
     * @return caseta caseta parametru2
     */
    public JTextField getParameter2TextField() {
        return parameter2TextField;
    }

}
