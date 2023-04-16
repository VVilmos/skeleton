package Model;

public abstract class Source extends Node{
    @Override
    public void Step() {
        Skeleton.Start(this, "Step()");
        for (PipeEnd pe : pipeEnds)  {
            pe.AcceptWater();
        }
        Skeleton.End();
    }
}
