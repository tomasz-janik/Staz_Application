package tomaszjanik98.com.stazapplication;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tomaszjanik98.com.stazapplication.Classes.Repository;
import tomaszjanik98.com.stazapplication.Classes.User;
import tomaszjanik98.com.stazapplication.Interfaces.GetUserInterface;
import tomaszjanik98.com.stazapplication.Interfaces.LoadRepositoriesInterface;

import java.util.List;

public class Utilities {

    /**
     * Checks if user has internet connection
     * @param context   Application context
     * @return true if has, false otherwise
     */
    private static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null){
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        }
        return false;
    }

    /**
     * Creates call for user info and manages responses
     * @param username  username we are looking for
     * @param service   service used to communicating with Github
     * @param userInterface interface used to indicate what kind of response we got
     * @param context   Application/Activity context
     */
    public static void getUser(final String username, GithubService service, final GetUserInterface userInterface,
                        final Context context) {
        if (Utilities.isNetworkAvailable(context)) {
            service.getUser(username).enqueue(new Callback<User>() {
                @Override
                public void onResponse(@Nullable Call<User> call, @Nullable Response<User> response) {
                    if (response != null && response.isSuccessful()) {
                        userInterface.saveUser(response.body(), username);
                        userInterface.responseSuccessful(response.body(), username);
                    } else {
                        userInterface.responseFailed();
                    }
                }

                @Override
                public void onFailure(@Nullable Call<User> call, @Nullable Throwable t) {
                    userInterface.noResponse();
                }
            });
        } else {
            userInterface.noInternet();
        }
    }

    /**
     * Creates call for repositories and handles responses
     * @param username username of the user who's repositories we are looking for
     * @param service   service used to communicating with Github
     * @param loadRepositoriesInterface interface used to indicate what kind of response we got
     * @param context   Application/Activity context
     */
    public static void getRepositories(final String username, GithubService service,
                                final LoadRepositoriesInterface loadRepositoriesInterface, Context context){
        if (Utilities.isNetworkAvailable(context)){
            service.listRepos(username).enqueue(new Callback<List<Repository>>() {
                @Override
                public void onResponse(@Nullable Call<List<Repository>> call, @Nullable Response<List<Repository>> response) {
                    if (response != null && response.isSuccessful()){
                        loadRepositoriesInterface.responseSuccessful(response.body(), username);
                    }
                    else{
                        loadRepositoriesInterface.responseFailed();
                    }
                }

                @Override
                public void onFailure(@Nullable Call<List<Repository>> call, @Nullable Throwable t) {
                    loadRepositoriesInterface.noResponse();
                }
            });
        }
        else{
            loadRepositoriesInterface.noInternet();
        }
    }

    /**
     * Hides keyboard when user clicks 'Send'
     * @param activity  activity that is currently live
     */
    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        View view = activity.getCurrentFocus();

        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        if (imm != null)
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

}
