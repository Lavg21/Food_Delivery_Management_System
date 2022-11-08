package business;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Collection;

/**
 * Interfata pentru unele operatii din clasa DeliveryService
 */
public interface IDeliveryServiceProcessing {

    // Operatii Administrator:

    /**
     * Metoda de importare a produselor din fisier
     *
     * @throws IOException exceptie
     */
    void importProducts() throws IOException;

    /**
     * Metoda de adaugare a unui produs
     *
     * @param product produsul care trebuie adaugat
     */
    void addProduct(MenuItem product);

    /**
     * Metoda de stergere a unui produs
     *
     * @param product produsul care trebuie sters
     */
    void deleteProduct(MenuItem product);

    /**
     * Metoda de modificare a unui produs
     *
     * @param oldItem vechiul produs
     * @param newItem noul produs
     */
    void modifyProduct(MenuItem oldItem, MenuItem newItem);

    // Operatii Client:

    /**
     * Metoda de creare a unei comenzi
     *
     * @param orderID   ID-ul comenzii
     * @param clientID  ID-ul clientului
     * @param orderDate data comenzii
     * @param items     produsele continute de comanda
     */
    void createOrder(int orderID, int clientID, LocalDateTime orderDate, Collection<MenuItem> items);

    MenuItem searchProducts(String title);
}
