package Model;

import java.util.ArrayList;
import java.util.List;

public class Player {

    protected Element on;

    public void Move(Element to){
        Skeleton.Start(this, "Move(" + Skeleton.GetObjectName(to) + ")");
        if(on == null){
            to.AcceptPlayer(this);
            on = to;
        }
        else{
            List<Element> neighbours =  on.GetNeighbours();
            boolean adjacent = false;
            for(int i = 0; i < neighbours.size(); i++){
                if(to.equals(neighbours.get(i))){
                    adjacent = true;
                }
            }
            if(!adjacent){
                return;
            }
            boolean accepted = to.AcceptPlayer(this);
            if(accepted){
                on.RemovePlayer(this);
                on = to;
            }
        }
        Skeleton.End();
    }
}
