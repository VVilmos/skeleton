package Model;



public class Player {

    protected Element on;

   public boolean Move(Element e) {
       Skeleton.Start(this, "Move(" + Skeleton.GetObjectName(e) + ")");
        if (e.AcceptPlayer(this)) on = e;

        Skeleton.End();
        return false;
    }
}
