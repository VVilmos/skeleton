package Model;

/**
 * Egy játékmenetet reprezentáló osztály
 * A megvalósítani kívánt tesztprogram jellege miatt még csak korlátozott felelősséggel bír, tényleges játszma megvalósítására nem alkalmas!
 */
public class Game {
    /**
     * A szabotőrök csapata által megszerzett víz "gyüjtőhelye"
     */
    private static Pool saboteurPool = new Pool();
    /**
     * A szerelők csapata által megszerzett víz "gyüjtőhelye"
     */
    private static Pool mechanicPool = new Pool();

    /**
     * Getter, mely visszaadja a szabotőrök "vízgyűjtőjét"
     * @return referencia a szabotőrök vízgyüjtőjére
     */
    public static Pool getSaboteurPool() { return saboteurPool; }

    /**
     * Getter, mely visszaadja a szerelők "vízgyűjtőjét"
     * @return referencia a szerelők vízgyüjtőjére
     */
    public static Pool getMechanicPool() {
        return mechanicPool;
    }
}
