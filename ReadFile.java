import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class ReadFile {

    public static void main(String[] args) throws IOException {

    	Scanner scan = new Scanner(new File("JavaFiles/Properties.csv"));
    	ArrayList<String[]> properties = new ArrayList<String[]>();
    	String[] property = new String[2];
    	String owners = "Owners";
    	while(scan.hasNext())
    	{
    		
    	property = scan.nextLine().split(",");
    	if (property[0].equals("Owners")) {
    	    continue;
    	    } 
    	    else {
    	    	properties.add(property);
    	}
    	
    	    for(int i = 0; i < properties.size(); i++)
    	    {
    	        for(int j = 0; j < properties.get(i).length; j++)
    	        {
    	            System.out.print(properties.get(i)[j] + " ");
    	        }
    	        System.out.print("\n");
    	    }
    	    
        }
    }
}