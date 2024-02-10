import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        TreeMap<Integer, Integer> map = new TreeMap<>();

        StringTokenizer st;
        for(int n=0;n<N;n++) {
            st = new StringTokenizer(br.readLine());
            int cnt = st.countTokens();
            
            if(cnt==1) {
                if(map.size()==0) {
                    System.out.println("None");
                    continue;
                }

                Iterator<Entry<Integer, Integer>> it = map.entrySet().iterator();
                while(it.hasNext()) {
                    Entry<Integer, Integer> tmp = it.next();
                    System.out.print(tmp.getValue()+" ");
                }
                System.out.println();
            } else {
                String cmd = st.nextToken();
                if(cmd.equals("add")) {
                    map.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                } else if(cmd.equals("remove")) {
                    map.remove(Integer.parseInt(st.nextToken()));
                } else {
                    int value = map.getOrDefault(Integer.parseInt(st.nextToken()), 0);
                    if(value>0) {
                        System.out.println(value);
                    } else {
                        System.out.println("None");
                    }
                }
            }

        }
    }
}