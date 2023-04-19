public interface BasicMethod {
    static void swap(int[] array, int b, int c){
        int temp = array[b];
        array[b] = array[c];
        array[c] = temp;
    }
}
