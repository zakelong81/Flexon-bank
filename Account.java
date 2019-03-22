import java.util.Scanner;
import java.util.Random;
public class Account{
  private int account_number = 123456789;
  private Double balance =50.0;
  private String customer_name = "Long Nguyen";
  private String email = "lnguyen71195@gmail.com";
  private String phone = "5305912929";
  private String username = "lnguyen71195";
  private String password = "password";

  public void Create(String un, String p, String n, String e, String ph){
    username = un;
    password = p;
    customer_name = n;
    email = e;
    phone = ph;
    Random rand = new Random();
    account_number = rand.nextInt(99999999) + 100000000;
  }

  public String get_username()
  {
    return username;
  }
  public boolean log_in(String p){
    if (p.equals(password))
      return true;
    else
      return false;
  }

  public void Deposit(Double money){
    balance = balance + money;
    System.out.print("Current balance: ");
    System.out.printf("$%2.2f", balance);
  }
  public void Withdraw(Double money)
  {
    if (balance - money < 0)
    {
      System.out.println("Dont have enough balance");
    }
    else
    {
      balance = balance - money;
      System.out.print("Current balance: ");
      System.out.printf("$%2.2f", balance);
    }
  }
  public String getname(){
    return customer_name;
  }
  public void print_account()
  {
    System.out.println("Name: " + customer_name);
    System.out.println("Account Number: " + account_number);
    System.out.println("Email: "+ email);
    System.out.println("Phone: "+  phone);
    System.out.print("Current balance: ");
    System.out.printf("$%2.2f", balance);
  }
}
