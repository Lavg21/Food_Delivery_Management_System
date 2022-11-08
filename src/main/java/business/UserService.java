package business;

import data.Serialization;

import java.util.HashMap;
import java.util.Map;

/**
 * Clasa pentru implementarea logica din spatele operatiilor de pe interfata
 */
public class UserService {

    private Map<String, User> users;

    private Serialization serialization;

    /**
     * Constructor pentru clasa UserService()
     */
    public UserService() throws Exception {

        User u1 = new User(1, "admin", "admin", "administrator");
        User u2 = new User(2, "ion", "ion", "client");
        User u3 = new User(3, "angajat", "angajat", "employee");
        User u4 = new User(4, "alin", "alin", "client");

        this.users = new HashMap<>();

        users.put(u1.getUsername(), u1);
        users.put(u2.getUsername(), u2);
        users.put(u3.getUsername(), u3);
        users.put(u4.getUsername(), u4);

        serialization = new Serialization();
        serialization.serializare(users);
    }

    /**
     * Metoda de get() pentru users
     *
     * @return users
     */
    public Map<String, User> getUsers() {

        return users;
    }

    /**
     * Metoda de adaugare a unui user
     *
     * @param user user-ul care trebuie adaugat
     */
    public void addUser(User user) throws Exception {

        this.users.put(user.getUsername(), user);
        serialization.serializare(users);
    }

    /**
     * Metoda de verificare a credentialelor
     *
     * @param username username
     * @param password parola
     * @return user-ul
     * @throws Exception exceptie
     */
    public User checkCredentials(String username, String password) throws Exception {

        this.users = serialization.deserializare();

        if (!this.users.containsKey(username))
            throw new Exception("Nu exista un utilizator cu acest username!");

        else {
            User user = this.users.get(username);

            if (!user.getPassword().equals(password))
                throw new Exception("Parola gresita!");

            return user;
        }
    }
}
