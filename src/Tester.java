import Model.*;

import java.lang.invoke.MethodHandle;
import java.util.List;

/**
 * Tesztelő osztály a játékban szereplő osztályok elvárt működésének ellenörzésére
 */
public class Tester {

    /**
     * Tesztekhez felhasznált pumpa referencia
     */
    private static Pump pump;
    /**
     * Tesztekhez felhasznált cső referencia
     */
    private static Pipe p1;
    /**
     * Tesztekhez felhasznált cső referencia
     */
    private static Pipe p2;
    /**
     * Tesztekhez felhasznált csővég referencia
     */
    private static PipeEnd pe1;
    /**
     * Tesztekhez felhasznált csővég referencia
     */
    private static PipeEnd pe2;

    public static void LeakingPipeRepair() {
        Skeleton.ClearMap();
        //init a komm diagram alapján
        Skeleton.LogOff();
        Pump pu = new Pump();
        Skeleton.AddObject(pu, "pu");
        Pipe pip = new Pipe(pu);
        Skeleton.AddObject(pip, "pip");
        pip.Leak();
        Mechanic m = new Mechanic();
        Skeleton.AddObject(m, "m");
        m.Move(pip);
        List<PipeEnd> ends = pip.GetEnds();
        pu.Switch(ends.get(0), null);

        //létrehozott objektumok és állapotuk feltüntetése a konzolon
        System.out.println("\nThe test will run on the following objects:");
        System.out.println("pu:Pump with empty tank \npip:Pipe which is leaking and connected to Pump pu \n" +
                "end1/end2: the ends of Pipe pip \nm: Mechanic standing on Pipe pip");

        //Tester függvényhívásai
        System.out.print("\nThe next functions were called during the test:");
        Skeleton.LogOn();
        m.RepairPipe();
        pip.AcceptWater();
        pu.Step();

    }

    public static void SteppingToAndSwitchPump() {
        Skeleton.ClearMap();
        Skeleton.LogOff();
        Pump pu = new Pump();
        Skeleton.AddObject(pu, "pu");
        pu.FillWaterTank();
        Pipe pip1 = new Pipe(pu);
        Skeleton.AddObject(pip1, "pip1");
        PipeEnd from = pip1.GetEnds().get(0);
        pip1.AcceptWater();
        Pipe pip2 = new Pipe(pu);
        Skeleton.AddObject(pip2, "pip2");
        PipeEnd to = pip2.GetEnds().get(0);

        Mechanic m = new Mechanic();
        Skeleton.AddObject(m, "m");
        m.Move(pip1);

        //létrehozott objektumok és állapotuk feltüntetése a konzolon
        System.out.println("\nThe test will run on the following objects:");
        System.out.println("pu:Pump with two pipes connected to it \npip2:Pipe connected to Pump pu \n" +
                "end1/end2: the ends of Pipe pip \nm: Mechanic standing on Pipe pip1");

        //Tester függvényhívásai
        Skeleton.LogOn();
        m.Move(pu);

        pu.Switch(from, to);
        pu.Step();

    }

    public static void DisconnectingFullPipe() {
        Skeleton.ClearMap();
        Skeleton.LogOff();

        Skeleton.AddObject(Game.getSaboteurPool(), "saboteurPool");

        Pump pu = new Pump();

        Skeleton.AddObject(pu, "pu");
        Pipe pip = new Pipe(pu);
        Skeleton.AddObject(pip, "pip");
        pip.AcceptWater();
        Mechanic m = new Mechanic();
        Skeleton.AddObject(m, "m");
        m.Move(pu);
        PipeEnd end1 = pip.GetEnds().get(0);

        //létrehozott objektumok és állapotuk feltüntetése a konzolon
        System.out.println("\nThe test will run on the following objects:");
        System.out.println("pu:Pump with one pipe connected to it \npip:Full Pipe connected to Pump pu \n" +
                "end1: the connected end of Pipe pip \nm: Mechanic standing on Pump pu \nsaboteurPool: Pool that represents all water Saboteurs collect");

        //Tester függvényhívásai
        Skeleton.LogOn();
        m.DisconnectPipe(end1);

    }

