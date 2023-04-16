package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * A szerelőt reprezentáló osztály, a Player osztályból származik.
 * Felelőssége: Képes megjavítani az elromlott pumpákat és a lyukas csöveket,
 * új csövet / pumpákat magához venni és letenni.
 */
public class Mechanic extends Player{
    /**
     * A szerelőnél levő pumpákat tárolja el.
     */
    private List<Pump> holdingPumps = new ArrayList<>();

    /**
     * A Mechanic paraméter nélküli konstruktora.
     */
    public Mechanic(){
        super();
    }

    /**
     * Megjavítja a pumpát, amin a szerelő áll.
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
        Skeleton.LogOff();
        Skeleton.AddObject(newPipe, "newPipe");
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

    /**
     * Felvesz egy új pumpát.
     * Megkéri a Ciszternát, hogy gyártson le neki egy új pumpát,
     * majd hozzáaadja azt a holdingPumps-hoz.
     */
    public void PickupPump() {
        Skeleton.Start(this, "PickUpPump()");
        Pump p = on.MakePump();
        holdingPumps.add(p);
        Skeleton.End();
    }

    /**
     * Felvesz egy új csővéget, amennyiben a Mechanic kezében nincs már egy.
     * Megkéri a Ciszternát, hogy gyártson le neki egy új csövet,
     * majd hozzáadja a végét a holdingPipeEnd-hez.
     * A cső másik vége a Ciszternához van bekötve.
     */
    public void PickupPipe() {
        Skeleton.Start(this, "PickUpPipe()");
        if(holdingPipeEnd == null){
            PipeEnd p = on.MakePipe();
            holdingPipeEnd = p;
        }
        Skeleton.End();
    }

    /**
     * Megfoltozza a csövet, amin a Mechanic áll.
     */
    public void RepairPipe() {
        Skeleton.Start(this, "RepairPipe()");
        on.Patch();
        Skeleton.End();
    }
}
