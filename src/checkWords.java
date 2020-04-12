package hangman;
import java.util.*;
public class checkWords {
	static ArrayList<String>hint; //hint 저장 
	static int leftNum; //맞추고 남은 숫자 저장 
	public checkWords(int length) { //생성자 
		hint=new ArrayList<String>(); 
		for(int i=0 ;i<length;i++) {
			hint.add("_");
		 }  
		leftNum=length;
	}
	public void printHint(String word, String args) {		
		args=args.toLowerCase(); //소문자로 바꾸어 주기 
		if(word.contains(args)) { //word(단어) 에 args (입력받은 단어)가 있다면 
			for(int i =0 ; i < word.length();i++) { //일치하는 부분 hint args로 변경 
				if(String.valueOf(word.charAt(i)).equals(args)) {
					if(!hint.get(i).equals(args)) { //중복된 문자 방지->중복된 문자만 계속 입력받을 시 중복된 수가 계속 leftNum--하면서 
						                            //leftNum을 0으로 만들기 때문
						hint.set(i, args); //해당 자리 hint args로 바꾸기   ex )  _  _ a _ _  
						leftNum--; //맞춰야하는 문자 수 감소 
					}
				}
			}
		}
		System.out.println(hint);	
	}
}
