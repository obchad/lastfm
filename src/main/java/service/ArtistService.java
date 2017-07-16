package service;

import entities.Artist;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArtistService {
	
	
	private List<Artist> results  = new ArrayList<>();

	public ArtistService() {


		results.add(new Artist("Pa01", "product1", 123.01d, 5, "Australia"));
		results.add(new Artist("Pa02", "product2", 200.01d, 4, "Australia"));
		results.add(new Artist("Pa03", "product3", 300d, 25, "India"));
		results.add(new Artist("Pa04", "product4", 400d, 15, "Australia"));
		results.add(new Artist("Pa05", "product5", 500d, 10, "India"));
		
	}

	
	public List<Artist> getAllArtists() {
		
		return results;
	}
	
    public List<Artist> getArtistsByCountryPaginated(String country, int startPosition) {
		List<Artist> artistsByCountry = results.stream()
				                             .filter(p ->  p.getCountry().equalsIgnoreCase(country))
				                             .collect(Collectors.toList());
		return artistsByCountry;
	}
}
