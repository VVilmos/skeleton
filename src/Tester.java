import Model.*;

import java.lang.invoke.MethodHandle;
import java.util.List;

/**
 * Tesztelő osztály a játékban szereplő osztályok elvárt működésének ellenörzésére
 */
public class Tester {

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
        pip.AcceptPlayer(m);
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
        Skeleton.AddObject(m ,"m");
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


    public static void PlayerSteps2(){
        Skeleton.ClearMap();
        Skeleton.LogOff();
        Pump to1 = new Pump();
        Skeleton.AddObject(to1, "to1");
        Pipe on1 = new Pipe(to1);
        Skeleton.AddObject(on1, "on1");
        Mechanic m = new Mechanic();
        Skeleton.AddObject(m, "m");
        m.Move(on1);
        on1.AcceptPlayer(m);

        Pipe to2 = new Pipe(to1);
        Skeleton.AddObject(to2, "to2");

        System.out.println("\nThe test will run on the following objects:");
        System.out.println("to1: \non1: \n m: \nto2: ");

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
        on.AcceptPlayer(m);

        m.SetHoldingPipeEnd(pip.GetEnds().get(1));

        System.out.println("\nThe test will run on the following objects:");
        System.out.println("pu: \npip: \non: \nm: ");

        System.out.print("\nThe next functions were called during the test:");
        Skeleton.LogOn();
        m.ConnectPipe();
    }

    public static void StepOnCisternAndPicksUpPipe(){
        Skeleton.ClearMap();
        Skeleton.LogOff();
        Cistern to = new Cistern();
        Skeleton.AddObject(to, "to");
        Pipe on = new Pipe(to);
        Skeleton.AddObject(on, "on");
        Mechanic m = new Mechanic();
        Skeleton.AddObject(m, "m");
        m.Move(on);
        on.AcceptPlayer(m);

        System.out.println("\nThe test will run on the following objects:");
        System.out.println("to: \non: \nm: ");

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
        on.AcceptPlayer(s);

        System.out.println("\nThe test will run on the following objects:");
        System.out.println("p1: \non: \ns: \npool: ");

        System.out.print("\nThe next functions were called during the test:");
        Skeleton.LogOn();
        s.BreakPipe();
        on.AcceptWater();
    }
        
        
    //12
    public static void SecondStepOnPump(){
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
        /*pi.AcceptPlayer(m1);
        pu.AcceptPlayer(m2);*/
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

    //13
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

    //14
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

    public static void PlacePump() {
        Skeleton.ClearMap();
        Skeleton.LogOff();
        Pipe.ResetCounter();

        Mechanic m = new Mechanic();
        Skeleton.AddObject(m, "m");

        Cistern c = new Cistern();
        Skeleton.AddObject(c, "c");

        Pump pump = new Pump();
        Skeleton.AddObject(pump, "pump");

        Pipe pipe = new Pipe(c);
        Skeleton.AddObject(pipe, "pipe");
        List<PipeEnd> ends = pipe.GetEnds();
        Skeleton.AddObject(ends.get(0), "end1");
        Skeleton.AddObject(ends.get(1), "end2");

        ends.get(1).ConnectNode(pump);
        m.Move(c);

        //létrehozott objektumok és állapotuk feltüntetése a konzolon
        System.out.println("\nThe test will run on the following objects:");
        System.out.println(
                "c:Cistern \n" +
                        "m:Mechanic standing on cistern \n" +
                        "pump: Pump \n" +
                        "pipe: Pipe connecting pump and cistern \n" +
                        "end1/end2: the ends of pipe \n" +
                        "newPump: the placed pump \n" +
                        "newPipe: the created pipe \n" +
                        "end21/end22: the ends of newPipe");

        //Tester függvényhívásai
        System.out.print("\nThe next functions were called during the test:");
        Skeleton.LogOn();

        m.PickupPump();
        m.Move(pipe);
        m.PlacePump();
    }
}
