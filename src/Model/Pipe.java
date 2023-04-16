package Model;

import java.util.ArrayList;
import java.util.List;

public class Pipe extends Element{

    private boolean isBroken = false;
    private boolean hasWater = false;
    private List<PipeEnd> ends = new ArrayList<>();

    private static int count = 0;
    public static void ResetCounter() {count = 0;}



    public Pipe(Node node) {            //itt ki kéne találni, hogyan logoljuk a konstruktort / egyáltalán kell-e
        count++;
        PipeEnd end1 = new PipeEnd(this);
        Skeleton.AddObject(end1, "end" + count + "1");
        node.AddPipe(end1);
        PipeEnd end2 = new PipeEnd(this);
        Skeleton.AddObject(end2, "end" + count + "2");
        ends.add(end1);
        ends.add(end2);

    }

    public void Leak() {  //pontadas?
        Skeleton.Start(this, "Leak()");
        isBroken = true;
        if (hasWater) {
            Game.getSaboteurPool().AddWater();
            hasWater =false;
        }
        Skeleton.End();
    }

    public void Patch() {
        Skeleton.Start(this, "Patch()");
        isBroken = false;
        Skeleton.End();
    }

    public boolean AcceptWater() {
        Skeleton.Start(this, "AcceptWater()");
        if(hasWater) {
            Skeleton.End();
            Skeleton.PrintReturn("false");
            return false;
        }
        hasWater = true;
        if(isBroken){
            Game.getSaboteurPool().AddWater();
            hasWater = false;
        }
        Skeleton.End();
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

    public List<PipeEnd> GetEnds() {
        Skeleton.Start(this, "GetEnds");
        Skeleton.End();
        Skeleton.PrintReturn("ends");
        return ends;
    }
    public List<Element> GetNeighbours() {
        Skeleton.Start(this, "GetNeighbours()");
        List<Element> neighbours = new ArrayList<>();
        for (PipeEnd e : ends) {
            neighbours.add(e.GetAttachedNode());
        }

        Skeleton.End();
        Skeleton.PrintReturn("neighbours");
        return neighbours;
    }
}
