package Model;

/**
 * Medence, amiben a víz tárolódik.
 * Felelőssége: Képes tárolni az érkezett vizet.
 */
public class Pool {
    /**
     * A Pool által tárolt víz mennyisége.
     */
    private int amount = 0;

    /**
     * Ez a metódus vizet ad hozzá a Pool-hoz. Ezáltal a Pool által tárolt víz mennyisége nő.
     */
    public void AddWater(){
        Skeleton.Start(this, "AddWater()");
        amount++;
        Skeleton.End();
    }
}
