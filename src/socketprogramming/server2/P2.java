package socketprogramming.server2;

import socketprogramming.client.Item;
import socketprogramming.client.PurchaseOrder;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

public class P2 implements PurchaseOrder {
    public P2() throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        accepting();
    }

    private void accepting() throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        ServerSocket serverSocket = new ServerSocket(4546);
        Socket s = serverSocket.accept();
        ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
        Item item = (Item) ois.readObject();
        Class c = Class.forName("socketprogramming.server2.S2");
        Method m = c.getMethod("purchase", Item.class);
        m.invoke(c.newInstance(), item);
        ois.close();
    }

    @Override
    public void purchase(Item item) throws IOException {
        Socket socket = new Socket("localhost", 4546);
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(item);
        oos.close();
    }
}
