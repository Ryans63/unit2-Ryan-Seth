import java.util.Random;

public class RandomNumbers{
  public static void main(String[] args){
    Random rand = new Random();

    rand.nextInt(10);
    System.out.println("# [0,9]:  " + rand.nextInt(10) );
    System.out.println("# [0,9]  " + (int) (Math.random()*10));

    rand.nextInt(11);
    System.out.println("# [1,10]  " + (rand.nextInt(10) + 1) );
    System.out.println("# [1,10]  " + (int) ((Math.random()*10)+ 1));

    rand.nextInt(15);
    System.out.println("# [20,34]  " + (rand.nextInt(15)+ 20) );

    rand.nextInt(20);
    System.out.println("# [-10,9]  " + (rand.nextInt(20)- 10));

    rand.nextInt(26);
    System.out.println("# [25,50]  " + (rand.nextInt(26)+  25) );

    rand.nextInt(16);
    System.out.println("# [-10,5]  " + (rand.nextInt(16)-  10) );

    System.out.println("# [0,10]  " + (int) ((Math.random()*10)+ 1));

    System.out.println("# [0,500]  " + (int) ((Math.random()*500)+ 1));

    System.out.println("# [25,50]  " + (int) ((Math.random()*25)+ 26));

  }
}
