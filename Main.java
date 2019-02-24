import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


class BadPassword extends RuntimeException{
    BadPassword(String name){
        super(name);
    }
}



public class Main{

    //Individual Method for each of constraint, can modify if needs

    public static boolean minimumLength(String var){
        
        return var.length()<6;

    }

    public static boolean maximumLength(String var){
        return var.length()>12;
    }

    public static boolean lowerCase(String str){
        return !Pattern.compile("[a-z]").matcher(str).find();

    }

    public static boolean upperCase(String str){
        
        return !Pattern.compile("[A-Z]").matcher(str).find();
    }

    public static boolean Digit(String str){
        return !Pattern.compile("[0-9]").matcher(str).find();
    }

    public static boolean Misc1(String str){
        return !Pattern.compile("[*$_#=@]").matcher(str).find();
    }

    public static boolean Misc2(String str){
        return Pattern.compile("[%!()]").matcher(str).find();
    }

    public static void main(String[] args) {
        Scanner In=new Scanner(System.in);
        System.out.println("Enter Passwords seperated by Comma");
        String name=In.nextLine();
        String[] passwords=name.split(",");
        System.out.println(Arrays.toString(passwords));
        System.out.println("--------------------------------------------");
        
        for(int i=0;i<passwords.length;i++){
            System.out.print("Given String is "+passwords[i]+"\n");
            String Checker=new String("Failure\n");
            String First=new String("Failure\n");

            
            try {
                String Check=passwords[i];
                 switch(1){
                     //Case Statements Check each of the conditions Fall Through
                     case 1: if(minimumLength(Check)){First+="** Password Must be 6 character Long\n";}
                     case 2: if(maximumLength(Check)){First+="** Password Must not be longer than 12 characters\n";}
                     case 3: if(lowerCase(Check)){First+="** Password must contain one charcter from a-z\n";}
                     case 4: if(upperCase(Check)){First+="** Password must Contain one charcater from A-Z\n";}
                     case 5: if(Digit(Check)){First+="** Password must contain one character from 0-9\n";}
                     case 6: if(Misc1(Check)){First+="** Password must contain one character from *$_#=@\n";}
                     case 7: if(Misc2(Check)){First+="** Password Must not contain a character from %)(!\n";}
                 }

                 if(First.equals(Checker)){
                    System.out.println("Success");
                    System.out.println("------");
                } else{
                    throw new BadPassword(First);  //An Exception is thrown if any condition fails
                    
                }


            } catch (BadPassword e) {
                System.out.print(e.getMessage());
                System.out.println("------");
            }
        }

    }
}