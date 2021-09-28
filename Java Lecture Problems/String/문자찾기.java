import java.util.Scanner;
  
public class 문자찾기 {
  public static void main(String[] args){
    Scanner in=new Scanner(System.in);
    String str = in.next().toLowerCase();
    char target = in.next().toLowerCase().charAt(0);

    int answer = 0;
    for(char c: str.toCharArray()){
      if(c == target) answer ++;
    }
    System.out.println(answer);
    return ;
  }
}
