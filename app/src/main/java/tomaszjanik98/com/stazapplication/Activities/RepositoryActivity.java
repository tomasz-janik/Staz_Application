package tomaszjanik98.com.stazapplication.Activities;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import org.parceler.Parcels;
import tomaszjanik98.com.stazapplication.Classes.Repository;
import tomaszjanik98.com.stazapplication.R;

public class RepositoryActivity extends AppCompatActivity {

    private TextView repositoryName, repositoryDescription, repositoryOwner,
            repositorySize, repositoryLanguage, repositoryUpdatedAt;

    /**
     * Binding views and getting repository that we want user to see
     * @param savedInstanceState saved bundle, we get username of the user who's repositories we are trying to get
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repository);

        Repository example = Parcels.unwrap(getIntent().getParcelableExtra("repository"));

        repositoryName = findViewById(R.id.repository_name);
        repositoryDescription = findViewById(R.id.repository_description);
        repositoryOwner = findViewById(R.id.repository_owner);
        repositorySize = findViewById(R.id.repository_size);
        repositoryLanguage = findViewById(R.id.repository_language);
        repositoryUpdatedAt = findViewById(R.id.repository_updated);

        init(example);
    }

    /**
     * Initializing textViews with content and setting visibility of some views
     * @param repository repository to show
     */
    private void init(Repository repository){
        SpannableString spanString = new SpannableString(repository.getName());
        spanString.setSpan(new StyleSpan(Typeface.BOLD), 0, spanString.length(), 0);

        String description = repository.getDescription();
        String owner = "Owner: " + repository.getOwner().getLogin();
        String size = "Size: " + repository.getSize().toString();
        String language = "Language: " + repository.getLanguage();
        String updated = "Updated at: " + repository.getUpdated_at().substring(0, 10);

        repositoryName.setText(repository.getName());

        //if there is no description we won't show it, so we need to make slight changes to layout
        if (description != null){
            repositoryDescription.setText(description);
        }
        else{
            repositoryDescription.setVisibility(View.GONE);

            RelativeLayout.LayoutParams  params = (RelativeLayout.LayoutParams) repositoryOwner.getLayoutParams();
            params.addRule(RelativeLayout.BELOW, repositoryDescription.getId());

            repositoryOwner.setLayoutParams(params);
        }

        repositoryOwner.setText(owner);
        repositorySize.setText(size);

        if (repository.getLanguage() != null){
            repositoryLanguage.setText(language);
        }
        else{
            repositoryLanguage.setVisibility(View.GONE);
        }

        repositoryUpdatedAt.setText(updated);
    }
}
