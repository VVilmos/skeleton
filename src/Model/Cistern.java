package Model;

import java.util.List;

/**
 * Ciszternát reprezentáló osztály
 * Felelőssége: egy aktív elem, amely a hozzácsatlakozatott csövekből vizet szív ki
 */
public class Cistern extends Node {
    /**
     * A ciszterna lép az ütem elején
     * Működése: minden ütembe a bekötött csövekből vizet próbál szívni
     * Ha kap vizet az egyik csőből, akkor megnöveli a játékban játszó szerelők csapatának összesen szerzett vízmennyiségét
     */
    @Override
    public void Step() {
        Skeleton.Start(this, "Step()");
        for (PipeEnd pe : pipeEnds)  {
            if (pe != null) {
                boolean hadWater =  pe.RemoveWater();
                if (hadWater) Game.getMechanicPool().AddWater();
            }
        }
        Skeleton.End();
    }

    /**
     * A ciszterna egy új csövet juttat a rajta álló szerelőnek
     * Az új cső egyik végét automatikusan magához csatlakoztatja a ciszterna, így egy szerelő csak egy szabad véggel rendelkező csövet tud felvenni
     * @return az új cső szabad vége
     */
    public PipeEnd MakePipe() {
        Skeleton.Start(this, "MakePipe()");

        Pipe newPipe = new Pipe(this);
        Skeleton.AddObject(newPipe, "newPipe");

        List<PipeEnd> ends = newPipe.GetEnds();
        Skeleton.AddObject(ends.get(0), "newEnd1");
        Skeleton.AddObject(ends.get(1), "newEnd2");

        Skeleton.End();
        Skeleton.PrintReturn("newEnd2");
        return ends.get(1);
    }

    /**
     * A ciszterna egy új pumpát juttat a rajta álló szerelőnek
     * @return az új pumpa
     */
    public Pump MakePump() {
        Skeleton.Start(this, "MakePump()");

        Pump newPump = new Pump();
        Skeleton.AddObject(newPump, "newPump");

        Skeleton.End();
        Skeleton.PrintReturn("newPump");
        return newPump;
    }
}
