import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class Main
{
    public static void main(String[] args)
    {
        int depth = 0;
        int hor_pos = 0; 
        int result = 0;
        int value = 0;
        int aim = 0;
        String line = null;
        Character check = null;
        try
        {
            FileReader fileReader = new FileReader("input.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null)
            {
                value = Integer.parseInt(line.replaceAll("[^0-9]",""));
                check = line.charAt(0);

                if (check == 'f'){
                    hor_pos = hor_pos + value;
                    depth = depth + (value * aim);
                } else if (check == 'd'){
                    aim = aim + value;
                } else if (check == 'u'){
                    aim = aim - value;
                } 
            }
            bufferedReader.close();
            result = depth * hor_pos;
            
            System.out.println("\nadvent of code day two");
            System.out.println("\ndepth = " + depth + "\nhorizontal position = " + hor_pos + 
            "\ndepth x horizontal position = " + result);
        }
        catch(IOException ex)
        {
            System.out.println("\nError occurred");
            System.out.println("Exception Name: " +ex);
        }
    }
}