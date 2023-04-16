package Model;

import java.util.ArrayList;
import java.util.List;

public class Mechanic extends Player{

    private List<Pump> holdingPumps = new ArrayList<>();
    public void RepairPipe() {
        Skeleton.Start(this, "RepairPipe()");
        on.Patch();
        Skeleton.End();
    }

    public void RepairPump() {}

    public void PlacePump() {
        Skeleton.Start(this, "PlacePump()");
        if(holdingPumps.size() == 0) {
            Skeleton.End();
            return;
        }

        Pipe newPipe = on.Cut();
        Skeleton.PrintReturn("newPipe");
        Skeleton.AddObject(newPipe, "newPipe");
        Skeleton.LogOff();
        Skeleton.AddObject(newPipe.GetEnds().get(0), "newEnd1");
        Skeleton.AddObject(newPipe.GetEnds().get(1), "newEnd2");
        Skeleton.LogOn();

        List<PipeEnd> ends = on.GetEnds();
        ends.get(1).ConnectNode(holdingPumps.get(0));

        newPipe.GetEnds().get(1).ConnectNode(holdingPumps.get(0));

        Move(holdingPumps.get(0));
        holdingPumps.remove(0);

        Skeleton.End();
    }
    public void PickupPump() {
        Skeleton.Start(this, "PickupPump()");
        Pump newPump = on.MakePump();
        holdingPumps.add(newPump);
        Skeleton.AddObject(newPump, "newPump");
        Skeleton.PrintReturn("newPump");
        Skeleton.End();
    }
    public void PickupPipe() {}



}
