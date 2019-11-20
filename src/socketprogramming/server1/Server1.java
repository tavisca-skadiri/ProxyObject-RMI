package socketprogramming.server1;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.Socket;

public class Server1 {
    public static void main(String[] args) throws IOException, NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Socket s = new Socket("localhost", 4444);
        DataOutputStream dataOutputStream = new DataOutputStream(s.getOutputStream());
        dataOutputStream.writeUTF("Server");
        dataOutputStream.writeUTF("S1");
        ObjectOutputStream oout = new ObjectOutputStream(dataOutputStream);
        oout.writeObject( new P1());
        oout.close();
    }
}
