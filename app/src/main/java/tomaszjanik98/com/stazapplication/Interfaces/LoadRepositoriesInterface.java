package tomaszjanik98.com.stazapplication.Interfaces;

import tomaszjanik98.com.stazapplication.Classes.Repository;

import java.util.List;

public interface LoadRepositoriesInterface {
    void noInternet();
    void responseSuccessful(List<Repository> list, String username);
    void responseFailed();
    void noResponse();
}
