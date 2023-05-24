/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package juego_ahorcado;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author desst
 */
public class Ahorcado {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		//
		final String caracterRelleno="*";
		//Nos declaramos la palabra a buscar
		String ahorcado;
		//
		String[] arrayAhorcado = {"materia","tormenta","silencio","juego","madrid","arbol"};
		int numeroAleatorio = new Random().nextInt(arrayAhorcado.length-1);
		ahorcado=arrayAhorcado[numeroAleatorio];
		//Numero de errores permitido
		final int erroresPermitidos = 6;
		//Numero de errores acomulados
		int errores = 0;
		// Declaramos la letra que nos van a pedir
		String letra ="";
		//declaramos una cadena con los ----
		String cadenaAciertos = rellenarCaracteres(ahorcado.length(),caracterRelleno);
		char[] caracteres=cadenaAciertos.toCharArray();
		//Pedimos las distintas letras
		while (errores <=erroresPermitidos ){
			//mientras que errores acomulados sean menor o igual que 6 se le irá pidiendo cosas
			System.out.println("Introduzca una letra:");
			letra = scanner.next().toLowerCase();
			// comprobar que la letra no haya sido introducida antes
			
			// preguntamos si la cadena contiene la letra introducida
			if(ahorcado.contains(letra)) {				
				//colocamos la letra acertada en la variable cadenaAciertos
					// buscamos la posición en la variable ahorcado
				for(int i=0;i<ahorcado.length();i++) {
					if(ahorcado.charAt(i)==letra.charAt(0)) {
						caracteres[i]=letra.charAt(0);
					}					
				}
				// colocamos la letra en la posición correcta de cadenaAciertos
				
				cadenaAciertos=String.valueOf(caracteres);
				//mostramos la variable cadenaAciertos para que vea que letras tiene acertadas
				System.out.println(cadenaAciertos);
				if(cadenaAciertos.equals(ahorcado)) {
					break;
				}
			}else { // ha fallado
				// aumentamos los errores en 1
				errores++;
				System.out.println("Esa letra no es correcta, llevas: " + errores + " errores.");

			}
		}
		if (errores == 7) {//errores es igual a 7?
			System.out.println("Juego terminado, has perdido, la palabra correcta era: " + ahorcado);
		}else {
			System.out.println("Enhorabuena. Juego terminado");
		}
		

	}
	public static String rellenarCaracteres(int numero, String caracter) {
		
		String cadena = "";
		for(int i=1; i<=numero; i++) {
			//cadena += caracter ;
			cadena=cadena+caracter;
		}
		//System.out.println("La cadena es:" + cadena);

		return cadena;
	}
}
