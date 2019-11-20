package socketprogramming.client;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public interface PurchaseOrder {
    void purchase(Item item) throws IOException, ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException;
}
