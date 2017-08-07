public class Main {
    public static void main(String[] args) {
        System.out.println(minSteps(100));
    }

    public static int minSteps(int n) {
        int[] cache = new int[n+1];
        cache[1] = 0;
        
        for(int i=2; i<=n; i++) {
            for(int j=i/2; j>0; j--) {
                if(i % j == 0) {
                    cache[i] = cache[j] + (i/j);
                    break;
                }
            }
        }
        
        return cache[n];
    }
}