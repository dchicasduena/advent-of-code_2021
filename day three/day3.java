import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


class Main
{
    //part one
    public static void main(String[] args)
    {
        int ones = 0;
        int zeros = 0;
        String gamma_rate = "";
        String epsilon_rate = "";
        String next = null;
        String line = null;
        ArrayList <String> numbers = new ArrayList<String>();

        try
        {
            FileReader fileReader = new FileReader("input.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null)
            {
                next = line;
                numbers.add(next);
            }
            bufferedReader.close();
            
            System.out.println("\nadvent of code day three");
        }
        catch(IOException ex)
        {
            System.out.println("\nError occurred");
            System.out.println("Exception Name: " +ex);
        }

        for (int i = 0; i < numbers.get(0).length(); i++){
            for (int j = 0; j < numbers.size(); j++){
                Character bit = numbers.get(j).charAt(i);
                if (bit == '1'){
                    ones += 1;
                } else if (bit == '0'){
                    zeros += 1;
                }
            }

            if (ones > zeros) {
                gamma_rate += '1';
                epsilon_rate += '0';
            } else if (zeros > ones){
                gamma_rate += '0';
                epsilon_rate += '1';
            }
        ones = 0;
        zeros = 0;
        }

        int gamma_r = Integer.parseInt(gamma_rate,2);
        System.out.println("\ngamma rate = " + gamma_rate + "(" + gamma_r + ")");
        int epsilon_r = Integer.parseInt(epsilon_rate,2);
        System.out.println("epsilon rate = " + epsilon_rate + "(" + epsilon_r + ")");
        System.out.println(gamma_r + " x " + epsilon_r + " = " + (gamma_r * epsilon_r) + "\n");
    }
}