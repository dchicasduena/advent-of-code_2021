import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class Main
{
    // part one
    public static void main(String[] args)
    {
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
        }
        catch(IOException ex)
        {
            System.out.println("\nError occurred");
            System.out.println("Exception Name: " +ex);
        }
        part1(numbers);
        part2(numbers);
    }

    public static String part1(ArrayList<String> numbers){
        int ones = 0;
        int zeroes = 0;
        String gamma_rate = "";
        String epsilon_rate = "";

        for (int i = 0; i < numbers.get(0).length(); i++){
            for (int j = 0; j < numbers.size(); j++){
                Character bit = numbers.get(j).charAt(i);
                if (bit == '1'){
                    ones += 1;
                } else if (bit == '0'){
                    zeroes += 1;
                }
            }

            if (ones > zeroes) {
                gamma_rate += '1';
                epsilon_rate += '0';
            } else if (zeroes > ones){
                gamma_rate += '0';
                epsilon_rate += '1';
            }
        ones = 0;
        zeroes = 0;
        }

        System.out.println("\nadvent of code day three - part 1");
        int gamma_r = Integer.parseInt(gamma_rate,2);
        System.out.println("\ngamma rate = " + gamma_rate + "(" + gamma_r + ")");
        int epsilon_r = Integer.parseInt(epsilon_rate,2);
        System.out.println("epsilon rate = " + epsilon_rate + "(" + epsilon_r + ")");
        System.out.println(gamma_r + " x " + epsilon_r + " = " + (gamma_r * epsilon_r) + "\n");
        return null;
    }

    public static String part2(ArrayList<String> numbers){
        ArrayList<String> oxygen = new ArrayList<String>(numbers);
		ArrayList<String> co2 = new ArrayList<String>(numbers);

        // oxygen
		int column = 0;
		while (oxygen.size() > 1) {
			int ones = 0;
			int zeroes = 0;
			for (int row = 0; row < oxygen.size(); row++) {
				if (oxygen.get(row).charAt(column) == '0')
					zeroes++;
				else
					ones++;
			}
			char checkMax = (ones >= zeroes ? '1' : '0');
			for (int row = oxygen.size() - 1; row >= 0; row--) {
				if (oxygen.get(row).charAt(column) != checkMax)
					oxygen.remove(row);
			}
			column++;
        }
        
        // co2
		column = 0;
		while (co2.size() > 1) {
			int ones = 0;
			int zeroes = 0;
			for (int row = 0; row < co2.size(); row++) {
				if (co2.get(row).charAt(column) == '0')
					zeroes++;
				else
					ones++;
			}
			char checkMin = (ones >= zeroes ? '0' : '1');
			for (int row = co2.size() - 1; row >= 0; row--) {
				if (co2.get(row).charAt(column) != checkMin)
					co2.remove(row);
			}
			column++;
		}

    System.out.println("\nadvent of code day three - part 2");
    int oxygen_r = Integer.parseInt(oxygen.get(0),2);
    System.out.println("\noxygen = " + oxygen.get(0) + "(" + oxygen_r + ")");
    int co2_r = Integer.parseInt(co2.get(0),2);
    System.out.println("co2 = " + co2.get(0) + "(" + co2_r + ")");
    System.out.println(oxygen_r + " x " + co2_r + " = " + (oxygen_r * co2_r) + "\n");
    return null;
    }
}