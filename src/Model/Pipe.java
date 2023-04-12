package Model;

import java.util.List;

public class Pipe extends Element{

    private boolean hasWater = false;

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

    @Override
    public List<Element> GetNeighbours() {
        return null;
    }
}
