package socketprogramming.server3;

import socketprogramming.client.Item;
import socketprogramming.client.PurchaseOrder;

import java.io.Serializable;

public class S3 implements PurchaseOrder, Serializable {
    @Override
    public void purchase(Item item) {
        System.out.println("Printing at S3 : " + item);
    }
}
