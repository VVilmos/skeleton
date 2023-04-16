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

    public static void PlacePump() {
        Skeleton.ClearMap();
        Skeleton.LogOff();

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
                "newEnd1/newEnd2: the ends of newPipe");

        //Tester függvényhívásai
        System.out.print("\nThe next functions were called during the test:");
        Skeleton.LogOn();

        m.PickupPump();
        m.Move(pipe);
        m.PlacePump();
    }
}
