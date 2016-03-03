import java.util.Scanner;
import java.util.Random;
public class DamRISK {
	/**
	 * DEFINICIÓ DE CONSTANTS
	 */
	
	/**
	 * Véctor (array) amb els noms dels continents. La posició del continent dins del vector l'identifica en les diferents matrius o arrays on es relaciona. Seria la seva clau primària.
	 */
	public static final String[] continents = {"Amèrica Nord","Amèrica Sud","Àfrica","Europa","Àsia","Oceania"};
	
	/**
	 * Vector (array) amb els noms dels territoris. Es relacionen amb el seu continent ja que el nombre de fila correspon a la posició del array continents. 
	 *
	 * territoris[0] -> Correspondrà als territoris del continent[0] Amèrica del Nord
	 * territoris[1] -> Correspondrà als territoris del continent[1] Amèrica Sud
	 */
	public static final String[] territoris={"Alaska","Territorio del nor-oeste","Groenlandia","Alberta","Ontario","Labrador","Territorio del oeste","Territorio del este","America central",
			"Venezuela","Perú","Argentina","Brasil","África del norte","Egipto","Africa Oriental","Congo","África del sur","Magadascar","Europa Occidental","Gran Bretaña","Islandia","Escandinavia","Europa del norte","Europa del sur","Ucrania",
			"Ural","Afganistan","Oriente Medio","Siberia","Yakutia","Chita","Kamchatka","Mongolia","Japon","China","Siam","India","Indonesia","Nueva Guinea","Australia Occidental","Australia Oriental"};

	/**
	 * Matriu (array de dues dimensions) que ens permet identificar els païssos veïns i així poder moure exèrcits entre ells o atacar. Segons moment de la partida.
	 */
	//public static final String[][] fronteres={{"Alaska,Kamchatka"}};
	public static final String[][] veins={{"Alaska,Kamchatka"}};
	
	
	
	/**
	 * Véctor (array) amb els objectius del joc. La posició de l'objectiu dins del vector l'identifica en les diferents matrius o arrays on es relaciona. Seria la seva clau primària.
	 */	
	public static final String[] objectius = {"Amèrica sur i Àfrica","Amèrica del nord i Oceania","Àfrica i Àsia"};
	
	/**
	 * Véctor (array) amb la quantitat d'exèrcits inicials. En la posició 0 correspon a 3 jugadors i la posició 3 a 6 jugadors.
	 */
	public static final int[] exercitsInicials = {35,30,25,20};
	
	/**
	 * Véctor (array) amb la quantitat d'exèrcits que guanyes per continent conquistat. En la posició 0 correspon a Amèrica del Nord i la 5 a Oceania.
	 */
	public static final int[] continentsComplets = {5,2,3,5,7,2};
	
	/**
	 * Nombre que divideix els païssos conquerits per saber les unitats de reforç.
	 */
	public static final int divisioTerritori = 3;
	/**
	 * Nombre màxims de jugadors que poden jugar al DamRISK.
	 */
	public static final int maxJugadors = 6;
	/**
	 * Nombre mínim de jugadors que poden jugar al DamRISK.
	 */
	public static final int minJugadors = 3;
	
	
	
