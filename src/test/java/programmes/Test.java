package programmes;

public class Test   
{  
    public static void main (String args[])  
    {  
        String s1 = "Sharma is a good player";  
        String s2 = new String("Sharma is a good player"); 
        System.out.println(s1);
        System.out.println(s2);
        s2 = s2.intern();  
        System.out.println(s1 ==s2);  
    }  
}    
