package presentation.controllers;

import business.BaseProduct;
import business.CompositeProduct;
import business.DeliveryService;
import business.MenuItem;
import presentation.views.AdministratorView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/**
 * Clasa care implementeaza logica din spatele butoanelor de pe interfata
 */
public class AdministratorController {

    private AdministratorView view;

    private DeliveryService deliveryService;

    /**
     * Constructor-ul clasei AdministratorController
     *
     * @param view            view-ul
     * @param deliveryService service-ul
     */
    public AdministratorController(AdministratorView view, DeliveryService deliveryService) {

        this.view = view;
        this.deliveryService = deliveryService;

        this.view.addCreareListener(new CreareListener());

        this.view.addAdaugareListener(new AdaugareListener());
        this.view.addStergereListener(new StergereListener());
        this.view.addModificareListener(new ModificareListener());

        this.view.addRaportListener(new RaportListener());

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
     * Clasa pentru implementarea logicii din spatele butonului de adaugare
     */
    class AdaugareListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {

                String title = view.getTitleTextField().getText();
                if (title.equals(""))
                    throw new Exception("Titlul nu poate fi vid!");

                String rating = view.getRatingTextField().getText();
                if (rating.equals(""))
                    throw new Exception("Rating-ul nu poate fi vid!");

                String calories = view.getCaloriesTextField().getText();
                if (calories.equals(""))
                    throw new Exception("Calories nu poate fi vid!");

                String protein = view.getProteinTextField().getText();
                if (protein.equals(""))
                    throw new Exception("Protein nu poate fi vid!");

                String fat = view.getFatTextField().getText();
                if (fat.equals(""))
                    throw new Exception("Fat nu poate fi vid!");

                String sodium = view.getSodiumTextField().getText();
                if (sodium.equals(""))
                    throw new Exception("Sodium nu poate fi vid!");

                String price = view.getPriceTextField().getText();
                if (price.equals(""))
                    throw new Exception("Pretul nu poate fi vid!");

                BaseProduct product = new BaseProduct(title, Double.parseDouble(rating), Double.parseDouble(calories), Double.parseDouble(protein), Double.parseDouble(fat), Double.parseDouble(sodium), Double.parseDouble(price));
                deliveryService.addProduct(product);

                JOptionPane.showMessageDialog(null, "Produs adaugat cu succes!");

                view.getProductsTable().clearSelection();

                loadTableData();
            } catch (Exception ex) {

                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }

    /**
     * Clasa pentru implementarea logicii din spatele butonului de stergere
     */
    class StergereListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {

                int selectedRow = view.getProductsTable().getSelectedRow();
                if (selectedRow == -1)
                    throw new Exception("Trebuie selectat un produs din tabel!");

                int i = 0;
                MenuItem delete = null;

                for (MenuItem item : deliveryService.getMenuItems()) {

                    if (i == selectedRow) {

                        delete = item;
                        break;
                    }

                    i++;
                }

                deliveryService.deleteProduct(delete);

                JOptionPane.showMessageDialog(null, "Produs sters cu succes!");

                view.getProductsTable().clearSelection();

                loadTableData();
            } catch (Exception ex) {

                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }

    /**
     * Clasa pentru implementarea logicii din spatele butonului de modificare
     */
    class ModificareListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {

                String title = view.getTitleTextField().getText();
                if (title.equals(""))
                    throw new Exception("Titlul nu poate fi vid!");

                String rating = view.getRatingTextField().getText();
                if (rating.equals(""))
                    throw new Exception("Rating-ul nu poate fi vid!");

                String calories = view.getCaloriesTextField().getText();
                if (calories.equals(""))
                    throw new Exception("Calories nu poate fi vid!");

                String protein = view.getProteinTextField().getText();
                if (protein.equals(""))
                    throw new Exception("Protein nu poate fi vid!");

                String fat = view.getFatTextField().getText();
                if (fat.equals(""))
                    throw new Exception("Fat nu poate fi vid!");

                String sodium = view.getSodiumTextField().getText();
                if (sodium.equals(""))
                    throw new Exception("Sodium nu poate fi vid!");

                String price = view.getPriceTextField().getText();
                if (price.equals(""))
                    throw new Exception("Pretul nu poate fi vid!");

                double ratingDouble = Double.parseDouble(rating);
                double caloriesDouble = Double.parseDouble(rating);
                double proteinDouble = Double.parseDouble(rating);
                double fatDouble = Double.parseDouble(rating);
                double sodiumDouble = Double.parseDouble(rating);
                double priceDouble = Double.parseDouble(price);

                int selectedRow = view.getProductsTable().getSelectedRow();
                if (selectedRow == -1)
                    throw new Exception("Trebuie selectat un produs din tabel!");

                int i = 0;
                MenuItem modify = null;

                for (MenuItem item : deliveryService.getMenuItems()) {

                    if (i == selectedRow) {

                        modify = item;
                        break;
                    }

                    i++;
                }

                deliveryService.modifyProduct(modify, new BaseProduct(title, ratingDouble, caloriesDouble, proteinDouble, fatDouble, sodiumDouble, priceDouble));

                JOptionPane.showMessageDialog(null, "Produs modificat cu succes!");

                view.getProductsTable().clearSelection();

                loadTableData();
            } catch (Exception ex) {

                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
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

                if (selectedRows.size() < 2) {

                    throw new Exception("Trebuie selectate macar 2 produse pentru un meniu!");
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

                MenuItem compositeMenu = new CompositeProduct(view.getMenuTextField().getText(), items);
                deliveryService.addProduct(compositeMenu);

                loadTableData();

                JOptionPane.showMessageDialog(null, "Meniu adaugat cu succes!");

                view.getProductsTable().clearSelection();
            } catch (Exception ex) {

                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }

    /**
     * Clasa pentru implementarea logicii din spatele butonului de report
     */
    class RaportListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {

                String type = view.getReportTextField().getText();
                if (type.equals(""))
                    throw new Exception("Trebuie introdus un tip pentru raport!");

                String param1 = view.getParameter1TextField().getText();
                String param2 = view.getParameter2TextField().getText();

                deliveryService.handleReport(type, param1, param2);

                JOptionPane.showMessageDialog(null, "Raport generat!");

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }
}
