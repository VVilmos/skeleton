package Model;

import java.util.List;

public class Cistern extends Node {
    @Override
    public void Step() {
        Skeleton.Start(this, "Step()");
        for (PipeEnd pe : pipeEnds)  {
            if (pe != null) {
                boolean hadWater =  pe.RemoveWater();
                if (hadWater) Game.getMechanicPool().AddWater();
            }
        }
        Skeleton.End();
    }

    public PipeEnd MakePipe() {
        Skeleton.Start(this, "MakePipe()");
        Pipe newpip = new Pipe(this);
        Skeleton.AddObject(newpip, "newpip");
        List<PipeEnd> ends = newpip.GetEnds();
        Skeleton.End();
        Skeleton.PrintReturn(Skeleton.GetObjectName(ends.get(1)));
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
