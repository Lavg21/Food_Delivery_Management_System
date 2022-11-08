package business;

import java.util.Collection;

/**
 * Clasa care cotine atributele pentru CompositeProduct
 */
public class CompositeProduct extends MenuItem {

    private String title;
    private double price;
    private Collection<MenuItem> menuItems;

    /**
     * Constructor pentru clasa CompositeProduct
     *
     * @param title numele produsului
     * @param items pretul produsului
     */
    public CompositeProduct(String title, Collection<MenuItem> items) {

        super(title, 0);
        this.title = title;
        this.menuItems = items;
        this.price = computePrice();
    }

    /**
     * Metoda de calculare a pretului unui CompositeProduct
     *
     * @return pretul
     */
    @Override
    public double computePrice() {

        double total = 0;

        for (MenuItem m : menuItems) {

            total += m.getPrice();
        }

        super.setPrice(total);

        return total;
    }

    /**
     * Metoda de get() pentru numele produsului
     *
     * @return titlul
     */
    @Override
    public String getTitle() {
        return title;
    }

    /**
     * Metoda de set() pentru numele produsului
     *
     * @param title numele produsului
     */
    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Metoda de get() pentru pretul produsului
     *
     * @return pretul
     */
    @Override
    public double getPrice() {
        return price;
    }

    /**
     * Metoda de set() pentru pretul produsului
     *
     * @param price pretul
     */
    @Override
    public void setPrice(double price) {
        this.price = price;
    }
}
