package Model;

import java.util.List;

public class Cistern extends Node {
    @Override
    public void Step() {
        Skeleton.Start(this, "Step()");
        for (PipeEnd pe : pipeEnds)  {pe.RemoveWater();}
        Skeleton.End();
    }

    public PipeEnd MakePipe() {
        Skeleton.Start(this, "MakePipe()");
        Pipe newpip = new Pipe(this);
        List<PipeEnd> ends = newpip.GetEnds();
        Skeleton.End();
        return ends.get(1);
    }

    public Pump MakePump() {
        Skeleton.Start(this, "MakePump");
        Skeleton.End();
        return new Pump();
    }


}
