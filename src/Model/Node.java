package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * Aktív elemeket reprezentáló absztrakt osztály
 * Felelőssége: ..
 */
public abstract class Node extends Element implements ISteppable{

    protected List<PipeEnd> pipeEnds = new ArrayList<>();

    @Override
    public boolean AcceptPlayer(Player p) {
        Skeleton.Start(this, "AcceptPlayer(" + Skeleton.GetObjectName(p) + ")");
        players.add(p);

        Skeleton.End();
        Skeleton.PrintReturn("true");
        return true;
    }

    @Override
    public abstract void Step();

    public List<Element> GetNeighbours() {
        Skeleton.Start(this, "GetNeighbours()");
        List<Element> neighbours = new ArrayList<>();
        for (int i = 0; i < pipeEnds.size(); i++)
            neighbours.add(pipeEnds.get(i).GetOwnPipe());

        Skeleton.End();
        return neighbours;
    }

    public boolean AddPipe(PipeEnd pe)  {
        Skeleton.Start(this, "AddPipe(" + Skeleton.GetObjectName(pe) + ")");
        if (pipeEnds.size() <= 8) {
            pipeEnds.add(pe);
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

    public void RemovePipe(PipeEnd pe) {
        Skeleton.Start(this, "RemovePipe(" + Skeleton.GetObjectName(pe) + ")");
        pipeEnds.remove(pe);
        Skeleton.End();
    }

    public List<PipeEnd> GetPipeEnds() {
        Skeleton.Start(this, "GetPipeEnds()");
        Skeleton.End();
        return pipeEnds;
    }

}
