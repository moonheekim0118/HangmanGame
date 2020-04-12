package hangman;
import java.util.*;
import java.io.*;
public class Main {
	static String[]words;
	private static void fileReader() { //파일입력 
		try {
			int index=  0; 
			File file = new File("C:\\Users\\hangman\\hangmanWord.txt");
			FileReader filereader= new FileReader(file);
			BufferedReader bufReader = new BufferedReader(filereader);
			String line ="";
			while((line= bufReader.readLine())!=null) {
				words[index]=line; //string 배열에 저장 
				index++;  
			}
		}catch(IOException e) {}
	}
	
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		String cmd;
		words = new String[10];
		System.out.println("---this is hangman game---");
		System.out.println("Do you want to play game? [y/n]");
		cmd=in.nextLine(); //커맨드 
		if(cmd.equals("y") || cmd.equals("Y")) {
			fileReader(); //파일읽기 
			int index=0;  
			while(!cmd.equals("N") || !cmd.equals("n")) {
				int leftChance=10; //행맨 guess 주어진chance는 10번 
				checkWords checker= new checkWords(words[index].length()); //checker 객체 생성 
				System.out.println(checkWords.hint);  //처음 상태 print  
				while(leftChance!=0) { //chance 10번 
					cmd=in.nextLine();
					leftChance--; //chance 감소 
					checker.printHint(words[index], cmd); 
					if(checkWords.leftNum==0) break; //남은 문자가없다면 == 모두 맞추었다면 끝 
				}
				index++; //words 배열의 다음 인덱스로 
				if(checkWords.leftNum==0) 
					System.out.println("scongraturation! you win!");
				else {
					System.out.println("sorry , you lose!");
					System.out.println("the answer was... " + "["+words[index-1]+"]");
					
					}
				 if(index<10) 
					 System.out.println("Do you want to play more? [y/n]");
				 
				 else {
					 System.out.println("end of the game! bye!");
					 break;
				 }
				cmd=in.nextLine();
			}
		
		}
	}
}
