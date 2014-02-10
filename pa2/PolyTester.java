import java.util.ArrayList;

public class PolyTester
{
    public static void main(String[] args)
    {
        ArrayList<Term> list = new ArrayList<Term>();
        for(int i=0; i<11; i++)
        {
            list.add(new Term(i+2, i));
            //System.out.println(list.get(i).getCoeff());
        }
        list.add(new Term(3, 10));
        list.add(new Term(3, 14));
        list.add(new Term(4.5, 14));
        list.add(new Term(0, 23));

        Poly polyTester = new Poly();
        Poly polyTester1 = new Poly(new Term(3,5));
        Poly polyTester2 = new Poly(list);
        System.out.println(polyTester2.toFormattedString());
        System.out.println(polyTester2.eval(1));
        System.out.println(polyTester2.eval(0));
        System.out.println(polyTester1.toFormattedString());
        System.out.println(polyTester1.eval(1));
        System.out.println(polyTester1.eval(2));
        System.out.println(polyTester1.eval(3));
        System.out.println(polyTester.toFormattedString());
    }
}