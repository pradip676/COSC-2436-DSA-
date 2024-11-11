// Pradip Sapkota

import java.util.*;
import java.io.*;

public class Homework3 {
    static long bubbleIterations = 0;
    static long selectionIterations = 0;
    static long mergeIterations = 0;
    static long radixIterations = 0;

    public static void main(String[] args) throws IOException {
        Scanner infile = new Scanner(new File("primes1.txt"));
        System.out.println("This program compares the bubble, selection, merge, and radix sorts.");

        // Read file and populate arrays and arraylists
        int[] bubbleData = new int[100000];
        int[] selectionData = new int[100000];
        ArrayList<Integer> mergeData = new ArrayList<>();
        ArrayList<Integer> radixData = new ArrayList<>();

        int n = 0;   // Data set size will increment for each number read
        int data;
        while (infile.hasNextInt()) {
            data = infile.nextInt();
            bubbleData[n] = data;
            selectionData[n] = data;
            mergeData.add(data);
            radixData.add(data);
            n++;
        }
        
        System.out.println("The data set is " + n + " prime numbers unsorted");
        System.out.println();
        infile.close();

        // Bubble Sort
        System.out.println("1. Bubble Sort");
        long BeginTime = System.currentTimeMillis();
        bubbleData = bubbleSort(bubbleData, n);
        long EndTime = System.currentTimeMillis();
        System.out.println("Seconds to sort = " + (EndTime - BeginTime) / 1000.0);
        System.out.println("Number of iterations : " + bubbleIterations);

        // Print first 10 bubble sorted elements
        System.out.print("First 10 sorted: ");
        for (int i = 0; i < 10; i++) 
        {
            System.out.print(bubbleData[i]);
            if (i < 9) 
                System.out.print(", ");
        }
        System.out.println();
        //print last 10 bubble sorted elements
        System.out.print("Last 10 sorted: ");
        for (int i = n - 10; i < n; i++)
        {
           System.out.print(bubbleData[i]);
           if(i<n-1)
               System.out.print(", ");
        }
        
        
        System.out.println();
        System.out.println();

        // Selection Sort
        System.out.println("2. Selection Sort");
        BeginTime = System.currentTimeMillis();
        selectionData = selectionSort(selectionData, n);
        EndTime = System.currentTimeMillis();
        System.out.println("Seconds to sort = " + (EndTime - BeginTime) / 1000.0);
        System.out.println("Number of iterations : " + selectionIterations);

        // Print first 10 selection sorted elements
        System.out.print("First 10 sorted: ");
        for (int i = 0; i < 10; i++)
        {
            System.out.print(selectionData[i]);
            if (i < 9) 
                System.out.print(", ");
        }
        System.out.println();
        //print last 10 selection sorted elements
        System.out.print("Last 10 sorted: ");
        for (int i = n - 10; i < n; i++)
        {
           System.out.print(selectionData[i]);
           if(i<n-1)
               System.out.print(", ");
        }
        
        System.out.println();
        System.out.println();

        // Merge Sort
        System.out.println("3. Merge Sort");
        BeginTime = System.currentTimeMillis();
        mergeData = MergeSort(mergeData);
        EndTime = System.currentTimeMillis();
        System.out.println("Seconds to sort = " + (EndTime - BeginTime) / 1000.0);
        System.out.println("Number of iterations : " + mergeIterations);

        // Print first 10 merge sorted elements
        System.out.print("First 10 sorted: ");
        for (int i = 0; i < 10; i++)
        {
            System.out.print(mergeData.get(i));
            if (i < 9) 
                System.out.print(", ");
        }
        System.out.println();
        //print last 10 merge sorted elements
        System.out.print("Last 10 sorted: ");
        for (int i = n - 10; i < n; i++)
        {
           System.out.print(mergeData.get(i));
           if(i<n-1)
               System.out.print(", ");
        }

        System.out.println();
        System.out.println();

        // Radix Sort
        System.out.println("4. Radix Sort");
        BeginTime = System.currentTimeMillis();
        radixData = RadixSort(radixData);
        EndTime = System.currentTimeMillis();
        System.out.println("Seconds to sort = " + (EndTime - BeginTime) / 1000.0);
        System.out.println("Number of Iterations : " + radixIterations);

        // Print first 10 radix sorted elements
        System.out.print("First 10 sorted: ");
        for (int i = 0; i < 10; i++)
        {
            System.out.print(radixData.get(i));
            if (i < 9) 
                System.out.print(", ");
        }
        System.out.println();
        //print last 10 radix sorted elements
        System.out.print("Last 10 sorted: ");
        for (int i = n - 10; i < n; i++)
        {
           System.out.print(radixData.get(i));
           if(i<n-1)
               System.out.print(", ");
        }
    }

    // Radix Sort
    static ArrayList<Integer> RadixSort(ArrayList<Integer> dataset) {
        ArrayList<Integer> dataset2 = new ArrayList<>();
        for (int k = 1; k <= 1000000; k *= 10) {
            for (int i = 0; i <= 9; i++) {
                for (int j = 0; j < dataset.size(); j++) {
                    radixIterations++;
                    if (dataset.get(j) / k % 10 == i)
                        dataset2.add(dataset.get(j));
                }
            }

            dataset.clear();
            for (int m = 0; m < dataset2.size(); m++) {
                radixIterations++;
                dataset.add(dataset2.get(m));
            }
            dataset2.clear();
        }
        return dataset;
    }

    // Merge Sort method
    static ArrayList<Integer> MergeSort(ArrayList<Integer> dataset) {
        mergeIterations++;
        if (dataset.size() == 1) return dataset;
        else {
            // Split data into 2 parts
            ArrayList<Integer> LeftData = new ArrayList<>(dataset.subList(0, dataset.size() / 2));
            ArrayList<Integer> RightData = new ArrayList<>(dataset.subList(dataset.size() / 2, dataset.size()));
            dataset = Merge(MergeSort(LeftData), MergeSort(RightData));
        }
        return dataset;
    }

    // Merge the left and right lists together
    static ArrayList<Integer> Merge(ArrayList<Integer> LeftData, ArrayList<Integer> RightData) {
        ArrayList<Integer> MergedData = new ArrayList<>();
        while (LeftData.size() > 0 || RightData.size() > 0) {
            mergeIterations++;
            if (RightData.size() == 0) {
                MergedData.add(LeftData.get(0));
                LeftData.remove(0);
            } else if (LeftData.size() == 0) {
                MergedData.add(RightData.get(0));
                RightData.remove(0);
            } else if (LeftData.get(0) < RightData.get(0)) {
                MergedData.add(LeftData.get(0));
                LeftData.remove(0);
            } else {
                MergedData.add(RightData.get(0));
                RightData.remove(0);
            }
        }
        return MergedData;
    }

    // Bubble Sort method 
    static int[] bubbleSort(int[] data, int n) {
        int Temp;
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n - 1 - x; y++) {
                bubbleIterations++;
                // Compare and swap if needed
                if (data[y] > data[y + 1]) {
                    Temp = data[y];
                    data[y] = data[y + 1];
                    data[y + 1] = Temp;
                }
            }
        }
        return data;
    }

    // Selection Sort method
    static int[] selectionSort(int[] data, int n) {
        int min, Temp;
        for (int x = 0; x < n; x++) {
            min = x;
            for (int y = x; y < n; y++) {
                selectionIterations++;
                if (data[y] < data[min]) {
                    min = y;
                }
            }
            // Swap data[x] with data[min]
            Temp = data[x];
            data[x] = data[min];
            data[min] = Temp;
        }
        return data;
    }
}
