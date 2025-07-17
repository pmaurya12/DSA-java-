
package hashing;
import java.util.*;
public class hashset {
    public static void main(String[] args) {
        HashSet<String> gta=new HashSet<>();
        gta.add("vice");
        gta.add("city");
        Iterator it=gta.iterator();
        while(it.hasNext()){
            System.out.print(it.next()+" ");
        }
    }
}
