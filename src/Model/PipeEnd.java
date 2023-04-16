package Model;

public class PipeEnd {
    /**
     * Az a cső, melynek egyik vége az adott csővég példány
     */
    private Pipe pipe;
    /**
     * Az az aktív elem/csúcs, amelyhez a csővég csatlakoztatva van
     * Ha a csőnek ez a vége szabad, akkor a mező értéke null
     */
    private Node node;

    public PipeEnd(Pipe p) {
        this.pipe = p;
    }
    public Element GetOwnPipe() {  //miert nem Pipe-al tér vissza
        Skeleton.Start(this, "GetOwnPipe()");
        //Pipe ownPipe = this.pipe;
        Skeleton.End();
        Skeleton.PrintReturn(Skeleton.GetObjectName(this.pipe));
        return this.pipe;
    }

    public boolean AcceptWater() {
        Skeleton.Start(this, "AcceptWater()");
        boolean accepted = pipe.AcceptWater();
        Skeleton.End();
        if(accepted){
            Skeleton.PrintReturn("true");
        }
        else{
            Skeleton.PrintReturn("false");
        }
        return accepted;
    }

    public boolean RemoveWater() {
        Skeleton.Start(this, "RemoveWater()");
        boolean accepted = pipe.RemoveWater();
        Skeleton.End();
        if (accepted) Skeleton.PrintReturn("true");
        else Skeleton.PrintReturn("false");
        return accepted;
    }

    public void ConnectNode(Node node) {
        Skeleton.Start(this, "ConnectNode(" + Skeleton.GetObjectName(node) + ")");
        Skeleton.End();
        this.node = node;
    }

    public void DisconnectFromNode(){
        Skeleton.Start(this, "DisconnectFromNode()");
        boolean isFull = pipe.RemoveWater();
        if (isFull) Game.getSaboteurPool().AddWater();
        Skeleton.End();
    }

    public Node GetAttachedNode(){
        Skeleton.Start(this, "GetAttachedNode()");
        Skeleton.End();
        Skeleton.PrintReturn(Skeleton.GetObjectName(this.node));
        return this.node;
    }
}
