import java.util.*;
import java.util.prefs.AbstractPreferences;

public class PersonalFinanceAnomalyDetector
{
    public  static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String choice ;
        boolean running = true;
        ArrayList<Transaction> transactions = new ArrayList<>();
        while (running)
        {
            System.out.println("1. Add Transaction\n" +
                    "2. View Transactions\n" +
                    "3. Analyze Spending\n" +
                    "4. Detect Anomalies\n" +
                    "5. Financial Summary\n" +
                    "6. Exit");

             System.out.println("enter your preference (eg 1,2,3,4,5 or 6):");
              int num = sc.nextInt();

             switch (num)
          {
                case 1://adding transaction
                    choice ="yes" ;
                 while (choice.equalsIgnoreCase("yes"))
                 {
                    System.out.print("Enter The Amount in:");
                    double Amount = sc.nextDouble();
                    System.out.print("Enter The Expenditure Type:");
                    String Category = sc.next();
                    System.out.print("Enter The Date:");
                    String Date = sc.next();
                    System.out.print("enter the description");
                    String description = sc.next();
                    transactions.add(new Transaction(Amount, Category, Date, description));
                    System.out.println("do you want to add new transaction enter yes or no");
                     choice = sc.next();

                }

                break;
              case 2:// view trasaction
                int transacs= transactions.size();
                for(int i=0 ;i < transacs ; i++)
                {
                    Transaction oneTransaction = transactions.get(i);
                    System.out.println( oneTransaction);

                }

                break;


              case 3:
                  double Amount;
                  double foodsum = 0;
                  double travelsum = 0;
                  double shoppingsum=0;
                  for (Transaction t : transactions) {
                      if (t.category.equalsIgnoreCase("food"))
                      {
                           foodsum += t.Amount;
                      }
                      if (t.category.equalsIgnoreCase("travel"))
                      {
                           travelsum += t.Amount;
                      }
                      if (t.category.equalsIgnoreCase("shopping"))
                      {
                          shoppingsum += t.Amount;
                      }
                  }
                  System.out.println("travel (₹):" +travelsum);
                  System.out.println("food (₹):" +foodsum);
                  System.out.println("shopping (₹):" +shoppingsum);


                  break;

              case 4:
                  System.out.print("enter the category");
                   String category = sc.next();
                   for (Transaction t : transactions)
                   {
                       if (t.category.equalsIgnoreCase(category) &&  (t.Amount>10000))
                       {
                           System.out.println("Anomaly detected! " +t);
                       }

                   }

                   break;

              case 5:
                  double total=0;
                  for (Transaction t : transactions)
                  {
                      total = total +t.Amount;
                  }
                  System.out.println(" your Financial Summary is ");
                  double tran =transactions.size();
                  System.out.println("total transaction are " +tran);
                  System.out.println("the total transaction and the  amount spend is : "+total);

                  double average =  (total/tran);
                  System.out.println("the average of transaction is : " +average);


                  System.out.println("Financial Summary");

                  break;

              case 6:
                  System.out.println("program stops");
                  running = false;






          }
        }

    }
}
class Transaction
{
    double Amount;
    String category;
    String date;
    String description;
    Transaction(double Amount,String category,String date ,String description)
    {
        this.Amount = Amount;
        this.category = category ;
        this.date = date;
        this.description = description;

    }
    public String toString()
    {
        return"amount:"+ Amount + ", category:"+category + ", date: "+date+",  description: "+description;
    }
}
