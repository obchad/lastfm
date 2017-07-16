package entities;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Chad on 16/07/2017.
 */
@XmlRootElement(name = "artist")
public class DisplayArtists {

    private String name;
    private String thumbnailUrl;
    private String topTracksUrl;

    public DisplayArtists(String name, String thumbnailUrl, String topTracksUrl) {
        this.name = name;
        this.thumbnailUrl = thumbnailUrl;
        this.topTracksUrl = topTracksUrl;
    }

    @XmlElement(name = "thumbnailUrl")
    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    @XmlElement(name = "topTracksUrl")
    public String getTopTracksUrl() {
        return topTracksUrl;
    }

    public void setTopTracksUrl(String topTracksUrl) {
        this.topTracksUrl = topTracksUrl;
    }


    @XmlElement(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
