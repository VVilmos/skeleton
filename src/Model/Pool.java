package Model;

public class Pool {
    private int amount = 0;

    public void AddWater(){
        Skeleton.Start(this, "AddWater()");
        amount++;
        Skeleton.End();
    }

}
