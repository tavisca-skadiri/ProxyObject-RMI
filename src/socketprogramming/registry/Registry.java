package socketprogramming.registry;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class Registry {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        HashMap<String, Object> registry = new HashMap<>();
        ServerSocket ss = new ServerSocket(4444);
        while (true) {
            Socket socket = ss.accept();
            DataInputStream registryInput = new DataInputStream(socket.getInputStream());
            DataOutputStream registryOutput = new DataOutputStream(socket.getOutputStream());
            String hostType = registryInput.readUTF();

            if (hostType.equals("Client")) {
                String type=registryInput.readUTF();
                ObjectOutputStream oout=new ObjectOutputStream(registryOutput);
                oout.writeObject(registry.get(type));
                oout.close();
            }
            else if (hostType.equals("Server")) {
                String serverName = registryInput.readUTF();
                ObjectInputStream oin = new ObjectInputStream(socket.getInputStream());
                Object o = oin.readObject();
                registry.put(serverName, o);
                System.out.println(registry);
                oin.close();
            }
        }
    }
}
