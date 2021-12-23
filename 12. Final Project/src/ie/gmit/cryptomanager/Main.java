package ie.gmit.cryptomanager;

//imports
import java.io.File;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * The Main class holds the main method.
 */
public class Main extends Application {
	
	// Used for managing crypto
	CryptoManager sm = new CryptoManager(); 
	
	@Override
	public void start(Stage primaryStage) {
		
		// Used to set stage title
		int noOfCmdLineArgs = 0;	
		// Used to set stage title
		String cmdLineArgs = null;	
		
		/* Preparing the Scenes */
		// Create gridpane node to use as root node of scene and to arrange child nodes logically
		GridPane gridPane1 = new GridPane();
		Text txtHeader = new Text("Please select an option below:");

		Button btnLoadCryptoList = new Button("Load Crypto from File");
		TextField tfLoadCryptoFilePath = new TextField();
		tfLoadCryptoFilePath.setPromptText("Path to Crypto File");
		Button btnAddCrypto = new Button("Add Crypto");
		TextField tfCryptoAdress = new TextField();
		tfCryptoAdress.setPromptText("Crypto Adress");
		TextField tfCryptoName = new TextField();
		tfCryptoName.setPromptText("Crypto Name");
		TextField tfCryptoShortName = new TextField();
		tfCryptoShortName.setPromptText("Short name");
		TextField tfSAmount = new TextField();
		tfSAmount.setPromptText("Amount");
		
		// Delete Crypto
		Button btnDelCrypto = new Button("Delete Crypto");
		TextField tfCryptoDel = new TextField();
		tfCryptoDel.setPromptText("Crypto Adress");
		
		// Show total number of Crypto
		Button btnShowTotal = new Button("Show Total of Cyprocurrencies");
		
		// Show total number of crypto
		Button btnShowCryptoList = new Button("Show Crypto List");
		
		// Save crypto to file
		Button btnSaveCryptoList = new Button("Save Crypto List");
		TextField tfSaveCryptoFilePath = new TextField();
		tfSaveCryptoFilePath.setPromptText("Path to Crypto File");
		
		// Add Quit button
		Button btnQuit = new Button("Quit");	
		
		// Create TextArea node for bottom of scene 1 to display output
		TextArea taMyOutput = new TextArea();
		
		// Adding and arranging all the nodes in the grid - add(node, column, row)
		gridPane1.add(txtHeader, 0, 0);
		gridPane1.add(btnLoadCryptoList, 0, 1);
		gridPane1.add(tfLoadCryptoFilePath, 1, 1);
		gridPane1.add(btnAddCrypto, 0, 2);
		gridPane1.add(tfCryptoAdress, 1, 2);
		gridPane1.add(tfCryptoName, 2, 2);
		gridPane1.add(tfCryptoShortName, 3, 2);
		gridPane1.add(tfSAmount, 4, 2);
		gridPane1.add(btnDelCrypto, 0, 3);
		gridPane1.add(tfCryptoDel, 1, 3);
		gridPane1.add(btnShowTotal, 0, 4);
		gridPane1.add(btnShowCryptoList, 0, 5);
		gridPane1.add(btnSaveCryptoList, 0, 6);
		gridPane1.add(tfSaveCryptoFilePath, 1, 6);
		gridPane1.add(btnQuit, 0, 7);
		gridPane1.add(taMyOutput, 0, 8, 5, 1);
		
		// Adding events to buttons
		// Load Crypto DB button
		btnLoadCryptoList.setOnAction(e -> {

			if (tfLoadCryptoFilePath.getText().trim().equals("")) { 
				// If text field is empty
				taMyOutput.setText("Please enter path to Crypto file.\n");
			} else {

				File cryptoObjectsFile = new File(tfLoadCryptoFilePath.getText());
				
				sm = sm.loadCryptoManagerObjectFromFile(cryptoObjectsFile);
				if (sm == null) {
					sm = new CryptoManager();
					taMyOutput.setText("ERROR: DB path " + tfLoadCryptoFilePath.getText() + " does not exist\n");
					taMyOutput.appendText("Please check DB path and try again");
					tfLoadCryptoFilePath.clear();
				} else {
					taMyOutput.setText("DB loaded successfully from " + tfLoadCryptoFilePath.getText());
					tfLoadCryptoFilePath.clear();
				}
			}

		});
		
		//Crypto button action
		btnAddCrypto.setOnAction(e -> {

			// If any of the Crypto fields are empty print prompt message
			if (tfCryptoAdress.getText().trim().equals("") || 
					tfCryptoName.getText().trim().equals("") ||
					tfCryptoShortName.getText().trim().equals("") ||
					tfSAmount.getText().trim().equals("")) { 
				taMyOutput.setText("Please enter ALL Cryoto details\n");
			} else {
				// Create new Crypto with information in text fields
				try {
					Crypto newCrypto = new Crypto(tfCryptoAdress.getText(), tfCryptoName.getText(), tfCryptoShortName.getText(), Integer.parseInt(tfSAmount.getText()));
					this.sm.addCrypto(newCrypto);
					// Print success message
					taMyOutput.setText(newCrypto.getName() + " " + newCrypto.getShortName() + " has been added to the crypto list");
				
					// Clear input fields
					tfCryptoAdress.clear();
					tfCryptoName.clear();
					tfCryptoShortName.clear();
					tfSAmount.clear();
				} catch (NumberFormatException ex) {
					ex.printStackTrace();
					taMyOutput.setText("Please enter amount of crypto");
				}

			}

		});
		
		// Delete Crypto button action
		btnDelCrypto.setOnAction(e -> {
			
			if (tfCryptoDel.getText().trim().equals("")) { // If text field is empty
				taMyOutput.setText("Please enter the Crypto adress you want to delete");
			} else {
				Crypto removedCrypto;
				removedCrypto = sm.deleteCryptoByNumber(Integer.parseInt(tfCryptoDel.getText()));
				if (removedCrypto != null) {
					taMyOutput.setText(removedCrypto.getName() + " " + removedCrypto.getShortName() + " has been removed from the crypto list!");
					tfCryptoDel.clear();
				} else {
					taMyOutput.setText("Crypto " + tfCryptoDel.getText() + " not found\n");
					taMyOutput.appendText("No crypto deleted!");
					tfCryptoDel.clear();
				}
			}

		});

		// Show total number of cryptocurrencies
		btnShowTotal.setOnAction(e -> {

			int totalCrypto = 0;
			// Find total Cryptos
			totalCrypto = sm.findTotalCrypto();
			taMyOutput.setText("Current Total cryptos: " + Integer.toString(totalCrypto));
		
		});
		
		// Show total number of Crypto
		btnShowCryptoList.setOnAction(e -> {

			taMyOutput.setText(sm.listAllCrypto());

		});
		
		
		btnSaveCryptoList.setOnAction(e -> {

			if (tfSaveCryptoFilePath.getText().trim().equals("")) { 
				// If text field is empty
				taMyOutput.setText("Please enter path to Crypto List.\n");
			} else {
				File cryptoListFile = new File(tfSaveCryptoFilePath.getText());
				try {
					sm.saveCryptoManagerObjectToFile(cryptoListFile);
					taMyOutput.setText("Crypto list saved!");
					tfSaveCryptoFilePath.clear();
				} catch (Exception exception) {
					System.out.print("[Error] Cannont save DB. Cause: ");
					exception.printStackTrace();
					taMyOutput.setText("ERROR: Failed to save Crypto DB!");
				}
			}

		});
		
		// Quit button action
		btnQuit.setOnAction(e -> Platform.exit());
		
	
		// Create scene and add the root node i.e. the gridpane
		Scene scene1 = new Scene(gridPane1, 600, 450);

		// Find number of command line arguments supplied 
		noOfCmdLineArgs = getParameters().getRaw().size();
		// If command line arguments have been provided then set the title to 
		// them. If none were provided then set title to default value.
		if (noOfCmdLineArgs > 0) {
			// Get command line arguments as String
			cmdLineArgs = getParameters().getRaw().toString();
			//System.out.println(cmdLineArgs);
			// Remove unwanted characters ([ and ] and ,)from string
			cmdLineArgs = cmdLineArgs.replaceAll("\\[|\\]|\\,", "");
			//System.out.println(cmdLineArgs);
			primaryStage.setTitle(cmdLineArgs);
		} else {
			// Default value
			primaryStage.setTitle("Crypto Manager Application");
		}
		
		// Setting the scene to Stage
		primaryStage.setScene(scene1);
		// Displaying the stage
		primaryStage.show();
		
		
	}// End Start Method
	

	public static void main(String[] args) {
		launch(args);
	}
	
} // End Main Class
