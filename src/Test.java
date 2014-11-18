import java.util.LinkedList;




public class Test {
	
	public static void main(String[] args) throws InterruptedException{
		LinkedList<String> temp = new LinkedList<String>();
		
		for(int i = 0 ; i < 100; i++){
			if( i%2 == 0)
				temp.addLast("Last " + i);
			else
				temp.addFirst("First " + i);
		}
		
		
		for(String txt : temp)
			System.out.println(txt);
	}
}
