package Model;

/**
 * Szabotőr játékos
 * A játékos képességein felül képes csövet lyukasztani.
 */
public class Saboteur extends Player{
    /**
     * Konstruktor
     */
    public Saboteur() {
        Skeleton.CtorStart("Saboteur()");
        Skeleton.End();
    }

    /**
     * Kilyukasztja a csövet, amin éppen áll.
     */
    public void BreakPipe(){
        Skeleton.Start(this, "BreakPipe()");
        on.Leak();
        Skeleton.End();
    }
}
