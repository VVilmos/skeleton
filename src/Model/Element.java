package Model;

import java.util.ArrayList;
import java.util.List;

public abstract class Element {

    protected List<Player> players = new ArrayList<>();
    public void Patch() {
    }

    boolean AcceptWater() {
        return false;
    }

   public abstract boolean AcceptPlayer(Player p);
    public abstract List<Element> GetNeighbours();

    public void RemovePlayer(Player p) {
        Skeleton.Start(this, "RemovePlayer(" + Skeleton.GetObjectName(p) + ")");
        players.remove(p);
        Skeleton.End();
    }

    public boolean AddPipe(PipeEnd pe) { return true;}

    public void RemovePipe(PipeEnd pe) {}

    public void Break() {}
    public void Repair() {}
    public void Leak() {}
    public void Switch(PipeEnd from, PipeEnd to) {}
    public Pump MakePump() {return new Pump();}
    public PipeEnd MakePipe() {return null;}
    public Pipe Cut() {return null;}
    public List<PipeEnd> GetEnds() {return null;}
}
