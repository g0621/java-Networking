package Revise;

interface X{
    public int xy();
}

public class Main{
    public static void change(String a){
        a  = "MY goodness";
        System.out.println(a);
    }
    public static void main(String argc[]){
     String a = new String ("My god");
     change(a);
     System.out.println(a);

     X b = new X() {
         @Override
         public int xy() {
             return 0;
         }
     };
    }
}