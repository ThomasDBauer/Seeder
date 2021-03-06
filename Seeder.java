public class Seeder {

	
	/* !!Was ist das und warum?
	 * Der Seeder erstellt erst die n�tigen Tabellen und f�llt sie mit Dummy-Daten. 
	 * W�hrend der Entwicklung ist das sehr praktisch:
	 * 
	 * 1. Im Laufe der Entwicklung muss die Datenbank immer wieder neu 
	 * aufgesetzt werden: zB weil neue Spalten hinzugef�gt oder gel�scht 
	 * werden m�ssen. Jedes Mal neue Tabellen zu erstellen und die Daten 
	 * daf�r einzugeben ist sehr anstrengend.
	 * 
	 * 2. Mit Testdaten l�sst sich die Funktionalit�t der Datenbank/Applikation 
	 * schnell testen. Wenn Tabellen und Daten nicht richtig zusammenpassen, 
	 * f�llt das mit einem Seeder schnell auf.
	 */
	
	/* !!HowTo:
	 * 
	 * 0. In das Package mit den MapperKlassen diese SeederKlasse implementieren.
	 * 
	 * 1. ein neuen Block starten. zB **** profilTable start ****
	 * 
	 * 2. eine Methode schreiben. zB seedProfilTable()
	 * 
	 * 3. f�r jedes Attribut des BusinessObjects einen Array anlegen
	 * 	  mit den ben�tigten Werten. zB 10xVornamen, 10xNachnamen und 10xAlter
	 * 
	 * 4. Eine Schleife in die seedProfilTable() schreiben, die die Mapper.insert()
	 *    benutzt und daf�r die Werte aus den Arrays aus 3. benutzt.
	 *    
	 * 5. Die neue Methode aus 2. in die seed() Methode schreiben. 
	 *    5.1 Die createTable() des Mappers in die migrate() Methode schreiben.
	 * 
	 * 6. Von wo auch immer die seed() Methode aufrufen. Die ruft alle anderen Methoden
	 *    auf und bef�llt die Datenbank.
	 *    Hier bietet sich die Klasse SeedButton an, die mit einer Zeile instanziiert und
	 *    einem Panel hinzugef�gt werden kann.
	 *    
	 * 7. Sich freuen wie n Iltis! 
	 * 
	 */
	

	/** Diese Methode startet den ganzen Prozess) */
	public void init(){
		migrate();
		seed();
	}
	

	/**Hier m�ssen die createTable() Methoden der Mapper eingef�gt werden */
	private void migrate(){
		SomeMapper.someMapper().createTable();
		//n�chster Mapper@createTable();
	}


	/**Hier werden die selbstgeschriebenen Methoden aus den Bl�cken unten eingef�gt */
	private void seed(){
		seedSomeTable();
		//n�chste seedSomeTable();
	}
	
	/************* someTable start *******************/
	private void seedSomeTable(){
		for(int i = 0; i < someValues.length; i++){
			SomeObject so = new SomeObject();
			so.setAlter(someValues[i]);
			so.setFname(someOtherValues[i]);
			SomeObjectMapper.someObjectMapper().insertSObject(so);
		}
	}
	
	private int[]someValues = {
		5, 6, 7, 12, 54, 2, 98, 1, 54, 90
	};
	
	private String[]someOtherValues = {
		"Thomas", "Hanna", "Dieter", "Gerd", "Mike",
		"Kerstin", "Anna", "Peter", "Martin", "Tim"	
	};
	
	/************* someTable end *******************/

	/************* someOtherTable start *******************/
	//genau wie bei 'someTable'


}
