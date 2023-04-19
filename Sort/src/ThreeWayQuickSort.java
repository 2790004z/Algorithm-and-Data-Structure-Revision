import java.util.Arrays;

public class ThreeWayQuickSort implements BasicMethod{
    public int[] threeWayPartition(int[] array, int head, int tail){
        int pivot = array[tail];
        int lastPivot = tail;
        int beforeFirstPivot = head - 1;
        for (int currentPosition = tail -1; currentPosition > beforeFirstPivot; currentPosition--){
            if (array[currentPosition] > pivot){
                BasicMethod.swap(array, currentPosition, lastPivot);
                lastPivot--;
            }else if (array[currentPosition] < pivot){
                beforeFirstPivot++;
                BasicMethod.swap(array, currentPosition, beforeFirstPivot);
                currentPosition++;
            }
        }
        return new int[] {beforeFirstPivot, lastPivot};
    }
    public void threeWayQuickSort(int[] array, int head, int tail){
        if (head < tail){
            int[] pivotPosition = threeWayPartition(array, head, tail);
            int beforeFirstPivot = pivotPosition[0];
            int lastPivot = pivotPosition[1];
            threeWayQuickSort(array, head, beforeFirstPivot);
            threeWayQuickSort(array, lastPivot + 1, tail);
        }
    }
    public static void main(String[] args) {
        ThreeWayQuickSort threeWayQuickSort = new ThreeWayQuickSort();
        int[] array = new int[] {5,8,2,4,1,9,6,3,5,7,10};
        threeWayQuickSort.threeWayQuickSort(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));
    }
}
