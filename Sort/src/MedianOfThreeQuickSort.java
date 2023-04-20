import java.util.Arrays;
import java.util.stream.BaseStream;

public class MedianOfThreeQuickSort implements BasicMethod {
    public int medianOfThreePartition(int[] array, int head, int tail) {
        int median = head + (tail - head)/2;
        if (array[head] > array[tail]) BasicMethod.swap(array, head, tail);
        if (array[median] > array[tail]) BasicMethod.swap(array, median, tail);
        if (array[head] > array[median]) BasicMethod.swap(array, head, median);
        BasicMethod.swap(array, median, tail-1);

        int pivot = array[tail];
        int i = head-1;
        for (int j = head; j < tail; j++) {
            if (array[j] <= pivot){
                i++;
                BasicMethod.swap(array, i, j);
            }
        }
        BasicMethod.swap(array, i + 1, tail);
        return i + 1;
    }
    public void medianOfThreeQuickSort(int[] array, int head, int tail) {
        if (head < tail) {
            int q = medianOfThreePartition(array, head, tail);
            medianOfThreeQuickSort(array, head, q - 1);
            medianOfThreeQuickSort(array, q + 1, tail);
        }
    }
    public static void main(String[] args){
        MedianOfThreeQuickSort medianOfThreeQuickSort = new MedianOfThreeQuickSort();
        int[] array = new int[] {5,8,2,4,1,9,6,3,5,7,10};
        medianOfThreeQuickSort.medianOfThreeQuickSort(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));
    }
}
