package construction;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Scanner;

public class SkyscraperConstruction {

  public static boolean isLargestAvailable(Queue<Integer> q, int n) {
    Queue<Integer> copyQ = new LinkedList<Integer>(q);
    int largest = Integer.MIN_VALUE;
    while(!copyQ.isEmpty()) {
      int i = copyQ.poll();
      if(i>largest)
        largest = i;
    }
    return n>=largest;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter the total number of floors in the building:");
    int n = scanner.nextInt();

    Queue<Integer> floorSizes = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      System.out.println("Enter the floor size given on day " + (i + 1) + ":");
      int floorSize = scanner.nextInt();
      floorSizes.offer(floorSize);
    }

    Stack<Integer> floorsToAssemble = new Stack<>();

    System.out.println("The order of construction is as follows:");
    System.out.println();

    for(int i = 0;i<n;i++) {
      System.out.println("Day: " + (i+1));
      int floor = floorSizes.poll();
      floorsToAssemble.push(floor);
      if(isLargestAvailable(floorSizes, floor)) {
        while(!floorsToAssemble.isEmpty()) {
          System.out.print(floorsToAssemble.pop() + " ");
        }
      }
      System.out.println();
    }
  }
}
