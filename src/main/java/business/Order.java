package business;

import java.time.LocalDateTime;

/**
 * Clasa pentru atributele unei comenzi
 */
public class Order {

    private int orderID;
    private int clientID;
    private LocalDateTime orderDate;
    private double price;

    /**
     * Constructor pentru clasa Order
     *
     * @param orderID   ID-ul comenzii
     * @param clientID  ID-ul clientului
     * @param orderDate data comenzii
     */
    public Order(int orderID, int clientID, LocalDateTime orderDate) {
        this.orderID = orderID;
        this.clientID = clientID;
        this.orderDate = orderDate;
    }

    /**
     * Metoda hashCode()
     *
     * @return hashcode
     */
    @Override
    public int hashCode() {

        return Integer.hashCode(this.orderID);
    }

    /**
     * Metode de get() pentru orderID
     *
     * @return orderID
     */
    public int getOrderID() {
        return orderID;
    }

    /**
     * Metode de set() pentru orderID
     *
     * @param orderID orderID
     */
    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    /**
     * Metode de set() pentru clientID
     *
     * @return clientID
     */
    public int getClientID() {
        return clientID;
    }

    /**
     * Metode de get() pentru orderDate
     *
     * @return orderDate
     */
    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    /**
     * Metoda de toString()
     *
     * @return string-ul care contine atributele comenzii
     */
    @Override
    public String toString() {

        return "Order{" +
                "orderID=" + orderID +
                ", clientID=" + clientID +
                ", orderDate=" + orderDate +
                ", price=" + price +
                '}';
    }

    /**
     * Metoda de set() a pretului
     *
     * @param price pretul
     */
    public void setPrice(double price) {

        this.price = price;
    }

    /**
     * Metoda de get() a pretului
     *
     * @return pretul
     */
    public double getPrice() {
        return price;
    }

    /**
     * Metoda de equals()
     *
     * @param o obiectul
     * @return true sau false
     */
    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderID == order.orderID;
    }

}
