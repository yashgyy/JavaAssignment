import java.util.*;


class BadPassword extends RuntimeException{
    BadPassword(String name){
        super(name);
    }
}



public class Main{

    public static boolean minimumLength(String var){
        return var.length()<6;

    }

    public static boolen maximumLength(String var){
        return var.length()>12;
    }

    public static boolen lowerCase(String str){
        return !str.matches("[a-z]");

    }

    public static boolean upperCase(String str){
        return !str.matches("[A-Z]");
    }

    public static boolean Digit(String str){
        return !str.matches("[0-9]");
    }

    public static boolean Misc1(String str){
        return !str.matches("[*&_#=@]");
    }

    public static boolean Misc2(String str){
        return str.matches("[%!()]");
    }

    public static void main(String[] args) {
        Scanner In=new Scanner(System.in);
        System.out.print("Enter Passwords seperated by Comma\n");
        String name=In.nextLine();
        String[] passwords=name.split(",");
        System.out.println(Arrays.toString(passwords));
        
        for(int i=0;i<passwords.length;i++){
          
            String Checker="Failure\n";
            String First="Failure\n";

            
            try {
                String Check=passwords[i];
                 switch(1){
                     case 1: if(minimumLength(Check)){First+="Password Must be 6 character Long\n";}
                     case 2: if(maximumLength(Check)){First+="Password Must not be longer than 12 characters\n";}
                     case 3: if(lowerCase(Check)){First+="Password must contain one charcter from a-z\n";}
                     case 4: if(upperCase(Check)){First+="Password must Contain one charcater from A-Z\n";}
                     case 5: if(Digit(Check)){First+="Password must contain one character from 0-9";}
                     case 6: if(Misc1(Check)){First+="Password must contain one character from *$_#=@";}
                     case 7: if(Misc2(str)){First+="Password Must not contain a character from %)(!";}
                 }

                 if(First.equals(Checker)){
                     throw new BadPassword(First);
                } else{
                    System.out.println("Success");
                }


            } catch (BadPassword e) {
                System.out.println(e.getMessage());
            }
        }

    }
}