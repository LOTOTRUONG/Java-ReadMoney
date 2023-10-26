package fr.fs.algor2;

import java.util.Scanner;

public class Read_money {
	
	static Scanner algo017 = new Scanner(System.in);
    public static void main(String[] args) {
    	
    	
   System.out.print("Saisissez votre montant a payer: ");
	float montant = algo017.nextFloat(); 
    	
    	
	System.out.println("\nMontant est  " + montant);
	
	long entier = (long)( montant ) ;
	double decimal = ( montant - entier ) * 100.0f ;
    
    String resultat = Read_moneyFrenchNumberToWords.convert(entier) + " euro"+ " , "
            + Read_moneyFrenchNumberToWords.convert(decimal) + " centimes";
    
    
    		System.out.println("\n" +resultat);
}
}

