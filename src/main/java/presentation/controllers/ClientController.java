package presentation.controllers;

import business.DeliveryService;
import business.MenuItem;
import business.User;
import data.MyFileWriter;
import presentation.views.ClientView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Clasa care implementeaza logica din spatele butoanelor de pe interfata
 */
public class ClientController {

    private ClientView view;

    private DeliveryService deliveryService;

    /**
     * Constructor pentru clasa ClientController
     *
     * @param view            view-ul
     * @param deliveryService service-ul
     */
    public ClientController(ClientView view, DeliveryService deliveryService) {

        this.view = view;
        this.deliveryService = deliveryService;

        this.view.addCreareListener(new CreareListener());

        this.view.addCautareListener(new CautareListener());

        this.loadTableData();
    }

    /**
     * Metoda de punere a datelor in tabel
     */
    private void loadTableData() {

        DefaultTableModel tableModel = new DefaultTableModel();

        Collection<MenuItem> items = this.deliveryService.getMenuItems();

        tableModel.addColumn("Title");
        tableModel.addColumn("Rating");
        tableModel.addColumn("Calories");
        tableModel.addColumn("Protein");
        tableModel.addColumn("Fat");
        tableModel.addColumn("Sodium");
        tableModel.addColumn("Price");

        for (MenuItem item : items) {

            List<String> values = new ArrayList<>();

            values.add(item.getTitle());
            values.add(String.valueOf(item.getRating()));
            values.add(String.valueOf(item.getCalories()));
            values.add(String.valueOf(item.getProtein()));
            values.add(String.valueOf(item.getFat()));
            values.add(String.valueOf(item.getSodium()));
            values.add(String.valueOf(item.getPrice()));

            tableModel.addRow(values.toArray());
        }

        this.view.getProductsTable().setModel(tableModel);
    }

    /**
     * Metoda de punere a datelor in tabel
     *
     * @param items produse din meniu
     */
    private void loadTableData(List<MenuItem> items) {

        DefaultTableModel tableModel = new DefaultTableModel();

        tableModel.addColumn("Title");
        tableModel.addColumn("Rating");
        tableModel.addColumn("Calories");
        tableModel.addColumn("Protein");
        tableModel.addColumn("Fat");
        tableModel.addColumn("Sodium");
        tableModel.addColumn("Price");

        for (MenuItem item : items) {

            List<String> values = new ArrayList<>();

            values.add(item.getTitle());
            values.add(String.valueOf(item.getRating()));
            values.add(String.valueOf(item.getCalories()));
            values.add(String.valueOf(item.getProtein()));
            values.add(String.valueOf(item.getFat()));
            values.add(String.valueOf(item.getSodium()));
            values.add(String.valueOf(item.getPrice()));

            tableModel.addRow(values.toArray());
        }

        this.view.getProductsTable().setModel(tableModel);
    }

    /**
     * Clasa pentru implementarea logicii din spatele butonului de creare
     */
    class CreareListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {

                List<Integer> selectedRows = new ArrayList<>();

                for (int row : view.getProductsTable().getSelectedRows()) {

                    selectedRows.add(row);
                }

                int i = 0, added = 0;

                List<MenuItem> items = new ArrayList<>();
                for (MenuItem item : deliveryService.getMenuItems()) {

                    if (selectedRows.contains(i)) {

                        items.add(item);
                        added++;

                        if (added == selectedRows.size())
                            break;
                    }

                    i++;
                }

                if (view.getOrderTextField().getText().equals(""))
                    throw new Exception("Nu s-a introdus un ID pentru comanda!");

                int id = Integer.parseInt(view.getOrderTextField().getText());

                User client = view.getLoggedInClient();
                deliveryService.createOrder(id, client.getId(), LocalDateTime.now(), items);

                String fileName = "order" + id + ".txt";
                String content = "ID: " + id + "\nClient ID: " + client.getId() + "\nDate Order: " + LocalDateTime.now() + "\nItems: " + items;
                MyFileWriter.writeToFile(content, fileName);

                view.getProductsTable().clearSelection();

                JOptionPane.showMessageDialog(null, "Comanda a fost creata cu succes!");
            } catch (Exception ex) {

                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }

    }

    /**
     * Clasa pentru implementarea logicii din spatele butonului de cautare
     */
    class CautareListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {

                String criteria = view.getCriteriaTextField().getText();
                if (criteria.equals(""))
                    throw new Exception("Treubie introdus un criteriu de cautare!");

                String keyword = view.getKeyTextField().getText();
                if (keyword.equals(""))
                    throw new Exception("Trebuie introdus o cheie pentru cautare!");

                List<MenuItem> items = deliveryService.handleFilter(criteria, keyword);
                loadTableData(items);
            } catch (Exception ex) {

                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }
}
