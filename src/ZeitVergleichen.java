import java.util.concurrent.SynchronousQueue;

public class ZeitVergleichen {
	
	
	  public static void main(String [] args)
	    {        
	        int arr1[] = {12, 11, 13, 5, 6};
	        int arr2[] = {12, 11, 13, 5, 6};
	        int arr3[] = {12, 11, 13, 5, 6};
	        int arr4[] = {12, 11, 13, 5, 6};
	        int arr5[] = {12, 11, 13, 5, 6};
	        int arr6[] = {12, 11, 13, 5, 6};
	        
	        int n = arr1.length;
	        System.out.println("Der zu sortierende Array lautet: ");
	        printArray(arr1);
	        System.out.println("Quicksort: ");
	        quickSort(arr1, 0, n-1);
	        printArray(arr1);
	        System.out.println("Mergesort: ");
	        mergeSort(arr2, 0, arr2.length-1);
	        printArray(arr2);
	        System.out.println("Bubblesort: ");
	        bubbleSort(arr3);
	        printArray(arr3);
	        System.out.println("Insertionsort: ");
	        insertionSort(arr4);
	        printArray(arr4);
	        System.out.println("Selectionsort: ");
	        selectionSort(arr5);
	        printArray(arr5);
	        System.out.println("Heapsort: ");
	        heapSort(arr6);
	        printArray(arr6);
	        
	    }
	  
	  static void printArray(int arr[])
	    {
	        int n = arr.length;
	        for (int i=0; i<n; ++i)
	            System.out.print(arr[i]+" ");
	        System.out.println();
	    }

	public static void insertionSort(int arr[])
	{
		final long timeStart = System.nanoTime();  
	
	        int n = arr.length;
	        for (int i=1; i<n; ++i)
	        {
	            int key = arr[i];
	            int j = i-1;
	            while (j>=0 && arr[j] > key)
	            {
	                arr[j+1] = arr[j];
	                j = j-1;
	            }
	            arr[j+1] = key;
	        }
	        final long timeEnd = System.nanoTime(); 
	        System.out.println("Verlaufszeit der Schleife: " + (timeEnd - timeStart) + " Nanosek.");
	    }
	
	public static void selectionSort(int arr[])
	{
		final long timeStart = System.nanoTime();  
	        int n = arr.length;
	 
	        for (int i = 0; i < n-1; i++)
	        {
	            int min_idx = i;
	            for (int j = i+1; j < n; j++)
	                if (arr[j] < arr[min_idx])
	                    min_idx = j;
	
	            int temp = arr[min_idx];
	            arr[min_idx] = arr[i];
	            arr[i] = temp;
	        }
	        final long timeEnd = System.nanoTime();
	        System.out.println("Verlaufszeit der Schleife: " + (timeEnd - timeStart) + " Nanosek.");
	    }
	
	public static void bubbleSort(int arr[])
	{
		final long timeStart = System.nanoTime(); 
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] > arr[j+1])
                {
                    // swap temp and arr[i]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
        final long timeEnd = System.nanoTime();
        System.out.println("Verlaufszeit der Schleife: " + (timeEnd - timeStart) + " Nanosek.");
	}


	public static int quickSort(int arr[], int low, int high)
    {
		final long timeStart = System.nanoTime(); 
        int pivot = arr[high]; 
        int i = (low-1); 
        for (int j=low; j<high; j++)
        {
            if (arr[j] <= pivot)
            {
                i++;
 
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            
        }
 
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        final long timeEnd = System.nanoTime();
        System.out.println("Verlaufszeit der Schleife: " + (timeEnd - timeStart) + " Nanosek.");
        return i+1;
    }
 
	public static void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
 
        /* Create temp arrays */
        int L[] = new int [n1];
        int R[] = new int [n2];
 
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];
 
 
        /* Merge the temp arrays */
 
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
 
        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
 
        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
 
    public static void mergeSort(int arr[], int l, int r)
    {
    	final long timeStart = System.nanoTime(); 
        if (l < r)
        {
            // Find the middle point
            int m = (l+r)/2;
 
            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr , m+1, r);
 
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
        final long timeEnd = System.nanoTime();
        System.out.println("Verlaufszeit der Schleife: " + (timeEnd - timeStart) + " Nanosek.");
    }
    
    public static void heapSort(int arr[])
    {
    	final long timeStart = System.nanoTime();
        int n = arr.length;
 
        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
 
        // One by one extract an element from heap
        for (int i=n-1; i>=0; i--)
        {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
 
            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
        final long timeEnd = System.nanoTime();
        System.out.println("Verlaufszeit der Schleife: " + (timeEnd - timeStart) + " Nanosek.");
    }
 
    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    static void heapify(int arr[], int n, int i)
    {
        int largest = i;  // Initialize largest as root
        int l = 2*i + 1;  // left = 2*i + 1
        int r = 2*i + 2;  // right = 2*i + 2
 
        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;
 
        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;
 
        // If largest is not root
        if (largest != i)
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
 
            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }
}
