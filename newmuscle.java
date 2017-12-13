import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

/**
 * this class is to create muscle object and search it.
 */
    public class newmuscle {

        /** for searching. */
        static Scanner scan = new Scanner(System.in);
        /** name of muscle.*/
        private String name = "";
        /**action of muscle.*/
        private String action = "";
        /**origin of muscle.*/
        private String origin = "";
        /**insertion of muscle.*/
        private String insertion = "";
        /**innervation of muscle.*/
        private String innervation = "";

        /**the cell activation of muscle. */
        private int[][] neuron = new int[10][10];

        /** shape A for the cell activation of muscle. */
        public static int[][] LETTER_A = new int[][] {{-1,-1,-1,-1,1,1,-1,-1,-1,-1}, {-1,-1,-1,1,1,1,1,-1,-1,-1},
                {-1,-1,1,1,-1,-1,1,1,-1,-1}, {-1,1,1,-1,-1,-1,-1,1,1,-1},
                {-1,1,1,1,1,1,1,1,1,-1}, {1,1,1,1,1,1,1,1,1,1},
                {1,1,1,-1,-1,-1,-1,1,1,1}, {1,1,-1,-1,-1,-1,-1,-1,1,1},
                {1,1,-1,-1,-1,-1,-1,-1,1,1}, {1,1,-1,-1,-1,-1,-1,-1,1,1}};

        /** shape A for the cell activation of muscle. */
        public static int[][] LETTER_B = new int[][] {{1,1,1,1,1,-1,-1,-1,-1,-1},{1,1,-1,-1,1,1,-1,-1,-1,-1},
                  {1,1,-1,-1,1,1,-1,-1,-1,-1},{1,1,-1,-1,1,1,-1,-1,-1,-1},
                  {1,1,1,1,1,-1,-1,-1,-1,-1},{1,1,1,1,1,-1,-1,-1,-1,-1},
                  {1,1,-1,-1,1,1,-1,-1,-1,-1},{1,1,-1,-1,1,1,-1,-1,-1,-1},
                  {1,1,-1,-1,1,1,-1,-1,-1,-1},{1,1,1,1,1,-1,-1,-1,-1,-1}};

        /** shape B for the cell activation of muscle. */
        public static int[][] LETTER_C = new int[][] {{-1,1,1,1,1,1,1,-1,-1,-1},{1,1,1,1,1,1,1,-1,-1,-1},
                  {1,1,1,-1,-1,-1,-1,-1,-1,-1},{1,1,-1,-1,-1,-1,-1,-1,-1,-1},
                  {1,1,-1,-1,-1,-1,-1,-1,-1,-1},{1,1,-1,-1,-1,-1,-1,-1,-1,-1},
                  {1,1,1,-1,-1,-1,-1,-1,-1,-1},{1,1,1,-1,-1,-1,-1,-1,-1,-1},
                  {1,1,1,1,1,1,1,-1,-1,-1},{-1,1,1,1,1,1,1,-1,-1,-1}};


        /**setter for neuron of muscle. */
        public void setNeuron() {
            int[][] neuron = {{-1,1,-1,1,-1,1,-1,-1,-1,-1},{-1,1,-1,1,1,1,1,-1,-1,-1},
                    {1,-1,1,1,-1,-1,1,1,-1,-1},{-1,1,1,-1,1,-1,-1,1,1,-1},
                    {1,-1,1,1,1,-1,-1,1,1,-1}, {1,1,-1,1,1,1,1,1,-1,1},
                    {1,1,1,-1,1,-1,-1,1,1,1},{1,1,-1,1,-1,-1,-1,-1,1,1},
                    {1,-1,-1,-1,-1,-1,-1,1,1,1},{1,1,1,-1,-1,-1,-1,-1,1,-1}};

            this.neuron = neuron;

        }
        public void setName () {
            System.out.println("Enter the name of the muscle: ");
            this.name = scan.nextLine();

        }
        public void setAction () {
            System.out.println("Enter the action of the muscle: ");
            this.action = scan.nextLine();
        }
        public void setOrigin () {
            System.out.println("Enter the origin of the muscle: ");
            this.origin = scan.nextLine();
        }
        public void setInsertion () {
            System.out.println("Enter the insertion of the muscle: ");
            this.insertion = scan.nextLine();
        }
        public void setInnervation () {
            System.out.println("Enter the innervation of the muscle: ");
            this.innervation = scan.nextLine();
        }

        public newmuscle () {
            this.setName();
            this.setAction();
            this.setOrigin();
            this.setInsertion();
            this.setInnervation();

        }


         public static newmuscle[] createMuscles () {
              System.out.println("How many muscles do you want to put into the list?");
                int num = Integer.parseInt(scan.nextLine());
                while (num <= 0) {
                    System.out.println("Please enter the valid number");
                    num = Integer.parseInt(scan.nextLine());
                }


                newmuscle[] muscleList = new newmuscle[num];
                for (int i = 0; i < muscleList.length; i++) {
                    muscleList[i] = new newmuscle();
                    if (i >= 1) {
                        for (int j = 0; j < i; j++) {

                            if (muscleList[i].name.equals(muscleList[j].name)) {
                                System.out.println("there exists the same name of muscle. Please use the other name for muscle");
                                muscleList[i].setName();
                            }

                            }
                        }

          }
                return muscleList;
          }

          public static int searchName (String na, newmuscle[] list) {
              int result = 0;
              if (na == " ") {
                  System.out.println("Please enter the valid name of muscle");
              }
              for (int j = 0; j < list.length; j++) {
                  if (list[j].name.equals(na)) {
                      result = j;
                      break;
                  }
              }
            return result;
          }

          public static String comp (String com, newmuscle m) {
              String result = "";
              String a = "action";
              String o = "origin";
              String i = "inertion";
              String ner = "innervation";


              if (com.equals(a)) {
                  result = m.action;
              }
              if (com.equals(o)) {
                  result = m.origin;
              }
              if (com.equals(i)) {
                  result = m.insertion;
              }
              if (com.equals(ner)) {
                  result = m.innervation;
              }

            return result;




          }
          /**main function. */
          public static void main(final String[] args) {
              newmuscle[] list = createMuscles();
              System.out.println("Which muscle are you looking for?");
              String n = scan.nextLine();
              int a = searchName(n, list);

              System.out.println("Which composition of muscle are you looking for?");
              String com = scan.nextLine();


              String compo = comp(com, list[a]);
              System.out.println("the " + com + " of " + list[a].name + " is " + compo);
              int letter = 0;
              list[a].setNeuron();
              System.out.println("Enter the shape you want to make (1. A, 2. B, 3. C)");


              letter = scan.nextInt();
              int [][] letterg = null;

              int[][] finishline = null;
              if (letter == 1) {
                finishline = list[a].memorize(LETTER_A,list[a].neuron);
                letterg = LETTER_A;
              } else if (letter == 2) {
                finishline = list[a].memorize(LETTER_B,list[a].neuron);
                letterg = LETTER_B;
              } else  {
                 finishline = list[a].memorize(LETTER_C,list[a].neuron);
                 letterg = LETTER_C;
              }


              int[][] reconstruct = finishline;
              int time = 0;
              while (true) {
                  if (reconstruct == LETTER_A) {
                      break;
                  } else {
                      time = time + 1;
                      reconstruct = list[a].memorize(letterg, reconstruct);
                  }
              }

              System.out.println("how long hours you have to exercise for getting a shape you want?");
              System.out.println(time);




          }

public int[][] memorize(final int[][] letter, int[][] premuscle) {

    int m = 1;
    int n = 0;
    int[][] shape = null;
    Random randomGenerator = new Random();
    ArrayList<int[][]> neuron_processing = new ArrayList<int[][]>();
    neuron_processing.add(0,premuscle);
    ArrayList<Integer> energy = new ArrayList<Integer>();
    energy.add(0, 0);
    for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 10; j++) {
            if (j == 9 && j == 9) {
                break;
            }
            if (j < 9) {
                for (int k = j + 1; k < 10; k++) {
                    int a = energy.get(0) - (letter[i][j])^2*letter[i][k]^2;
                    energy.add(0, a);
                }
            }

            for(int s = 0; s < 10; s++) {
                for (int p = 0; p < 10; p++) {
                    int a = energy.get(0) - letter[i][j]^2*letter[s][p]^2;
                }
            }

        }
    }



    for (int x = 0; x < 10; x++) {
        for (int y = 0; y < 10; y++) {

            shape = neuron_processing.get(n);
            shape[x][y] = - shape[x][y];

            m = m + 1;
            int energy_old = 0;
            int energy_new = 0;

            for (int I = 0; I < 10; I++) {
                for (int J = 0; J < 10; J++) {
                    if (I == 9 && J == 9) {
                        break;
                    }

                    if (J < 9) {
                        for (int K = J + 1; K < 10; K++) {
                            int randn = randomGenerator.nextInt(1);
                            if (randn > 0.5) {
                                energy_old = energy_old - shape[I][J]*shape[I][K]*letter[I][J]*letter[I][K];
                            }
                        }
                    }

                    for (int s = I + 1; s < 10; s++) {
                        for (int p = 1; p < 10; p++) {
                            int randn = randomGenerator.nextInt(1);
                            if (randn > 0.5) {
                                energy_old = energy_old - shape[I][J]*shape[s][p]*letter[I][J]*letter[s][p];
                            }
                        }
                    }

                }

            }

            for (int I = 0; I < 10; I++) {
                for (int J = 0; J < 10; J++) {
                    if (I == 9 && J == 9) {
                        break;
                    }

                    if (J < 9) {
                        for (int K = J + 1; K < 10; K++) {
                            int randn = randomGenerator.nextInt(1);
                            if (randn > 0.5) {
                                energy_new = energy_new - shape[I][J]*shape[I][K]*letter[I][J]*letter[I][K];
                            }
                        }
                    }

                    for (int s = I + 1; s < 10; s++) {
                        for (int p = 1; p < 10; p++) {
                            int randn = randomGenerator.nextInt(1);
                            if (randn > 0.5) {
                                energy_new = energy_new - shape[I][J]*shape[s][p]*letter[I][J]*letter[s][p];
                            }
                        }
                    }

                }

            }

            if (energy_new - energy_old < 0) {
                neuron_processing.add(n + 1, shape);
                n = n + 1;
                energy.add(n, energy_new);
            }

        }
    }



    return shape;
}

   }

