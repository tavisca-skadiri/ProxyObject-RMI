package socketprogramming.server2;

import socketprogramming.client.Item;
import socketprogramming.client.PurchaseOrder;

import java.io.Serializable;

public class S2 implements PurchaseOrder, Serializable {
    @Override
    public void purchase(Item item) {
        System.out.println("Printing at S2 : " + item);
    }
}
