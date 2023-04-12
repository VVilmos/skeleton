package Model;

import java.util.ArrayList;
import java.util.List;

public class Pipe extends Element{

    private boolean isBroken = false;
    private boolean hasWater = false;

    private List<PipeEnd> ends;

    public Pipe(Node node) {}

    public void Leak() {}

    public void Patch() {
    }

    @Override
    boolean AcceptWater() {
        if (hasWater) return false;
        hasWater = true;
        return true;
    }

    @Override
    public boolean AcceptPlayer(Player p) {
        if (players.size() > 0) return false;
        players.add(p);
        return true;
    }


    public boolean RemoveWater() {
        if (hasWater) {
            hasWater = false;
            return true;
        }
        return false;
    }

    public Pipe Cut() {return null;}

    public List<PipeEnd> GetEnds() {return ends;}
    public List<Element> GetNeighbours() {
        List<Element> neighbours = new ArrayList<>();
        for (PipeEnd e : ends) {
            neighbours.add(e.GetOwnPipe());
        }
        return neighbours;
    }
}
