import java.util.*;
import java.math.*;

public class Store  {

  public static void main (String [] args)  {

    String cashierName = "Sally";

    double grandTotal;
    double subTotal;
    double tax;
    double shipping;

    Random rand = new Random(); // Random number generator

    Product books = new Product(9.0, 0.95, true, 0.0, 50.0, "Books", 0);
    books.getAmount();

    Product movies = new Product(13.97, (0.04 * 13.97), true, 0.0, 50.0, "Movies", 0);
    movies.getAmount();

    Product peanuts = new Product(1.72, .3, false, 0.0, 50.0, "Peanuts (lbs.)", -1);
    peanuts.getAmount();

    subTotal = books.total + movies.total + peanuts.total;
    tax = books.tax + movies.tax + peanuts.tax;
    shipping = books.ship + movies.ship + peanuts.ship;

    grandTotal = subTotal + tax + shipping;

    System.out.format("+----------------------+\n" +
    "|Steve's S-MART        |\n" +
    "+----------------------+\n" +
    "|%-22s|\n" +
    "|%02d:%02d:%02d    %02d/%02d/%04d|\n" +
    "|Books:              %02.0f|\n" +
    "|               $%06.2f|\n" +
    "|Movies:             %02.0f|\n" +
    "|               $%06.2f|\n" +
    "|Peanuts:          %04.1f|\n" +
    "|                $%05.2f|\n" +
    "+----------------------+\n" +
    "|Subtotal:             |\n" +
    "|              $%07.2f|\n" +
    "|Tax:                  |\n" +
    "|                $%05.2f|\n" +
    "|Shipping:             |\n" +
    "|                $%05.2f|\n" +
    "+----------------------+\n" +
    "|Grand Total:          |\n" +
    "|              $%07.2f|\n" +
    "+----------------------+\n",
    cashierName,
    rand.nextInt(24), rand.nextInt(60), rand.nextInt(60), rand.nextInt(28) + 1, rand.nextInt(12) + 1, rand.nextInt(20) + 2000,
    books.amount, books.total, movies.amount, movies.total, peanuts.amount, peanuts.total,
    subTotal, tax, shipping, grandTotal);

  }

}

class Product  { // I miss pointers

  // Various configurbles

  boolean TAXABLE;

  double PRICE, SHIPPING, MAXAMOUNT, MINAMOUNT, PRECISION, PRECISION2;

  String PRODUCT;

  public Product (double price, double shipping, boolean taxable, double min, double max, String productName, int precision)  {

    PRICE = price;
    SHIPPING = shipping;

    TAXABLE = taxable;

    MAXAMOUNT = max;
    MINAMOUNT = min;

    PRODUCT = productName;

    PRECISION = Math.pow(10, precision);
    PRECISION2 = Math.pow(10, -1 * precision);

  }

  // Variables

  double total; // Cost of the amount purchased

  double amount; // Amount purchased

  double tax = 0; // Amount needed for tax

  double ship; // Shipping fee

  void getAmount ()  {

    double temp;

    // Declare and Initialize Scanner

    Scanner sc = new Scanner(System.in);

    boolean exitLoop = false;

    do  {
      try  {
        System.out.printf("%s purchased (%f - %f", PRODUCT, MAXAMOUNT, MINAMOUNT); // Prompt user for amount purchased
        if (PRECISION != 1)  {
          System.out.printf(") (Min decimal is %f", PRECISION);
        }
        System.out.print("): ");
        amount = sc.nextDouble();
        exitLoop = true;
      }
      catch (Exception e)  { //  In case what's typed isn't a double
        exitLoop = false;
        sc.next(); // Flush that buffer!
      }
      finally  {
        if (amount > MAXAMOUNT || MINAMOUNT > amount)  {
          exitLoop = false;
        }
        else if (amount % PRECISION != 0 && PRECISION > 0.1)  {
          exitLoop = false;
        }
        else if (PRECISION < 1 && (amount - (int) amount) != 0)  { // Witchcraft to deal with floating point errors
          temp = (amount * PRECISION2) - (int) (amount * PRECISION2);
          if (temp != 0)  {
            exitLoop = false;
          }
        }
      }
    }  while (!exitLoop);
    total = amount * PRICE;
    ship = amount * SHIPPING;
    if (TAXABLE)  {
      tax = total * .072;
    }
  }
}
