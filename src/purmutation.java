import java.util.Vector;

public class purmutation {
    public Vector<Vector<String>> permute(String s) {
        int count=1;
        Vector<Vector<String>> vectorofpurmuts=new Vector<>();
        Vector<String> temp=new Vector<>(3);
        temp.add(""+s.charAt(0));
        temp.add("");temp.add("");
        vectorofpurmuts.add(temp);
        for(int i=1;i<s.length();i++){
            String ts=""+s.charAt(i);
            Vector<Vector<String>> huehue=(Vector<Vector<String>>) vectorofpurmuts.clone();
            int nn=huehue.size();
            for(int j=0;j<nn;j++){
                Vector<String> tvs=vectorofpurmuts.remove(0);
                System.out.println("Hello: "+count);
                boolean go=true;
                int km=0;
                while(go && km<3){
                    Vector<String> tvs2=(Vector<String>) tvs.clone();
                    String str=tvs2.elementAt(km)+ts;
                    if(str.length()==1){
                        go=false;
                    }
                    tvs2.set(km,str);
                    count++;
                    if(!vectorofpurmuts.contains(tvs2)) {
                        vectorofpurmuts.add(tvs2);
                    }
                    km++;
                }
            }
        }
        System.out.println("No. of steps :- "+count);
        return vectorofpurmuts;
    }

    public static void main(String[] args) {
        purmutation P=new purmutation();
        System.out.println(P.permute("shresthsaxena"));
    }
}