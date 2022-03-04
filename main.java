public class Main {

  //REQUIRES: String 
  //MODIFIES: none
  //EFFECTS: removes any rows from the data (in CSV format) of string 'S' and
  //returns the updated data in a string (in CSV format)
  public static String removeNullRows(String S){  //made static to be able to use in main function as an example
    String rows[] = S.split("\n", S.length()); //array to store individual rows
    
    String temp[] = rows[0].split(",", S.length()); //temporary array to be used to store each row's cell values, also to get column length
    int i, j; //loop counter variables
    int colLen = temp.length, rowLen=rows.length; //store row and column length in variables to increase program execution speed
    int skip[]= new int[rowLen]; //to store row numbers with a "NULL" cell, i.e. skipped rows 
    
    for(i=0;i<rowLen;i++){
      temp = rows[i].split(",", colLen); //stores the cell values in the 'temp' array
      for(j=0;j<colLen;j++){  //this will check each cell value 
        if(temp[j].equals("NULL")){
          skip[i]++; //set the value of the row's index in skip[] to 1
          break; //breaks out of nested loop to increase program efficiency
        }      
      }
    }
    String answer = "";  
    for(i=0;i<rowLen;i++){
      if(skip[i]!=1) //if the value is NOT 1 (valid row), add it to final answer
        answer += rows[i] + "\n"; 
    }
   return answer; //final answer is returned in CSV format, the same format as the argument string
  }
  
  //I've included a main function to demonstrate the correctness of the function
  public static void main(String[] args) {
    String input = "ID,First Name,Last Name\n88,Susie,NULL\n44,Jack,Smith\n22,NULL,NULL\n98,Fred,Anullo"; //first row contains column headers
    System.out.println(removeNullRows(input)); //function will remove second and fourth rows
  }
}
