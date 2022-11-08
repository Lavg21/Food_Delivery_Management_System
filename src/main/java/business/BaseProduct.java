package business;

/**
 * Clasa care cotine atributele pentru BaseProduct
 */
public class BaseProduct extends MenuItem {

    private String title;
    private double rating;
    private double calories;
    private double protein;
    private double fat;
    private double sodium;
    private double price;

    /**
     * Constructor pentru clasa BaseProduct
     *
     * @param title numele produsului
     * @param price pretul produsului
     */
    public BaseProduct(String title, double price) {

        super(title, price);
    }

    /**
     * Constructor pentru clasa BaseProduct
     *
     * @param title    numele produsului
     * @param rating   rating-ul produsului
     * @param calories numarul de calorii ale produsului
     * @param protein  numarul de proteine ale produsului
     * @param fat      numarul de grasimi ale produsului
     * @param sodium   numarul de sodiu al produsului
     * @param price    pretul produsului
     */
    public BaseProduct(String title, double rating, double calories, double protein, double fat, double sodium, double price) {
        super(title, rating, calories, protein, fat, sodium, price);
        this.title = title;
        this.rating = rating;
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.sodium = sodium;
        this.price = price;
    }

    /**
     * Metoda pentru calcularea pretului pentru un BaseProduct
     *
     * @return pretul
     */
    @Override
    public double computePrice() {
        return super.getPrice();
    }

    /**
     * Metoda pentru afisarea atributelor unui BaseProduct
     *
     * @return string-ul care contine aceste atribute
     */
    @Override
    public String toString() {
        return "BaseProduct{" +
                "title='" + title + '\'' +
                ", rating=" + rating +
                ", calories=" + calories +
                ", protein=" + protein +
                ", fat=" + fat +
                ", sodium=" + sodium +
                ", price=" + price +
                '}';
    }
}
