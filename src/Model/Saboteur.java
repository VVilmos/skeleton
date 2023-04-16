package Model;

public class Saboteur extends Player{
    public Saboteur(){ super(); }

    public void BreakPipe(Pool sP){
        Skeleton.Start(this, "BreakPipe()");
        on.Leak(sP);
        Skeleton.End();
    }
}
