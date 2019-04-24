package tomaszjanik98.com.stazapplication;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import tomaszjanik98.com.stazapplication.Classes.Repository;
import tomaszjanik98.com.stazapplication.Classes.User;

import java.util.List;

public interface GithubService {

    @GET("users/{user}")
    Call<User> getUser(@Path("user") String user);

    @GET("users/{user}/repos")
    Call<List<Repository>> listRepos(@Path("user") String user);

}
