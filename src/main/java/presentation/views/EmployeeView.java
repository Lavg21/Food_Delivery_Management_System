package presentation.views;

import javax.swing.*;
import java.awt.*;

/**
 * Clasa care implementeaza interfata pentru angajat
 */
public class EmployeeView extends JFrame {

    private JLabel titleLabel;
    private JTextArea orderTextArea;

    /**
     * Constructor pentru clasa EmployeeView
     */
    public EmployeeView() {

        this.setBounds(100, 100, 551, 550);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        titleLabel = new JLabel("EMPLOYEE MENU");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        titleLabel.setBounds(121, 37, 313, 46);
        this.getContentPane().add(titleLabel);

        orderTextArea = new JTextArea();
        orderTextArea.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        orderTextArea.setBounds(72, 119, 397, 366);
        orderTextArea.setEditable(false);
        this.getContentPane().add(orderTextArea);

        // Afisare fereastra actuala
        // this.setVisible(true);
    }

    /**
     * Metoda de get() pentru caseta text
     *
     * @return caseta text
     */
    public JTextArea getOrderTextArea() {

        return orderTextArea;
    }
}
