package ws;

import de.umass.lastfm.Artist;
import de.umass.lastfm.ImageSize;
import entities.DisplayArtists;
import utils.LastFmUtils;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Path("lastfm")
public class LastfmRestful {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/artists/{country}")
    public Response findTracksByCountry(@PathParam("country") String country, @QueryParam("start") int start) {

        List<DisplayArtists> results = new ArrayList<>();

        Collection<Artist> artistsByCountryAndPage = LastFmUtils.getArtistsByCountryAndPage(country, start);
        for (Artist artist : artistsByCountryAndPage) {

            results.add(new DisplayArtists(artist.getName(), artist.getImageURL(ImageSize.SMALL), artist.getUrl()));
        }

        return Response.ok().entity(new GenericEntity<List<DisplayArtists>>(results) {
        })
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS, HEAD")
                .build();

    }
}
