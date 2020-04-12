package hangman;
import java.util.*;
import java.io.*;
public class Main {
	static String[]words;
	private static void fileReader() { //�����Է� 
		try {
			int index=  0; 
			File file = new File("C:\\Users\\hangman\\hangmanWord.txt");
			FileReader filereader= new FileReader(file);
			BufferedReader bufReader = new BufferedReader(filereader);
			String line ="";
			while((line= bufReader.readLine())!=null) {
				words[index]=line; //string �迭�� ���� 
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
		cmd=in.nextLine(); //Ŀ�ǵ� 
		if(cmd.equals("y") || cmd.equals("Y")) {
			fileReader(); //�����б� 
			int index=0;  
			while(!cmd.equals("N") || !cmd.equals("n")) {
				int leftChance=10; //��� guess �־���chance�� 10�� 
				checkWords checker= new checkWords(words[index].length()); //checker ��ü ���� 
				System.out.println(checkWords.hint);  //ó�� ���� print  
				while(leftChance!=0) { //chance 10�� 
					cmd=in.nextLine();
					leftChance--; //chance ���� 
					checker.printHint(words[index], cmd); 
					if(checkWords.leftNum==0) break; //���� ���ڰ����ٸ� == ��� ���߾��ٸ� �� 
				}
				index++; //words �迭�� ���� �ε����� 
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
