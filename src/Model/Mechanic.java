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

    public void PlacePump() {}
    public void PickupPump() {}
    public void PickupPipe() {}



}
