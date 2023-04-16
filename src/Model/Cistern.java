package Model;

import java.util.List;

public class Cistern extends Node {
    @Override
    public void Step() {  //pontadas?
        Skeleton.Start(this, "Step()");
        for (PipeEnd pe : pipeEnds)  {pe.RemoveWater();}
        Skeleton.End();
    }

    public PipeEnd MakePipe() {
        Skeleton.Start(this, "MakePipe()");
        Pipe newpip = new Pipe(this);  //ezt nem kene hozzaadni a hashMap-hez?
        Skeleton.AddObject(newpip, "newpip");
        List<PipeEnd> ends = newpip.GetEnds();
        Skeleton.End();
        Skeleton.PrintReturn("end2");
        return ends.get(1);
    }

    public Pump MakePump() {
        Skeleton.Start(this, "MakePump");
        Skeleton.End();
        Pump newPump = new Pump();
        Skeleton.PrintReturn("newPump");
        return newPump;
    }
}
