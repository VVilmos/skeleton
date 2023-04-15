package Model;

import java.util.ArrayList;
import java.util.List;

public class Mechanic extends Player{

    private List<Pump> holdingPumps = new ArrayList<>();

    public Mechanic(){
        super();
    }

    public void RepairPump() {
        on.Repair();
    }

    public void PlacePump() {
        if(holdingPumps.size() > 0){
            List<Node> neighbours = new ArrayList<>(); //on szomszedos Node-jai
            neighbours.add(on.GetEnds().get(0).getNode());
            neighbours.add(on.GetEnds().get(1).getNode());
            Pipe newPipe = on.Cut();
            List<PipeEnd> onEnds = on.GetEnds();
            PipeEnd onFreeEnd = null; //annak a csonek a szabad vege, amin allunk
            if(newPipe != null && onEnds != null){
                for(int i = 0; i < 2; i++){ //vegigmegyunk a ket vegen az on csonek
                    if(onEnds.get(i).getNode() == null){ //tehat ha szabad a vege
                        onFreeEnd = onEnds.get(i); //akkor ez lesz az egyik, amit majd csatlakoztatni kell
                    }
                }
                List<PipeEnd> newEnds = newPipe.GetEnds();
                Pump pump = holdingPumps.get(0);
                holdingPumps.remove(0);
                pump.AddPipe(newEnds.get(0));
                pump.AddPipe(onFreeEnd);
                neighbours.get(1).AddPipe(newEnds.get(1));
            }
        }
    }
    public void PickupPump() {
        Pump p = on.MakePump();
        holdingPumps.add(p);
    }
    public void PickupPipe() {
        PipeEnd p = on.MakePipe();
        holdingPipeEnd = p;
    }
    public void RepairPipe() {
        Skeleton.Start(this, "RepairPipe()");
        on.Patch();
        Skeleton.End();
    }



}
