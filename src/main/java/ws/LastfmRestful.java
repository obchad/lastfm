package ws;

import entities.Artist;
import service.ArtistService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("lastfm")
public class LastfmRestful {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/findall")
	public Response findAll() {
		ArtistService service = new ArtistService();
		List<Artist> results = service.getAllArtists();
		
		return Response.ok().entity(new GenericEntity<List<Artist>>(results) {})
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods",  "GET, POST, DELETE, PUT, OPTIONS, HEAD")
				.build();
				
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/artists")
	public Response findTracksByCountry(@QueryParam("country") String country, @QueryParam("start") int start) {
		ArtistService service = new ArtistService();
		List<Artist> results = service.getArtistsByCountryPaginated(country, start);
		
		return Response.ok().entity(new GenericEntity<List<Artist>>(results) {})
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods",  "GET, POST, DELETE, PUT, OPTIONS, HEAD")
				.build();
				
	}

}
