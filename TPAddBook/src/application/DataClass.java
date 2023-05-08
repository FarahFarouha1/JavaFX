package application;

import java.util.ArrayList;
import java.util.List;

public class DataClass {
	private List<Person> importList;
	private List<Person> exportList;
	public DataClass() {
		importList=new ArrayList<Person>();
		importList.add(new Person("Sami","BenAli","sami@exemple.com","12"));
		importList.add(new Person("Alia","BenSalah","alia@exemple.com","18"));
		importList.add(new Person("Ali","BenSalah","ali@exemple.com","45"));
		exportList=new ArrayList<Person>(); 
	}
	public List<Person> getImportList() {
		return importList;
	}
	public List<Person> getExportList() {
		return exportList;
	}
	public void setExportList(List<Person> exportList) {
		this.exportList.addAll(exportList);
		for(Person p:this.exportList) {
			System.out.println(p);
		}
	}
	
}