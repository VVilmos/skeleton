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
     * ???
     */
    public void PlacePump() {
        Skeleton.Start(this, "PlacePump()");
        if(holdingPumps.size() > 0){
            List<Node> neighbours = new ArrayList<>(); //on szomszedos Node-jai
            neighbours.add(on.GetEnds().get(0).GetAttachedNode());
            neighbours.add(on.GetEnds().get(1).GetAttachedNode());
            Pipe newPipe = on.Cut();
            List<PipeEnd> onEnds = on.GetEnds();
            PipeEnd onFreeEnd = null; //annak a csonek a szabad vege, amin allunk
            if(newPipe != null && onEnds != null){
                for(int i = 0; i < 2; i++){ //vegigmegyunk a ket vegen az on csonek
                    if(onEnds.get(i).GetAttachedNode() == null){ //tehat ha szabad a vege
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
        Skeleton.End();
    }

    /**
     * Felvesz egy új pumpát.
     * Megkéri a Ciszternát, hogy gyártson le neki egy új pumpát,
     * majd hozzáaadja azt a holdingPumps-hoz.
     */
    public void PickupPump() {
        Skeleton.Start(this, "PickUpPump()");
        Pump newPump = on.MakePump();
        holdingPumps.add(newPump);
        Skeleton.AddObject(newPump, "newPump");
        Skeleton.PrintReturn("newPump");
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
