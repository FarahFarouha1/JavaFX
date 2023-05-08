package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Window;

public class AddBookControlor implements Initializable{
	
	@FXML
	private TextField tfLastname;
	@FXML
	private TextField tfFirstname;
	@FXML
	private TextField tfEmail;
	@FXML
	private TextField tfAge;
	
	
	
	@FXML
	private Button addBtn;
	@FXML
	private Button exportBtn;
	@FXML
	private Button importBtn;
	@FXML
	private Button removeBtn;
	@FXML
	private Button quitBtn;
	@FXML
	private TableView<Person> table;
	@FXML
	private TableColumn<Person, String> emailCol;
	@FXML
	private TableColumn<Person, String> firstNameCol;
	@FXML
	private TableColumn<Person, String> lastNameCol;
	
	@FXML
	private TableColumn<Person, String> ageCol;
	
	private DataClass data=new DataClass();
	ObservableList <Person> list;
	@FXML
	void add(ActionEvent event)
	{
		Window owner = addBtn.getScene().getWindow();
		if(tfLastname.getText().isEmpty()) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Form Error!");
			alert.setHeaderText(null);
			alert.setContentText("Please enter your last name");
			alert.initOwner(owner);
			alert.show();
		}
		else if (tfFirstname.getText().isEmpty()){
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Form Error!");
			alert.setHeaderText(null);
			alert.setContentText("Please enter your first name");
			alert.initOwner(owner);
			alert.show();
		}
		else if (tfEmail.getText().isEmpty()){
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Form Error!");
			alert.setHeaderText(null);
			alert.setContentText("Please enter your email");
			alert.initOwner(owner);
			alert.show();
		}
		
		else if (tfAge.getText().isEmpty()){
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Form Error!");
			alert.setHeaderText(null);
			alert.setContentText("Please enter your Age");
			alert.initOwner(owner);
			alert.show();
		}
		
	
		else {
			list.add(new Person(tfLastname.getText(),tfFirstname.getText(),tfEmail.getText() ,tfAge.getText()));
			tfEmail.setText(null);
			tfFirstname.setText(null);
			tfLastname.setText(null);
			tfAge.setText(null);
		}
	}
	@FXML
	void remove(ActionEvent event) {
		Window owner = addBtn.getScene().getWindow();
		Person p=table.getSelectionModel().getSelectedItem();
		list.remove(p);
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("successfully deleted");
		alert.setHeaderText(null);
		alert.setContentText("Item has been successfully deleted");
		alert.initOwner(owner);
		alert.show();
	}
	
	
//	ObservableValue<int[]> 
	@FXML
	void importt(ActionEvent event) {
		table.setEditable(true);
		firstNameCol.setCellValueFactory(cellData -> cellData.getValue().getNom());
		lastNameCol.setCellValueFactory(cellData -> cellData.getValue().getPrenom());
		emailCol.setCellValueFactory(cellData -> cellData.getValue().getEmail());
		ageCol.setCellValueFactory(cellData -> cellData.getValue().getAge());
		list=getlist();
		table.setItems(list);
		
		// make column of table editable
		firstNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
		lastNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
		emailCol.setCellFactory(TextFieldTableCell.forTableColumn());
		ageCol.setCellFactory(TextFieldTableCell.forTableColumn());
	}
	@FXML
	void export(ActionEvent event) {
		Window owner = addBtn.getScene().getWindow();

		for (Person p:table.getItems()){
			System.out.println(p);
		}
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("successfully exported");
		alert.setHeaderText(null);
		alert.setContentText("Data has exporetd with successfully");
		alert.initOwner(owner);
		alert.show();
	}
	
	
	@FXML
	void quit(ActionEvent event) {
		Platform.exit();
	}
	@FXML
	void addElement(ActionEvent event) {
		
		
	}
	public ObservableList<Person> getlist()
	{
		ObservableList<Person> l= FXCollections.observableArrayList();
		for (Person e :data.getImportList()) {
			l.add(e);
		}
		
		return l;
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// you must change the deflaut editable
		table.setEditable(true);
		firstNameCol.setCellValueFactory(cellData -> cellData.getValue().getNom());
		lastNameCol.setCellValueFactory(cellData -> cellData.getValue().getPrenom());
		emailCol.setCellValueFactory(cellData -> cellData.getValue().getEmail());
		ageCol.setCellValueFactory(cellData -> cellData.getValue().getAge());
		list=getlist();
		table.setItems(list);
		
		// make column of table editable
		firstNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
		lastNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
		emailCol.setCellFactory(TextFieldTableCell.forTableColumn());
		ageCol.setCellFactory(TextFieldTableCell.forTableColumn());
	}

}