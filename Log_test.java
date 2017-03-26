import java.io.File;
import Log.Log;

public class Log_test{

	public static void main(String[] args){

		Log test_logfile = new Log("./testlog.log",500);

		while(true){
			test_logfile.print("test 1,2");
			try{
				Thread.sleep(1000);

			}catch(InterruptedException e){
			}
		}
	}
}
