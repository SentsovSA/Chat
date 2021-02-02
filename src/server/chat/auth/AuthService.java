package server.chat.auth;

public interface AuthService {
    String getUsernameByLoginAndPassword(String login, String password);
    void startOfAuthentication();
    void endOfAuthentication();
}
