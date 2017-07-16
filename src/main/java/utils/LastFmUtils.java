package utils;

import de.umass.lastfm.*;
import de.umass.util.MapUtilities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//        API key	ccf7e29521f6632b0b73a3303fbc04a7
//        Shared secret	89ae88012246a055d217e7aa9d06c9c8
//        Registered to	obchad

//Task:
//  Create a list of the most popular artists on Last.fm by country,using Java and HTML.
//  The user should be able to enter a keyword(country name),which is then used to search Last.fm api.
//  The search results should be paginated and displayed as five results per page,
//  and the user should be able to navigate to other pages(browsable).
//  Each result should be displayed as the name of the band and a thumbnail of the band;clicking on the thumbnail should
// open a new page which shows the Artist Top Tracks.
// Keep in mind that your solution should work efficiently,no matter how many results match the keyword.


public class LastFmUtils {


    private final static String key = "ccf7e29521f6632b0b73a3303fbc04a7"; //this is the key used in the Last.fm API examples
    private final static String user = "obchad";

    public static Collection<Artist> getMostPopularArtistsByCountry(String country) {
        // The requirments ask for the most popular artists, this one just returns page 1 of the artists.
        // Which is the top 50.  So we would do paging on the front end seeing the list is only 50.
        Collection<Artist> artists = Geo.getTopArtists(country, key);
        return artists;
    }

    public static Collection<Artist> getArtistsByCountryAndPage(String country, int screenPage) {

        // Last.fm returns 50 artists per page.  The requirements state most popular but then a following comment states:
        // "Keep in mind that your solution should work efficiently,no matter how many results match the keyword."
        // So in that case my front end will handle the paging of 5 at a time for a list of 50,
        // then handle the next lots of 10 pages via this. Maybe do some math bits and let the front end be free,
        // that way I will get consistent performance.

        // This is last.fm page.  Groups of 50.
        int page = 1;
        if (screenPage > 10) {
            page = (screenPage / 10) + 1;
        }

        Map<String, String> params = new HashMap<String, String>();
        params.put("page", String.valueOf(page));
        MapUtilities.nullSafePut(params, "country", country);
        Result result = Caller.getInstance().call("geo.getTopArtists", key, params);

        PaginatedResult<Artist> artistsByPage = ResponseBuilder.buildPaginatedResult(result, Artist.class);

        Collection<Artist> artists = artistsByPage.getPageResults();
        Collection<Artist> artistsByScreenPage = new ArrayList<Artist>();
        int subPage = (screenPage % 10);
        int startCounter = ((subPage-1) * 5) + 1;
        int endCounter = ((subPage-1) * 5) + 5;



        System.out.println("ScreenPage: " + screenPage + ", Page: " + page + ", SubPage: " + subPage);
        System.out.println("startCounter: " + startCounter + " , endCounter: " + endCounter);


        int counter = 1;
        for (Artist artist : artists) {
            if ((counter >= startCounter) && (counter <= endCounter)) {
                artistsByScreenPage.add(artist);

            }
            counter++;
        }
        return artistsByScreenPage;
    }
}