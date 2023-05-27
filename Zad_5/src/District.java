import java.util.ArrayList;

public class District {
    int id;
    String name;
    final ArrayList<Street> streets = new ArrayList<>();

    public District(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