    public static void CisternSteps() {
        Skeleton.ClearMap();
        Skeleton.LogOff();
        Pipe.ResetCounter();

        Cistern c = new Cistern();
        Skeleton.AddObject(c, "c");
        Pipe pip1 = new Pipe(c);
        Skeleton.AddObject(pip1, "pip1");
        pip1.AcceptWater();

        Pipe pip2 = new Pipe(c);
        Skeleton.AddObject(pip2, "pip2");
        Skeleton.AddObject(Game.getMechanicPool(), "mechanicPool");

        //létrehozott objektumok és állapotuk feltüntetése a konzolon
        System.out.println("\nThe test will run on the following objects:");
        System.out.println("c:Cistern with two pipe connected to it \npip1:Full Pipe connected to Cistern c \n" +
                "pip2: Empty Pipe conected to Cistern c \nend1: connected ends of Pipe");

        //Tester függvényhívásai
        Skeleton.LogOn();
        c.Step();
    }

    public static void PlayerSteps2() {
        Skeleton.ClearMap();
        Skeleton.LogOff();
        Pump to1 = new Pump();
        Skeleton.AddObject(to1, "to1");
        Pipe on1 = new Pipe(to1);
        Skeleton.AddObject(on1, "on1");
        Mechanic m = new Mechanic();
        Skeleton.AddObject(m, "m");
        m.Move(on1);

        Pipe to2 = new Pipe(to1);
        Skeleton.AddObject(to2, "to2");

        System.out.println("\nThe test will run on the following objects:");
        System.out.println("to1: Pump where Mechanic steps first " +
                "\non1: Pipe where Mechanic is on " +
                "\nm: Mechanic, who will step " +
                "\nto2: Pipe where mechanic steps second");

        System.out.print("\nThe next functions were called during the test:");
        Skeleton.LogOn();
        m.Move(to1);
        m.Move(to2);
    }

    public static void ConnectPipeToPump(){
        Skeleton.ClearMap();
        Skeleton.LogOff();
        Pump pu = new Pump();
        Skeleton.AddObject(pu, "pu");
        Pipe pip = new Pipe(pu);
        Skeleton.AddObject(pip, "pip");
        Pump on = new Pump();
        Skeleton.AddObject(on, "on");
        Mechanic m = new Mechanic();
        Skeleton.AddObject(m, "m");
        m.Move(on);

        m.SetHoldingPipeEnd(pip.GetEnds().get(1));

        System.out.println("\nThe test will run on the following objects:");
        System.out.println("pu: Pump, where pip's first pipeEnd is connected " +
                "\npip: The ownPipe of holdingPipeEnd " +
                "\non: Pump, where Mechanic is on and where holdingPipeEnd will be connected " +
                "\nm: Mechanic, who will connect holdingPipeEnd to on");

        System.out.print("\nThe next functions were called during the test:");
        Skeleton.LogOn();
        m.ConnectPipe();
    }

    public static void StepOnCisternAndPicksUpPipe(){
        Skeleton.ClearMap();
        Skeleton.LogOff();
        Pipe.ResetCounter();
        Cistern to = new Cistern();
        Skeleton.AddObject(to, "to");
        Pipe on = new Pipe(to);
        Skeleton.AddObject(on, "on");
        Mechanic m = new Mechanic();
        Skeleton.AddObject(m, "m");
        m.Move(on);

        System.out.println("\nThe test will run on the following objects:");
        System.out.println("to: Cistern, where Mechanic will step" +
                "\non: Pipe, where Mechanic is on" +
                "\nm: Mechanic, who will step on to and pick up Pipe");

        System.out.print("\nThe next functions were called during the test:");
        Skeleton.LogOn();
        m.Move(to);
        m.PickupPipe();
    }

