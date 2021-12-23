package ie.gmit.cryptomanager;


//import
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CryptoManager implements Serializable {

	private static final long serialVersionUID = 1L;

	//Create Crypto ArrayList
	private List<Crypto> cryptoList = null;

	//Constructor
	public CryptoManager() {
		cryptoList = new ArrayList<Crypto>();
	}

	//Crypto Add Method
	public boolean addCrypto(Crypto cryptoObject) {

		for (Crypto crypto : cryptoList) { 
			if (crypto.getCryptoAdress().equals(cryptoObject.getCryptoAdress())) {
				System.out.println("Crypto NOT Added to Crypto List. Crypto already on Crypto List!");
				return false;
			}
		}

		return cryptoList.add(cryptoObject);

	}

	// Crypto Remove Method
	public boolean removeCrypto(Crypto cryptoObject) {
		return cryptoList.remove(cryptoObject);
	}

	public Crypto deleteCryptoByNumber(int number) {
		try {
			return cryptoList.remove(number - 1);
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("There are " + cryptoList.size()
					+ "cryptos on the list. Please pick a number from 1 to " + cryptoList.size());
		}
		return null;
	}

	public int findTotalCrypto() {
		// returns the current number of Crypto in the ArrayList
		return cryptoList.size();
	}

	public String listAllCrypto() {
		// Create a StringBuilder object
		StringBuilder sb = new StringBuilder();
		int counter = 1;

		sb.append(String.format("%-20s%-20s%-20s%-20s%-20s\n", "No.", "Crypto Adress", "Name", "Short Name", "Amount"));
		sb.append(String.format("===============================================================\n"));

		for (Crypto crypto : this.cryptoList) {
			sb.append(counter + ": " + crypto.findAllFieldValuesInCSVFormat().replace(",", "\t\t") + "\n");
			counter++;
		}

		return sb.toString();
	}

	public void loadCryptoFromCSVFile(File cryptoCSVFile) {
		FileReader cryptoCSVFileReader = null;
		BufferedReader bufferedCryptoCSVFileReader = null;
		String bufferData = null;

		// Create a file reader
		try {
			cryptoCSVFileReader = new FileReader(cryptoCSVFile);
			// Add a buffer to the file reader
			bufferedCryptoCSVFileReader = new BufferedReader(cryptoCSVFileReader);
			// Read first line of file and discard it. It contains column headers.
			bufferedCryptoCSVFileReader.readLine();

			while ((bufferData = bufferedCryptoCSVFileReader.readLine()) != null) {
				String[] cryptoFieldValues = bufferData.split(",");
				Crypto newCrypto = new Crypto(cryptoFieldValues[0], cryptoFieldValues[1], cryptoFieldValues[2],
						Integer.parseInt(cryptoFieldValues[3]));
				this.addCrypto(newCrypto);
			}
			System.out.println("Loaded Cryptos List from CSV file successfully!");
		} catch (FileNotFoundException fnfExc) {
			fnfExc.printStackTrace();
		} catch (IOException IOExc) {
			IOExc.printStackTrace();
		} finally {
			try {
				if (cryptoCSVFileReader != null) {
					// Flushes buffer, which transfers buffer data to the file, then closes buffer.
					bufferedCryptoCSVFileReader.close();
					// Close the file reader stream
					cryptoCSVFileReader.close();
				}
			} catch (IOException IOExc) {
				IOExc.printStackTrace();
			} // End catch
		} // End finally
	} // End load method

	public void saveCryptoToCSVFile(File cryptoDBFile) {
		FileWriter cryptoFileWriterStream = null;
		BufferedWriter bufferedcryptoFileWriterStream = null;
		try {
			cryptoFileWriterStream = new FileWriter(cryptoDBFile);
			bufferedcryptoFileWriterStream = new BufferedWriter(cryptoFileWriterStream);
			bufferedcryptoFileWriterStream.write("Crypto Adress,Name,Short Name,Amount" + "\n");

			// Write out Crypto data from cryptoList to buffer and flush it to CSV file
			for (Crypto cryptoObject : cryptoList) {
				bufferedcryptoFileWriterStream.write(cryptoObject.getCryptoAdress() + "," + cryptoObject.getName()
						+ "," + cryptoObject.getShortName() + "," + cryptoObject.getAmount() + "\n");
				// + "\n");
				bufferedcryptoFileWriterStream.flush(); // Flushes buffer which transfers buffer data to the file
			}
			System.out.println("Saved Cryptos List to CSV file successfully!");
		} catch (FileNotFoundException fnfExc) {
			fnfExc.printStackTrace();
		} catch (IOException IOExc) {
			IOExc.printStackTrace();
		} finally {
			try {
				if (cryptoFileWriterStream != null) {
					// Close buffer
					bufferedcryptoFileWriterStream.close();
					// Close file writer
					cryptoFileWriterStream.close();
				}
			} catch (IOException IOExc) {
				IOExc.printStackTrace();
			} // End catch
		} // End finally
	} // End Save method

	public CryptoManager loadCryptoManagerObjectFromFile(File cryptoObjectsFile) {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		CryptoManager sm = null;
		try {
			fis = new FileInputStream(cryptoObjectsFile);
			ois = new ObjectInputStream(fis);
			sm = (CryptoManager) ois.readObject();
		} catch (FileNotFoundException e) {
			System.out.println("error");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ois != null) {
					// Close ObjectOutputStream
					ois.close();
				}
				if (fis != null) {
					// Close FileOutputStream
					fis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			} // End catch
		} // End finally
		if (sm == null) {
		}
		return sm; // Returns null if no object is read in.
	}

	public void saveCryptoManagerObjectToFile(File cryptoObjectsFile) {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(cryptoObjectsFile);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(this);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (oos != null) {
					// Close ObjectOutputStream
					oos.close();
				}
				if (fos != null) {
					// Close FileOutputStream
					fos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			} // End catch
		} // End finally

	}

} // End Class