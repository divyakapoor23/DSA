package Assign1;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.*;

//testing class to test the sorting techniques
public class Tester {
	
	public static void main(String[] args) {
		System.out.print("Please enter a file name: ");
		Scanner s = new Scanner(System.in);
		String fileName = s.nextLine();
		long beginShell = System.currentTimeMillis();    
		LinkedNode<Integer> head1 = readValues(fileName);
		shellSortResults(head1);
		long timeSort = System.nanoTime() - beginShell;
		System.out.println("Time to perform Shell Sort: " + timeSort + " ms");
		long beginBubble = System.currentTimeMillis(); 
		LinkedNode<Integer> head = readValues(fileName);
		System.out.println();
		bubbleSortResults(head);
		long timeBubble = System.nanoTime() - beginBubble;
		System.out.println("Time to perform Bubble sort: " + timeBubble + " ms");
		

	
		
		
	}
	
	//results for bubble sort
	public static void bubbleSortResults(LinkedNode<Integer> head) {
		//create an output file
		//heading no of passes comp, exchanges
		

		try {
			FileWriter n = new FileWriter("BOutput.txt");
			n.write("pass     cmp     	exch\n");
			n.write("------------------------------------");
			n.close();
		}
		catch(IOException e) {
			System.out.println("File can not be created");
		}
	
		head = Sorting.bubbleSort(head);
		System.out.println("**************Bubble Sort****************\n");
		displayList(head);
		
	}

	//results for shell sort
	public static void shellSortResults(LinkedNode<Integer> head) {
		try {
			FileWriter n = new FileWriter("SOutput.txt");
			n.write("k 	pass	cmp    exch\n");
			n.write("------------------------------------");
			n.close();
		}
		catch(IOException e) {
			System.out.println("File can not be created");
		}
		head = Sorting.shellSort(head);
		System.out.println("**************Shell Sort****************\n");
		displayList(head);
		
	}

	//reading the values from the file
	public static LinkedNode<Integer> readValues(String fileName) {
		File f = new File(fileName);
		LinkedNode<Integer> head = new LinkedNode<>();
		try {
			Scanner sc = new Scanner(f);
			head.setElement(sc.nextInt());
			LinkedNode<Integer> curr = head;
			while(sc.hasNextInt())
			{
				LinkedNode<Integer> temp = new LinkedNode<>(sc.nextInt());
				curr.setNext(temp);
				curr = curr.getNext();
			}
		}
		catch(Exception e) {
			System.out.println("No values");
		}
		return head;
	}
	
	//displaying the list
	public static void displayList(LinkedNode<Integer> head) {
		LinkedNode<Integer> curr = head;
		int ind = 0;
		while(curr !=null) {
			System.out.print(curr.getElement());
			System.out.print(" ");
			curr = curr.getNext();
			ind++;
			if(ind %10==0) {
				System.out.println();
			}
		}
		System.out.println();
	}

}


