package main;

import three.ThreeNPlus1;
import fileops.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 295147905179352825856 = 2^68
		// 590295810358705651712 = 2^69
		// 295147905179377541371 gives us 1402 steps
		
		// This is our starting number
		BigInteger n = FileOps.readLatestChunk();
		BigInteger negOneHundredThousand = new BigInteger("-100000");
		BigInteger lastLogged = n;
		System.out.println("Starting at " + n);
		
		BufferedWriter out = null;

		BigInteger temp;
		long steps;
		long greatestSteps = 1402;
		for (;;) {
			temp = n;
			steps = 0;
			while (!n.equals(ThreeNPlus1.one)) {
				n = ThreeNPlus1.calc3n(n);
				steps += 1;
				// System.out.println("\t\t" + n);
			}
			// System.out.println("Using 3n + 1, " + temp + " was reduced to " + n + " in " + steps + " steps");
			if (steps > greatestSteps) {
				try {
					 FileWriter fdub = new FileWriter("stepTracking.txt");
			         out = new BufferedWriter(fdub);
			         String message = temp + " gives us " + steps + " steps\n";
			         out.write(message);
			         System.out.println(message);
			         out.close();
			         // Memory optimization
			         fdub = null;
			         out = null;
			         message = null;
			      }
			      catch (IOException e) {
			    	  e.printStackTrace();
			     } finally {
			    	 greatestSteps = steps;
			     }
			}
			if (temp.add(negOneHundredThousand).compareTo(lastLogged) == 1) {
				System.out.println("Last chunk checked: " + temp);
				FileOps.writeLatestChunk(temp);
				lastLogged = temp;
			}
			n = temp.add(ThreeNPlus1.one);
//			System.out.println("Latest: " + temp);
		}
		
	}

}
