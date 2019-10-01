public class QuizCorrections
{
    public static void main(String[] args)
    {
       String firstName = "Sofia ";
       String middleName = "Maria ";
       String lastName = "Hernandez  ";

       String firstInt = firstName.substring(0,1);
       String lowerFirstInt = firstInt.toLowerCase();

       String firstInt = middleName.substring(0,1);
       String lowermiddleInt = firstInt.toLowerCase();

       String firstInt = lastName.substring(0,1);
       String lowerlastInt = firstInt.toLowerCase();

       System.out.println(firstName + middleName + lastName);
     }
}
