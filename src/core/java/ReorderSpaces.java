package core.java;

public class ReorderSpaces {

    public static void main(String[] args) {
        System.out.println(reorderSpaces("  this   is  a sentence "));
        System.out.println(reorderSpaces(" practice   makes   perfect"));
    }
    
    
    public static String reorderSpaces(String text) {
        if (null == text || text.length() == 1) {
            return text;
        }
        int i = 0 ;
        int spCount = 0;
        int wCount = 0;
        
        while (i < text.length()) {
            char ch = text.charAt(i);
            if (ch == ' ') {
                spCount++;
            }
            if ((i !=0 && text.charAt(i-1) == ' ' && text.charAt(i) != ' ')
                || (i == 0 && text.charAt(i) != ' ')){
                wCount++;
            }      
            i++;
        }
        
        if (spCount == 0) {
            return text;
        }
        int spaceBetween = spCount / (wCount-1);
        int spaceEnd = spCount % (wCount-1);
         
        StringBuilder bet = new StringBuilder();
        for (int k=0 ; k < spaceBetween; k++) {
           bet.append(" ");
        }
        StringBuilder end1= new StringBuilder();
        if (spaceEnd > 0) {
        for (int k=0 ; k < spaceEnd; k++) {
            end1.append(" ");
        } }                        
        
        i = 0;
        StringBuilder sb = new StringBuilder();
        boolean prevCh = false;
        
        while (i < text.length()) {
            
            if (text.charAt(i) != ' ') {
               sb.append(text.charAt(i));
                prevCh = true;
                i++;
                continue;
            } 
            if (prevCh && wCount > 1) {
                sb.append(bet);
                prevCh = false;
                wCount--;
            }            
            i++;            
        }
        sb.append(end1);
        return sb.toString();
    }
}