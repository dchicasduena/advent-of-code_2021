
import java.util.ArrayList;

 class PartOne{
    public void finder_best(ArrayList<String>nums, ArrayList<Integer> bnums, int[][][] bcards){
        int rows = 0;
        int cols = 0;
        for (int i = 0; i < nums.size(); i += 6) {
            nums.remove(i);
            i--;
        }

        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(nums.get(i).substring(j * 3, j * 3 + 2).replaceAll("\\s+", ""));
                bcards[i / 5][i % 5][j] = num;
            }
        }

        for (int x = 0; x < bnums.size(); x++) {
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 5; j++) {
                    for (int k = 0; k < 5; k++) {
                        if (bcards[i][j][k] == bnums.get(x)) {
                            bcards[i][j][k] = -1;
                        }
                    }
                }

                // check rows
                for (int j = 0; j < 5; j++) {
                    for (int k = 0; k < 4; k++) {
                        if (bcards[i][j][k] == bcards[i][j][k + 1]) {
                            rows++;
                            if (rows == 4) {
                                bingo(bcards,i,bnums,x);
                                break;
                            }
                        } else {
                            rows = 0;
                        }
                    }
                }

                //check columns
                for (int k = 0; k < 5; k++) {
                    for (int j = 0; j < 4; j++) {
                        if (bcards[i][j][k] == bcards[i][j + 1][k]) {
                            cols++;
                            if (cols == 4) {
                                bingo(bcards,i,bnums,x);
                                break;
                            }
                        } else {
                            cols = 0;
                        }
                    }
                }
            }
        }
    }

    public void bingo(int[][][] bcards, int i, ArrayList<Integer> bnums, int x) {
        int sum = 0;

        for (int j = 0; j < 5; j++) {
            for (int k = 0; k < 5; k++) {
                if (bcards[i][j][k] != -1) {
                    sum += bcards[i][j][k];
                }
            }
        }

        System.out.println("\nadvent of code day four - part 1\n");
        System.out.println("winner number = " + bnums.get(x) + "\nsum = " + sum + "\nnumber * sum = " + (bnums.get(x) * sum));
        System.exit(0);
    }
}