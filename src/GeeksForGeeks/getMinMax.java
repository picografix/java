package GeeksForGeeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.LongStream;

class pair
{
    long first, second;
    public pair(long first, long second)
    {
        this.first = first;
        this.second = second;
    }
}
class Compute
{
    static pair getMinMax(long a[], long n)
    {
        long min=0,max=0;
        Arrays.sort(a);
        pair myp = new pair(a[0],a[a.length-1]);
        return myp;
    }

}
