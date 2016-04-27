public class Seeder {

	
	/* !!Was ist das und warum?
	 * Der Seeder f�llt die DB mit Dummy-Daten. Denn um zu Testen sind 
	 * Testdaten sehr praktisch:
	 * 
	 * 1. Im Laufe der Entwicklung muss die Datenbank immer wieder neu 
	 * aufgesetzt werden: zB weil neue Spalten hinzugef�gt oder gel�scht 
	 * werden m�ssen. Jedes Mal neue Daten einzugeben ist sehr anstrengend.
	 * 
	 * 2. Mit Testdaten l�sst sich die Funktionalit�t der Datenbank/Applikation 
	 * schnell testen.Wenn Tabellen und Daten nicht richtig zusammenpassen, 
	 * f�llt das mit einem Seeder schnell auf.
	 */

	/** !!Wie es funktioniert:
	 *  F�r jede MapperKlasse (bsp: SomeObjectMapper) braucht es einen Block,
	 *  der in der Vorlage eingerahmt wird von den Kommentaren 'someTable start' 
	 *  und 'someTable end'. Jeder Block besteht aus einer Methode (bsp: seedSomeTable()), 
	 *  die die Datenbank f�llt und Arrays aus den n�tigen Werten (bsp: 'someValues').
	 *  
	 *  Die seedSomeTable() Methode ruft in der entsprechenden MapperKlasse
	 *  (bsp: SomeObjectMapper) die insert() Methode auf (bsp: insertSObject()).
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
	 * 6. Von wo auch immer die seed() Methode aufrufen. Die ruft alle andern Methoden
	 *    auf und bef�llt eure Datenbank.
	 *    
	 * 7. Sich freuen wie n Iltis! 
	 * 
	 */

	public void init(){
		migrate();
		seed();
	}
	
	public void migrate(){
		SomeMapper.someMapper().createTable();
		//n�chster Mapper@createTable();
	
	public void seed(){
		seedSomeTable();
		//n�chste seedSomeTable();
	}
	
	/************* someTable start *******************/
	public void seedSomeTable(){
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
