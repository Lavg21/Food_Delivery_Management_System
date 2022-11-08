package business;

import java.io.Serializable;

/**
 * Clasa pentru atributele unui user
 */
public class User implements Serializable {

    private int id;

    private String username;
    private String password;
    private String type;

    /**
     * Constructor pentru clasa User
     *
     * @param id       ID-ul
     * @param username username
     * @param password parola
     * @param type     tip (Client, Angajat, Administrator)
     */
    public User(int id, String username, String password, String type) {

        this.id = id;
        this.username = username;
        this.password = password;
        this.type = type;
    }

    /**
     * Meotda de get() pentru ID
     *
     * @return ID-ul
     */
    public int getId() {

        return id;
    }

    /**
     * Meotda de set() pentru ID
     *
     * @param id ID-ul
     */
    public void setId(int id) {

        this.id = id;
    }

    /**
     * Meotda de get() pentru username
     *
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Meotda de set() pentru ID
     *
     * @param username username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Meotda de get() pentru parola
     *
     * @return parola
     */
    public String getPassword() {
        return password;
    }

    /**
     * Meotda de get() pentru tip
     *
     * @return tipul
     */
    public String getType() {
        return type;
    }

    /**
     * Metoda de toString()
     *
     * @return string-ul care contine atributele unui user
     */
    @Override
    public String toString() {

        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
