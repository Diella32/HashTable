package tableTest;

import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import doubleHashingPD.doubleHashing;
import linearProbingPD.LinearProbing;

public class main<E> {
	public static void main(String[] args) {
	String fileUsed = "hashdata.csv";
	int numberOfCollisions = 0; 
	String line = null;
	String dataType; 
	Student student;  
	String[] stringUsed; 
	//LinearProbing<Student> elementUsedLP = new LinearProbing<Student>(100) ; 
	doubleHashing<Student> elementUsedDH = new doubleHashing<Student>(100) ; 
// w3 schools
	// call all tests in main
	int id = 0; 


try {
         FileReader fileReader =  new FileReader("C:\\Users\\diell\\Downloads\\hashdata.csv");

         BufferedReader bufferedReader = new BufferedReader(fileReader);
         
         while((line = bufferedReader.readLine())!= null) {
        	 stringUsed = line.split(","); 
        	 student = new Student(Integer.parseInt(stringUsed[0]), stringUsed[1]); 
        	 numberOfCollisions += elementUsedDH.put(student.getKey(), student);
        	  
         }
}

catch(FileNotFoundException ex) 
	 {
	   System.out.println( "Unable to open file '" +  fileUsed + "'");                
	 }
catch(IOException ex) 
	 {
	    System.out.println (  "Error reading file '" + fileUsed + "'");   	
	 }

	
	System.out.println("Test HashTableDH with table size 100 ");
	System.out.print("Number of Collisions " + " = " );
	System.out.println(numberOfCollisions); 
	System.out.println("Name = " + elementUsedDH.get(782209).getElement());
	elementUsedDH.Remove(782209).getElement();
	System.out.println("Delete element");
	 if (elementUsedDH.get(782209) == null) {
		 System.out.println("782209" + " not found"); 
	 }	

	 
	}
	
}
