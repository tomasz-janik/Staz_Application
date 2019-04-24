package tomaszjanik98.com.stazapplication.Interfaces;

import tomaszjanik98.com.stazapplication.Classes.User;

public interface GetUserInterface {
    void noInternet();
    void responseSuccessful(User user, String username);
    void responseFailed();
    void noResponse();
    void saveUser(User user, String username);
}
