/*
Functional Requirement (FR)

FR1. The output of the method should be the String value out of the array passed 
     in that contains the least number of numeric characters.  

FR2. If two Strings have the same number of numeric characters, return the 
     longest String.  

FR3. If two Strings have the same number of numeric characters and are the 
     same length, return the String that appears first in the input array.

FR4. If the array is empty, return null;
*/

class BestString {

	public String getBestString(String[] values) {
		String best = null;
		
		// FR4 - If the array is empty, return null;
		if (null==values)
			return null;

		int idx=0;
		int numLow=0; // lowest numeric valued string pointer
		int firstDupIdx=0; // first of duplicate strings
		int numericCnt=0; // numeric content of string

		int stringIdx=0;
		int longStrIdx=0; // pointer to longest string in array
		int longStrVal=0; // length of longest string in array
		int dupLen=0;

		boolean dupFlag=false;

		for (String value : values) {

			// calc the total numeric value in current string in array
			for (char ch: value.toCharArray()) {
				if (Character.isDigit(ch)) {
					numericCnt++;
				}
			}

			// if the lowest value of numeric items have a duplicate
			if (numericCnt==numLow) {
				dupFlag=true;
				
				String first = values[firstDupIdx];
				String second = values[idx];

				if (first.length()==second.length()) {
					longStrIdx=firstDupIdx;
				}

				break;
			}
			
			// set a pointer to lowest numeric string
			if ((numericCnt < numLow) || idx==0)  {
				numLow=numericCnt;
				stringIdx=idx;
				firstDupIdx=idx;
			}

			// set a pointer to highest numeric string
			int l = value.length();
			if (l > longStrVal) {
				longStrVal=l;
				longStrIdx=idx;
			}

			// System.out.println(value + " = " + l + " = " + numericCnt);
			numericCnt=0;
			idx++;
		}

		//System.out.println("lowest: " + numLow);
		//System.out.println(values[stringIdx]);
		//System.out.println(dupFlag);

		// return the best string
		if (dupFlag) {
			best = values[longStrIdx]; // FR2.
		} else {
			best = values[stringIdx]; // FR1.
		}
		
		return best;
	}

	public static void main(String[] args) 
	{
		String[] values = {
			"The First 48",
			"Play Station 2",
			"Play Station 3",
			"XBox 360" };

		BestString bs = new BestString();
		System.out.println(bs.getBestString(null));
		System.out.println(bs.getBestString(values));
	}
}
