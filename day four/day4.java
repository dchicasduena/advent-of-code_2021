import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class Main
{
    public static void main(String[] args)
    {
        String next = null;
        String line = null;
        ArrayList <String> input = new ArrayList<String>();

        try
        {
            FileReader fileReader = new FileReader("input.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null)
            {
                next = line;
                input.add(next);

            }
            bufferedReader.close(); 
            System.out.println("advent of code day four");       
            System.out.println(input.get(3));   
        }
        catch(IOException ex)
        {
            System.out.println("\nError occurred");
            System.out.println("Exception Name: " +ex);
        }
    }
}
