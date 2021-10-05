import java.io.*;
public class ObjectDeserializationDemo {

    public Object deserialize(byte[] data) throws IOException, ClassNotFoundException { ByteArrayInputStream bais = new ByteArrayInputStream(data);
        ObjectInputStream ois = new ObjectInputStream(bais);
        return ois.readObject();
    };
}
