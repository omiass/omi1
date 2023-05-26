package abhi1;
import java.util.Scanner;

public class SelectionSort {
    
    static void display(int[] arr) {
        for(int el : arr) {
            System.out.print(el + " ");
        }
        System.out.println();
    }

    static int[] sorting(int[] arr) {
        int n = arr.length;
        for(int i = 0; i < n-1; i++) {
            int minIndex = i;
            for(int j = i+1; j < n; j++) {
                if(arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
            System.out.print("Pass " + (i+1) + ": ");
            display(arr);
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Unsorted Array:");
        display(arr);
        arr = sorting(arr);
        System.out.println("Sorted Array:");
        display(arr);
        sc.close();
    }
}
