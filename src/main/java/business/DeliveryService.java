package business;

import data.MyFileWriter;
import data.Serialization;
import presentation.Observer;
import utils.MyComparator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Clasa care implementeaza logica din spatele operatiilor de pe interfata
 */
public class DeliveryService implements Observable, IDeliveryServiceProcessing {

    private List<Observer> observers;

    private Map<Order, Collection<MenuItem>> orders;

    private Collection<MenuItem> menuItems;

    private Map<String, User> users;
    private Serialization serialization;

    /**
     * Constructor pentru clasa DeliveryService
     */
    public DeliveryService() throws Exception {

        this.observers = new ArrayList<>();
        this.orders = new HashMap<>();
        this.menuItems = new TreeSet<>(new MyComparator());

        this.users = new HashMap<>();

        serialization = new Serialization();
        serialization.serializare(users);
        this.users = serialization.deserializare();
    }

    /**
     * Metoda de creare a unor comenzi
     */
    public void generateOrders() {

        // convertim din set in lista pentru a putea accesa elemente de pe index
        List<MenuItem> menuItemList = new ArrayList<>();

        for (MenuItem i : this.menuItems)
            menuItemList.add(i);

        List<MenuItem> l1 = new ArrayList<>();
        l1.add(menuItemList.get(0));
        l1.add(menuItemList.get(1));
        l1.add(menuItemList.get(2));
        this.createOrder(1, 2, LocalDateTime.of(2022, 1, 20, 17, 5), l1);

        List<MenuItem> l2 = new ArrayList<>();
        l2.add(menuItemList.get(1));
        l2.add(menuItemList.get(3));
        this.createOrder(2, 2, LocalDateTime.of(2022, 3, 25, 19, 13), l2);


        List<MenuItem> l3 = new ArrayList<>();
        l3.add(menuItemList.get(1));
        l3.add(menuItemList.get(3));
        l3.add(menuItemList.get(5));
        this.createOrder(3, 2, LocalDateTime.of(2022, 4, 25, 23, 29), l3);

        List<MenuItem> l4 = new ArrayList<>();
        l4.add(menuItemList.get(1));
        l4.add(menuItemList.get(3));
        l4.add(menuItemList.get(4));
        this.createOrder(4, 4, LocalDateTime.of(2022, 4, 4, 10, 10), l4);
    }

    /**
     * Metoda care importa informatiile despre produse din fisier
     *
     * @throws IOException exceptie
     */
    @Override
    public void importProducts() throws IOException {

        BufferedReader csvReader = new BufferedReader(new FileReader("D:\\Facultate\\UTCN\\An II\\Semestrul 2\\Tehnici de programare\\Laboratoare\\PT2022_30228_Gavrilescu_AndreeaLavinia_4\\src\\main\\resources\\products.csv"));
        String row;

        row = csvReader.readLine();

        while ((row = csvReader.readLine()) != null) {

            String[] data = row.split(",");

            String title;
            double rating, calories, protein, fat, sodium, price;
            title = data[0].strip();
            rating = Double.parseDouble(data[1]);
            calories = Double.parseDouble(data[2]);
            protein = Double.parseDouble(data[3]);
            fat = Double.parseDouble(data[4]);
            sodium = Double.parseDouble(data[5]);
            price = Double.parseDouble(data[6]);

            MenuItem item = new BaseProduct(title, rating, calories, protein, fat, sodium, price);

            menuItems.add(item);
        }

        csvReader.close();
    }

    /**
     * Metoda de adaugare a unui produs
     *
     * @param product produsul care trebuie adaugat
     */
    @Override
    public void addProduct(MenuItem product) {

        if (!menuItems.contains(product)) // daca produsul nu exista deja
            menuItems.add(product);
    }

    /**
     * Metoda de stergere a unui produs
     *
     * @param product produsul care trebuie sters
     */
    @Override
    public void deleteProduct(MenuItem product) {

        for (MenuItem m : menuItems) {
            if (m.getTitle().equals(product.getTitle())) {
                // identificam produsul de sters
                menuItems.remove(m);
                return;
            }
        }
    }

