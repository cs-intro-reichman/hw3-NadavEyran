// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));

	    System.out.println(plus(-2,-3));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
    if (x2 < 0) {
        for (int i = 0; i > x2; i--) {
            x1--;
        	}
    	} else {
        for (int i = 0; i < x2; i++) {
            x1++;
        	}
    	}
    return x1;
	}
	// Returns x1 - x2
	public static int minus(int x1, int x2) {
    if (x2 < 0) {
        for (int i = 0; i > x2; i--) {
            x1++;
        }
    } else {
        for (int i = 0; i < x2; i++) {
            x1--;
        	}
    	}
    return x1;
	}
	// Returns x1 * x2
	public static int times(int x1, int x2) {
	    int result = 0;

	    boolean isNegative = false; 

	    if (x1 < 0) {
	        x1 = -x1;
	        isNegative = !isNegative;
	    }
	    if (x1 < 0) {
	        x1 = -x2;
	        isNegative = !isNegative;
	    }

	    for (int i = 0; i < x1; i++) {
	        result += x2;
	    }

		if (isNegative) {
		    return -result;
		} else {
		    return result;
		}
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
        int result = 1;

        for (int i = 0; i < n; i++) {
        	result = times(result,x);
        }

        return result;
    }
	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
    	if ( x2 == 0) {
    		return (000);
    	}
	    int result = 0;
	    boolean isNegative = false; 

	    if (x2 < 0) {
	        x2 = (-x2);
	        isNegative = !isNegative;
	    }
	    if (x1 < 0) {
	        x1 = -x1;
	        isNegative = !isNegative;
	    }
	    while (x1 >= x2) {
	        x1 = minus(x1,x2);
	        result++; 
	    }
		if (isNegative) {
		    return -result;
		} else {
		    return result;
		}
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
	    if (x2 == 0) {
    		return (000);
	    }

	    boolean isNegative = false;

	    if (x1 < 0) {
	        x1 = -x1;
	        isNegative = true;
	    }
	    if (x2 < 0) {
	        x2 = -x2;
	    }

	    while (x1 >= x2) {
	        x1 = minus(x1, x2);
	    }

		if (isNegative) {
		    return (-x1);
		} else {
		    return x1;
		}
	}


	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
    	if (x < 0) {
    		return (-1);
    	}

    	int guess = 0;

   		while (times(guess, guess) <= x) {
       		guess = plus(guess, 1);
    	}
    	guess--;
    	return (guess);
	}}