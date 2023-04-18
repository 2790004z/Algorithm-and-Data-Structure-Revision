public class MergeSort {
    public void merge(int[] array, int p, int q, int r){
        int i, j, k;
        int n1 = q - p + 1;
        int n2 = r-q;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (i = 0; i < n1; i++) L[i] = array[p + i];
        for (j = 0; j < n2; j++) R[j] = array[q + 1 + j];
        i = 0;
        j = 0;
        k = 0;
        while (i < n1 && j < n2){
            if (L[i] <= R[j]){
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1){
            array[k] = L[i];
            i++;
            k++;
        }
        while (j < n2){
            array[k] = R[i];
            j++;
            k++;
        }
    }
    public void mergeSort(int[] array, int p, int r){
        if (p < r){
            int q = (p + r) / 2;
            mergeSort(array, p, q);
            mergeSort(array, q + 1, r);
            merge(array, p, q, r);
        }
    }
}