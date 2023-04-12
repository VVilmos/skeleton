package Model;

public class Cistern extends Node {
    @Override
    public void step() {
        for (PipeEnd pe : pipeEnds)  {pe.RemoveWater();}
    }

    public PipeEnd MakePipe() {
        return null;
    }

    public Pump MakePump() {
        return new Pump();
    }


}
