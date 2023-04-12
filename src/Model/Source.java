package Model;

public class Source extends Node{
    @Override
    public void step() {
        for (PipeEnd pe : pipeEnds)  {pe.AcceptWater();}
    }
}