    public static void BreakPipeAndItAcceptsWater(){
        Skeleton.ClearMap();
        Skeleton.LogOff();
        Skeleton.AddObject(Game.getSaboteurPool(), "saboteurPool");
        Pump p1 = new Pump();
        Skeleton.AddObject(p1, "p1");
        Pipe on = new Pipe(p1);
        Skeleton.AddObject(on, "on");
        on.Patch(); //kell-e?
        on.AcceptWater();

        Saboteur s = new Saboteur();
        Skeleton.AddObject(s, "s");
        s.Move(on);

        System.out.println("\nThe test will run on the following objects:");
        System.out.println("p1: Pump, where 'on' is connected to" +
                "\non: Pipe, where Saboteur is on" +
                "\ns: Saboteur, who will break Pipe 'on' " +
                "\nsaboteurPool: Pool that represents all water Saboteurs collect");

        System.out.print("\nThe next functions were called during the test:");
        Skeleton.LogOn();
        s.BreakPipe();
        on.AcceptWater();
    }


    //12
    public static void SecondStepOnPump() {
        Skeleton.ClearMap();
        Skeleton.LogOff();
        Mechanic m1 = new Mechanic();
        Skeleton.AddObject(m1, "m1");
        Mechanic m2 = new Mechanic();
        Skeleton.AddObject(m2, "m2");
        Pump pu = new Pump();
        Skeleton.AddObject(pu, "pu");
        Pipe pi = new Pipe(pu);
        Skeleton.AddObject(pi, "pi");
        m1.Move(pi);
        m2.Move(pu);

        System.out.println("\nSecond person tries to step on Pump");
        System.out.println("\nThe test will run on the following objects:");
        System.out.println("m1: Mechanic standing on Pipe pi \n" +
                "m2: Mechanic standing on Pump pu\n" +
                "pu: Pump that Mechanic m1 will step on \n" +
                "pi: Pipe which is connected to Pump pu");

        System.out.print("\nThe next functions were called during the test:");
        Skeleton.LogOn();
        m1.Move(pu);
    }

    public static void GetPumpAtCistern() {
        Skeleton.ClearMap();
        Skeleton.LogOff();
        Cistern c = new Cistern();
        Skeleton.AddObject(c, "c");
        Pipe pi = new Pipe(c);
        Skeleton.AddObject(pi, "pi");
        Mechanic m = new Mechanic();
        Skeleton.AddObject(m, "m");
        m.Move(pi);

        System.out.println("\nTester steps on Cistern and picks up Pump");
        System.out.println("\nThe test will run on the following objects:");
        System.out.println("m: Mechanic standing on Pipe pi \n" +
                "c: Cistern that Mechanic m will step on \n" +
                "pi: Pipe which is connected to Cistern c");

        System.out.print("\nThe next functions were called during the test:");
        Skeleton.LogOn();
        m.Move(c);
        m.PickupPump();
    }

    public static void BreakPumpAndTwoStep(){
        Skeleton.ClearMap();
        Skeleton.LogOff();
        Pump pu = new Pump();
        Skeleton.AddObject(pu, "pu");
        Pipe pi = new Pipe(pu);
        Skeleton.AddObject(pi, "pi");
        pu.FillWaterTank();

        System.out.println("\nPump breaks with full Tank and steps two times");
        System.out.println("\nThe test will run on the following objects:");
        System.out.println("pu: Pump that will break \n" +
                "pi: Pipe which is connected to Pump pu");

        System.out.print("\nThe next functions were called during the test:");
        Skeleton.LogOn();
        pu.BreakPump();
        pu.Step();
        pu.Step();
    }

    /**
     * A csőhálózat eldugulásának a tesztelését végző függvény
     */
    public static void ClogPipeNetwork() {
        Skeleton.ClearMap();
        Skeleton.LogOff();

        Pump pump = new Pump();
        Skeleton.AddObject(pump, "pump");

        Pipe p1 = new Pipe(pump);
        Skeleton.AddObject(p1, "p1");

        Pipe p2 = new Pipe(pump);
        Skeleton.AddObject(p2, "p2");

        List<PipeEnd> firstPipeEnds = p1.GetEnds();

        PipeEnd pe1 = firstPipeEnds.get(0);
        Skeleton.AddObject(pe1, "pe1");

        PipeEnd pe2 = firstPipeEnds.get(1);
        Skeleton.AddObject(pe2, "pe2");

        List<PipeEnd> secondPipeEnds = p2.GetEnds();

        PipeEnd pe3 = secondPipeEnds.get(0);
        Skeleton.AddObject(pe3, "pe3");

        pump.Switch(pe2, pe3);

        System.out.println("Pipe network clogs.");
        System.out.println("This test uses the following objects:");
        System.out.println("pump: A pump which moves water through the network");
        System.out.println("p1 and p2: The pipes this simple network consists of");
        System.out.println("pe1: The input of this network which the test fills up with water");
        System.out.println("pe2 and pe3: The two PipeEnds the pump if connected to");
        System.out.println("The following functions are called during this test:");
        Skeleton.LogOn();
        pe1.AcceptWater();
        pump.Step();
        pe1.AcceptWater();
        pump.Step();
        pe1.AcceptWater();
        pump.Step();
        pe1.AcceptWater();
    }

