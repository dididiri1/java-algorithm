
public class Ex01 {
    public void DFS(int n) {
        if (n == 0) {
            return;
        } else {
            DFS(n-1);
            System.out.println(n+" ");
        }
    }

    public static void main(String[] args) {
        Ex01 T = new Ex01();
        T.DFS(3);
    }
}