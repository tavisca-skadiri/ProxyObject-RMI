package socketprogramming.client;

import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.Socket;

public class MyClient {
    public static void main(String[] args) {
        try {
            Item item = new Item();
            item.name = "Apple";

            Socket s = new Socket(InetAddress.getByName("localhost"), 4444);
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            dos.writeUTF("Client");
            dos.writeUTF("S1");

            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());

            PurchaseOrder purchaseOrder = (PurchaseOrder) ois.readObject();
            purchaseOrder.purchase(item);

            s.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}