package Model;

public class Source extends Node{
    @Override
    public void Step() {
        for (PipeEnd pe : pipeEnds)  {pe.AcceptWater();}
    }
}
