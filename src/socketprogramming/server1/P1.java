package socketprogramming.server1;

import socketprogramming.client.Item;
import socketprogramming.client.PurchaseOrder;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

public class P1 implements PurchaseOrder, Serializable {
    public P1() {
    }

    private void accepting() throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {

        System.out.println("Accepting is called");
        ServerSocket serverSocket = new ServerSocket(4545);
        Socket s = serverSocket.accept();

        ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
        Item item = (Item) ois.readObject();
        Class c = Class.forName("socketprogramming.server1.S1");
        Method m = c.getMethod("purchase", Item.class);
        m.invoke(c.newInstance(), item);
        ois.close();
    }

    @Override
    public void purchase(Item item) {
        System.out.println("Purchase is called");
        new Thread(() -> {
            try {
                accepting();
            } catch (IOException | ClassNotFoundException | NoSuchMethodException | InvocationTargetException | IllegalAccessException | InstantiationException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                serve(item);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void serve(Item item) throws IOException {

        System.out.println("Serve is called");
        Socket socket = new Socket("localhost", 4545);
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(item);
        oos.close();
    }
}
