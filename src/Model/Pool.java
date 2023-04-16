package Model;

/**
 * Medence, amiben a víz tárolódik.
 * Felelőssége: Képes tárolni az érkezett vizet.
 */
public class Pool {
    /**
     * A medence tartalma.
     */
    private int amount = 0;

    /**
     * Beönt egy egység vizet a medencébe.
     */
    public void AddWater(){
        Skeleton.Start(this, "AddWater()");
        amount++;
        Skeleton.End();
    }
}
