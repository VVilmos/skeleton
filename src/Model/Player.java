package Model;


import java.util.List;

public class Player {
    protected Element on = null;
    protected PipeEnd holdingPipeEnd;

    public Player(){    }

    public void SetHoldingPipeEnd(PipeEnd pE){
        Skeleton.Start(this, "SetHoldingPipeEnd(" + Skeleton.GetObjectName(pE) + ")");
        this.holdingPipeEnd = pE;
        Skeleton.End();
    }
    public void Move(Element to){
        Skeleton.Start(this, "Move(" + Skeleton.GetObjectName(to) + ")");
        if(on == null){
            to.AcceptPlayer(this);
            on = to;
        }
        else{
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
            boolean accepted = to.AcceptPlayer(this);
            if(accepted){
                on.RemovePlayer(this);
                on = to;
            }
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
        holdingPipeEnd = p;
        Skeleton.End();
    }
}
