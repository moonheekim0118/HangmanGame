package hangman;
import java.util.*;
public class checkWords {
	static ArrayList<String>hint; //hint ���� 
	static int leftNum; //���߰� ���� ���� ���� 
	public checkWords(int length) { //������ 
		hint=new ArrayList<String>(); 
		for(int i=0 ;i<length;i++) {
			hint.add("_");
		 }  
		leftNum=length;
	}
	public void printHint(String word, String args) {		
		args=args.toLowerCase(); //�ҹ��ڷ� �ٲپ� �ֱ� 
		if(word.contains(args)) { //word(�ܾ�) �� args (�Է¹��� �ܾ�)�� �ִٸ� 
			for(int i =0 ; i < word.length();i++) { //��ġ�ϴ� �κ� hint args�� ���� 
				if(String.valueOf(word.charAt(i)).equals(args)) {
					if(!hint.get(i).equals(args)) { //�ߺ��� ���� ����->�ߺ��� ���ڸ� ��� �Է¹��� �� �ߺ��� ���� ��� leftNum--�ϸ鼭 
						                            //leftNum�� 0���� ����� ����
						hint.set(i, args); //�ش� �ڸ� hint args�� �ٲٱ�   ex )  _  _ a _ _  
						leftNum--; //������ϴ� ���� �� ���� 
					}
				}
			}
		}
		System.out.println(hint);	
	}
}
