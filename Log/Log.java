package Log;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

import Log.DateTime.DateTime;

public class Log{

	//ログファイルパス
	String filepath;
	long max_filesize;

	//constructor
	public Log(String filepath, long max_filesize){
		this.filepath = filepath;
		this.max_filesize = max_filesize;
	}

	//ログへの書き込み
	public void print(String message){

		//ファイルオブェクトの生成
		File logfile = new File(filepath);



		/*存在確認*/
		//もし存在しなかったら
		if(logfile.exists()==false){
			try{
				System.out.println("##ファイルが存在しないので新規作成します");
				logfile.createNewFile();
			}catch(IOException e){
			}
		}

		/*サイズチェック*/
		System.out.println("##logfile.length:"+logfile.length()+" max_filesize:"+max_filesize);
		//もし指定したmaxサイズを超えていたら
		if(logfile.length() > max_filesize){
			System.out.println("##エクシード");
			//削除
			logfile.delete();
			try{
				//ファイルを新規作成
				System.out.println("##新規作成");
				logfile.createNewFile();
			}catch(IOException e){
			}
		}


		/*書き込み*/
		try{
			BufferedWriter bw = new BufferedWriter(new FileWriter(logfile,true));
			bw.write(DateTime.returnDatetime()+"  "+message);
			bw.newLine();
			bw.close();
		}catch(IOException e){
		}

	}
}