    /**
     * Metoda de modificare a unui produs
     *
     * @param oldItem vechiul produs
     * @param newItem noul produs
     */
    @Override
    public void modifyProduct(MenuItem oldItem, MenuItem newItem) {

        // Reactualizam datele
        oldItem.setTitle(newItem.getTitle());
        oldItem.setRating(newItem.getRating());
        oldItem.setCalories(newItem.getCalories());
        oldItem.setProtein(newItem.getProtein());
        oldItem.setFat(newItem.getFat());
        oldItem.setSodium(newItem.getSodium());
        oldItem.setPrice(newItem.getPrice());
    }

    /**
     * Metoda de creare a unei comenzi
     *
     * @param orderID   ID-ul comenzii
     * @param clientID  ID-ul clientului
     * @param orderDate data comenzii
     * @param items     produsele continute de comanda
     */
    @Override
    public void createOrder(int orderID, int clientID, LocalDateTime orderDate, Collection<MenuItem> items) {

        Order order = new Order(orderID, clientID, orderDate); // cream o comanda

        double price = 0; // intial pretul e 0

        for (MenuItem i : items) {

            price += i.getPrice(); // calculam pretul total al comenzii
        }

        order.setPrice(price); // setam pretul comenzii

        orders.put(order, items); // punem comanda in lista de comenzi

        this.notifyObservers(order); // trimitem o notificare catre angajati
    }

    /**
     * Metoda de cautare a unui produs dupa titlu
     *
     * @param title titlul pe care il cautam
     * @return produsele corespunzatoare cautarii
     */
    @Override
    public MenuItem searchProducts(String title) {

        for (MenuItem m : menuItems) {
            if (m.getTitle().equals(title)) // cautare dupa nume
                return m;
        }
        return null;
    }

    /**
     * Metoda de adaugare a unui observator
     *
     * @param o observatorul care trebuie adaugat
     */
    @Override
    public void addObserver(Observer o) {

        this.observers.add(o);
    }

    /**
     * Metoda de stergere a unui observator
     *
     * @param o observatorul care trebuie sters
     */
    @Override
    public void removeObserver(Observer o) {

        this.observers.remove(o);
    }

    /**
     * Metoda de notificare a tuturor observatorilor
     *
     * @param order comanda in functie de care se vor trimite notificari
     */
    @Override
    public void notifyObservers(Order order) {

        for (Observer o : this.observers)
            o.update(order);
    }

    /**
     * Metoda de get() pentru obtinerea produselor din meniu
     *
     * @return produsele din meniu
     */
    public Collection<MenuItem> getMenuItems() {

        return menuItems;
    }

    /**
     * Metoda de get() pentru obtinerea produselor din comenzilor
     *
     * @return comenzile
     */
    public Map<Order, Collection<MenuItem>> getOrders() {

        return orders;
    }

    /**
     * Metoda de set() pentru comenzi
     *
     * @param orders comenzile
     */
    public void setOrders(Map<Order, Collection<MenuItem>> orders) {

        this.orders = orders;
    }

    /**
     * Metoda de filtrare dupa titlu
     *
     * @param keyword titlul dupa care se va face filtrarea
     * @return lista de produse corespunzatoare
     */
    private List<MenuItem> filterByTitle(String keyword) {

        return this.menuItems
                .stream()
                .filter(item -> item.getTitle().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());  // collects the result of the filter into a List<MenuItem>
    }

    private List<MenuItem> filterByRating(String keyword) {

        try {

            double rating = Double.parseDouble(keyword);

            return this.menuItems
                    .stream()
                    .filter(item -> item.getRating() == rating)
                    .collect(Collectors.toList());
        } catch (NumberFormatException ex) {

            return null;
        }
    }

    /**
     * Metoda de filtrare dupa numarul de calorii
     *
     * @param keyword numarul de calorii dupa care se va face filtrarea
     * @return lista de produse corespunzatoare
     */
    private List<MenuItem> filterByCalories(String keyword) {

        try {

            double calories = Double.parseDouble(keyword);

            return this.menuItems
                    .stream()
                    .filter(item -> item.getCalories() == calories)
                    .collect(Collectors.toList());
        } catch (NumberFormatException ex) {

            return null;
        }
    }

