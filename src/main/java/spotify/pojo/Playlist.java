
package spotify.pojo;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.qameta.allure.Step;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class Playlist {

    @JsonProperty("collaborative")
    private Boolean collaborative;
    @JsonProperty("description")
    private String description;
    @JsonProperty("external_urls")
    private ExternalUrls externalUrls;
    @JsonProperty("followers")
    private Followers followers;
    @JsonProperty("href")
    private String href;
    @JsonProperty("id")
    private String id;
    @JsonProperty("images")
    private List<Object> images;
    @JsonProperty("primary_color")
    private Object primaryColor;
    @JsonProperty("name")
    private String name;
    @JsonProperty("type")
    private String type;
    @JsonProperty("uri")
    private String uri;
    @JsonProperty("owner")
    private Owner owner;
    @JsonProperty("public")
    private Boolean _public;
    @JsonProperty("snapshot_id")
    private String snapshotId;
    @JsonProperty("tracks")
    private Tracks tracks;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("collaborative")
    public Boolean getCollaborative() {
        return collaborative;
    }

    @JsonProperty("collaborative")
    public Playlist setCollaborative(Boolean collaborative) {
        this.collaborative = collaborative;
        return this;
    }
    
    @Step
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }
   
    @JsonProperty("description")
    public Playlist setDescription(String description) {
        this.description = description;
        return this;
    }

    @JsonProperty("external_urls")
    public ExternalUrls getExternalUrls() {
        return externalUrls;
    }

    @JsonProperty("external_urls")
    public Playlist setExternalUrls(ExternalUrls externalUrls) {
        this.externalUrls = externalUrls;
        return this;
    }

    @JsonProperty("followers")
    public Followers getFollowers() {
        return followers;
    }

    @JsonProperty("followers")
    public Playlist setFollowers(Followers followers) {
        this.followers = followers;
        return this;
    }

    @JsonProperty("href")
    public String getHref() {
        return href;
    }

    @JsonProperty("href")
    public Playlist setHref(String href) {
        this.href = href;
        return this;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public Playlist setId(String id) {
        this.id = id;
        return this;
    }

    @JsonProperty("images")
    public List<Object> getImages() {
        return images;
    }

    @JsonProperty("images")
    public Playlist setImages(List<Object> images) {
        this.images = images;
        return this;
    }

    @JsonProperty("primary_color")
    public Object getPrimaryColor() {
        return primaryColor;
    }

    @JsonProperty("primary_color")
    public Playlist setPrimaryColor(Object primaryColor) {
        this.primaryColor = primaryColor;
        return this;
    }
    @Step
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public Playlist setName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public Playlist setType(String type) {
        this.type = type;
        return this;
    }

    @JsonProperty("uri")
    public String getUri() {
        return uri;
    }

    @JsonProperty("uri")
    public Playlist setUri(String uri) {
        this.uri = uri;
        return this;
    }

    @JsonProperty("owner")
    public Owner getOwner() {
        return owner;
    }

    @JsonProperty("owner")
    public Playlist setOwner(Owner owner) {
        this.owner = owner;
        return this;
    }
    @Step
    @JsonProperty("public")
    public Boolean getPublic() {
        return _public;
    }

    @JsonProperty("public")
    public Playlist setPublic(Boolean _public) {
        this._public = _public;
        return this;
    }

    @JsonProperty("snapshot_id")
    public String getSnapshotId() {
        return snapshotId;
    }

    @JsonProperty("snapshot_id")
    public Playlist setSnapshotId(String snapshotId) {
        this.snapshotId = snapshotId;
        return this;
    }

    @JsonProperty("tracks")
    public Tracks getTracks() {
        return tracks;
    }

    @JsonProperty("tracks")
    public Playlist setTracks(Tracks tracks) {
        this.tracks = tracks;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public Playlist setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
