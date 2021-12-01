import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class Main
{
    public static void main(String[] args)
    {
        // part one
        int increment = 0;
        int old = 0;
        int next = 0;
        String line = null;
        ArrayList <Integer> numbers = new ArrayList<Integer>();
        try
        {
            FileReader fileReader = new FileReader("input.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null)
            {
                next = Integer.valueOf(line);
                numbers.add(next);
                if (next > old)
                {
                    increment++;
                }
                old = next;
            }
            bufferedReader.close();
            System.out.println("\nadvent of code day one");
            System.out.println("\nnumber of increments = " + (increment-1));
        }
        catch(IOException ex)
        {
            System.out.println("\nError occurred");
            System.out.println("Exception Name: " +ex);
        }
        // part 2
        int increment2 = 1;
        int sum = numbers.get(0) + numbers.get(1) + numbers.get(2);
        for (int i = 1; i < numbers.size() - 3; i++)
        {
            int other_sum = numbers.get(i) + numbers.get(i + 1) + numbers.get(i +2);

            if (other_sum > sum){
                increment2++;
            }

            sum = other_sum;
        }
        System.out.println("number of increments part 2 = " + (increment2) + "\n");
    }
}