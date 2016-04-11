package classes;  
  
  
public class MultiplicationTable {  
  
public class Main {  
      private int number;  
      private int max_number = 9;  
    
      public static void main(String[] args) {  
        MultiplicationTable mtable = new MultiplicationTable();  
        Main mtable = new Main();  
    
        mtable.max_number = 19;
        mtable.setMaxNumber(19);   
        mtable.setMaxNumber(9);  
  
        for(int i=2; i<10; i++){  
            System.out.println(i+"단");  
            mtable.setNumber(i);  
            mtable.printTable();  
        }  
    
        mtable.setNumber(4);  
        mtable.printTable();  
      }  
  } 
