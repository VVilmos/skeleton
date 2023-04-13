package Model;

import java.util.HashMap;

public  class Skeleton {
    private static int indent = 0;

    private static boolean log = true;

    private static HashMap<Object, String> hm = new HashMap<>();


    public static void LogOn() {log = true;}
    public static void LogOff() {log = false;}

    public static void Start(Object o, String m) {
        if (log) {
            System.out.println();
            for (int i = 0; i < indent; i++) System.out.print("\t");
            String name = hm.get(o);
            System.out.print(name + "." + m + " ");
            indent++;
        }
    }

    public static void End() {
        if (log) indent--;
    }

    public static void PrintReturn(String value) {
        if (log) {
            System.out.println();
            for (int i = 0; i < indent; i++) System.out.print("\t");
            System.out.print(value+ " ");
        }
    }

    public static void AddObject(Object object, String name) {hm.put(object, name);}

    public static String GetObjectName(Object o) { return hm.get(o);}

    public static void ClearMap() {
        hm.clear();
    }

}
