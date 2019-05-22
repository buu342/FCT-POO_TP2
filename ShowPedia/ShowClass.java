package ShowPedia;

import java.util.List;
import java.util.Map;
import java.util.SortedMap;

public class ShowClass implements Show {

    private Map<Integer, Episode> seasons;
    
    public ShowClass() {
        this.seasons = new SortedMap<>();
    }
    
}