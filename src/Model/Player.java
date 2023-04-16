package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Egy absztrakt játékos.
 * A szabotőr és a szerelő közös viselkedését valósítja meg.
 */
public abstract class Player {
    /**
     * Az elem, amin a játékos éppen áll.
     */
    protected Element on = null;

    /**
     * A cső, amit a játékos éppen fog.
     */
    protected PipeEnd holdingPipeEnd;

    /**
     * Beállítja az éppen fogott csövet.
     * @param pe csővég, amit fogni szeretne.
     */
    public void SetHoldingPipeEnd(PipeEnd pe){
        Skeleton.Start(this, "SetHoldingPipeEnd(" + Skeleton.GetObjectName(pe) + ")");
        this.holdingPipeEnd = pe;
        Skeleton.End();
    }

    /**
     * Rálép a megadott elemre, ha szomszédos.
     * @param to az elem, amire lépni szeretne.
     */
    public void Move(Element to){
        Skeleton.Start(this, "Move(" + Skeleton.GetObjectName(to) + ")");
        if(on == null){
            to.AcceptPlayer(this);
            on = to;
        }
        else{
            List<Element> neighbours =  on.GetNeighbours();
            boolean adjacent = false;
            for(int i = 0; i < neighbours.size(); i++){
                if(to.equals(neighbours.get(i))){
                    adjacent = true;
                }
            }
            if(!adjacent){
                return;
            }
            boolean accepted = to.AcceptPlayer(this);
            if(accepted){
                on.RemovePlayer(this);
                on = to;
            }
        }
        Skeleton.End();
    }

    /**
     * Átállítja a pumpát.
     * @param from honnan.
     * @param to hova.
     */
    public void SwitchPump(PipeEnd from, PipeEnd to){
        Skeleton.Start(this, "SwitchPump(" + Skeleton.GetObjectName(from)
                + "," + Skeleton.GetObjectName(to) + ")");
        on.Switch(from, to);
        Skeleton.End();
    }

    /**
     * Hozzákapcsolja az éppen fogott csövet az elemhez, amin áll.
     */
    public void ConnectPipe() {
        Skeleton.Start(this, "ConnectPipe()");
        boolean accepted;
        if(holdingPipeEnd != null){
            accepted = on.AddPipe(holdingPipeEnd);
            if(accepted){
                holdingPipeEnd = null;
            }
        }
        Skeleton.End();
    }

    /**
     * Lekapcsolja a csövet.
     * @param p a lekapcsolandó cső.
     */
    public void DisconnectPipe(PipeEnd p){
        Skeleton.Start(this, "DisconnectPipe(" + Skeleton.GetObjectName(p) + ")");
        on.RemovePipe(p);
        holdingPipeEnd = p;
        Skeleton.End();
    }
}
