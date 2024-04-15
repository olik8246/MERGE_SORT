// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int[] array = new int[10];

        for (int i = 0; i < array.length; i++) {
            array[i] = ((int) (Math.random() * 11));
        }
        mergrSort(array);

        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }

    }

    private static void mergrSort(int[] array) {
        int length = array.length;
        if (length <= 1) return;

        int middle = length/2;
        int[] leftArray = new int[middle];
        int[] rightArray = new int[length-middle];

        int l = 0;//left array
        int r = 0;//right array

        for(; l < length ; l++){
            if (l < middle){
                leftArray[l] = array[l];
            }
            else {
                rightArray[r] = array[l];
                r++;
            }
        }
        mergrSort(leftArray);
        mergrSort(rightArray);
        marge(leftArray,rightArray,array);

    }
    private static void marge(int[] leftArray, int[] rightArray, int[] array ){
        int leftSize = array.length/2;
        int rightSize = array.length - leftSize;
        int i = 0 , l = 0 , r = 0;
        while (l < leftSize &&  r < rightSize){
            if(leftArray[l] < rightArray[r]){
                array[i] = leftArray[l];
                i++;
                l++;
            }
            else{
                array[i] = rightArray[r];
                i++;
                r++;
            }
        }
        while (l < leftSize){
            array[i] = leftArray[l];
            i++;
            l++;
        }
        while (r < rightSize){
            array[i] = rightArray[r];
            i++;
            r++;
        }

    }
}