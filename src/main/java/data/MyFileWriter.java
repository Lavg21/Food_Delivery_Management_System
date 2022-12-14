package data;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Clasa in care se va crea fisierul in care trebuie scris un raport/comanda
 */
public class MyFileWriter {

    /**
     * Metoda in care se va scrie in fisier fiecare comanda adaugata
     *
     * @param content ce trebuie scris in fisier
     * @param file    fisierul in care trebuie scris
     */
    public static void writeToFile(String content, String file) {

        try {

            String filePath = "D:\\Facultate\\UTCN\\An II\\Semestrul 2\\Tehnici de programare\\Laboratoare\\PT2022_30228_Gavrilescu_AndreeaLavinia_4\\src\\main\\resources\\orders\\" + file;
            BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
            bw.write(content);
            bw.close();
        } catch (IOException ex) {

            ex.printStackTrace();
        }
    }
}
