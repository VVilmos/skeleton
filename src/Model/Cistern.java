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
    public void Step() {  //pontadas?
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

        Skeleton.CtorStart("Pipe(" + Skeleton.GetObjectName(this) + ") newpip");
        Pipe newpip = new Pipe(this);  //ezt nem kene hozzaadni a hashMap-hez?
        Skeleton.End();
        Skeleton.AddObject(newpip, "newpip");
        List<PipeEnd> ends = newpip.GetEnds();

        Skeleton.End();
        Skeleton.PrintReturn(Skeleton.GetObjectName(ends.get(1)));
        return ends.get(1);
    }

    /**
     * A ciszterna egy új pumpát juttat a rajta álló szerelőnek
     * @return az új pumpa
     */
    public Pump MakePump() {
        Skeleton.Start(this, "MakePump()");
        Skeleton.CtorStart("Pump() newPump");
        Pump newPump = new Pump();
        Skeleton.End();
        Skeleton.End();
        Skeleton.PrintReturn("newPump");
        return newPump;
    }
}
