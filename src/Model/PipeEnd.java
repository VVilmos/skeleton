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
    public Element GetOwnPipe() {
        return pipe;
    }

    public boolean AcceptWater() {
        return pipe.AcceptWater();
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
        boolean accepted = node.AddPipe(this);
        Skeleton.End();
        if (accepted) this.node = node;
    }
}
