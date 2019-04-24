package tomaszjanik98.com.stazapplication.Classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.parceler.Parcel;

/**
 * Class that describes user returned from Github REST API
 */
@Parcel
public class User {

    @Expose
    @SerializedName("login")
    public String login;

    @Expose
    @SerializedName("id")
    public Integer id;

    @Expose
    @SerializedName("node_id")
    public String node_id;

    @Expose
    @SerializedName("avatar_url")
    public String avatar_url;

    @Expose
    @SerializedName("gravatar_id")
    public String gravatar_id;

    @Expose
    @SerializedName("url")
    public String url;

    @Expose
    @SerializedName("html_url")
    public String html_url;

    @Expose
    @SerializedName("followers_url")
    public String followers_url;

    @Expose
    @SerializedName("following_url")
    public String following_url;

    @Expose
    @SerializedName("gists_url")
    public String gists_url;

    @Expose
    @SerializedName("starred_url")
    public String starred_url;

    @Expose
    @SerializedName("subscriptions_url")
    public String subscriptions_url;

    @Expose
    @SerializedName("organizations_url")
    public String organizations_url;

    @Expose
    @SerializedName("repos_url")
    public String repos_url;

    @Expose
    @SerializedName("events_url")
    public String events_url;

    @Expose
    @SerializedName("received_events_url")
    public String received_events_url;

    @Expose
    @SerializedName("type")
    public String type;

    @Expose
    @SerializedName("site_admin")
    public Boolean site_admin;

    @Expose
    @SerializedName("name")
    public String name;

    @Expose
    @SerializedName("company")
    public String company;

    @Expose
    @SerializedName("blog")
    public String blog;

    @Expose
    @SerializedName("location")
    public String location;

    @Expose
    @SerializedName("email")
    public String email;

    @Expose
    @SerializedName("hireable")
    public Boolean hireable;

    @Expose
    @SerializedName("bio")
    public String bio;

    @Expose
    @SerializedName("public_repos")
    public Integer public_repos;

    @Expose
    @SerializedName("public_gists")
    public Integer public_gists;

    @Expose
    @SerializedName("followers")
    public Integer followers;

    @Expose
    @SerializedName("following")
    public Integer following;

    @Expose
    @SerializedName("created_at")
    public String created_at;

    @Expose
    @SerializedName("updated_at")
    public String updated_at;

    public String getLogin(){
        return login;
    }
}
