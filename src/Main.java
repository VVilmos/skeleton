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
            System.out.println("X: Exit\n");
            System.out.print("Enter your choice: ");

            Scanner scanner = new Scanner(System.in);
            int no = scanner.nextInt();

            if (no == 1) Tester.LeakingPipeRepair();
            if (no == 10) Tester.GetPumpAtCistern();

            System.out.print("\nDo you want to try another test case [y/n]? ");
            char ans = scanner.next().charAt(0);
            if (ans == 'n') break;
        }

    }
}