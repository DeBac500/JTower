import com.XDDominik.engine.LevelReader;


public class Test {
	
	public static void main(String[] args) throws InterruptedException{
		LevelReader.getLevelInfo("level_01");
		char c = '#';
		do{
			c = LevelReader.getNextField();
			System.out.println(c);
			Thread.sleep(100);
		}while(c != '#');
	}
}
