package Model;

/**
 * Forrás elem
 * Időegységenként löki ki magából a vizet a hozzá kapcsolódó csövekbe.
 */
public class Source extends Node{
    /**
     * A forrás minden ütem elején való léptetését megvalósító függvény,
     * amely minden hozzákötött csővégbe belepumpálja a vizet
     */
    @Override
    public void Step() {
        Skeleton.Start(this, "Step()");
        for (PipeEnd pe : pipeEnds)  {
            if(pe != null) pe.AcceptWater();
        }
        Skeleton.End();
    }
}
