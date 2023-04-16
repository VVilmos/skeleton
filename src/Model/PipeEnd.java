package Model;

/**
 * Csővég.
 * Ezen keresztül csatlakozik egy cső a szomszédos elemeihez.
 */
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

    /**
     * Konstruktor
     * @param p a cső, aminek a vége.
     */
    public PipeEnd(Pipe p) {
        this.pipe = p;
    }

    /**
     * Visszaadja a csövet, aminek a végéről van szó.
     * @return a cső.
     */
    public Element GetOwnPipe() {
        Skeleton.Start(this, "GetOwnPipe()");
        Pipe ownPipe = this.pipe;
        Skeleton.End();
        Skeleton.PrintReturn(Skeleton.GetObjectName(this.pipe));
        return pipe;
    }

    /**
     * Elfogad egy egység vizet.
     * @return sikerült-e az elfogadás.
     */
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

    /**
     * A csővégen keresztül kiveszi az egység vizet a csőből. (ha van benne)
     * @return sikerült-e a művelet.
     */
    public boolean RemoveWater() {
        Skeleton.Start(this, "RemoveWater()");
        boolean accepted = pipe.RemoveWater();
        Skeleton.End();
        if (accepted) Skeleton.PrintReturn("true");
        else Skeleton.PrintReturn("false");
        return accepted;
    }

    /**
     * Hozzácsatol egy nodeot a csővéghez.
     * @param node
     */
    public void ConnectNode(Node node) {
        Skeleton.Start(this, "ConnectNode(" + Skeleton.GetObjectName(node) + ")");
        Skeleton.End();
        this.node = node;
    }

    /**
     * Lekapcsolja a csővéget a noderól.
     */
    public void DisconnectFromNode(){
        Skeleton.Start(this, "DisconnectFromNode()");
        boolean isFull = pipe.RemoveWater();
        if (isFull) Game.getSaboteurPool().AddWater();
        Skeleton.End();
    }

    /**
     * Visszaadja a node-ot, amihez hozzá van kötve a csővég.
     * @return a megfelelő node.
     */
    public Node GetAttachedNode(){
        Skeleton.Start(this, "GetAttachedNode()");
        Skeleton.End();
        Skeleton.PrintReturn(Skeleton.GetObjectName(this.node));
        return this.node;
    }
}
