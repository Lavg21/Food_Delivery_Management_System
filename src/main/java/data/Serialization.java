package data;
import business.User;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Serialization {

    public void serializare(Map<String, User> users) throws Exception
    {
        FileOutputStream fileOutputStream
                = new FileOutputStream("out.txt");
        ObjectOutputStream objectOutputStream
                = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(users);
        objectOutputStream.flush();
        objectOutputStream.close();
    }

    public Map<String, User> deserializare() throws Exception, ClassNotFoundException
    {
        Map<String, User> users = new HashMap<>();
        try {
            FileInputStream fileInputStream
                    = new FileInputStream("out.txt");
            ObjectInputStream objectInputStream
                    = new ObjectInputStream(fileInputStream);
            users = (Map<String, User>) objectInputStream.readObject();
            objectInputStream.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }catch(ClassNotFoundException exception){
            exception.printStackTrace();
        }
        return users;
    }
}