    /**
     * Inicializáló segédfüggvény a {@link #WorkingPumpPumps()}, {@link #StepPumpTwiceAfterRepair()} tesztekhez
     */
    private static void initPumpWithTwoPipes() {
        Skeleton.ClearMap();
        Skeleton.LogOff();

        pump = new Pump();
        Skeleton.AddObject(pump, "pump");

        p1 = new Pipe(pump);
        Skeleton.AddObject(p1, "p1");

        p2 = new Pipe(pump);
        Skeleton.AddObject(p2, "p2");

        List<PipeEnd> p1Ends = p1.GetEnds();
        List<PipeEnd> p2Ends = p2.GetEnds();

        pe1 = p1Ends.get(0);
        Skeleton.AddObject(pe1, "pe1");
        pe2 = p2Ends.get(0);
        Skeleton.AddObject(pe2, "pe2");

        pump.Switch(pe1, pe2);

    }

    /**
     * Egy működő pumpa kipróbálását megvalósító függvény
     */
    public static void WorkingPumpPumps() {
        initPumpWithTwoPipes();

        pe1.AcceptWater();

        System.out.println("Working Pump pumps");
        System.out.println("This test uses the following objects:");
        System.out.println("pump: The pump to test its functionality");
        System.out.println("p1 and p2: The two pipes connected to the pump");
        System.out.println("pe1: The PipeEnd the pump extracts water from");
        System.out.println("pe2: The PipeEnd where the water is expected upon pumping");

        Skeleton.LogOn();
        pump.Step();
        p1.AcceptWater();
        pump.Step();
    }

    /**
     * A pumpa megjavítása után kétszeri léptetéssel ellenőrzi a helyes működést.
     */
    public static void StepPumpTwiceAfterRepair() {
        initPumpWithTwoPipes();
        pump.BreakPump();
        p1.AcceptWater();
        System.out.println("Pump steps twice after repair");
        System.out.println("This test uses the following objects:");
        System.out.println("pump: The pump to test if it functions correctly after a repair");
        System.out.println("p1 and p2: The two pipes connected to the pump");
        System.out.println("pe1: The PipeEnd the pump extracts water from");
        System.out.println("pe2: The PipeEnd where the water is expected upon pumping");

        Skeleton.LogOn();
        pump.Repair();
        pump.Step();
        pump.Step();
    }

    /**
     * Ez a teszt egy üres cső lecsatolásának a helyes működését ellenőrzi a pumpáról.
     */
    public static void DisconnectEmptyPipeFromPump() {
        Skeleton.ClearMap();
        Skeleton.LogOff();

        pump = new Pump();
        Skeleton.AddObject(pump, "pump");

        Pipe p = new Pipe(pump);
        Skeleton.AddObject(p, "p");

        Mechanic m = new Mechanic();
        Skeleton.AddObject(m, "m");

        PipeEnd pe = p.GetEnds().get(0);
        Skeleton.AddObject(pe, "pe");

        m.Move(pump);

        System.out.println("Tester disconnects empty pipe from Pump");
        System.out.println("This test uses the following objects:");
        System.out.println("pump: The pump the pipe is disconnected from");
        System.out.println("p: The pipe which will be disconnected");
        System.out.println("pe: The end of the pipe connected to pump");
        System.out.println("m: The mechanic which performs the operations");

        Skeleton.LogOn();
        m.DisconnectPipe(pe);
        pe.RemoveWater();

    }

}

