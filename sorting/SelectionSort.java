package sorting;

public class SelectionSort implements Sorter {

    public void sort(int[] input) {
        System.out.println("Selection Sort!!!");
        
        for (int i = 0; i < input.length - 1; i++) {
            int smallest = i;
            
            for (int j = i + 1; j < input.length; j++) {
                if (input[j] < input[smallest]) {
                    smallest = j;
                }
            }
            
            int temp = input[smallest];
            input[smallest] = input[i];
            input[i] = temp;
        }
    }
}