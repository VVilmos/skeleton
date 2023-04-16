package Model;

public class Saboteur extends Player{
    public Saboteur(){ super(); }

    public void BreakPipe(){
        Skeleton.Start(this, "BreakPipe()");
        on.Leak();
        Skeleton.End();
    }
}
