public class BubbleSort {

    public void bubblesort(int A[], int n) {
        for(int pass=n-1;pass>=0;pass--) {
            for(int i=0;i<pass;i++) {
                if(A[i] > A[i+1]) {
                    int temp = A[i];
                    A[i] = A[i+1];
                    A[i+1] = temp;
                }
            }
        }
    }

    public void display(int A[], int n) {
        for(int i=0;i<n;i++)
            System.out.print(A[i] + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        BubbleSort s = new BubbleSort();
        int A[] = {8, 3, 9, 4, 6, 2};
        System.out.print("Original Array: ");
        s.display(A, 6);
        s.bubblesort(A, A.length);
        System.out.print("Sorted Array: ");
        s.display(A, 6);
    }

}
