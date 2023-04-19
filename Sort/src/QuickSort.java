import java.util.Arrays;

public class QuickSort implements BasicMethod{

    public int partition(int[] array, int head, int tail){
        int pivot = array[tail];
        int i = head - 1;
        for (int j = head; j < tail; j++){
            if (array[j] <= pivot){
                i += 1;
                BasicMethod.swap(array, i, j);
            }
        }
        BasicMethod.swap(array, i + 1, tail);
        return i + 1;
    }
    public void quickSort(int[] array, int head, int tail){
        if (head < tail){
            int q = partition(array, head, tail);
            quickSort(array, head, q -1);
            quickSort(array, q + 1, tail);
        }
    }
    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] array = new int[] {5,8,2,4,1,9,6,3,7,10};
        quickSort.quickSort(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));
    }
}
