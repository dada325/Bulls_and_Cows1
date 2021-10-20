class EnglishAlphabet {

    public static StringBuilder createEnglishAlphabet() {
        StringBuilder myString = new StringBuilder();
        int a = 65;
        while (a <= 90){
            String b = ((char)a+" ");
            myString.append(b);
            a++;
        }
        myString.delete(myString.length()-1,myString.length());
        return myString;
    }
}