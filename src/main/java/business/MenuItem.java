package business;

/**
 * Clasa care cotine atributele pentru MenuItem
 */
public abstract class MenuItem {

    private String title;
    private double rating;
    private double calories;
    private double protein;
    private double fat;
    private double sodium;
    private double price;

    /**
     * Constructor pentru clasa MenuItem
     *
     * @param title numele produsului
     * @param price pretul produsului
     */
    public MenuItem(String title, double price) {
        this.title = title;
        this.price = price;
    }

    /**
     * Constructor pentru clasa MenuItem
     *
     * @param title    numele produsului
     * @param rating   rating-ul produsului
     * @param calories numarul de calorii ale produsului
     * @param protein  numarul de proteine ale produsului
     * @param fat      numarul de grasimi ale produsului
     * @param sodium   numarul de sodiu al produsului
     * @param price    pretul produsului
     */
    public MenuItem(String title, double rating, double calories, double protein, double fat, double sodium, double price) {
        this.title = title;
        this.rating = rating;
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.sodium = sodium;
        this.price = price;
    }

    /**
     * Metoda de get() pentru rating
     *
     * @return rating-ul
     */
    public double getRating() {
        return rating;
    }

    /**
     * Metoda de set() pentru rating
     *
     * @param rating rating-ul
     */
    public void setRating(double rating) {
        this.rating = rating;
    }

    /**
     * Metoda de get() pentru calorii
     *
     * @return rating-ul
     */
    public double getCalories() {
        return calories;
    }

    /**
     * Metoda de set() pentru numarul de calorii
     *
     * @param calories numarul de calorii
     */
    public void setCalories(double calories) {
        this.calories = calories;
    }

    /**
     * Metoda de get() pentru numarul de proteine
     *
     * @return numarul de proteine
     */
    public double getProtein() {
        return protein;
    }

    /**
     * Metoda de set() pentru numarul de proteine
     *
     * @param protein numarul de proteine
     */
    public void setProtein(double protein) {
        this.protein = protein;
    }

    /**
     * Metoda de get() pentru numarul de grasimi
     *
     * @return numarul de grasimi
     */
    public double getFat() {
        return fat;
    }

    /**
     * Metoda de set() pentru numarul de grasimi
     *
     * @param fat numarul de grasimi
     */
    public void setFat(double fat) {
        this.fat = fat;
    }

    /**
     * Metoda de get() pentru sodiu
     *
     * @return numarul de sodiu
     */
    public double getSodium() {
        return sodium;
    }

    /**
     * Metoda de set() pentru numarul de sodiu
     *
     * @param sodium numarul de sodiu
     */
    public void setSodium(double sodium) {
        this.sodium = sodium;
    }

    /**
     * Metoda de get() pentru numele produsului
     *
     * @return numele produsului
     */
    public String getTitle() {
        return title;
    }

    /**
     * Metoda de set() pentru numele produsului
     *
     * @param title numele produsului
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Metoda de get() pentru pretul produsului
     *
     * @return pretul produsului
     */
    public double getPrice() {
        return price;
    }

    /**
     * Metoda de set() pentru pretul produsului
     *
     * @param price pretul produsului
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Metoda abstracta de calculare a pretului
     *
     * @return pretul
     */
    public abstract double computePrice();

    /**
     * Metoda de verificare a titlului
     *
     * @param obj obiectul dupa al carui titlu verificam
     * @return true sau false in functie de caz
     */
    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof MenuItem))
            return false;

        else {
            MenuItem item = (MenuItem) obj;
            return item.title.equals(this.title);
        }
    }
}
