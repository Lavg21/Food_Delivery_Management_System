package utils;

import business.MenuItem;

import java.util.Comparator;

/**
 * Clasa in care se vor compara doua produse
 */
public class MyComparator implements Comparator<MenuItem> {

    /**
     * Metoda de comparare a doua produse
     *
     * @param m1 parametrul1
     * @param m2 parametrul2
     * @return rezultatul comparatiei
     */
    @Override
    public int compare(MenuItem m1, MenuItem m2) {
        return (m1.getTitle()).compareTo(m2.getTitle());
    }
}