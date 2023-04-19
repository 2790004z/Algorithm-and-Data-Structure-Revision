import java.util.Arrays;

public class HeapSort {
    public void buildMaxHeap(int[] array, int lengthToSort){
        for (int indexOfNode = lengthToSort / 2 - 1; indexOfNode >= 0; indexOfNode--)
            maxHeapify(array, lengthToSort, indexOfNode);
    }
    public static void maxHeapify(int[] array, int sizeOfHeap, int indexOfNode) {
        int indexOfLeftLeaf = 2 * indexOfNode + 1;
        int indexOfRightLeaf = 2 * indexOfNode + 2;
        int indexOfLargest = indexOfNode;

        if (indexOfLeftLeaf < sizeOfHeap && array[indexOfLeftLeaf] > array[indexOfLargest]) indexOfLargest = indexOfLeftLeaf;
        if (indexOfRightLeaf < sizeOfHeap && array[indexOfRightLeaf]> array[indexOfLargest]) indexOfLargest = indexOfRightLeaf;

        if (indexOfLargest != indexOfNode){
            BasicMethod.swap(array, indexOfLargest, indexOfNode);
            maxHeapify(array, sizeOfHeap, indexOfLargest);
        }
    }
    public void maxHeapSort(int[] array){
        int length = array.length;
        buildMaxHeap(array, length);
        for (int index = length - 1; index >= 0; index--) {
            BasicMethod.swap(array, 0, index);
            maxHeapify(array, index, 0);
        }
    }
    public static void main(String[] args) {
        HeapSort h = new HeapSort();
        int[] array = new int[] {5,8,2,4,1,9,6,3,7,10};
        h.maxHeapSort(array);
        System.out.println(Arrays.toString(array));
    }
}
