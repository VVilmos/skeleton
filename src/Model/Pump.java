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
            boolean accepted = pipeEnds.get(outPipe).AcceptWater();
            if (accepted) tankFull = false;
        }
        if (!isBroken&!tankFull) {
            boolean arrived = pipeEnds.get(inPipe).RemoveWater();
            if (arrived) tankFull = true;
        }

        Skeleton.End();
    }

    public void Switch(PipeEnd from, PipeEnd to) {
        Skeleton.Start(this, "Switch(" + Skeleton.GetObjectName(from) + "," + Skeleton.GetObjectName(to) + ")");
        for (int i = 0; i < pipeEnds.size(); i++) {
            if (pipeEnds.get(i) != null&&pipeEnds.get(i).equals(from)) inPipe = i;
            if (pipeEnds.get(i) != null&&pipeEnds.get(i).equals(from)) outPipe = i;
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
}
