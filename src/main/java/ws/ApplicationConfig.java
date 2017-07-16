package ws;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("rest")
public class ApplicationConfig extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> resources = new HashSet<>();
		addRestResources(resources);
		return resources;
	}

	private void addRestResources(Set<Class<?>> resources) {
		resources.add(LastfmRestful.class);
	}
	
	

}

