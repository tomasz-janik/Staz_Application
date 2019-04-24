package tomaszjanik98.com.stazapplication;

import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import tomaszjanik98.com.stazapplication.Classes.Repository;
import tomaszjanik98.com.stazapplication.Interfaces.RepositoryClickListener;

import java.util.ArrayList;
import java.util.List;

public class RepositoriesAdapter extends RecyclerView.Adapter<RepositoriesAdapter.RepositoryViewHolder> {

    private List<Repository> repositories = new ArrayList<>();
    private RepositoryClickListener repositoryListener;

    public RepositoriesAdapter(){}

    /**
     * Initialization of listeners
     * @param repositoryListener    listener handles click on single repository
     */
    public void initListeners(RepositoryClickListener repositoryListener){
        this.repositoryListener = repositoryListener;
    }

    /**
     * Inserts list of repositories into our adapter
     * @param repositories  list of repositories to be inserted
     */
    public void insert(List<Repository> repositories){
        for (Repository repository : repositories){
            this.repositories.add(repository);
            notifyItemInserted(repositories.size() - 1);
        }
    }

    @Override
    @NonNull
    public RepositoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_repository, parent, false);
        return new RepositoryViewHolder(view);
    }

    /**
     * Initialization of single repositories in adapter
     * @param holder    viewHolder for single repository
     * @param position  position on the list of repositories
     */
    @Override
    public void onBindViewHolder(@NonNull final RepositoryViewHolder holder, int position) {
        final Repository repository = repositories.get(position);

        SpannableString spanString = new SpannableString(repositories.get(position).getName());
        spanString.setSpan(new StyleSpan(Typeface.BOLD), 0, spanString.length(), 0);

        holder.repositoryName.setText(spanString);
        holder.repositoryLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                repositoryListener.click(v, repository);
            }
        });
    }

    @Override
    public int getItemCount() {
        return repositories.size();
    }

    /**
     * Class that describes single repository in adapter
     */
    class RepositoryViewHolder extends RecyclerView.ViewHolder {

        TextView repositoryName;
        RelativeLayout repositoryLayout;

        RepositoryViewHolder(View itemView) {
            super(itemView);
            repositoryName= itemView.findViewById(R.id.row_repository_name);
            repositoryLayout = itemView.findViewById(R.id.row_repository_main_layout);
        }
    }
}
