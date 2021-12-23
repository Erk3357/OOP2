package ie.gmit.cryptomanager;

//Import
import java.io.Serializable;
import java.lang.reflect.Field;

public class Crypto implements Serializable {
	
	// Add for serialization
	private static final long serialVersionUID = 1L;
	
	//Instance Variables
	private String cryptoAdress;
	private String name;
	private String shortName;
	private int amount;
	
	// Constructor
	public Crypto(String cryptoAdress) {
		this.cryptoAdress = cryptoAdress;
	}
	
	public Crypto(String CryptoAdress, String name, String shortName) {
		this(CryptoAdress);
		this.name = name;
		this.shortName = shortName;
	}

	public Crypto(String cryptoAdress, String name, String shortName, int amount) {
		this(cryptoAdress, name, shortName);
		this.amount = amount;
	}
	
	// Getters and Setters
	public String getCryptoAdress() {
		return cryptoAdress;
	}
	
	public void setCryptoAdress(String cryptoAdress) {
		this.cryptoAdress = cryptoAdress;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public String findAllFieldValuesInCSVFormat() {
		StringBuilder listOfFields = new StringBuilder();
		//String newLine = System.getProperty("line.separator");
		
		// determine fields declared in this class only (no fields of superclass)
		Field[] fields = this.getClass().getDeclaredFields();

		// print field names
		for (Field field : fields) {
		//	result.append("  ");
		try {
			// discard static fields
			if (!java.lang.reflect.Modifier.isStatic(field.getModifiers())) {
				//listOfFields.append(field.getName());
				//requires access to private field:
				listOfFields.append( field.get(this) );
				listOfFields.append(",");
		    }	
				// requires access to private field:
				//result.append(field.get(this));
			} catch (IllegalAccessException ex) {
				System.out.println(ex);
			}
			//result.append(newLine);
		}
		// Remove comma at end
		if( listOfFields.length() > 0 ) {
			listOfFields.setLength( listOfFields.length() - 1 );
			//listOfFields.append(newLine); 
		}

		return listOfFields.toString();
	}
	
}