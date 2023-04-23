import java.util.Scanner;

class Atm{
    float Balance;
    int pin=12345;
     
  

 public void checkpin(){
    System.out.println("enter the pin");
    Scanner sc=new Scanner(System.in);
    int enterpin=sc.nextInt();
    if(enterpin==pin){
        menu();

    }
    else{
        System.out.println("plese enter the rigit pin");
    }

}

       public void menu(){
        System.out.println("enter the choice");
        System.out.println("1)check for balnace");
        System.out.println("2) withdrw money");
        System.out.println("3)deposit money");
        System.out.println("4)exit");
         Scanner sc=new Scanner(System.in);
         int opt=sc.nextInt();

         if (opt==1){
            checkBalance();
         }
         else if(opt==2){
            withdrawmoney();

         }
         else if(opt==3){
            depositmoney();
         }
         else if(opt==4){
            return;
         }
        else{
            System.out.println("wrong input again check");
        }

         }
    
     public void checkBalance(){
        System.out.println("Balance:"+Balance);
        menu();
     }
     public void withdrawmoney(){
        System.out.println("enter the money you withdrw");
        Scanner sc=new Scanner(System.in);
        float amount  = sc.nextFloat();
        if(amount>Balance){
            System.out.println("insufficent fund");
        }
        else{
            Balance=Balance-amount;
            System.out.println("the witdraw amount is" + Balance);
        }
              menu();
     }
     public void depositmoney(){
        System.out.println("enter the money you deposit");
        Scanner sc= new Scanner(System.in);
        float amount=sc.nextFloat();
        Balance=amount+Balance;
        System.out.println("the amount balnace is "+Balance);

              menu();
     }
     
     public void exit(){
        System.out.println("wrong input");

     }
}


public class atm {
    public static void main(String args[]){
        Atm obj=new Atm();
        obj.checkpin();

    }
    
}