    /**
     * Metoda de filtrare dupa numarul de proteine
     *
     * @param keyword numarul de proteine dupa care se va face filtrarea
     * @return lista de produse corespunzatoare
     */
    private List<MenuItem> filterByProteins(String keyword) {

        try {

            double proteins = Double.parseDouble(keyword);

            return this.menuItems
                    .stream()
                    .filter(item -> item.getProtein() == proteins)
                    .collect(Collectors.toList());
        } catch (NumberFormatException ex) {

            return null;
        }
    }

    /**
     * Metoda de filtrare dupa numarul de grasimi
     *
     * @param keyword numarul de grasimi dupa care se va face filtrarea
     * @return lista de produse corespunzatoare
     */
    private List<MenuItem> filterByFats(String keyword) {

        try {

            double fats = Double.parseDouble(keyword);

            return this.menuItems
                    .stream()
                    .filter(item -> item.getFat() == fats)
                    .collect(Collectors.toList());
        } catch (NumberFormatException ex) {

            return null;
        }
    }

    /**
     * Metoda de filtrare dupa numarul de sodiu
     *
     * @param keyword numarul de sodiu dupa care se va face filtrarea
     * @return lista de produse corespunzatoare
     */
    private List<MenuItem> filterBySodium(String keyword) {

        try {

            double sodium = Double.parseDouble(keyword);

            return this.menuItems
                    .stream()
                    .filter(item -> item.getSodium() == sodium)
                    .collect(Collectors.toList());
        } catch (NumberFormatException ex) {

            return null;
        }
    }

    /**
     * Metoda de filtrare dupa pret
     *
     * @param keyword pretul dupa care se va face filtrarea
     * @return lista de produse corespunzatoare
     */
    private List<MenuItem> filterByPrice(String keyword) {

        try {

            double price = Double.parseDouble(keyword);

            return this.menuItems
                    .stream()
                    .filter(item -> item.getPrice() == price)
                    .collect(Collectors.toList());
        } catch (NumberFormatException ex) {

            return null;
        }
    }

    /**
     * Metoda care verifica ce criteriu trebuie folosit in functie de numarul acestuia
     *
     * @param criteria numarul criteriul
     * @param keyword  parametrul dupa care se face filtrarea
     * @return lista de produse corespunatoare criteriului dat ca parametru
     */
    public List<MenuItem> handleFilter(String criteria, String keyword) {

        if (criteria.equals("1")) {

            // 1 = title

            return this.filterByTitle(keyword);
        } else if (criteria.equals("2")) {

            // 2 = rating

            return this.filterByRating(keyword);
        } else if (criteria.equals("3")) {

            // 3 = calories

            return this.filterByCalories(keyword);
        } else if (criteria.equals("4")) {

            // 4 = proteins

            return this.filterByProteins(keyword);
        } else if (criteria.equals("5")) {

            // 5 = fats

            return this.filterByFats(keyword);
        } else if (criteria.equals("6")) {

            // 6 = sodium

            return this.filterBySodium(keyword);
        } else if (criteria.equals("7")) {

            // 7 = price

            return this.filterByPrice(keyword);
        } else
            return null;
    }

    /**
     * Metoda care ofera un raport al comenzilor in functie de un interval orar
     *
     * @param start ora de inceput
     * @param end   ora de sfarsit
     */
    private void timeReport(String start, String end) {

        try {

            int startHour = Integer.parseInt(start);
            int endHour = Integer.parseInt(end);

            List<Order> result = this.orders
                    .keySet()
                    .stream()
                    .filter(order -> (order.getOrderDate().getHour() >= startHour && order.getOrderDate().getHour() <= endHour))
                    .collect(Collectors.toList());

            String content = "";
            for (Order o : result)
                content += o.toString() + "\n";

            MyFileWriter.writeToFile(content, "report.txt");
        } catch (NumberFormatException ex) {

            return;
        }
    }

