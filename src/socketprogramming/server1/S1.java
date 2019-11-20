package socketprogramming.server1;

import socketprogramming.client.Item;
import socketprogramming.client.PurchaseOrder;

import java.io.Serializable;

public class S1 implements PurchaseOrder, Serializable {
    @Override
    public void purchase(Item item) {
        System.out.println("Printing at S1 : " + item);
    }
}
