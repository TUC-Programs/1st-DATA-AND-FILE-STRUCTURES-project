package org.tuc.readFromFile;


import java.io.*;
import java.nio.*;
public class RandomNumbersToFiles {

	public static void main(String[] args) {
		String fileNamePrefix = "numbers-";
		int[] N = {20, 50, 100, 200, 1000, 2500, 5000, 10000, 20000, 40000, 60000, 
				80000, 100000, 200000, 1000000, 1500000, 2000000, 2500000, 3000000};
		
		
		
		RandomNumbersToFiles randomNumbersToFiles = new RandomNumbersToFiles();
		randomNumbersToFiles.createFiles(fileNamePrefix,N);
	}
	
	/**
	 * Creates N.length files containing random integers between 1 and 3xN[i], where i is the i th element of N.  
	 * The first M numbers in each file are not random, but are increasing numbers starting from 1
	 * M depends on the value of N[i]
	 * Numbers a stored in binary form, 4 bytes per number, Little Endian
	 * @param fileNamePrefix String
	 * @param N int[]
	 */
	private void createFiles(String fileNamePrefix, int[] N) {
		int numberOfNumbers;
		int initialSorted;
		int minIntNumber;
		int maxIntNumber;
		String fileName;
		int[] randomInts;
		
		System.err.println("Generating");
		java.util.Random randomGenerator = new java.util.Random();
		for(int count=0; count<N.length;count++) {
			System.err.print(N[count] + "...");
			fileName = fileNamePrefix+N[count]+".bin";
			numberOfNumbers = N[count];
			initialSorted = getInitialSorted(N[count]);

		
			minIntNumber = initialSorted + 1;
			maxIntNumber = numberOfNumbers * 3;
			randomInts = randomGenerator.ints(minIntNumber, maxIntNumber+1).distinct().limit(numberOfNumbers).toArray();

			writeInts(randomInts, fileName);
			
			for (int i=0; i<initialSorted;i++) {
				randomInts[i] = i+1;
			}
			writeInts(randomInts, fileName);
		}
		System.err.println("");

		System.err.println("Testing");
		// test reading the numbers
		for(int count=0; count<N.length;count++) {
			System.err.print(N[count] + "...");

			fileName = fileNamePrefix+N[count]+".bin";
			randomInts = readInts(fileName);
			
			if (randomInts.length != N[count]) {
				System.err.println("Wrong number of numbers for N=" + N[count]);
				System.exit(10);
			}
			
			initialSorted = getInitialSorted(N[count]);
			// make sure the first initialSorted are consecutive numbers starting at 1
			// and the rest between initialSorted+1 and 3*N
			for(int countNumbers=0; countNumbers<randomInts.length; countNumbers++) {
				if (randomInts[countNumbers] < 1 || randomInts[countNumbers] > 3 * N[count]) {
					System.err.println("Number outside range for N=" + N[count]);
					System.exit(30);
				}
				if (countNumbers < initialSorted) {
					if (randomInts[countNumbers] != (countNumbers + 1)) {
						System.err.println("Initial sorted error for N=" + N[count] + " for the " + countNumbers + "th number");
						System.exit(30);
					}
				}
			}

		}
		System.err.println("");

	}
	
	private int getInitialSorted(int N) {
		int initialSorted = 70;
		if (N < 201) {
			initialSorted = 10;
		}
		else if (N < 1001) {
			initialSorted = 20;
		}
		return initialSorted;
	}
	
	/**
	 * Reads the given file as 4 byte, little endian integers, and returns an array
	 * of the numbers
	 * @param fileName
	 * @return The read numbers
	 */
	public int[] readInts(String fileName) {
		int[] numbers = null;
		try {
            // Create FileInputStream and DataInputStream
            FileInputStream fis = new FileInputStream(fileName);
            DataInputStream dis = new DataInputStream(fis);
            
            // Create byte array with enough space for the whole file
            // and read the whole file. We assume that the file has the correct
            // length (multiple of Integer.BYTES=4)
            byte[] bytes = new byte[(int) new File(fileName).length()];
            dis.readFully(bytes);

            // Create ByteBuffer with little-endian byte order
            ByteBuffer buffer = ByteBuffer.wrap(bytes);
            buffer.order(ByteOrder.LITTLE_ENDIAN);
            
            // Read integers from the ByteBuffer
            numbers = new int[bytes.length / Integer.BYTES];
            for (int i = 0; i < numbers.length; i++) {
            	numbers[i] = buffer.getInt();
            }

            // Close streams
            dis.close();
            fis.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
		return numbers;
	}
	
	private void writeInts(int[] randomInts, String fileName) {
		try
		{
            // Create FileOutputStream and DataOutputStream
            FileOutputStream fos = new FileOutputStream(fileName);
            DataOutputStream dos = new DataOutputStream(fos);

            // Create ByteBuffer with little-endian byte order
            // Integer.BYTES holds the number of bytes of an integer. In java this is 4
            ByteBuffer buffer = ByteBuffer.allocate(randomInts.length * Integer.BYTES);
            buffer.order(ByteOrder.LITTLE_ENDIAN);
            
            // Put each element of the array into the ByteBuffer
            for (int i = 0; i < randomInts.length; i++) {
                buffer.putInt(randomInts[i]);
            }

            // Write the ByteBuffer's contents to the file
            dos.write(buffer.array());
            
            // Close streams
            dos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}
