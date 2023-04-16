import Model.*;

import java.util.List;

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
}
