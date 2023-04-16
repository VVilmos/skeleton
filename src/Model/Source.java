package Model;

public class Source extends Node{


    /**
     * A forrás minden ütem elején való léptetését megvalósító függvény,
     * amely minden hozzákötött csővégbe belepumpálja a vizet
     */
    @Override
    public void Step() {
        Skeleton.Start(this, "Step()");
        for (PipeEnd pe : pipeEnds)  {
            pe.AcceptWater();
        }
        Skeleton.End();
    }
}
