package tomaszjanik98.com.stazapplication.Classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.parceler.Parcel;

/**
 * Class that describes repository returned from Github REST API
 */
@Parcel
public class Repository {

    @Expose
    @SerializedName("id")
    public Integer id;

    @Expose
    @SerializedName("node_id")
    public String node_id;

    @Expose
    @SerializedName("name")
    public String name;

    @Expose
    @SerializedName("full_name")
    public String full_name;

    @Expose
    @SerializedName("public")
    public Boolean public_;

    @Expose
    @SerializedName("owner")
    public User owner;

    @Expose
    @SerializedName("html_url")
    public String html_url;

    @Expose
    @SerializedName("description")
    public String description;

    @Expose
    @SerializedName("fork")
    public Boolean fork;

    @Expose
    @SerializedName("url")
    public String url;

    @Expose
    @SerializedName("forks_url")
    public String forks_url;

    @Expose
    @SerializedName("keys_url")
    public String keys_url;

    @Expose
    @SerializedName("collaborators_url")
    public String collaborators_url;

    @Expose
    @SerializedName("teams_url")
    public String teams_url;

    @Expose
    @SerializedName("hooks_url")
    public String hooks_url;

    @Expose
    @SerializedName("issue_events_url")
    public String issue_events_url;

    @Expose
    @SerializedName("events_url")
    public String events_url;

    @Expose
    @SerializedName("assignees_url")
    public Boolean assignees_url;

    @Expose
    @SerializedName("branches_url")
    public String branches_url;

    @Expose
    @SerializedName("tags_url")
    public String tags_url;

    @Expose
    @SerializedName("blobs_url")
    public String blobs_url;

    @Expose
    @SerializedName("git_tags_url")
    public String git_tags_url;

    @Expose
    @SerializedName("git_refs_url")
    public String git_refs_url;

    @Expose
    @SerializedName("trees_url")
    public String trees_url;

    @Expose
    @SerializedName("statuses_url")
    public String statuses_url;

    @Expose
    @SerializedName("languages_url")
    public String languages_url;

    @Expose
    @SerializedName("stargazers_url")
    public String stargazers_url;

    @Expose
    @SerializedName("contributors_url")
    public String contributors_url;

    @Expose
    @SerializedName("subscribers_url")
    public String subscribers_url;

    @Expose
    @SerializedName("subscription_url")
    public String subscription_url;

    @Expose
    @SerializedName("commits_url")
    public String commits_url;

    @Expose
    @SerializedName("git_commits_url")
    public String git_commits_url;

    @Expose
    @SerializedName("comments_url")
    public String comments_url;

    @Expose
    @SerializedName("issue_comment_url")
    public String issue_comment_url;

    @Expose
    @SerializedName("contents_url")
    public String contents_url;

    @Expose
    @SerializedName("compare_url")
    public String compare_url;

    @Expose
    @SerializedName("merges_url")
    public String merges_url;

    @Expose
    @SerializedName("archive_url")
    public String archive_url;

    @Expose
    @SerializedName("downloads_url")
    public String downloads_url;

    @Expose
    @SerializedName("issues_url")
    public String issues_url;

    @Expose
    @SerializedName("pulls_url")
    public String pulls_url;

    @Expose
    @SerializedName("milestones_url")
    public String milestones_url;

    @Expose
    @SerializedName("notifications_url")
    public String notifications_url;

    @Expose
    @SerializedName("labels_url")
    public String labels_url;

    @Expose
    @SerializedName("releases_url")
    public String releases_url;

    @Expose
    @SerializedName("deployments_url")
    public String deployments_url;


    @Expose
    @SerializedName("created_at")
    public String created_at;

    @Expose
    @SerializedName("updated_at")
    public String updated_at;

    @Expose
    @SerializedName("pushed_at")
    public String pushed_at;

    @Expose
    @SerializedName("git_url")
    public String git_url;

    @Expose
    @SerializedName("ssh_url")
    public String ssh_url;

    @Expose
    @SerializedName("clone_url")
    public String clone_url;

    @Expose
    @SerializedName("svn_url")
    public String svn_url;

    @Expose
    @SerializedName("homepage")
    public String homepage;

    @Expose
    @SerializedName("size")
    public Integer size;

    @Expose
    @SerializedName("stargazers_count")
    public Integer stargazers_count;

    @Expose
    @SerializedName("watchers_count")
    public Integer watchers_count;

    @Expose
    @SerializedName("language")
    public String language;

    @Expose
    @SerializedName("has_issues")
    public Boolean has_issues;

    @Expose
    @SerializedName("has_projects")
    public Boolean has_projects;

    @Expose
    @SerializedName("has_downloads")
    public Boolean has_downloads;

    @Expose
    @SerializedName("has_wiki")
    public Boolean has_wiki;

    @Expose
    @SerializedName("has_pages")
    public Boolean has_pages;

    @Expose
    @SerializedName("forks_count")
    public Integer forks_count;

    @Expose
    @SerializedName("mirror_url")
    public String mirror_url;

    @Expose
    @SerializedName("archived")
    public Boolean archived;

    @Expose
    @SerializedName("disabled")
    public Boolean disabled;

    @Expose
    @SerializedName("open_issues_count")
    public Integer open_issues_count;

    @Expose
    @SerializedName("license")
    public License license;

    @Expose
    @SerializedName("forks")
    public Integer forks;

    @Expose
    @SerializedName("open_issues")
    public Integer open_issues;

    @Expose
    @SerializedName("watchers")
    public Integer watchers;

    @Expose
    @SerializedName("default_branch")
    public String default_branch;


    public String getName(){
        return name;
    }

    public User getOwner(){
        return owner;
    }

    public Integer getSize(){
        return size;
    }

    public String getLanguage(){
        return language;
    }

    public String getDescription(){
        return description;
    }

    public String getUpdated_at(){
        return updated_at;
    }
}
