import java.io.*;
//import java.util.ArrayList;
import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class Anagram {
    static long count=0;

    static Vector<String[]> permute = new Vector<>();
    static LinkedList<String>[] data;
    private static int Capacity = 0;
    public boolean isPrime(int I){
        int d = (int) Math.sqrt(I);
        for(int i=2;i<=d;i++){
            if(I%i==0){
                return false;
            }
        }
        return true;
    }
    public int findCap(int size){
        size = size*2+7;
        while (!isPrime(size)){
            size++;
        }
        return size;
    }
    private static final int A = 7;
    static void printPermutn(String str, String ans)    {
        if (str.length() == 0) {
//            System.out.println(ans + " ");
            permute.add(ans.trim().split("\\s+") );
            count++;


            return;
        }

        for (int i = 0; i < str.length(); i++) {

            // ith character of str
            char ch = str.charAt(i);

            // Rest of the string after excluding
            // the ith character
            String ros = str.substring(0, i) +
                    str.substring(i + 1);

            // Recurvise call
            printPermutn(ros, ans + ch);
        }
    }
    public static void setCapacity( int c){
        Capacity = c;
    }
    public static int hashFunction(String S){
        int a =0;
        char[] ar = S.toCharArray();
        Arrays.sort(ar);
        int n = ar.length;
        for(int i=0;i<n;i++){
            a += (int) ar[i] *(Math.pow(256,n-i)) % Capacity;
        }
        return a%Capacity;
    }
    public static int doubleHashFunction(String S){
        int a =0;
        char[] ar = S.toCharArray();
        Arrays.sort(ar);
        int n = ar.length;
        for(int i=0;i<n;i++){
            a += (int) ar[i] *(Math.pow(256,n-i)) % (Capacity-A);
        }
        return a%(Capacity-A)+1;
    }
    public static void addToLL(int addAt, String S){
        if(data[addAt]==null){
            data[addAt]=new LinkedList<>();
        }
        if (data[addAt].contains(S)) S=S+"$";
        data[addAt].add(S);
    }
    public static void doubleHash(int addAt,String S){
        int d= doubleHashFunction(S);
        int i = (addAt+d)%Capacity;

        while (data[i]!=null && !compare(data[i].getFirst(),S)){
            i=(i+d)%Capacity;
        }
        addToLL(i,S);
    }
    public static boolean compare(String S1, String S2){

        char[] ar = S1.toCharArray();
        Arrays.sort(ar);
        String sorted = String.valueOf(ar);
        char[] ar2 = S2.toCharArray();
        Arrays.sort(ar2);
        String sorted2 = String.valueOf(ar2);
        return sorted2.equals(sorted);

    }
    @SuppressWarnings("unchecked")
    public static void addAndHash(String S){
        if(data==null) data = new LinkedList[Capacity];

        int addAt = hashFunction(S);
        if(data[addAt]!=null){
            if(compare(data[addAt].getFirst(),S)){
//                System.out.println("iff");
                addToLL(addAt,S);
            }
            else{
                doubleHash(addAt,S);
            }
        }else{
            addToLL(addAt,S);
        }
//        addToLL(addAt,S);
    }
    public static int searchHard(String S){

        int f  = search(S);
        if(f==-1){
            return -1;
        }
        for(int i=0;i<data[f].size();i++){
            if(data[f].get(i).equals(S)){
                return i;
            }
        }
        return -1;
    }
    public static int search(String S){
        /*char[] ar = S.toCharArray();
        Arrays.sort(ar);
        String sorted = String.valueOf(ar);*/
        int f = hashFunction(S);
//        System.out.println(permut[f]);
//        System.out.println("F is: "+f);
//        System.out.println("Capacity is: "+ Capacity);
        if(data[f]==null){
            return -1;
        }
        if(compare(data[f].getFirst(),S)){
            /*for(int i=0;i<permut[f].size();i++){
                if(permut[f].get(i).equals(S)){
                    return f;
                }
            }*/
            return f;
        }else{
            int d = doubleHashFunction(S);
            int temp = (f+d)%Capacity;
            while (true){
                if(data[temp]!=null){
                    if(compare(data[temp].getFirst(),S)){
                        return temp;
                    }
                }
                else{
                    return -1;
                }

                temp=(temp+d)%Capacity;
            }
        }
//        return -1;
    }
    public static void print(){
        if(data==null){
            return;
        }
        int counter=0;
        System.out.println("Array length is: "+data.length);
        for (LinkedList<String> datum : data) {
            if (datum != null) {
                counter+=datum.size();
                System.out.println(datum.toString());
            }
        }
        System.out.println("Count in hashtable is: "+ counter);
    }

    public static void printMyVector(Vector<String[]> V){
        if(V==null){
//            System.out.println("Null Hai Be");
            return;
        }
        for(String[] s: V){
            System.out.println(Arrays.toString(s));
        }
    }
    public static Vector<String[]> findAnagram(String[] S){
        Vector<String[] > V = new Vector<>();
        int i,j,k=-1;
        i = search(S[0]);
        if(i==-1){
            return null;
        }
        if(S.length==3){
            j = search(S[1]);
            k = search(S[2]);
            if(k==-1 || j==-1){
                return null;
            }
            for(int p=0;p<data[i].size();p++){
                for(int q=0;q<data[j].size();q++){
                    for(int r=0;r<data[k].size();r++){
                        String[] temp = {data[i].get(p),data[j].get(q),data[k].get(r)};
                        if(!V.contains(temp)){
                            V.add(temp);
                        }

                    }
                }
            }
        }else if(S.length==2){
            j= search(S[1]);
            if(j==-1){
                return null;
            }
            for(int p=0;p<data[i].size();p++) {
                for (int q = 0; q < data[j].size(); q++) {
                    String[] temp = {data[i].get(p),data[j].get(q)};
                    if(!V.contains(temp)){
                        V.add(temp);
                    }
                }
            }
        } else{
            for(int p=0;p<data[i].size();p++) {
                String[] temp = {data[i].get(p)};
                if(!V.contains(temp)){
                    V.add(temp);
                }
            }
        }


        return V;
    }
    public static String[] findAnagrams(String[] S){
        int j ;
        for (String s : S) {
//            int p = search(S[i]);
            j = searchHard(s);
            if (j == -1) {
                return null;
            }
        }
        return S;
    }
    public static void permuteNow(String S){
        String temp ;
        for(int i=0;i<S.length();i++){
            for(int f=i;f<S.length();f++){
                temp = S.substring(0,i)+" "+S.substring(i,f)+" "+S.substring(f);
                permute.add(temp.trim().split("\\s+") );
            }
        }
    }
    public static void printAnagrams(String S){
        permuteNow(S);
        for (String[] SS : permute) {
            Vector<String[]> V = findAnagram(SS);
            printMyVector(V);
        }
    }
    public static void printAnagram(String S){
        printPermutn(S,"");
        for(int i = 0; i< permute.size(); i++){
            String[] SS = permute.get(i);
            String[]  V = findAnagrams(SS);
            if(V!=null){
                System.out.println(Arrays.toString(V));
            }
        }
    }
    public Vector<String[]> join(String S, String[] str){
        Vector<String[]> ans = new Vector<>();
        String[] temp = str.clone();
        temp[0]=temp[0]+S;
        ans.add(temp);
        temp = str.clone();
        if(str[1].equals("")){
            temp[1]=temp[1]+S;
            ans.add(temp);
//            temp = str.clone();
        }else{
            temp[1]=temp[1]+S;
            ans.add(temp);
            temp = str.clone();
            temp[2]=temp[2]+S;
            ans.add(temp);
        }
        return ans;
    }
    public Vector<String[]> wordGen(String S){
        Vector<String []> ans = new Vector<>();
        if(S.length()  <6){
            String[] ss = {S,"",""};
            ans.add(ss);
            return ans;
        }
        String[] myS = {""+S.charAt(S.length()-1),"",""};
        ans.add(myS);
        for(int i=S.length()-2;i>=0;i--){
            Vector<String []> ansTemp = new Vector<>();
            for (String[] an : ans) {
                ansTemp.addAll(join("" + S.charAt(i), an));
            }
            ans.removeAllElements();
            String[] last = new String[0];
            /*for(String[] sss:ansTemp){
//                Arrays.sort(sss);
                if(last.length!=0){
                    if(!Arrays.equals(last,sss)){
                        last=sss;
//                        System.out.println("last: "+Arrays.toString(last));
//                        System.out.println("SSS: "+Arrays.toString(sss));

                        ans.add(sss);
                    }
                }else{
                    last=  sss;
                    ans.add(sss);
                }
            }*/
            ans.addAll(ansTemp);

        }
        return ans;
    }
    public boolean check(String[] str){
        for(String S:str){
            if(S.length()==1 ||S.length()==2){
                return false;
            }
        }
        return true;
    }
    public Vector<String[]> driver(String S){
        Vector<String[]> myData = new Vector<>();
        permute = wordGen(S);
//        printMyVector(permut);
        for(int i = 0; i< permute.size(); i++){
            String[] SS = permute.get(i);
            if(check(SS)){
                if(SS[1].equals("")){
                    SS = Arrays.copyOfRange(SS,0,1);

                }else if (SS[2].equals("")){
                    SS = Arrays.copyOfRange(SS,0,2);
                }
//            System.out.println(Arrays.toString(SS));
                Vector<String[] > V = findAnagram(SS);
//            System.out.println(V.size());
                if(V!=null){
                    myData.addAll(V);
                }
            }
//            printMyVector(V);
        }

        return myData;
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

    public static void hashtableFromVocab(String S) throws Exception{
        Anagram A = new Anagram();
        File file = new File("./"+S);
        BufferedReader br = new BufferedReader(new FileReader(file));
        int n = Integer.parseInt(br.readLine()) ;
//        System.out.println("N is: "+n);
        String st;
        setCapacity(A.findCap(n));
        while ((st = br.readLine()) != null){
            addAndHash(st);
        }
    }
    public List<String> removeDuplicates(Vector<String> V){
        LinkedHashSet<String> hashSet= new LinkedHashSet<String>(V);
        List<String> list = new ArrayList<String>(hashSet);
        for(int i=0;i<list.size();i++){
            list.set(i,remove(list.get(i))) ;
        }
        Collections.sort(list);
        return list;
    }
    public void input(String S) throws Exception {
        Anagram A = new Anagram();
        File file = new File("./"+S);
        BufferedReader br = new BufferedReader(new FileReader(file));
        int n = Integer.parseInt(br.readLine()) ;
        String st;
        while ((st = br.readLine()) != null){
            char[] temp = st.toCharArray();
            Arrays.sort(temp);
            st= new String(temp);
            Vector<String> myAnagrams = new Vector<>();
            Vector<String[]> myData = A.driver(st);
            for(String[] str: myData){
                myAnagrams.addAll(A.word(str));
            }
            if(myAnagrams.size()==0){
                System.out.println(-1);
            }else{
                List<String> mylist = removeDuplicates(myAnagrams);
//                Collections.sort(myAnagrams);
                for(String mystr:mylist){
                    System.out.println(mystr);
                }
                /*String last="";
                for(String myStr:myAnagrams){
                   if(!last.equals("")){
                       if(!last.equals(myStr)){
                           last=myStr;
                           myStr = remove(myStr);
                           System.out.println(myStr);
                       }else{
                           last=myStr;
                       }


                   }else{
                       last = myStr;
                       myStr = remove(myStr);
                       System.out.println(myStr);

                   }
//                    System.out.println(myStr);
                }*/
                System.out.println(-1);
            }

        }

    }
    public static boolean checkVocab(String S) throws Exception{
        Anagram A = new Anagram();
        File file = new File("./"+S);
        BufferedReader br = new BufferedReader(new FileReader(file));
        int n = Integer.parseInt(br.readLine()) ;
//        System.out.println("N is: "+n);
        String st;
//        setCapacity(50923);
        setCapacity(A.findCap(n));
        while ((st = br.readLine()) != null){
            int temp = searchHard(st);
            if(temp==-1){
                System.out.println(st);
                return false;
            }
        }
        return true;
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
    public static void main(String[] args) throws Exception {
        Instant start = Instant.now();
        String vocabulary = args[0];
        String input = args[1];
//        System.out.println(S);
        hashtableFromVocab(vocabulary);
//        System.out.println(checkVocab(vocabulary));
        Anagram H = new Anagram();
        H.input(input);
//        print();
        Instant end = Instant.now();
        //  System.out.println("Total Time Taken :"+ Duration.between(start, end));

    }


}
