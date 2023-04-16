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
        pi.AcceptPlayer(m1);
        pu.AcceptPlayer(m2);

        System.out.println("\nSecond person tries to step on Pump");
        System.out.println("\nThe test will run on the following objects:");
        System.out.println("m1: Mechanic standing on Pipe pi \n" +
                "m2: Mechanic standing on Pump pu\n" +
                "pu: Pump that Mechanic m1 will step on \n" +
                "pi: Pipe which is connected to Pump pu");

        System.out.print("\nThe next functions were called during the test:");
        Skeleton.LogOn();
        m2.Move(pu);
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
        pi.AcceptPlayer(m);

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





}
