package test.bytes;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class ByteTest {

	public static void main(String[] args) throws IOException {
		String str = "CABAyAAMT000VzQyQTAwMDAzwgFpesQCWys+Q8gDIMgADjIwMTgwNjIxMTQ1NzIzxAFCjMzNxALCrgAAwQMBwgQtFg==";
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		byte[] packts = str.getBytes(StandardCharsets.US_ASCII);
		String tmp = new String(packts);
//		for(int i=0;i<packts.length;i++)
//			bw.write(String.valueOf(packts[i]));
		bw.write(tmp);
		bw.flush();
	}
}
