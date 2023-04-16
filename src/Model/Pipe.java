package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Cső passzív elem.
 * Tárolja/kezeli a fogadott vizet.
 */
public class Pipe extends Element{
    /**
     * Törött-e a cső.
     */
    private boolean isBroken = false;

    /**
     * Van-e a csőben víz.
     */
    private boolean hasWater = false;

    /**
     * A cső végei (1 vagy 2 db)
     */
    private List<PipeEnd> ends = new ArrayList<>();

    /**
     * Az éppen létező pipeok száma (csak névadásnál van szerepe).
     */
    private static int count = 0;

    /**
     * Kinullázza a számlálót.
     */
    public static void ResetCounter() {count = 0;}

    /**
     * Konstruktor
     * @param node a node, amihez kezdetben kapcsolva van.
     */
    public Pipe(Node node) {
        count++;

        PipeEnd end1 = new PipeEnd(this);
        Skeleton.AddObject(end1, "end" + count + "1");
        node.AddPipe(end1);

        PipeEnd end2 = new PipeEnd(this);
        Skeleton.AddObject(end2, "end" + count + "2");

        ends.add(end1);
        ends.add(end2);
    }

    /**
     * Kilyukasztja a csövet.
     */
    public void Leak() {
        Skeleton.Start(this, "Leak()");
        isBroken = true;
        if (hasWater) {
            Game.getSaboteurPool().AddWater();
            hasWater =false;
        }
        Skeleton.End();
    }

    /**
     * Megfoltozza a csövet.
     */
    public void Patch() {
        Skeleton.Start(this, "Patch()");
        isBroken = false;
        Skeleton.End();
    }

    /**
     * Elfogad csövet valakitől.
     * @return sikeres-e a fogadás.
     */
    public boolean AcceptWater() {
        Skeleton.Start(this, "AcceptWater()");
        if(hasWater) {
            Skeleton.End();
            Skeleton.PrintReturn("false");
            return false;
        }
        hasWater = true;
        if(isBroken){
            Game.getSaboteurPool().AddWater();
            hasWater = false;
        }
        Skeleton.End();
        Skeleton.PrintReturn("true");
        return true;
    }

    /**
     * Ráléptet egy játékost a csőre.
     * @param p a játékos.
     * @return sikerült-e a művelet.
     */
    @Override
    public boolean AcceptPlayer(Player p) {
        Skeleton.Start(this, "AcceptPlayer(" + Skeleton.GetObjectName(p) + ")");
        
        if (players.size() > 0) {
            Skeleton.End();
            Skeleton.PrintReturn("false");
            return false;
        }
        players.add(p);

        Skeleton.End();
        Skeleton.PrintReturn("true");
        return true;
    }

    /**
     * Kiszedi a vizet a csőből, ha van benne.
     * @return sikerült-e a művelet.
     */
    public boolean RemoveWater() {
        Skeleton.Start(this, "RemoveWater()");
        if (hasWater) {
            hasWater = false;
            Skeleton.End();
            Skeleton.PrintReturn("true");
            return true;
        }
        Skeleton.End();
        Skeleton.PrintReturn("false");
        return false;
    }

    /**
     * Kettévágja a csövet.
     * @return a művelet által létrehozott új cső.
     */
    public Pipe Cut() {
        Skeleton.Start(this, "Cut()");
        Node node = ends.get(1).GetAttachedNode();
        node.RemovePipe(ends.get(1));
        Pipe newPipe = new Pipe(node);
        Skeleton.End();
        Skeleton.PrintReturn("newPipe");
        return newPipe;
    }

    /**
     * Lekéri a cső végeit.
     * @return a csővégek.
     */
    public List<PipeEnd> GetEnds() {
        Skeleton.Start(this, "GetEnds()");
        Skeleton.End();
        Skeleton.PrintReturn("ends");
        return ends;
    }

    /**
     * Lekéri a cső szomszédos elemeit.
     * @return a szomszédok.
     */
    public List<Element> GetNeighbours() {
        Skeleton.Start(this, "GetNeighbours()");
        List<Element> neighbours = new ArrayList<>();
        for (PipeEnd e : ends) {
            neighbours.add(e.GetAttachedNode());
        }

        Skeleton.End();
        Skeleton.PrintReturn("neighbours");
        return neighbours;
    }
}
