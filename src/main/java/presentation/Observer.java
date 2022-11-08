package presentation;

import business.Order;

/**
 * Interfata Observer
 */
public interface Observer {

    /**
     * Metoda update
     *
     * @param order parametrul dupa care se face update
     */
    void update(Order order);
}
