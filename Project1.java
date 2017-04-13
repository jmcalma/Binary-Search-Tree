package edu.cpp.cs.cs241.Project1;
import java.util.*;

public class Project1 {
	public static void main(String[] args){
		Scanner read = new Scanner(System.in);
		BST tree = new BST();
		boolean exit = false;
		
		while(exit == false){
			if(tree.isEmpty()){
				System.out.println("Please enter the initial sequence of values to create a Binary Search Tree:");
				String input = read.nextLine();
				String[] numbers = input.split(" ");
				for(int i = 0; i < numbers.length; i++){
					tree.insert(Integer.parseInt(numbers[i]));
				}
				System.out.print("Pre-order: "); 
				tree.preOrder();
				System.out.println();
				System.out.print("In-order: "); 
				tree.inOrder();
				System.out.println();
				System.out.print("Post-order: "); 
				tree.postOrder();
				System.out.println();
				System.out.println("Here are the commands you can perform:");
				System.out.println("I (insert value here)  Insert a value");
				System.out.println("D (insert value here)  Delete a value");
				System.out.println("P (insert value here)  Find predecessor");
				System.out.println("S (insert value here)  Find successor");
				System.out.println("E  Exit the program");
				System.out.println("H  Display commands");
				System.out.print("Please enter a command. ");
			}
			String input = read.next();
			if(input.equals("I")){
				tree.insert(read.nextInt());
				System.out.print("In-order: ");
				tree.inOrder();
				read.nextLine();
			}
			else if(input.equals("D")){
				tree.delete(read.nextInt());
				System.out.print("In-order: ");
				tree.inOrder();
				read.nextLine();
			}
			//else if(input.equals("P")){
				
			//	read.nextLine();
			//}
			//else if(input.equals("S")){
				
			//	read.nextLine();
			//}
			else if(input.equals("E")){
				exit = true;
				System.out.println("Good bye.");
			}
			else if(input.equals("H")){
				System.out.println("Here are the commands you can perform:");
				System.out.println("I (insert value here)  Insert a value");
				System.out.println("D (insert value here)  Delete a value");
				System.out.println("P (insert value here)  Find predecessor");
				System.out.println("S (insert value here)  Find successor");
				System.out.println("E  Exit the program");
				System.out.println("H  Display commands");
				read.nextLine();
			}
			if(!input.equals("E")){
				System.out.println();
				System.out.print("Please enter a command. ");
			}
		}
		read.close();
	}
	
}
