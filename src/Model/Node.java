package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * Aktív elemeket reprezentáló absztrakt osztály
 * Felelőssége: ..
 */
public abstract class Node extends Element implements ISteppable{
    protected PipeEnd[] pipeEnds = {null, null, null, null, null, null, null, null};

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
        for (int i = 0; i < pipeEnds.length; i++){
            if (pipeEnds[i] != null) {
                neighbours.add(pipeEnds[i].GetOwnPipe());
            }
        }
        Skeleton.End();
        Skeleton.PrintReturn("neighbours");
        return neighbours;
    }

    public boolean AddPipe(PipeEnd pe)  {
        Skeleton.Start(this, "AddPipe(" + Skeleton.GetObjectName(pe) + ")");
        if (pipeEnds.length <= 8) { //😎
            int i = 0;
            while (pipeEnds[i] != null) {i++;}
            pipeEnds[i] = pe;

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

    public void RemovePipe(PipeEnd pe) {
        Skeleton.Start(this, "RemovePipe(" + Skeleton.GetObjectName(pe) + ")");
        int i = 0;
        while (pipeEnds[i] != pe){i++;}
        pipeEnds[i].DisconnectFromNode();
        pipeEnds[i] = null;
        Skeleton.End();
    }

    public PipeEnd[] GetPipeEnds() {
        Skeleton.Start(this, "GetPipeEnds()");
        Skeleton.End();
        return pipeEnds;
    }


}
