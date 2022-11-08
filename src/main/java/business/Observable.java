package business;

import presentation.Observer;

/**
 * Interfara pentru observator
 */
public interface Observable {

    /**
     * Metoda de adaugare a unui observator
     *
     * @param o observatorul care trebuie adaugat
     */
    void addObserver(Observer o);

    /**
     * Metoda de stergere a unui observator
     *
     * @param o observatorul care trebuie sters
     */
    void removeObserver(Observer o);

    /**
     * Metoda de notificare a unui observator
     *
     * @param order comanda in functie de care se trimit notificari
     */
    void notifyObservers(Order order);
}
