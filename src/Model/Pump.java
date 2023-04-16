package Model;

public class Pump extends Node{

    private boolean isBroken = false;
    private int inPipe;
    private int outPipe;
    private boolean tankFull;

    public Pump() {

    }
    @Override
    public void Step() {
        Skeleton.Start(this, "Step()");
        if (tankFull) {
            boolean accepted = pipeEnds[outPipe].AcceptWater();
            if (accepted) tankFull = false;
        }
        if (!isBroken&!tankFull) {
            boolean arrived = pipeEnds[inPipe].RemoveWater();
            if (arrived) tankFull = true;
        }

        Skeleton.End();
    }

    public void Switch(PipeEnd from, PipeEnd to) {
        Skeleton.Start(this, "Switch(" + Skeleton.GetObjectName(from) + "," + Skeleton.GetObjectName(to) + ")");
        for (int i = 0; i < pipeEnds.length; i++) {
            if (pipeEnds[i] != null&&pipeEnds[i].equals(from)) inPipe = i;
            if (pipeEnds[i] != null&&pipeEnds[i].equals(from)) outPipe = i;
        }
        Skeleton.End();
    }

    public void BreakPump() {
        Skeleton.Start(this, "BreakPump()");
        isBroken = true;
        Skeleton.End();

    }
    public void Repair() {
        Skeleton.Start(this, "Repair()");
        isBroken = false;
        Skeleton.End();

    }
    public void FillWaterTank() {
        Skeleton.Start(this, "FillWaterTank()");
        tankFull = true;
        Skeleton.End();
    }

    public void RemovePipe(PipeEnd pe) {
        Skeleton.Start(this, "RemovePipe(" + Skeleton.GetObjectName(pe) + ")");
        pe.DisconnectFromNode();
        Skeleton.End();
    }
}
