package Model;

public class Game {
    private static Pool saboteurPool = new Pool();
    private static Pool mechanicPool = new Pool();

    public static Pool getSaboteurPool() {
        return saboteurPool;
    }

    public static Pool getMechanicPool() {
        return mechanicPool;
    }
}
