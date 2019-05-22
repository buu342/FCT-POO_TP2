package ShowPedia;

import java.util.List;
import java.util.ArrayList;

public class ShowPediaClass implements ShowPedia {
    
    List<Show> shows;
    List<Actor> actors;
    
    public ShowPediaClass() {
        this.shows = new ArrayList<Show>();
        this.actors = new ArrayList<Actor>();
        
    }

}
