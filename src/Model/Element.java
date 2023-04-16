package Model;

import java.util.ArrayList;
import java.util.List;

public abstract class Element {

    /**
     * Az adott elemen álló játékosok listája
     */
    protected List<Player> players = new ArrayList<>();

    /**
     * Az adott elem szomszédait visszaadó absztrakt függvény
     * @return a szomszédok listája
     */
    public abstract List<Element> GetNeighbours();

    /**
     * A paraméterként megadott játékos elfogadását/ráléptetését az adott elemre megvalósító absztarkt függvény
     * @param p Az adott elemre lépni kívánó játékos
     * @return sikerült-e a rálépés
     */
    public abstract boolean AcceptPlayer(Player p);

    /**
     * A paraméterként megadott játékost törli a rajta levő játékosok közül
     * @param p az eltávolítandó játékos
     */
    public void RemovePlayer(Player p) {
        Skeleton.Start(this, "RemovePlayer(" + Skeleton.GetObjectName(p) + ")");
        players.remove(p);
        Skeleton.End();
    }

    /**
     * Csatlakoztatja a megadott csővéget az adott elemhez (csak Node-oknál fog bármit is csinálni)
     * @param pe a csatlakozatni kívánt csővég
     * @return sikerült-e a csatlakoztatás
     */
    public boolean AddPipe(PipeEnd pe) { return false;}

    /**
     * Lecsatlakoztatja a megadott csővéget az adott elemről (csak Node-oknál fog bármit is csinálni)
     * @param pe a lecsatlakoztatni kívánt csővég
     */
    public void RemovePipe(PipeEnd pe) {}

    /**
     * Megjavítja az adott Elementet (csak pumpánál fog bármit is csinálni)
     */
    public void Repair() {}

    /**
     * Átállítja a be- és kimeneti csövégeket (csak pumpánál fog bármit is csinálni)
     * @param from bemeneti csővég
     * @param to kimeneti csővég
     */
    public void Switch(PipeEnd from, PipeEnd to) {}

    /**
     * Létrehoz egy új pumpát (csak a ciszternánál fog bármit is csinálni)
     * @return az új pumpa
     */
    public Pump MakePump() {return null;}

    /**
     * Létrehoz egy új csövet az adott elemnél (csak a ciszternánál fog bármit is csinálni)
     * @return az új cső szabad vége
     */
    public PipeEnd MakePipe() {return null;}

    /**
     * Elvágja az adott elemet (csak csőre fog bármit is csinálni)
     * @return a keletkezett új cső
     */
    public Pipe Cut() {return null;}

    /**
     * Kilyukasztja az adott elemet (csak csőre fog bármit is csinálni)
     */
    public void Leak() {}

    /**
     * Megfoltozza az adott elemet (csak csőre fog bármit is csinálni)
     */
    public void Patch() {}

    /**
     * Az adott elem végeit adja vissza (csak csőre fog bármit is csinálni)
     * @return a végek listája
     */
    public List<PipeEnd> GetEnds() {return null;}
}
