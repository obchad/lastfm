package utils; /**
 * Created by Chad on 16/07/2017.
 */

import de.umass.lastfm.Artist;
import de.umass.lastfm.ImageSize;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Collection;

public class LastFmUtilsTest {


    @Test
    public void testPaging() {

        System.out.println("TEST - testPaging");

        int screenPage = 8;
        String country = "australia";
        Collection<Artist> artists = LastFmUtils.getArtistsByCountryAndPage(country, screenPage);

        System.out.println("junit input - screenPage: " + screenPage);

        for (Artist artist : artists) {
            // All
//            System.out.println(artist.toString());
            // What to return
            System.out.println(artist.getName() + ", " + artist.getImageURL(ImageSize.SMALL) + ", " + artist.getUrl());

        }
        // TODO Add asserts if time allows.
    }

    @Test
    @Ignore
    public void testGetTop50Artists() {
        System.out.println("TEST - getTop50");
        String country = "australia";
        Collection<Artist> artists = LastFmUtils.getMostPopularArtistsByCountry(country);
        for (Artist artist : artists) {
//            // All
//            System.out.println(artist.toString());
//            // What to return
            System.out.println(artist.getName() + ", " + artist.getImageURL(ImageSize.SMALL) + ", " + artist.getUrl());
        }
    }
}
