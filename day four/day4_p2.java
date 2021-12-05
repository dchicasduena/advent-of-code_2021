
import java.util.ArrayList;

 class PartTwo{
    public void finder_worst(ArrayList<String>nums, ArrayList<Integer> bnums, int[][][] bcards){  
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
                if (bcards[i] != null) {
                    for (int j = 0; j < 5; j++) {
                        for (int k = 0; k < 5; k++) {

                            if (bcards[i][j][k] == bnums.get(x)) {
                                bcards[i][j][k] = -1;

                            }
                        }
                    }

                    int rem = 0;
                    int last = 0;
                    for (int s = 0; s < bcards.length; s++) {
                        if (bcards[s] != null) {
                            rem++;
                            last = s;
                        }
                    }

                    // check rows
                    for (int j = 0; j < 5; j++) {
                        if (bcards[i] == null) {
                            break;
                        }
                        for (int k = 0; k < 4; k++) {
                            if (bcards[i][j][k] == bcards[i][j][k + 1]) {
                                rows++;
                                if (rows == 4 && rem == 1) {
                                    bingo(bcards, x, last, bnums);
                                }
                                if (rows == 4) {
                                    bcards[i] = null;
                                    break;
                                }
                            } else {
                                rows = 0;
                            }
                        }
                    }

                    for (int k = 0; k < 5; k++) {
                        if (bcards[i] == null) {
                            break;
                        }
                        for (int j = 0; j < 4; j++) {
                            if (bcards[i][j][k] == bcards[i][j + 1][k]) {
                                cols++;
                                if (cols == 4 && rem == 1) {
                                    bingo(bcards, x, last, bnums);
                                }
                                if (cols == 4) {
                                    bcards[i] = null;
                                    break;
                                }
                            } else {
                                cols = 0;
                            }
                        }
                    }
                    rem = 0;
                }
            }
        }
    }

    public void bingo(int[][][] bcards, int a, int last, ArrayList<Integer> bnums) {
        int sum = 0;

        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 5; y++) {
                if (bcards[last][x][y] != -1) {
                    sum += bcards[last][x][y];
                }
            }
        }
        
        System.out.println("\nadvent of code day four - part 2\n");
        System.out.println("winner number = " + bnums.get(a) + "\nsum = " + sum + "\nnumber * sum = " + (bnums.get(a) * sum));
        System.exit(0);
    }
}