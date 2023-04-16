package Model;



import java.util.ArrayList;
import java.util.List;

/**
 * A játékosok által irányítható karaktereket reprezentáló absztrakt osztály.
 * Felelőssége: a karakterek mozgatása, különböző akciók megvalósítása.
 */
public abstract class Player {
    /**
     * Az az Element, amelyen a Player éppen tartózkodik.
     */
    protected Element on = null;

    /**
     * Az a PipeEnd, amelyet a Player a kezében tart.
     */
    protected PipeEnd holdingPipeEnd = null;

    /**
     * A Player paraméter nélküli konstruktora.
     */
    public Player(){    }

    /**
     * Átmozgatja a Player-t egy másik, szomszédos Element-re, amennyiben sikerül, eltárolja az új helyzetének.
     * Amennyiben a Player még nincs rajta egy Element-en sem, tehát az on attribútuma null, a mozgatás
     * beállítja a to paramétert az on attribútumnak, amit inicializáláskor használunk.
     * Egyéb esetben lekérdezi a szomszédokat, és ellenőrzi, hogy a megadott Element szomszédos-e azzal az
     * Element-tel, amin áll. Ha ez teljesül, akkor rálépteti a PLayer-t, és ha ez a művelet sikeres volt, akkor
     * eltávolítja az on Elementről a PLayer-t és beállítja az új helyzetét.
     * @param to az az Element, amire átmozgatja a Player-t
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
     * Átállítja annak a pumpának a bemeneti és kimeneti csövét, amin a karakter áll.
     * @param from az a csővég, amiből kapja a vizet a pumpa
     * @param to az a csővég, amelyikbe továbbítja a vizet a pumpa
     */
    public void SwitchPump(PipeEnd from, PipeEnd to){
        Skeleton.Start(this, "SwitchPump(" + Skeleton.GetObjectName(from)
                + "," + Skeleton.GetObjectName(to) + ")");
        on.Switch(from, to);
        Skeleton.End();
    }

    /**
     * Csatlakoztatja a holding attribútumban levő csövet ahhoz az Elementhez, amin áll.
     * Csak akkor próbál csatlakoztatni, ha van cső a PLayer kezében, és ha ez sikerült,
     * törli a csövet a kezéből.
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
     * Lecsatlakoztatja a megadott paraméterű csővéget arról az Elementről, amin áll, és hozzáadja
     * a holdingPipeEnd-hez. Amenniyben a Player-nek már van a kezében egy csővég, akkor nem tud más
     * csövet lecsatlakoztatni.
     * @param p a lecsatlakoztatni kívánt PipeEnd
     */
    public void DisconnectPipe(PipeEnd p){
        Skeleton.Start(this, "DisconnectPipe()");
        if(holdingPipeEnd == null){
            on.RemovePipe(p);
            holdingPipeEnd = p;
            Skeleton.End();
        }

    }

    /**
     * Beállítja a paraméterben megadott csővéget a HoldingPipeEnd-nek.
     * @param pE a beállítandó PipeEnd
     */
    public void SetHoldingPipeEnd(PipeEnd pE){
        Skeleton.Start(this, "SetHoldingPipeEnd(" + Skeleton.GetObjectName(pE) + ")");
        this.holdingPipeEnd = pE;
        Skeleton.End();
    }
}
