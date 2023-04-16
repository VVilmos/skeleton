package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * Aktív elemeket reprezentáló absztrakt osztály
 * Felelőssége: tárolja a hozzá csatlakoztatott csöveket közvetve a csővégek által
 */
public abstract class Node extends Element implements ISteppable{
    /**
     * fix hosszúságú csővégekből álló tömb, az aktív elemhez csatlakoztatott csővégeket jelöli
     */
    protected List<PipeEnd> pipeEnds = new ArrayList<PipeEnd>();

    /**
     * Az aktív elemre egy karakter próbál lépni
     * @param p az érkező karakter
     * @return a mezőváltás/karakterfogadás sikeressége
     */
    @Override
    public boolean AcceptPlayer(Player p) {
        Skeleton.Start(this, "AcceptPlayer(" + Skeleton.GetObjectName(p) + ")");
        players.add(p);

        Skeleton.End();
        Skeleton.PrintReturn("true");
        return true;
    }

    /**
     * Absztrakt függvény, az aktív elem lép
     */
    @Override
    public abstract void Step();

    public List<Element> GetNeighbours() {
        Skeleton.Start(this, "GetNeighbours()");
        List<Element> neighbours = new ArrayList<>();
        for (int i = 0; i < pipeEnds.size(); i++){
            if (pipeEnds.get(i) != null) {
                neighbours.add(pipeEnds.get(i).GetOwnPipe());
            }
        }
        Skeleton.End();
        Skeleton.PrintReturn("neighbours");
        return neighbours;
    }

    /**
     * Egy szabadvégű cső csatlakoztatása az aktív elemhez
     * @param pe a cső szabad/be nem kötött vége
     * @return a felcsatlakoztatás sikeressége
     */
    public boolean AddPipe(PipeEnd pe)  {
        Skeleton.Start(this, "AddPipe(" + Skeleton.GetObjectName(pe) + ")");
        if (pipeEnds.size() <= 8) { //😎
            pipeEnds.add(pe);
            pe.ConnectNode(this);

            Skeleton.End();
            Skeleton.PrintReturn("true");
            return true;
        }
        else {
            Skeleton.End();
            Skeleton.PrintReturn("false");
            return false;
        }
    }

    /**
     * Egy bekötött cső eltávolítása az aktív elemről
     * @param pe az eltávolítani kívánt cső bekötött vége
     */
    public void RemovePipe(PipeEnd pe) {
        Skeleton.Start(this, "RemovePipe(" + Skeleton.GetObjectName(pe) + ")");
        pipeEnds.remove(pe);
        pe.DisconnectFromNode();
        Skeleton.End();
    }

    /**
     * Getter, mely visszaadja az aktív elemhez csatlakozatott csöveg bekötött végeit
     * @return a bekötött csővégek listája
     */
    public List<PipeEnd> GetPipeEnds() {
        Skeleton.Start(this, "GetPipeEnds()");
        Skeleton.End();
        Skeleton.PrintReturn("pipeEnds");
        return pipeEnds;
    }
}
