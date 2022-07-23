package Assign1;
import java.lang.Math;
import java.io.FileWriter;
import java.io.IOException;

//sorting class to perform the sort techniques
public class Sorting {
	public static int Size(LinkedNode<Integer> Head) {
		int size = 0;
		LinkedNode<Integer> curr = Head;
		while(curr!= null) {
			size++;
			curr = curr.getNext();
		}
		return size;
		
	}
	
	//Implementing bubble sort
	public static LinkedNode<Integer> bubbleSort(LinkedNode<Integer> head) {

		try(FileWriter fw = new FileWriter("BOutput.txt", true))
		{
			fw.write("\n");
		int cmp1 = 0;
		int exch1 = 0;
		int pass1 = 0;
		boolean change;
		for(int i = 0; i < Size(head)-1; i++) {
			change = false;
			pass1++;
			//curr node
			LinkedNode<Integer> curr = head;
			//next node 
			LinkedNode<Integer> next = curr.getNext();
			//previous node
			LinkedNode<Integer> prev = null;
			
			for(int j = 0 ; j < Size(head)-i-1 ; j++){
				cmp1++;
				if(curr.getElement()>next.getElement()) {
					change = true;
					exch1++;
				if(prev==null) {
					head = next;
					LinkedNode<Integer> temp = next.getNext();
					next.setNext(curr);
					curr.setNext(temp);
					
			
				}
				else {
					LinkedNode<Integer> temp = next.getNext();
					prev.setNext(next);
					next.setNext(curr);
					curr.setNext(temp);
					
	
				}
				prev = next;
				next = curr.getNext();
				
			}
				
				else {
				//move the nodes one step forward
				prev = curr;
				curr = next;
				next = next.getNext();
				
			}
				
			}
		if(!change) {
			break;
		}
			
				fw.write(pass1+"      "+ cmp1 +"      " + exch1+"\n");
		
			//System.out.printf();
		}
		
		fw.write("------------------------------------");
	}
		catch(IOException e) {
		System.out.println("File can not be created");
	}
		return  head;
	}
	
	//implementing shell sort
	public static LinkedNode<Integer> shellSort(LinkedNode<Integer> head) {
		try(FileWriter kw = new FileWriter("SOutput.txt", true)){
			kw.write("\n");
		int k = 1,comp,pass,exch;
		comp = 0;
		pass = 0;
		exch=0;
		int interval = 0;
		while(interval < Size(head)/3) {
			interval=  ((int)(Math.pow(3, k) - 1)/2);
			k++;
		}
		System.out.println("No. of Passes, comparisons and exchanges: ");
			while(interval>= 1) {
				
				for(int i = 0; i <Size(head)-1; i = i +interval) {
					
					
					pass+=1;
					LinkedNode<Integer> curr = head;
					LinkedNode<Integer> prev_Next =Interval_Jump(interval-1,head);
					LinkedNode<Integer> prev = null;
					LinkedNode<Integer> next = prev_Next.getNext();
					for(int j = 0; j<Size(head)-interval-i;  j+=interval) { //compa
						comp+=1;
						
						if(curr.getElement()>next.getElement()) {
							exch++;
							if(interval ==1){

								if(prev==null) {
									head = next;
									LinkedNode<Integer> temp = next.getNext();
									next.setNext(curr);
									curr.setNext(temp);
								
								}
								else {
									LinkedNode<Integer> temp = next.getNext();
									prev.setNext(next);
									next.setNext(curr);
									curr.setNext(temp);
							
					
								}
								prev = next;
								next = curr.getNext();
							}
							else{
							if(prev==null) {
								head = next;
								LinkedNode<Integer> temp = next.getNext();
								next.setNext(curr.getNext());
								curr.setNext(temp);
								prev_Next.setNext(curr);
							}
							else {
								LinkedNode<Integer> temp = next.getNext();
								prev.setNext(next);
								next.setNext(curr.getNext());
								curr.setNext(temp);
								prev_Next.setNext(curr);
							}
							
							prev = next;
							curr = prev.getNext();
							prev_Next = prev_Next.getNext();
							next = prev_Next.getNext();
						
							}
							
						}
						else {
							prev = curr;
							curr = curr.getNext();
							prev_Next = prev_Next.getNext();
							next = next.getNext();
						}

					
					}
				}
				kw.write(interval+"      "+ pass +"      "+comp +"      " + exch+"\n");
				
				System.out.printf("%d %d %d %d %n",interval,pass,comp,exch);  
				
				interval = interval/3;
				
				
			}
			pass+=pass;
			comp+=comp;
			exch+=exch;
			kw.write("------------------------------------\n");
			kw.write("Total: \t");
			kw.write(pass +"      "+comp +"      " + exch+"\n");
		}
		catch(IOException e) {
			System.out.println("File can not be created");
		}
		return head;
		
	}
	
	//helper method for the shell sort to implement the intervals
	private static LinkedNode<Integer> Interval_Jump(int interval,LinkedNode<Integer> start) {
		LinkedNode<Integer> temp = start;
		for(int i = 0 ; i < interval ; i++ ) {
					temp = temp.getNext();
				}
		return temp;
	}
	
	
	
}