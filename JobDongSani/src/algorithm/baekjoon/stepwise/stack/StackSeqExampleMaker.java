package algorithm.baekjoon.stepwise.stack;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class StackSeqExampleMaker {

	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\user\\git\\JobDongSani\\JobDongSani\\src\\algorithm\\baekjoon\\stepwise\\stack\\seq4.txt");
		FileWriter fw = new FileWriter(file);
		for(int i=1;i<=100000;i++) {
			fw.write(String.valueOf(i)+"\n");
		}
//		fw.write(String.valueOf(8791));
////		for(int i=98791;i<=100000;i++) {
////			fw.write(String.valueOf(i) + "\n");
////		}
		fw.flush();
		fw.close();
	}
}
