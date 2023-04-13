package Model;

import java.util.ArrayList;
import java.util.List;

public class Pipe extends Element{

    private boolean isBroken = false;
    private boolean hasWater = false;

    private List<PipeEnd> ends = new ArrayList<>();

    public Pipe(Node node) {            //itt ki kéne találni, hogyan logoljuk a konstruktort / egyáltalán kell-e
        PipeEnd end1 = new PipeEnd(this);
        Skeleton.AddObject(end1, "end1");
        end1.ConnectNode(node);
        PipeEnd end2 = new PipeEnd(this);
        Skeleton.AddObject(end2, "end2");
        ends.add(end1);
        ends.add(end2);
    }

    public void Leak() {
        Skeleton.Start(this, "Leak()");

        Skeleton.End();
    }

    public void Patch() {
        Skeleton.Start(this, "Patch()");
        isBroken = false;
        Skeleton.End();
    }

    @Override
    public boolean AcceptWater() {
        Skeleton.Start(this, "AcceptWater()");
        Skeleton.End();
        if (hasWater) {
            Skeleton.PrintReturn("false");
            return false;
        }
        hasWater = true;
        Skeleton.PrintReturn("true");
        return true;
    }

    @Override
    public boolean AcceptPlayer(Player p) {
        Skeleton.Start(this, "AcceptPlayer(" + Skeleton.GetObjectName(p) + ")");
        
        if (players.size() > 0) {
            Skeleton.End();
            Skeleton.PrintReturn("false");
            return false;
        }
        players.add(p);

        Skeleton.End();
        Skeleton.PrintReturn("true");
        return true;
    }


    public boolean RemoveWater() {
        Skeleton.Start(this, "RemoveWater()");
        if (hasWater) {
            hasWater = false;
            Skeleton.End();
            Skeleton.PrintReturn("true");
            return true;
        }
        Skeleton.End();
        Skeleton.PrintReturn("false");
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
