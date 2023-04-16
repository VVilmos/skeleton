import Model.Cistern;
import Model.Mechanic;
import Model.Pipe;
import Model.Player;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Welcome to our testing programme! Please choose a test case from the following list!");
        while(true) {
            System.out.println("1: Repairing a leaking pipe and testing it afterwards");
            System.out.println("2: Stepping to a pump, then switching and steping it");
            System.out.println("3: Disconnecting a full Pipe from Pump");
            System.out.println("4: Stepping cistern");

            System.out.println("8: Player steps 2");
            System.out.println("9: Connect Pipe to Pump");
            System.out.println("10: Step on Cistern and picks up Pipe");
            System.out.println("11: Break Pipe, then it accepts water");

            System.out.println("12: Second person tries to step on Pump");
            System.out.println("13: Tester steps on Cistern and picks up Pump");
            System.out.println("14: Pump breaks with full Tank and steps two times");
            System.out.println("15: Place pump");
            System.out.println("X: Exit\n");
            System.out.print("Enter your choice: ");

            Scanner scanner = new Scanner(System.in);
            int no = scanner.nextInt();
            
            //Vili
            if (no == 1) Tester.LeakingPipeRepair();
            if (no == 2) Tester.SteppingToAndSwitchPump();
            if (no == 3) Tester.DisconnectingFullPipe();
            if (no == 4) Tester.CisternSteps();

            //Viola
            if(no == 8) Tester.PlayerSteps2();
            if(no == 9) Tester.ConnectPipeToPump();
            if(no == 10) Tester.StepOnCisternAndPicksUpPipe();
            if(no == 11) Tester.BreakPipeAndItAcceptsWater();

            //Blanka
            if (no == 12) Tester.SecondStepOnPump();
            if (no == 13) Tester.GetPumpAtCistern();
            if (no == 14) Tester.BreakPumpAndTwoStep();
            if (no == 15) Tester.PlacePump();

            System.out.print("\nDo you want to try another test case [y/n]? ");
            char ans = scanner.next().charAt(0);
            if (ans == 'n') break;
        }
    }
}