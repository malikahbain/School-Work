public class A4Q1{

    public static void main(String[] args)
    {
        System.out.println(removeDups("aaabcddce"));
        System.out.println(removeDups("aaabcddc"));
        System.out.println(removeDups("xabbac"));

    }

    public static String removeDups(String x)
    {
        String fooString ="";
        String[] someArray = new String[x.length()];

        int count = 0;

        //store string in array
        for(int i = 0; i<someArray.length; i++){
            someArray[i] = Character.toString(x.charAt(i));
        }

        for(int i = 0; i < someArray.length-1; i++){

            if(someArray[i].equals(someArray[i+1])){
                someArray[i] = "";
                someArray[i+1] = "";
                count++;
            }
        }

        for(int i = 0; i < someArray.length; i++){
            fooString += someArray[i];
        }

        if(count > 0){
            return removeDups(fooString);
        }
        return fooString;
        
    }

}