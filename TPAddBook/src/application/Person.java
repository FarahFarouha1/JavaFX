package application;

import javafx.beans.property.SimpleStringProperty;

public class Person {
	private SimpleStringProperty prenom;
	private SimpleStringProperty nom;
	private SimpleStringProperty email;
	private  SimpleStringProperty  age;
	public Person(String prenom, String nom, String email,String age) {
		super();
		this.prenom = new SimpleStringProperty(prenom);
		this.nom = new SimpleStringProperty(nom);
		this.email = new SimpleStringProperty(email);
		this.setAge(new  SimpleStringProperty (age));
	}
	public SimpleStringProperty getPrenom() {
		return prenom;
	}
	public void setPrenom(SimpleStringProperty prenom) {
		this.prenom = prenom;
	}
	public SimpleStringProperty getNom() {
		return nom;
	}
	public void setNom(SimpleStringProperty nom) {
		this.nom = nom;
	}
	public SimpleStringProperty getEmail() {
		return email;
	}
	public void setEmail(SimpleStringProperty email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Person : prenom=" + prenom.getValue() + ", nom=" + nom.getValue() + ", email=" + email.getValue()+ " , age= "
				
				+this.getAge();
	}
	public SimpleStringProperty getAge() {
		return age;
	}
	public void setAge(SimpleStringProperty age) {
		this.age = age;
	}
	
	
	
	
}