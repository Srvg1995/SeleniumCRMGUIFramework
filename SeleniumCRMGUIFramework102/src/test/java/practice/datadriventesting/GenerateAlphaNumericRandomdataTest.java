package practice.datadriventesting;

import java.util.Random;

//These AlphaNumericRandomdata will be used in Banking Application
public class GenerateAlphaNumericRandomdataTest {

	public static void main(String[] args) {
		int n=20;

		//choose a Character random from this string
		String AlphaNumericString="ABCDEFGHIJKLMNOPQRSTUVWXYZ012345679abcdefghijklmnopqrstuvwxyz";

		//create StringBuffer size of Alphanumeric string
		StringBuffer sb=new StringBuffer(n);
		for(int i=0;i<n;i++) {

			//generate a random number 0 to AlphaNumericString variable length
			int index=(int)(AlphaNumericString.length()*Math.random());

			//add Chracter one by one in end of sb
			sb.append(AlphaNumericString.charAt(index));
		}
		System.out.println(sb);
	}

}
