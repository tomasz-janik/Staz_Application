package tomaszjanik98.com.stazapplication.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import org.parceler.Parcels;
import retrofit2.Retrofit;
import tomaszjanik98.com.stazapplication.*;
import tomaszjanik98.com.stazapplication.Classes.Repository;
import tomaszjanik98.com.stazapplication.Interfaces.LoadRepositoriesInterface;
import tomaszjanik98.com.stazapplication.Interfaces.RepositoryClickListener;

import java.util.List;

public class RepositoriesActivity extends AppCompatActivity implements LoadRepositoriesInterface, RepositoryClickListener {

    private GithubService service;
    private RepositoriesAdapter adapter;
    private RecyclerView recyclerView;

    /**
     * Binding views
     * @param savedInstanceState saved bundle, we get username of the user who's repositories we are trying to get
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repositories_list);

        recyclerView = findViewById(R.id.repositories_list_recycler_view);

        init(getIntent().getExtras());
    }

    /**
     * Initialization
     * @param bundle user bundle
     */
    private void init(Bundle bundle){
        initRetrofit();
        initRecyclerView();
        initRepositories(bundle);
    }

    /**
     *  Initializing retrofit instance
     */
    private void initRetrofit(){
        Retrofit retrofit = RetrofitClient.getClient(getString(R.string.url));
        service = retrofit.create(GithubService.class);
    }

    /**
     *  Initializing views
     */
    private void initRecyclerView(){
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(RepositoriesActivity.this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new RepositoriesAdapter();
        adapter.initListeners(this);

        recyclerView.setAdapter(adapter);
    }

    /**
     *  Reading data from bundle and communicating with Github REST API
     */
    private void initRepositories(Bundle bundle){
        if (bundle != null){
            String username = bundle.getString("username");
            if (username != null){
                Utilities.getRepositories(bundle.getString("username"), service, this, this);
                return;
            }
        }
        responseFailed();
    }

    @Override
    public void responseSuccessful(List<Repository> repositories, String username){
        adapter.insert(repositories);
    }

    /**
     * If the user doesn't have internet connection inform him about it,
     * because it's not possible to get current data
     */
    @Override
    public void noInternet(){
        Snackbar.make(findViewById(R.id.activity_main_layout),
                getString(R.string.no_internet), Snackbar.LENGTH_SHORT).show();
    }

    /**
     * If the response failed it means that there doesn't exist a user with given username or we couldn't parse information
     */
    @Override
    public void responseFailed(){
        Snackbar.make(findViewById(R.id.activity_main_layout), getString(R.string.error),
                Snackbar.LENGTH_SHORT).show();
    }

    /**
     * If we got no response from the site (e.g. it's down) we have to inform the user
     * that something went wrong
     */
    @Override
    public void noResponse(){
        Snackbar.make(findViewById(R.id.activity_main_layout),
                getString(R.string.error), Snackbar.LENGTH_SHORT).show();
    }

    /**
     * Handle repository click - go to Screen 3
     * @param view  view that user clicked on
     * @param repository    whole repository user clicked on
     */
    @Override
    public void click(View view, Repository repository){
        Bundle bundle = new Bundle();
        bundle.putParcelable("repository", Parcels.wrap(repository));

        Intent intent = new Intent(getApplicationContext(), RepositoryActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

}
