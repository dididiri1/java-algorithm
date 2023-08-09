
public class Ex02 {
    public void DFS(int n) {
        if (n == 0) {
            return;
        } else {
            DFS(n/2);
            System.out.println(n%2+" ");
        }
    }

    public static void main(String[] args) {
        Ex02 T = new Ex02();
        T.DFS(11);
    }
}