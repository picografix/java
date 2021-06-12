import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class words {

    public Vector<String[]> data = new Vector<>();
    public Vector<String> wordList = new Vector<>();
    long count=0;
    public boolean contains(String[] S, Vector<String[]> V){
        for(String[] mystr:V){
            if(Arrays.equals(mystr,S)){
                return true;
            }
        }
        return false;
    }
    public void spacePermuter(String S){

        String temp = "";

        for(int i=0;i<S.length();i++){
            for(int f=i+1;f<S.length();f++){
                count++;
                temp = S.substring(0,i)+" "+S.substring(i,f)+" "+S.substring(f,S.length());
                data.add(temp.trim().split("\\s+") );
            }
        }
    }
    public void requiredPermutaion(String S){
        wordList.add(S);
        String temp = "";
        for(int i=0;i<S.length()-1;i++){
            for(int j=i+1;j<S.length()/2 + 1;j++){
                temp = S.substring(0,i)+ S.charAt(j)+S.substring(i+1,j)+S.charAt(i)+S.substring(j+1,S.length());
                wordList.add(temp);
            }
        }
    }
    public void print(HashSet<String> V) throws FileNotFoundException {
        PrintWriter out = new PrintWriter("oceans.txt"); // Step 2


        /*for(int i = 0; i< V.size(); i++){
            Arrays.sort(V.get(i));
            out.println(Arrays.toString(V.get(i)));

        }*/
        for(String str:V){
//            Arrays.sort(str);
            out.println(str);
        }
        // Close the file.
        out.close();
    }
    public String dollar(String[] S){
        String ans="";
        for(String str:S){
            ans+=str;
            ans+="$";
        }
        return ans.substring(0,ans.length()-1);
    }
    public Vector<String> join(String S, String old){
        Vector<String> ans = new Vector<>();
        String[] str = old.split("\\$");
        String[] temp = str.clone();
        temp[2]=S+temp[2];
        ans.add(dollar(temp));
        temp = str.clone();
        if(str[1].equals("")){
            temp[1]=S+temp[1];
            ans.add(dollar(temp));
//            temp = str.clone();
        }else{
            temp[1]=S+temp[1];
            ans.add(dollar(temp));
            temp = str.clone();
            temp[0]=S+temp[0];
            ans.add(dollar(temp));
        }



        return ans;
    }
    public void print() throws FileNotFoundException {
        PrintWriter out = new PrintWriter("oceans.txt");
        for(int i = 0; i< data.size(); i++){

            out.println(Arrays.toString(data.get(i)));

        }
        out.close();
    }
    public Vector<String[]> join(String S, String[] str){
        Vector<String[]> ans = new Vector<>();
        String[] temp = str.clone();
        temp[2]=S+temp[2];
        ans.add(temp);
        temp = str.clone();
        if(str[1].equals("")){
            temp[1]=S+temp[1];
            ans.add(temp);
//            temp = str.clone();
        }else{
            temp[1]=S+temp[1];
            ans.add(temp);
            temp = str.clone();
            temp[0]=S+temp[0];
            ans.add(temp);
        }
        return ans;
    }
    public HashSet<String[]> wordGen(String S){
        HashSet<String[]> hs = new HashSet<>();
//        Vector<String []> ans = new Vector<>();
        /*if(S.length()  <6){
            String[] ss = {S};
            ans.add(ss);
            return ans;
        }*/
        String[] myS = {"","",""+S.charAt(S.length()-1)};
        hs.add(myS);
//        ans.add(myS);
        int Count= 0;
        for(int i=S.length()-2;i>=0;i--){
//            Vector<String []> ansTemp = new Vector<>();
            HashSet<String[]> hsTemp = new HashSet<>();
            /*for (String[] an : ans) {
                ansTemp.addAll(join("" + S.charAt(i), an));

            }*/
            for(String[] myStr:hs){
                hsTemp.addAll(join("" + S.charAt(i), myStr));
            }
            hs.clear();
//            ans.removeAllElements();
//            ans.addAll(ansTemp);
            hs.addAll(hsTemp);

        }
        System.out.println("Count Is : "+hs.size());
        return hs;
    }
    public HashSet<String> wordGenS(String S){
        HashSet<String> hs = new HashSet<>();
//        Vector<String []> ans = new Vector<>();
        /*if(S.length()  <6){
            String[] ss = {S};
            ans.add(ss);
            return ans;
        }*/
        String[] myS = {"","",""+S.charAt(S.length()-1)};
        hs.add(dollar(myS));
//        ans.add(myS);
        int Count= 0;
        for(int i=S.length()-2;i>=0;i--){
//            Vector<String []> ansTemp = new Vector<>();
            HashSet<String> hsTemp = new HashSet<>();
            /*for (String[] an : ans) {
                ansTemp.addAll(join("" + S.charAt(i), an));

            }*/
            for(String myStr:hs){
                hsTemp.addAll(join("" + S.charAt(i), myStr));
            }
            hs.clear();
//            ans.removeAllElements();
//            ans.addAll(ansTemp);
            hs.addAll(hsTemp);

        }
        System.out.println("Count Is : "+hs.size());
        return hs;
    }
    public String remove(String S){
//        String ans = "";
        for(int i=0;i<S.length();i++){

            if(S.charAt(i)=='$'){
                S = S.substring(0,i)+S.substring(i+1,S.length());
                i--;
            }
        }
        return S;
    }
    public Vector<String > word(String[] str){
        Vector<String > V =  new Vector<>();
        int n = str.length;
        if(n==3){
            V.add(str[0]+" "+str[1]+ " " +str[2]);
            V.add(str[0]+" "+str[2]+ " " +str[1]);
            V.add(str[1]+" "+str[0]+ " " +str[2]);
            V.add(str[1]+" "+str[2]+ " " +str[0]);
            V.add(str[2]+" "+str[0]+ " " +str[1]);
            V.add(str[2]+" "+str[1]+ " " +str[0]);
        }else if(n==2){
            V.add(str[0]+" "+str[1]);
            V.add(str[1]+" "+str[0]);
        }else{
            V.add(str[0]);
        }
        return V;
    }
    public static void main(String[] args) throws FileNotFoundException {
        Instant start = Instant.now();

        words w = new words();
        String S = "AAAAAAAAAAAAA";
        char temp[] = S.toCharArray();
        Arrays.sort(temp);
        S = new String(temp);
//        HashSet<String> T = w.wordGenS(S);
        w.print(w.wordGenS(S));
//      String mystring = "$$are";
//        String[] arr= mystring.split("\\$");
//        System.out.println(Arrays.toString(arr));
        Instant end = Instant.now();
        System.out.println("Total Time Taken :"+ Duration.between(start, end));


//        System.out.println(Arrays.toString(S));
    }
}
