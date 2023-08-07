import java.io.*;
public class ObjectSerializationDemo implements Serializable {

    private int id = 1;

    public byte[] serialize() throws IOException { ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(this);
        return baos.toByteArray();
    };
}
