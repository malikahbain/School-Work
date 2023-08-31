import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//Student ID:
//Student Name: Malikah Bain

/*/
Student Comments:


*/


public class A5Q1 {
    
    //This should find all the permutations of a string and return those in an array
    //feel free to write any helper method(s) that would do the recursion 
    //You may assume that the String s is made of uniique characters (no character repeated)
    public static ArrayList<String> permute(String s)
    {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList = stringToList(s);

        for(int i=0; i < arrayList.size(); i++){
            String fixed =  arrayList.get(i);

            for(int j=0; j<arrayList.size(); j++){
                String temp = arrayList.get(i);
                arrayList.set(0, (arrayList.get(j)));
                arrayList.set(j, arrayList.get(j));

                permute(s);

            }
        }

        return arrayList;//should return an arraylist
    }
   
    public static ArrayList<String> stringToList(String s){
        ArrayList<String> arrayList = new ArrayList<String>();

        for(int i=0; i < s.length(); i++){
            String temp = Character.toString(i);
            arrayList.add(temp);
        }

        return arrayList;

    }

    public static void main(String[] args)
    {
        System.out.println(A5Q1.permute("ABCD"));
    }
}
