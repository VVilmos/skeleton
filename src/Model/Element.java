package Model;

import java.util.ArrayList;
import java.util.List;

public abstract class Element {

    protected List<Player> players = new ArrayList<>();  //a diagramon private

    public abstract List<Element> GetNeighbours();
    public abstract boolean AcceptPlayer(Player p);

    public void RemovePlayer(Player p) {
        Skeleton.Start(this, "RemovePlayer(" + Skeleton.GetObjectName(p) + ")");
        players.remove(p);
        Skeleton.End();
    }
    
    public boolean AddPipe(PipeEnd pe) { return false;}   
    public void RemovePipe(PipeEnd pe) {}
    public void Break() {}  //minek?
    public void Repair() {}
    public void Switch(PipeEnd from, PipeEnd to) {}
    public Pump MakePump() {return null;} //ez igy jo-e?
    public PipeEnd MakePipe() {return null;}
    public Pipe Cut() {return null;}
    public void Leak() {}
    public void Patch() {}
    public List<PipeEnd> GetEnds() {return null;}

}
