import Model.Cistern;
import Model.Mechanic;
import Model.Pipe;
import Model.Player;

public class Main {

    public static class Skeleton {
        private static int indent = 0;

        public static void Start(Object o, String m) {
            for (int i = 0; i < indent; i++) System.out.print("\t");
            String cl = String.valueOf(o.getClass());
            cl = cl.substring(12);
            System.out.println(cl.indent(4) + "." + m );
            indent++;
        }

        public static void End() {
            indent--;
        }
    }
    public static void main(String[] args) {

        Mechanic m = new Mechanic();
        Pipe pip = new Pipe();
        Skeleton.Start(m, "Move(pip)");
        m.Move(pip);
        Skeleton.End();

    }
}