    /**
     * Metoda care verifica de cate ori a fost comandat un produs
     *
     * @param param1 numele produsului pentru verificare
     */
    private void numberOrderedReport(String param1) {

        try {

            int number = Integer.parseInt(param1);

            Map<MenuItem, Integer> orderMap = new HashMap<>();

            for (Order o : this.orders.keySet()) {

                for (MenuItem i : this.orders.get(o)) {

                    if (orderMap.containsKey(i))
                        orderMap.put(i, orderMap.get(i) + 1);

                    else
                        orderMap.put(i, 1);
                }
            }

            String content = "Items:\n";
            for (MenuItem i : orderMap.keySet()) {

                if (orderMap.get(i) > number)
                    content += i.toString() + "\n";
            }

            MyFileWriter.writeToFile(content, "report.txt");
        } catch (NumberFormatException ex) {

            return;
        }
    }

    /**
     * Metoda care scrie in fisier cati clienti au avut o coamnda cu pret mai mare decat o valoare data ca parametru
     *
     * @param param1 numarul de comenzi
     * @param param2 valoarea
     */
    private void clientsReport(String param1, String param2) {

        try {

            int numberOfOrders = Integer.parseInt(param1);
            int valueAmount = Integer.parseInt(param2);

            List<Order> orders = this.orders
                    .keySet()
                    .stream()
                    .filter(order -> order.getPrice() > valueAmount)
                    .collect(Collectors.toList());

            Map<Integer, Integer> mapClientsOrders = new HashMap<>();
            for (Order o : orders) {

                if (mapClientsOrders.containsKey(o.getClientID()))
                    mapClientsOrders.put(o.getClientID(), mapClientsOrders.get(o.getClientID()) + 1);

                else
                    mapClientsOrders.put(o.getClientID(), 1);
            }

            String content = "IDs:\n";
            for (Integer id : mapClientsOrders.keySet())
                if (mapClientsOrders.get(id) > numberOfOrders)
                    content += String.valueOf(id) + "\n";


            MyFileWriter.writeToFile(content, "report.txt");
        } catch (NumberFormatException ex) {

            return;
        }
    }

    /**
     * Metoda care scrie in fisier cate produse au fost comandate intr-o zi
     *
     * @param param1 ziua data ca parametru
     */
    private void dayReport(String param1) {

        try {

            int day = Integer.parseInt(param1);

            Map<MenuItem, Integer> orderMap = new HashMap<>();

            for (Order o : this.orders.keySet()) {

                if (o.getOrderDate().getDayOfMonth() == day) {

                    for (MenuItem i : this.orders.get(o)) {

                        if (orderMap.containsKey(i))
                            orderMap.put(i, orderMap.get(i) + 1);

                        else
                            orderMap.put(i, 1);
                    }
                }
            }

            String content = "Items and Times Ordered:\n";
            for (MenuItem i : orderMap.keySet()) {

                content += i.toString() + "\nOrdered: " + orderMap.get(i) + " times\n";
            }

            MyFileWriter.writeToFile(content, "report.txt");
        } catch (NumberFormatException ex) {

            return;
        }
    }

    /**
     * Metoda care verifica ce raport trebuie facut in functie de numarul acestuia
     *
     * @param type   numarul raportului
     * @param param1 primul paramaetru
     * @param param2 al doilea parametru
     */
    public void handleReport(String type, String param1, String param2) {

        if (type.equals("1")) {

            // time interval of the orders
            // – a report should be generated with the orders performed
            // between a given start hour and a given end hour regardless the date

            this.timeReport(param1, param2);
        } else if (type.equals("2")) {

            // the products ordered more than a specified number of times so far

            this.numberOrderedReport(param1);
        } else if (type.equals("3")) {

            // the clients that have ordered more than a specified number of times so far
            // and the value of the order was higher than a specified amount.

            this.clientsReport(param1, param2);
        } else if (type.equals("4")) {

            // the products ordered within a specified day with the number of times they have been ordered

            this.dayReport(param1);
        } else
            return;
    }
}
