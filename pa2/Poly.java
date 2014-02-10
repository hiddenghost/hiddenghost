// Name: Shijie Xu
// USC loginid: shijiexu
// CS 455 PA2
// Spring 2014

import java.lang.Math;
import java.util.Hashtable;
import java.util.Enumeration;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Arrays;


/**
   A polynomial. Polynomials evaluated and converted to a string form
   for printing.
*/
public class Poly
{
    private Term[] polyList;
    /**
       Creates the 0 polynomial
    */
    public Poly()
    {
        polyList = new Term[0];
        assert isValidPoly();
    }

    /**
       Creates polynomial with single term given
     */
    public Poly(Term term)
    {
        polyList = new Term[1];
        polyList[0] = term;
        System.out.println("DEBUG: sorted array: " + Arrays.toString(polyList));
        assert isValidPoly();
    }


    /**
       Creates polynomial from a (possibly-empty) ArrayList of terms.
       The terms in the ArrayList have no restrictions: can be in any
       order, have 0 terms, and/or duplicate exponents.
       The given ArrayList is not modified by the constructor.
    */
    public Poly(ArrayList<Term> termList)
    {
        Hashtable<Integer, Double> polyHash = new Hashtable<Integer, Double>();
        int key = 0;
        double value = 0;
        for(int i=0; i<termList.size(); i++)
        {
            key = termList.get(i).getExpon();
            value = termList.get(i).getCoeff();
            if(value != 0)
            {
                if(polyHash.containsKey(key))
                {
                    polyHash.put(key, polyHash.get(key)+value);
                }
                else
                {
                    polyHash.put(key, value);
                }
            }
        }
        ArrayList<Term> finalList = new ArrayList<Term>();
        Enumeration keyEnumeration = polyHash.keys();
        while(keyEnumeration.hasMoreElements())
        {
            key = (int) keyEnumeration.nextElement();
            //System.out.print(key);
            //System.out.println(": "+polyHash.get(key));
            finalList.add(new Term(polyHash.get(key),key));
        }
        //Term[] tempArr = termList.toArray(new Term[termList.size()]);
        Term[] tempArr = finalList.toArray(new Term[finalList.size()]);
        polyList = tempArr;
        // makes a copy into an array
        Arrays.sort(tempArr, new TermComparator());
        // sorts in decreasing order by exponent
        //System.out.println("DEBUG: sorted array: " + Arrays.toString(tempArr));
                                    	// you can remove this line later
                                        // you complete the implementation of this method . . .
        assert isValidPoly();
    }
    /**
       Returns the value of the poly at a given value of x.
     */
    public double eval(double x)
    {
        double result = 0;
        if(polyList.length >= 1)
        {
            for(int i=0; i<polyList.length; i++)
            {
                result += polyList[i].getCoeff() * Math.pow(x, polyList[i].getExpon());
            }
        }
        assert isValidPoly();
        return result;         // dummy code.  just to get stub to compile
    }


    /**
       Return a String version of the polynomial with the 
       following format, shown by exmaple:
       zero poly:   "0.0"
       1-term poly: "3.2x^2"
       4-term poly: "3.0x^5 + -x^2 + x + -7.9"

       Poly is in a simplified form (only one term for any exponent),
       with no zero-coefficient terms, and terms are shown in
       decreasing order by exponent.
    */
    public String toFormattedString()
    {
        String polyString = "";
        if(polyList.length >= 1)
        {
            if(polyList[0].getCoeff() != 0)
            {
                polyString += polyList[0].getCoeff();
                if(polyList[0].getExpon() != 0)
                    polyString += "x^" + polyList[0].getExpon();
            }
            for(int i=1; i<polyList.length; i++)
            {
                if(polyList[i].getCoeff() != 0)
                {
                    polyString += "+" + polyList[i].getCoeff();
                    if(polyList[i].getExpon() != 0)
                    {
                        polyString += "x^" + polyList[i].getExpon();
                    }
                }
            }
        }
        else
            polyString += "0.0";
        assert isValidPoly();
        return polyString;        // dummy code.  just to get stub to compile
    }

    // **************************************************************
    //  PRIVATE METHOD(S)

    /**
       Returns true iff the poly data is in a valid state.
    */
    private boolean isValidPoly()
    {
        if(polyList.length >= 1)
        {
            for(int i=0; i < polyList.length; i++)
            {
                if(polyList[i].getCoeff() == 0)
                    return false;
            }
        }
        return true;     // dummy code.  just to get stub to compile
    }



    // **************************************************************
    //  PRIVATE INSTANCE VARIABLE(S)


}

// *****************************************************************
// Helper class needed for call to Arrays.sort above  -- DO NOT CHANGE

// comparator to be used by sort in ArrayList to Poly constructor, above
class TermComparator implements Comparator<Term>
{

    // returns value < 0 if t1's exponent is > t2's exponent 
    //                                   (i.e. t1 should come before t2),
    // value > 0 if t1's exponent is < t2's exponent 
    //                                   (i.e., t1 should come after t2),
    // and 0 if their exponents are the same
    public int compare(Term t1, Term t2)
    {
        return t2.getExpon() - t1.getExpon();
    }
}
