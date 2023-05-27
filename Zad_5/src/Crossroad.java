import java.awt.*;
import java.util.ArrayList;

public class Crossroad {
    int id;
    String name;
    Point crossroadPoint;
    final ArrayList<Street> streets = new ArrayList<>();

    public Crossroad(int id, int x, int y, String name) {
        this.id = id;
        this.crossroadPoint = new Point(x,y);
        this.name = name;
    }
}
