package Model;

public class Player {

    protected Element on;

   public boolean Move(Element e) {
        if (e.AcceptPlayer(this)) on = e;
        return false;
    }
}
