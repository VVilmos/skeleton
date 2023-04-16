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
    public Element GetOwnPipe() {  //kiiratas?
        Skeleton.Start(this, "GetOwnPipe()");
        Pipe ownPipe = this.pipe;
        Skeleton.End();
        Skeleton.PrintReturn("ownPipe");
        return pipe;               //miert nem Pipe-al tér vissza
    }

    public boolean AcceptWater() {
        Skeleton.Start(this, "AcceptWater()");
        boolean accepted = pipe.AcceptWater(null);
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

    public void DisconnectFromNode(){  //pontadas?

    }

    public Node GetAttachedNode(){
        Skeleton.Start(this, "GetAttachedNode()");
        Skeleton.End();
        Skeleton.PrintReturn("node");
        return this.node;

    }
}
