import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        TreeMap<String, Integer> map = new TreeMap<>();
        for(int i=0;i<N;i++) {
            String tmp = br.readLine();
            map.put(tmp, map.getOrDefault(tmp, 0)+1);
        }

        Iterator<Entry<String, Integer>> it = map.entrySet().iterator();
        while(it.hasNext()) {
            Entry<String, Integer> tmp = it.next();
            String k = tmp.getKey();
            double v = (double)tmp.getValue()/N*100;

            System.out.printf("%s %.4f\n", k, v);
        }
    }
}