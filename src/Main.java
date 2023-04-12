import Model.Cistern;
import Model.Mechanic;
import Model.Pipe;
import Model.Player;

public class Main {

    public class Skeleton {
        private static int indent = 2;

        //hasmap

        public static void Start(Object o, String m) {
            for (int i = 0; i < indent; i++) System.out.print("\t");
            String cl = String.valueOf(o.getClass());
            cl = cl.substring(12);
            System.out.println(cl + "." + m );
            indent++;
        }

        public static void End() {
            indent--;
        }
    }
    public static void main(String[] args) {

        Mechanic m = new Mechanic();
        Skeleton.Start(m, "Move(pip)");
        Skeleton.End();
    }
}