package server;

import server.chat.MyServer;

import java.io.IOException;

public class ServerApp {

    private static final int DEFAULT_CHAT_PORT = 8888;

    public static void main(String[] args) {
        int port = DEFAULT_CHAT_PORT;

        if (args.length != 0){
            port = Integer.parseInt(args[0]);
        }

        try {
            new MyServer(port).start();
        } catch (IOException e){
            System.out.println("Error");
            e.printStackTrace();
            System.exit(1);
        }
    }
}
