package team;

import java.util.ArrayList;
import droid.Droid;
public class Team {
    private String Name;
    private ArrayList<Droid>droids;

    public Team(String name, ArrayList<Droid> droids) {
        Name = name;
        this.droids = droids;
    }
    public void attackOpposingTeam(Team opposingTeam) {

    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public ArrayList<Droid> getDroids() {
        return droids;
    }
    public void setDroids(ArrayList<Droid> droids) {
        this.droids = droids;
    }
}
