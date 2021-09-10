import java.util.Scanner;
  
public class 대소문자변환 {
  public static void main(String[] args){
    Scanner in=new Scanner(System.in);
 	String str = in.next();
    String answer = "";
	for(char c : str.toCharArray()){
      if(Character.isUpperCase(c)){
        answer += String.valueOf(c).toLowerCase();
      }
      else{
        answer += String.valueOf(c).toUpperCase();
      }
    }
    System.out.println(answer);
    return ;
  }
}
