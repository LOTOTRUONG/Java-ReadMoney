package fr.fs.algor2;

import java.text.*;

class Read_moneyFrenchNumberToWords {

private static final String[] ten_mulpti = {"",  "","vingt", "trente", "quarante", "cinquante", "soixante", "soixante", "quatre-vingt", "quatre-vingt" };

private static final String[] numberbelow20 = {"","un", "deux", "trois","quatre","cinq","six","sept","huit", "neuf","dix","onze","douze", "treize", "quatorze","quinze","seize","dix-sept", "dix-huit","dix-neuf"};

private static final String[] numberintheUnit = { "", "", "deux", "trois","quatre", "cinq","six","sept","huit","neuf","dix" };

	  private Read_moneyFrenchNumberToWords() {}

	  private static String convertZeroToHundred(int number) {

	    int Dizaine = number / 10;
	    int Unite = number % 10;
	    String result = "";

	    switch (Dizaine) {
	    case 1 :
	    case 7 :
	    case 9 :
	      Unite = Unite + 10;
	      break;
	    default:
	    }

	    // séparateur "-" "et"  ""
	    
	    String space = "";
	    if (Dizaine > 1) { 
	    	space = "-"; }
	    // cas particuliers
	    switch (Unite) {
	   case 0: 
		   space = "";
	    break;
	    case 1 : 
	     if (Dizaine == 8) {
	    	 space = "-";
	    }
	     else {
	        space = " et ";
	      }
	      break;
	    case 11 : 
	      if (Dizaine == 7) {
	        space = " et ";
	      }
	      break;
	    default:
	    }

	    // dizaines en lettres
	    switch (Dizaine) {
	    case 0:
	      result = numberbelow20[Unite];
	      break;
	    	
	    case 8 :
	      if (Unite == 0) {
	        result = ten_mulpti[Dizaine];
	      }
	      else {
	        result = ten_mulpti[Dizaine]
	                                + space + numberbelow20[Unite];
	      }
	      break;
	    default :
	      result = ten_mulpti[Dizaine]
	                              + space + numberbelow20[Unite];
	    }
	    return result;
	  }

	  private static String convertLessThanOneThousand(int number) {

	    int lesCentaines = number / 100;
	    int leReste = number % 100;
	    String sReste = convertZeroToHundred(leReste);

	    String result;
	    switch (lesCentaines) {
	    case 0:
	      result = sReste;
	      break;
	    case 1 :
	      if (leReste > 0) {
	        result = "cent " + sReste;
	      }
	      else {
	        result = "cent";
	      }
	      break;
	    default :
	      if (leReste > 0) {
	        result = numberintheUnit[lesCentaines] + " cent " + sReste;
	      }
	      else {
	        result = numberintheUnit[lesCentaines] + " cents";
	      }
	    }
	    return result;
	  }

	  public static String convert(double decimal) {
	    // 0 à 999 999 999 999
	    if (decimal == 0) { return "zero"; }

	    String snumber = Float.toString((float) decimal);

	    // pad des "0"
	    String mask = "000000000000";
	    DecimalFormat df = new DecimalFormat(mask);
	    snumber = df.format(decimal);

	    // XXXnnnnnnnnn
	    int lesMilliards = Integer.parseInt(snumber.substring(0,3));
	    // nnnXXXnnnnnn
	    int lesMillions  = Integer.parseInt(snumber.substring(3,6));
	    // nnnnnnXXXnnn
	    int lesCentMille = Integer.parseInt(snumber.substring(6,9));
	    // nnnnnnnnnXXX
	    int lesMille = Integer.parseInt(snumber.substring(9,12));

	    String tradMilliards;
	    switch (lesMilliards) {
	    case 0:
	      tradMilliards = "";
	      break;
	    case 1 :
	      tradMilliards = convertLessThanOneThousand(lesMilliards)
	         + " milliard ";
	      break;
	    default :
	      tradMilliards = convertLessThanOneThousand(lesMilliards)
	         + " milliards ";
	    }
	    String result =  tradMilliards;

	    String tradMillions;
	    switch (lesMillions) {
	    case 0:
	      tradMillions = "";
	      break;
	    case 1 :
	      tradMillions = convertLessThanOneThousand(lesMillions)
	         + " million ";
	      break;
	    default :
	      tradMillions = convertLessThanOneThousand(lesMillions)
	         + " millions ";
	    }
	    result =  result + tradMillions;

	    String tradCentMille;
	    switch (lesCentMille) {
	    case 0:
	      tradCentMille = "";
	      break;
	    case 1 :
	      tradCentMille = "mille ";
	      break;
	    default :
	      tradCentMille = convertLessThanOneThousand(lesCentMille)
	         + " mille ";
	    }
	    result =  result + tradCentMille;

	    String tradMille;
	    tradMille = convertLessThanOneThousand(lesMille);
	    result =  result + tradMille;

	    return result;
	  }



	
	}


