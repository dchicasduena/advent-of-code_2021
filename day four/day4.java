import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

 class Main{
    public static void main(String[] args){
        String next = null;
        String line = null;
        int[][][] cards = new int[100][5][5];
        ArrayList <String> numbers = new ArrayList<String>();
        ArrayList<Integer> bingoNums = new ArrayList<Integer>();

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

        } catch(IOException ex) {
            System.out.println("\nError occurred");
            System.out.println("Exception Name: " +ex);
        }

        for (int i = 0; i < numbers.get(0).length() - 2; i++) {
            bingoNums.add(Integer.parseInt(numbers.get(0).substring(i, numbers.get(0).indexOf(',', i))));
            i = numbers.get(0).indexOf(',', i);
        }

        bingoNums.add(Integer.parseInt(numbers.get(0).substring(numbers.get(0).lastIndexOf(',') + 1)));
        numbers.remove(0);

        if (args[0].equals("p1")){
            PartOne p1 = new PartOne();
            p1.finder_best(numbers, bingoNums, cards);
        } else if (args[0].equals("p2")){
            PartTwo p2 = new PartTwo();
            p2.finder_worst(numbers, bingoNums, cards);
        } else {
            System.out.println("wrong argument use p1 for part one or p2 for part two");
            System.exit(0);
        }
    }
}