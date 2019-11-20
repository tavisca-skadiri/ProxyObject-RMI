package socketprogramming.server3;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.Socket;

public class Server3 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Socket s = new Socket("localhost", 4444);
        DataOutputStream dataOutputStream = new DataOutputStream(s.getOutputStream());
        dataOutputStream.writeUTF("Server");
        dataOutputStream.writeUTF("S3");
        ObjectOutputStream oout = new ObjectOutputStream(dataOutputStream);
        oout.writeObject(new P3());
        oout.close();
    }
}
