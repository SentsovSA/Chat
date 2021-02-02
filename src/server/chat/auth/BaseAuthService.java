package server.chat.auth;

import server.chat.User;

import java.util.List;

public class BaseAuthService implements AuthService {

    private static final List<User> clients = List.of(
            new User("user1", "1111", "Котлетки"),
            new User("user2", "2222", "С"),
            new User("user3", "3333", "Пюрешкой")
    );

    @Override
    public String getUsernameByLoginAndPassword(String login, String password) {
        for (User client : clients) {
            if (client.getLogin().equals(login) & client.getPassword().equals(password)) {
                return client.getUsername();
            }
        }
        return null;
    }

    @Override
    public void startOfAuthentication() {
        System.out.println("Authentication starting");
    }

    @Override
    public void endOfAuthentication() {
        System.out.println("Authentication ending");
    }
}