	public static void main (String[] args){
		Scanner lector = new Scanner(System.in);
		//Variables
		int numJugadors=0;
		int exercits_jugador=0;
		int TerAle=0;
		
		/**
		 * Matriu que representa el tauler de joc. Cada posició té un array on es guarda la informació següent
		 * {Id jugador, Número exercits}
		 * Cada posició és un territori.
		 */
		int[][] tauler = new int[42][2];
		
		/**
		 * Inicialitzem el tauler sense jugadors, valor -1. Doncs el jugador 0 existeix  
		 */
		for(int territori=0;territori<tauler.length;territori++){
			tauler[territori][0]=-1;
		}
		
		/**
		 * Vector per guardar els noms dels jugadors. La posició dins del vector és l'identificador de jugador.
		 */
		String[] nomsJugadors=null;
		/**
		 * Matriu on guardem la informació del joc per a cada jugador. On guardem la informació del jugador. Per a cada jugador guardem
		 * nomsJugadors[0] li correspon la infoJugadors
		 * {objectiu, cavalleria, artilleria, cano, comodi }
		 */
		int[][]  infoJugadors =null;
		
		/**
		 * Enter que indicarà el nombre de jugador que li toca tirar. 
		 */
		int torn=0;
	    
		/**
		 * Java.util.Scanner ens permet llegir de consola les dades dels usuaris
		 */
		//TODO Codi per demanar el nombre de jugadors
		do{
			System.out.println("Introduce el numero de jugadores.Minimo 3, máximo 6");
		
				numJugadors=lector.nextInt();
			if(numJugadors<minJugadors){
				System.out.println("No sois suficientes jugadores. ");
			}else{
				if(numJugadors>maxJugadors){
					System.out.println("Sois demasiados jugadores. ");
				}
			}
			
			
		}while(numJugadors<minJugadors || numJugadors>maxJugadors);
	
		//TODO Dimensionar els vectors nomsJugadors i infoJugadors
		nomsJugadors= new String[numJugadors];
		infoJugadors= new int[numJugadors][5];
		
		//TODO Calcular nombre d'exèrcits inicials
	
		switch(numJugadors){
		
		case 3:
			System.out.println("Sois 3 jugadores cada uno recibe "+exercitsInicials[0]+" unidades para distribuir entre sus territorios.");
			 exercits_jugador=exercitsInicials[0];
			
			
			break;
		case 4:
			System.out.println("Sois 4 jugadores cada uno recibe "+exercitsInicials[1]+" unidades para distribuir entre sus territorios.");
			exercits_jugador=exercitsInicials[1];
			
			break;
			
		case 5:
			System.out.println("Sois 5 jugadores cada uno recibe "+exercitsInicials[2]+" unidades para distribuir entre sus territorios.");
			exercits_jugador=exercitsInicials[2];
	
			break;
		case 6:
			System.out.println("Sois 6 jugadores cada uno recibe "+exercitsInicials[3]+" unidades para distribuir entre sus territorios.");
			exercits_jugador=exercitsInicials[3];
	
			break;
			
		}
		
		
		
		
		//TODO Demanar les dades als jugadors i preparar-los per poder iniciar el joc.
		for(int jugador=0;jugador<numJugadors;jugador++){
			//TODO Demanar el nom i guardar-ho en el vector
			System.out.println("Dime el nombre de un jugador");
				
				nomsJugadors[jugador]=lector.next();;
	
			
			//TODO Assignar objetiu
				int objetivos_jugador = (int) Math.round(Math.random() * 3);
				System.out.println("Tu objetivo es " + objectius[objetivos_jugador]);
				infoJugadors[jugador][0]=objetivos_jugador;
				
				//public static void repartirTerritorio(numJugadors,territoris,tauler,int jugador){
	               // -- con numJugadors tenéis que saber cuantos territorios daréis
	               //         -- dividis el número de territorios (length) entre el numjugadors
	                //        -- si no da justo unos tienen que tener uno más        
	                //-- for para repartir todas las cartas
	                 //       -- coger aleatoriàmente el territorio
	                  //      -- no se puede repetir territorio (do; while)
	                    //    -- asigno el territorio -> tauler[posicion_territorio][0]=jugador;
			
			//TODO Repartir territorios
				switch(numJugadors){
				
				case 3:
					
					int Jug3= territoris.length/3;
					
					for (int territori=0;territori<Jug3;territori++)
					{
						do{
							// TerAle = (int) Math.round(Math.random() * territoris.length);
							
							Random rnd = new Random();
							 TerAle = rnd.nextInt(territoris.length - 1);
							 
						}while((tauler[TerAle][0]>-1));	
						tauler[TerAle][0]=jugador;
						System.out.println("I els teus territoris son: ");
						System.out.println(territoris[TerAle]);
					}
					
				
					break;
					
					
				case 4:
					
					
					
					
					break;
					
					
					
				case 5:
					
					
					break;
					
					
					
				case 6:
					int Jug6= territoris.length/6;
					
					for (int territori=0;territori<Jug6;territori++)
					{
						do{
							Random rnd = new Random();
							TerAle = rnd.nextInt(territoris.length - 1);
							
						}while((tauler[TerAle][0] > -1));	
							tauler[TerAle][0]=jugador;
							System.out.println("I els teus territoris son: ");
							System.out.println(territoris[TerAle]);
					}
					
					break;
				}
				
				
				
				
				
				
				
				
			
			//TODO Assignar tropes
			
		}	
		//TODO Decidir qui comença a jugar i dir-ho per pantalla
		Random empieza = new Random();
		int jugadorEmpieza = empieza.nextInt(numJugadors);
		
		
		/**
		 * Pinta el tauler com ha quedat 
		 */
		for(int territori=0;territori<tauler.length;territori++){
			System.out.println(territoris[territori]+"-"+nomsJugadors[tauler[territori][0]]+"-"+tauler[territori][1]);
		}
	}	
	
}
