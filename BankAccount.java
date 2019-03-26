import java.util.Scanner;
import java.io.Console;
//POLL SCM testing jenkins
public class BankAccount {
      public static void main(String[] args) {
            Account[] a = new Account[100];
            Scanner in = new Scanner(System.in);
            Console console = System.console();
            String user_username, user_password, user_name, user_email, user_phone,user_input_string, p;
            int current = 0;
            int user_section = 0;
            int user_input;
            boolean quit = false;
            boolean token = false;

      while(true){
            // Main menu
            System.out.println("Welcome to bank what do you want to do today?");
            do{
              System.out.println("1. Create Account");
              System.out.println("2. Log In");
              user_input = in.nextInt();
              in.nextLine();
              switch (user_input)
              {
                //Create New Account
                case 1:
                  System.out.print("Enter your username: ");
                  user_username = in.nextLine();
                  System.out.print("Enter your "+ user_username + " password: ");
                  user_password = in.nextLine();
                  System.out.print("Enter your name: ");
                  user_name = in.nextLine();
                  System.out.print("Enter your email: ");
                  user_email = in.nextLine();
                  System.out.print("Enter your phone: ");
                  user_phone = in.nextLine();
                  Account c = new Account();
                  c.Create(user_username,user_password,user_name, user_email,user_phone);
                  a[current] = c;
                  user_section = current;
                  current++;
                  quit = true;
                  break;
                //Log In
                case 2:
                  token = false;
                  while(token == false)
                  {
                    System.out.print("Enter your username: ");
                    user_input_string = in.nextLine();
                    for (int i = 0; i < current; i++)
                    {
                      if (user_input_string.equals(a[i].get_username()))
                      {
                        token = true;
                        user_section = i;
                      }
                    }
                    if (token == false){
                      System.out.println("No user found");
                    }
                  }
                  token = false;
                  System.out.println("Hi user " + a[user_section].get_username() + " enter your password!");
                  while (token == false){
                    char passwordArray[] = console.readPassword("");
                    p = new String(passwordArray);
                    token = a[user_section].log_in(p);
                    if (token == false){
                      System.out.print("Wrong password enter again: ");
                    }
                  }
                case 0:
                    quit = true;
                    break;
              };
            }while (!quit);
            token = false;
            quit = false;
            System.out.println("Hello Mr/Mrs. " + a[user_section].getname() + " what do you want to do today");
            do {
                  System.out.println("1. Withdraw");
                  System.out.println("2. Deposit");
                  System.out.println("3. Print Account");
                  System.out.println("0. Log off");
                  user_input = in.nextInt();
                  in.nextLine();
                  switch (user_input) {
                  case 1:
                        System.out.print("Enter the ammount Withdraw: $");
                        a[user_section].Withdraw(in.nextDouble());
                        break;
                  case 2:
                        System.out.print("Enter the ammount Deposit: $");
                        a[user_section].Deposit(in.nextDouble());
                        break;
                  case 3:
                        a[user_section].print_account();
                        break;
                  case 0:
                        quit = true;
                        break;
                  default:
                        System.out.println("Please enter 0-3");
                        break;
                  }
                  System.out.println();
                  System.out.println();
            } while (!quit);
            quit = false;
            System.out.print("\033[H\033[2J");
            System.out.flush();
      }
    }
}
