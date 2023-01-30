package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
    public int v1;
    public int v2;
    public int cost;
    Edge(int v1, int v2, int cost) {
        this.v1=v1;
        this.v2=v2;
        this.cost=cost;
    }

    // this 앞에 있으면 오름차순 정렬, Override 해준 후 Collections 써줘야 정렬딤딤
   @Override
    public int compareTo(Edge ob) {
        return this.cost-ob.cost;
    }
}

public class prac {
    static int[] unf;
    public static int Find(int v) {
        if(v==unf[v]) return v;
        else return unf[v]=Find(unf[v]);
    }
    public static void Union(int v1, int v2){
        int fa=Find(v1);
        int fb=Find(v2);
        if(fa!=fb) unf[fa]=fb;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        unf = new int[n+1];
        for(int i=1; i<=n; i++) unf[i]=i;
        ArrayList<Edge> arr = new ArrayList<Edge>();
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            arr.add(new Edge(a,b,c));
        }
        Collections.sort(arr);
        int answer=0;
        int cnt=0;
        for(Edge ob : arr) {
            if(cnt==n-1) break;
            int fv1=Find(ob.v1);
            int fv2=Find(ob.v2);
            if(fv1!=fv2) {
                answer+=ob.cost;
                Union(ob.v1,ob.v2);
                cnt++;
            }
        }
        System.out.println(answer);
    }
}
