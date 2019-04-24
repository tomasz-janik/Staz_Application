package tomaszjanik98.com.stazapplication.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.google.gson.Gson;
import retrofit2.Retrofit;
import tomaszjanik98.com.stazapplication.Classes.User;
import tomaszjanik98.com.stazapplication.GithubService;
import tomaszjanik98.com.stazapplication.Interfaces.GetUserInterface;
import tomaszjanik98.com.stazapplication.R;
import tomaszjanik98.com.stazapplication.RetrofitClient;
import tomaszjanik98.com.stazapplication.Utilities;

public class MainActivity extends AppCompatActivity implements GetUserInterface {

    private EditText inputText;
    private Button inputButton;
    private ProgressBar progressBar;
    private SharedPreferences mPrefs;

    /**
     * Binding views and initializing SharedPreferences and progress bar.
     * @param savedInstanceState saved bundle, we don't use it for anything
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPrefs = getPreferences(MODE_PRIVATE);

        inputText = findViewById(R.id.main_input);
        inputButton = findViewById(R.id.main_button);
        progressBar = findViewById(R.id.main_loading);
        progressBar.setIndeterminate(true);

        init();
    }

    /**
     *  Initializing retrofit instance and listeners
     */
    private void init(){
        final Retrofit retrofit = RetrofitClient.getClient(getString(R.string.url));
        final GithubService service = retrofit.create(GithubService.class);

        inputButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utilities.hideKeyboard(MainActivity.this);
                getUser(inputText.getText().toString(), service);
            }
        });

        inputText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEND) {
                    getUser(inputText.getText().toString(), service);
                }
                return false;
            }
        });
    }

    /**
     * Saving user in json format into SharedPreferences
     * @param user  object to save into json
     * @param username key of the saved object
     */
    @Override
    public void saveUser(User user, String username){
        SharedPreferences.Editor prefsEditor = mPrefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(user);
        prefsEditor.putString(username, json);
        prefsEditor.apply();
    }

    /**
     * Response was successful, we got user from Github API and can proceed into screen 2
     * @param user  requested information about user
     * @param username  username we were searching for
     */
    @Override
    public void responseSuccessful(User user, String username){
        if (progressBar.getVisibility() == View.INVISIBLE){
            return;
        }

        inputButton.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.INVISIBLE);

        Bundle bundle = new Bundle();
        bundle.putString("username", username);

        Intent intent = new Intent(getApplicationContext(), RepositoriesActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    /**
     * If the user doesn't have internet connection inform him about it,
     * because it's not possible to get current data
     */
    @Override
    public void noInternet(){
        inputButton.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.INVISIBLE);
        Snackbar.make(findViewById(R.id.activity_main_layout),
                getString(R.string.no_internet), Snackbar.LENGTH_SHORT).show();
    }

    /**
     * If the response failed it means that there doesn't exist a user with given username
     */
    @Override
    public void responseFailed(){
        inputButton.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.INVISIBLE);
        Snackbar.make(findViewById(R.id.activity_main_layout), getString(R.string.no_username),
                Snackbar.LENGTH_SHORT).show();
    }

    /**
     * If we got no response from the site (e.g. it's down) we have to inform the user
     * that something went wrong
     */
    @Override
    public void noResponse(){
        inputButton.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.INVISIBLE);
        Snackbar.make(findViewById(R.id.activity_main_layout),
                getString(R.string.error), Snackbar.LENGTH_SHORT).show();
    }

    /**
     * Checks if there already is a user saved in SharedPreferences.
     * If there is we proceed into screen 2 and at the same time in the background we try getting latest info about
     *  the user using api in case something changed (e.g. user changed his username or deleted his profile)
     * If there isn't we wait for the response.
     * @param username  username we are looking for
     * @param service   Retrofit service to communicating
     */
    private void getUser(String username, GithubService service) {
        if (progressBar.getVisibility() != View.VISIBLE && username != null) {

            inputButton.setVisibility(View.INVISIBLE);
            progressBar.setVisibility(View.VISIBLE);

            Utilities.getUser(username, service, this, this);

            Gson gson = new Gson();
            String json = mPrefs.getString(username, null);
            if (json == null){
                return;
            }

            User user = gson.fromJson(json, User.class);
            responseSuccessful(user, username);

        }
    }

}
