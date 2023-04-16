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
    public Element GetOwnPipe() {
        return pipe;
    }

    /**
     * Továbbítja a vizet a csőnek.
     * @return Igazzal tér vissza, ha a cső ({@link Pipe}) képes vizet befogadni.
     */
    public boolean AcceptWater() {
        return pipe.AcceptWater();
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
        boolean accepted = node.AddPipe(this);
        Skeleton.End();
        if (accepted) this.node = node;
    }

    /**
     * Getter a {@link Node}-ra, amire a csővég rá van kapcsolva.
     * @return Visszatéríti a csővéghez kapcsolódó {@link Node}-ot.
     */
    public Node getNode(){
        return node;
    }
}
