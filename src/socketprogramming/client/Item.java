package socketprogramming.client;

import java.io.Serializable;

public class Item implements Serializable {
    String name;

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                '}';
    }
}
