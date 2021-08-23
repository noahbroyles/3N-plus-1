package fileops;

import java.io.*;
import java.math.BigInteger;

public abstract class FileOps {
	
	private static FileWriter fdubs;
	private static FileReader frubs;
	private static BufferedWriter bdubs;
	private static BufferedReader brubs;
	
	
	public static BigInteger readLatestChunk() {
		try {
			frubs = new FileReader("latestChunk.txt");
			brubs = new BufferedReader(frubs);
			return new BigInteger(brubs.readLine());
		} catch (IOException e) {
			e.printStackTrace();
			return BigInteger.ZERO;
		} finally {
			frubs = null;
			brubs = null;
		}
	}
	
	public static void writeLatestChunk(BigInteger latest) {
		try {
			fdubs = new FileWriter("latestChunk.txt");
			bdubs = new BufferedWriter(fdubs);
			bdubs.write(latest.toString());
			bdubs.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			fdubs = null;
			bdubs = null;
		}
	}

}
