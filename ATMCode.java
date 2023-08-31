import java.util.HashMap;
import java.util.Map;

public class ATMCode 
{

    private Map <String, Double> accountMap = new HashMap<String, Double>();
    //if the user does not exist create a new account for 
    //the user and store their deposit amount
   public void openAccount(String userID, double amount)
   {
        if(accountMap.containsKey(userID))
        {
            throw new IllegalArgumentException("The account already exists.");
        }
        else
        {
            accountMap.put(userID, amount);
        }
   }

   // if there is no balance, delete the account entry
   //If there is a balance, throw an error mentioning the need to withdraw $$$ before closing
   public void closeAccount(String userID)
   {
        if(!accountMap.containsKey(userID))
        {
            throw new IllegalArgumentException("This account doesn't exist.");
        }
        else if(accountMap.get(userID)>0)
        {
            throw new IllegalArgumentException("This account still has money. Withdraw the rest of it!!"); 
        }
        else
        {
            accountMap.remove(userID);
        }
   }

   //output the exact account value
   //throw an error if the account doesn't exist
   public double checkBalance(String userID)
   {
     if(!accountMap.containsKey(userID))
        {
            throw new IllegalArgumentException("This account doesn't exist.");
        }
        return accountMap.get(userID);
   }

   //return a double of the deposited amount or throw exception
   //if the account exists increase the amount of the users account value
   //If not, throw exception saying they can't withdraw money
   public double depositMoney(String userID, double amount)
   {
       if(!accountMap.containsKey(userID))
        {
            throw new IllegalArgumentException("This account doesn't exist.");
        } 
        accountMap.put(userID, accountMap.get(userID)+amount);
        return amount;
   }

   //return the double of the returned amount or throw an exception
   //check for withdrawl method within the account. If the amount exists
   //reduce the withdrawn amount and return that value
   //if not, throw exception
   public double withdrawMoney(String userID, double amount)
   {
        if(!accountMap.containsKey(userID))
        {
            throw new IllegalArgumentException("This account doesn't exist.");
        } 
        if(accountMap.get(userID) < amount)
        {
            throw new IllegalArgumentException("You don't have enough money :(");
        }
        accountMap.put(userID, accountMap.get(userID)-amount);
        return amount;
   }

   //return a boolean with if the transfer was successful or not
   //withdraw moeny from the "from" account deposit money into the to account
   public boolean transferMoney(String fromAccount, String toAccount, double amount)
   {
    if(!accountMap.containsKey(fromAccount))
    {
        return false;
    }
    if(!accountMap.containsKey(toAccount))
    {
        return false;
    }
    withdrawMoney(fromAccount, amount);
    depositMoney(toAccount, amount);
    return true;
   }
   
   //If the file already exists, delete the current file 
   //and write a new one
   //write a file named "AccountAudit.txt"
   //write out each account email and value on subsequent new lines
   //closes the file after writing
   public void audit()
   {

   }
}
