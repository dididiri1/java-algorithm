public class Ex03 {
    public int DFS(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * DFS(n-1);
        }
    }

    public static void main(String[] args) {
        Ex03 T = new Ex03();
        System.out.println(T.DFS(5));
    }
}