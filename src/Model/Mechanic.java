package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Egy szerelő játékos.
 */
public class Mechanic extends Player{
    /**
     * A pumpák, amelyeket a szerelő éppen magánál tart.
     */
    private List<Pump> holdingPumps = new ArrayList<>();

    /**
     * Megjavítja a pumpát (ha éppen rossz pumpán áll).
     */
    public void RepairPump() {
        Skeleton.Start(this, "RepairPump()");
        on.Repair();
        Skeleton.End();
    }

    /**
     * Lerak egy pumpát a csőre, amin áll.
     */
    public void PlacePump() {
        Skeleton.Start(this, "PlacePump()");
        if(holdingPumps.size() == 0) {
            Skeleton.End();
            return;
        }

        Pipe newPipe = on.Cut();
        Skeleton.AddObject(newPipe, "newPipe");
        Skeleton.AddObject(newPipe.GetEnds().get(0), "newEnd1");
        Skeleton.AddObject(newPipe.GetEnds().get(1), "newEnd2");

        List<PipeEnd> ends = on.GetEnds();
        ends.get(1).ConnectNode(holdingPumps.get(0));

        newPipe.GetEnds().get(1).ConnectNode(holdingPumps.get(0));

        Move(holdingPumps.get(0));
        holdingPumps.remove(0);

        Skeleton.End();
    }

    /**
     * Felvesz egy pumpát, csak ciszternánál van értelme.
     */
    public void PickupPump() {
        Skeleton.Start(this, "PickUpPump()");
        Pump p = on.MakePump();
        holdingPumps.add(p);
        Skeleton.End();
    }

    /**
     * Magához vesz egy csövet, csak ciszternánál van értelme.
     */
    public void PickupPipe() {
        Skeleton.Start(this, "PickUpPipe()");
        PipeEnd p = on.MakePipe();
        holdingPipeEnd = p;
        Skeleton.End();
    }

    /**
     * Megjavítja a csövet, amin éppen áll.
     */
    public void RepairPipe() {
        Skeleton.Start(this, "RepairPipe()");
        on.Patch();
        Skeleton.End();
    }
}
