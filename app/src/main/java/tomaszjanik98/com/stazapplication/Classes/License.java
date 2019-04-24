package tomaszjanik98.com.stazapplication.Classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.parceler.Parcel;

/**
 * Object that describes license that can be part of repository
 */
@Parcel
public class License {

    @Expose
    @SerializedName("key")
    public String key;

    @Expose
    @SerializedName("name")
    public String name;

    @Expose
    @SerializedName("spdx_id")
    public String spdx_id;

    @Expose
    @SerializedName("url")
    public String url;

    @Expose
    @SerializedName("node_id")
    public String node_id;
}
