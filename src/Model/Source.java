package Model;

/**
 * Forrás elem
 * Időegységenként löki ki magából a vizet a hozzá kapcsolódó csövekbe.
 */
public class Source extends Node{
    /**
     * Konstruktor
     */
    public Source() {
        Skeleton.CtorStart("Source()");
        Skeleton.End();
    }

    /**
     * Lépteti a forrást, amely ezáltal kilöki magából a vizet.
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
