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
    public Element GetOwnPipe() {
        return pipe;
    }

    public boolean AcceptWater() {
        return pipe.AcceptWater();
    }

    public boolean RemoveWater() {
       return pipe.RemoveWater();
    }

}
