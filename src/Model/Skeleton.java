package Model;

import java.util.HashMap;

/**
 * A teszesetenként használt objektumok és a függvényhívások nyomonkövetését, naplózását végző osztály.
 */
public  class Skeleton {
    /**
     * Egy adott függvényhívás kiírásakor az behúzás mértéke
     */
    private static int indent = 0;

    /**
     * A naplózás funkció beállítása. Hamis érték esetén az osztály függvényei nem írnak ki semmit a kimenetre
     */
    private static boolean log = true;

    /**
     * Egy adott tesztesetben szereplő objektumokhoz kapcsolódó példány-változónév párosok Map-je
     */
    private static HashMap<Object, String> hm = new HashMap<>();


    /**
     * A naplózás funkció bekapcsolása
     */
    public static void LogOn() {log = true;}

    /**
     * A naplózás funkció kikapcsolása
     */
    public static void LogOff() {log = false;}

    /**
     * Függvényhívás jelzése az osztálynak
     * @param o az objektum, amin a függvényt hívták
     * @param m a függvény neve, paraméterei
     */
    public static void Start(Object o, String m) {
        if (log) {
            System.out.println();
            for (int i = 0; i < indent; i++) System.out.print("\t");
            String name = hm.get(o);
            System.out.print(name + "." + m + " ");
            indent++;
        }
    }

    /**
     * A konstruktorok naplózása/kiírása
     * @param m a meghívott konstruktor és az újonna létrehozott objektum neve
     */
    public static void CtorStart(String m) {
        if (log) {
            System.out.println();
            for (int i = 0; i < indent; i++) System.out.print("\t");
            System.out.print("<<create>> " + m);
            indent++;
        }
    }

    /**
     * Függvényvisszatérés jelzése az osztálynak
     */
    public static void End() {
        if (log) indent--;
    }

    /**
     * Függvény visszatérésének kiírása
     * @param value a kiírandó visszatérési érték
     */
    public static void PrintReturn(String value) {
        if (log) {
            System.out.println();
            for (int i = 0; i < indent; i++) System.out.print("\t");
            System.out.print(value+ " ");
        }
    }


    /**
     * Új objektum felvétele a HashMap-be
     * @param object az új objektum referenciája
     * @param name az új objektum neve
     */
    public static void AddObject(Object object, String name) {hm.put(object, name);}

    /**
     * Getter, mely visszaadja a paraméterlistában megadott objektumhoz rendelt nevet
     * @param o a lekérdezett objektum
     * @return az objektum neve
     */
    public static String GetObjectName(Object o) { return hm.get(o);}

    /**
     * Az objektum-változónév összerendelések törlése a HashMap-ből
     */
    public static void ClearMap() {
        hm.clear();
    }
}