package Model;


import java.util.ArrayList;
import java.util.List;

public class Player {

    protected Element on;

    protected PipeEnd holdingPipeEnd;


    public Player(Element on){
        this.on = on;
    }
    public void Move(Element to) { //miért boolean a visszatérés?
        Skeleton.Start(this, "Move(" + Skeleton.GetObjectName(to) + ")");
        List<Element> neighbours =  on.GetNeighbours();
        boolean adjacent = false;
        for(int i = 0; i < neighbours.size(); i++){
            if(to.equals(neighbours.get(i))){
                adjacent = true;
            }
        }
        if(!adjacent){
            return;
        }
        boolean accepted;
        accepted = to.AcceptPlayer(this);
        if (accepted){
            on = to;
        }
        Skeleton.End();
    }
    public void SwitchPump(PipeEnd from, PipeEnd to){
        Skeleton.Start(this, "SwitchPump(" + Skeleton.GetObjectName(from)
                + "," + Skeleton.GetObjectName(to) + ")");
        on.Switch(from, to);
        Skeleton.End();
    }
    public void ConnectPipe() {
        Skeleton.Start(this, "ConnectPipe()");
        boolean accepted;
        if(holdingPipeEnd != null){
            accepted = on.AddPipe(holdingPipeEnd);
            if(accepted){
                holdingPipeEnd = null;
            }
        }
        Skeleton.End();
    }

    public void DisconnectPipe(PipeEnd p){
        Skeleton.Start(this, "DisconnectPipe()");
        on.RemovePipe(p);
        Skeleton.End();
    }
}
