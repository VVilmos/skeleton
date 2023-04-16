package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Bármilyen játékbeli passzív, vagy aktív elem.
 * Felelőssége: Biztosítja az interfészt az összes elem számára, valamint törölhető róla játékos.
 */
public abstract class Element {
    /**
     * Az elemen álló játékosok listája.
     */
    protected List<Player> players = new ArrayList<>();

    /**
     * Lekéri az elem összes szomszédos elemét.
     * @return a szomszédos elemek.
     */
    public abstract List<Element> GetNeighbours();

    /**
     * Rárakja az adott játékost az elemre, ha ráfér.
     * @param p a játékos.
     * @return sikerült-e a művelet.
     */
    public abstract boolean AcceptPlayer(Player p);

    /**
     * Eltávolítja az adott játékost az elemről.
     * @param p az eltávolítandó játékos.
     */
    public void RemovePlayer(Player p) {
        Skeleton.Start(this, "RemovePlayer(" + Skeleton.GetObjectName(p) + ")");
        players.remove(p);
        Skeleton.End();
    }

    /**
     * Hozzákapcsol egy csövet az elemhez (csak Nodenál van értelme)
     * @param pe a cső vége.
     * @return sikeres-e a művelet.
     */
    public boolean AddPipe(PipeEnd pe) {
        Skeleton.Start(this, "AddPipe(" + Skeleton.GetObjectName(pe) + ")");
        Skeleton.End();
        Skeleton.PrintReturn("false");
        return false;
    }

    /**
     * Lekapcsol egy csövet. (csak Nodenál van értelme)
     * @param pe a lekapcsolandó cső vége.
     */
    public void RemovePipe(PipeEnd pe) {
        Skeleton.Start(this, "RemovePipe(" + Skeleton.GetObjectName(pe) + ")");
        Skeleton.End();
    }

    /**
     * Megjavítja az aktuális elemet. (Pumpnál és Pipenál)
     */
    public void Repair() {
        Skeleton.Start(this, "Repair()");
        Skeleton.End();
    }

    /**
     * Beállítja, hogy honnan hova pumpáljon a pumpa.
     * @param from honnan.
     * @param to hova.
     */
    public void Switch(PipeEnd from, PipeEnd to) {
        Skeleton.Start(this, "Switch(" + Skeleton.GetObjectName(from) + ", " + Skeleton.GetObjectName(to) + ")");
        Skeleton.End();
    }

    /**
     * Létrehoz egy új pumpát. (Csak Cisternnél)
     * @return az új pumpa.
     */
    public Pump MakePump() {
        Skeleton.Start(this, "MakePump()");
        Skeleton.End();
        Skeleton.PrintReturn("null");
        return null;
    }

    /**
     * Létrehoz egy új csövet. (csak Ciszternánál)
     * @return az új cső
     */
    public PipeEnd MakePipe() {
        Skeleton.Start(this, "MakePipe()");
        Skeleton.End();
        Skeleton.PrintReturn("null");
        return null;
    }

    /**
     * Kettévágja a csövet.
     * @return az új cső.
     */
    public Pipe Cut() {
        Skeleton.Start(this, "Cut()");
        Skeleton.End();
        Skeleton.PrintReturn("null");
        return null;
    }

    /**
     * Kilyukasztja a csövet.
     */
    public void Leak() {
        Skeleton.Start(this, "Leak()");
        Skeleton.End();
    }

    /**
     * Megfoltozza a csövet.
     */
    public void Patch() {
        Skeleton.Start(this, "Patch()");
        Skeleton.End();
    }

    /**
     * Visszaadja a cső végeit.
     * @return a csővégek.
     */
    public List<PipeEnd> GetEnds() {
        Skeleton.Start(this, "GetEnds()");
        Skeleton.End();
        Skeleton.PrintReturn("null");
        return null;
    }
}
