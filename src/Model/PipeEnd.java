package Model;

/**
 * A játékban levő csővégeket reprezentálja. \n
 * Lehet hozzá Node-ot kötni illetve lecsatlakoztatni róla. \n
 * Tárolja, hogy milyen Node-dal áll összeköttetésben, és hogy melyik csőhöz tartozik.
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
     * A PipeEnd konstruktora \n
     * Hozzárendeli, felcsatlakoztatja a paraméterként kapott csőre a csővégt.
     * @param p A cső, amire kerül ez a csővég.
     */
    public PipeEnd(Pipe p) {
        this.pipe = p;
    }
    /**
     * Getter a csővéghez tartozó csőre.
     * @return Visszatéríti a csövet, aminek ez a csővég a vége.
     */
    public Element GetOwnPipe() {  //kiiratas?
        Skeleton.Start(this, "GetOwnPipe()");
        Pipe ownPipe = this.pipe;
        Skeleton.End();
        Skeleton.PrintReturn(Skeleton.GetObjectName(this.pipe));
        return pipe;               //miert nem Pipe-al tér vissza
    }

    /**
     * Továbbítja a vizet a csőnek.
     * @return Igazzal tér vissza, ha a cső ({@link Pipe}) képes vizet befogadni.
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
     * Kiszívja, eltávolítja a vizet a csővéghez tartozó csőből.
     * @return Igazzal tér vissza, ha a csőből ({@link Pipe}) lehet vizet kiszívni.
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
     * A paraméterként kapott {@link Node}-hoz kapcsolja a csővéget.
     * @param node A {@link Node}, amire a csővéget felcsatlakoztatjuk.
     */
    public void ConnectNode(Node node) {
        Skeleton.Start(this, "ConnectNode(" + Skeleton.GetObjectName(node) + ")");
        Skeleton.End();
        this.node = node;
    }

    /**
     * Lecsatlakoztatja a csővéget a felkapcsolt {@link Node}-ról.
     */
    public void DisconnectFromNode(){  //pontadas?
        Skeleton.Start(this, "DisconnectFromNode()");
        boolean isFull = pipe.RemoveWater();
        if (isFull) Game.getSaboteurPool().AddWater();
        Skeleton.End();
    }

    /**
     * Getter a {@link Node}-ra, amire a csővég rá van kapcsolva.
     * @return Visszatéríti a csővéghez kapcsolódó {@link Node}-ot.
     */
    public Node GetAttachedNode(){
        Skeleton.Start(this, "GetAttachedNode()");
        Skeleton.End();
        Skeleton.PrintReturn(Skeleton.GetObjectName(this.node));
        return this.node;

    }
}
