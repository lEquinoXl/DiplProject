import java.util.Arrays;

public class ArrayManager {

//    public int counter = 0;

    public int[] arr;
    private int size;
    private int max;
    private int min;

    static int MIN_MERGE = 32;

    public void forSort(int [] arr) {
        this.arr = arr;
        size = arr.length;
    }

    public void clear() {
        size = 10000000;
        min = 1000000;
        max = 10000000;
        double[] dArr = new double[size];
        for (int i = 0; i < size; i++)
            dArr[i] = (min + ((max - min) * Math.random()));
    }

    public void generate() {
        arr = new int[size];
        for (int i = 0; i < size; i++)
            arr[i] = (int) (min + ((max - min) * Math.random()));
    }

    public void swap(int[] array, int first, int second) {

        int tmp = array[first];
        array[first] = array[second];
        array[second] = tmp;
    }

    public void shuffleRec() {
        boolean state = false;
        while (!state) {
            boolean pState = true;
            for (int i = 0; i < Math.sqrt(size); i++) {
                int first = (int) (Math.random() * arr.length);
                int second = (int) (Math.random() * arr.length);
                if (first < second) {
                    if (arr[first] > arr[second]) {
//                        counter++;
                        swap(arr, first, second);
                        pState = false;
                    }
                } else if (first == second) {
                    continue;
                } else {
                    if (arr[second] > arr[first]) {
//                        counter++;
                        swap(arr, first, second);
                        pState = false;
                    }
                }
            }
            state = pState;
//            System.out.println("Swaps: " + counter);
//            counter = 0;
        }
    }

    public void shuffle() {
        for (int i = 0; i < Math.sqrt(size); i++) {
            int first = (int) (Math.random() * arr.length);
            int second = (int) (Math.random() * arr.length);
            if (first < second) {
                if (arr[first] > arr[second]) {
                    swap(arr, first, second);
                }
            } else if (first == second) {
                continue;
            } else {
                if (arr[second] > arr[first]) {
                    swap(arr, first, second);
                }
            }
        }
    }

    public void bubbleSort() {
        boolean isSorted = false;
        int tmp;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    isSorted = false;

                    tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                }
            }
        }
    }

    public void quickSort(int[] array, int low, int high) {
        if (array.length == 0)
            return;

        if (low >= high)
            return;

        int middle = low + (high - low) / 2;
        int opora = array[middle];

        int i = low, j = high;
        while (i <= j) {
            while (array[i] < opora) {
                i++;
            }

            while (array[j] > opora) {
                j--;
            }

            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        if (low < j)
            quickSort(array, low, j);

        if (high > i)
            quickSort(array, i, high);
    }

    public void mergeSort(int[] array, int left, int right) {
        if (right <= left) return;
        int mid = (left + right) / 2;
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    void merge(int[] array, int left, int mid, int right) {
        int lengthLeft = mid - left + 1;
        int lengthRight = right - mid;

        int leftArray[] = new int[lengthLeft];
        int rightArray[] = new int[lengthRight];

        for (int i = 0; i < lengthLeft; i++)
            leftArray[i] = array[left + i];
        for (int i = 0; i < lengthRight; i++)
            rightArray[i] = array[mid + i + 1];

        int leftIndex = 0;
        int rightIndex = 0;

        for (int i = left; i < right + 1; i++) {
            if (leftIndex < lengthLeft && rightIndex < lengthRight) {
                if (leftArray[leftIndex] < rightArray[rightIndex]) {
                    array[i] = leftArray[leftIndex];
                    leftIndex++;
                } else {
                    array[i] = rightArray[rightIndex];
                    rightIndex++;
                }
            } else if (leftIndex < lengthLeft) {
                array[i] = leftArray[leftIndex];
                leftIndex++;
            } else if (rightIndex < lengthRight) {
                array[i] = rightArray[rightIndex];
                rightIndex++;
            }
        }
    }

    void heapify(int[] array, int length, int i) {
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        int largest = i;

        if (leftChild < length && array[leftChild] > array[largest]) {
            largest = leftChild;
        }

        if (rightChild < length && array[rightChild] > array[largest]) {
            largest = rightChild;
        }

        if (largest != i) {
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
            heapify(array, length, largest);
        }
    }

    public void heapSort() {
        if (arr.length == 0) return;

        int length = arr.length;
        for (int i = length / 2 - 1; i >= 0; i--)
            heapify(arr, length, i);

        for (int i = length - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    public void insertionSort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= left && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }

    public void selectionSort(int[] numbers, int low, int high) {
        for (int h = low; h <= high; h++)
            swap(numbers, h, getSmallest(numbers, h, high));
    }

    public int getSmallest(int[] numbers, int low, int high) {
        int small = low;
        for (int i = low + 1; i <= high; i++)
            if (numbers[i] < numbers[small])
                small = i;
        return small;
    }

    public static int minRunLength(int n) {
        assert n >= 0;

        int r = 0;
        while (n >= MIN_MERGE) {
            r |= (n & 1);
            n >>= 1;
        }
        return n + r;
    }

    public void timSort(int[] arr, int n) {
        int minRun = minRunLength(MIN_MERGE);

        for (int i = 0; i < n; i += minRun) {
            insertionSort(arr, i,
                    Math.min((i + MIN_MERGE - 1), (n - 1)));
        }

        for (int size = minRun; size < n; size = 2 * size) {

            for (int left = 0; left < n;
                 left += 2 * size) {

                int mid = left + size - 1;
                int right = Math.min((left + 2 * size - 1),
                        (n - 1));

                if (mid < right)
                    merge(arr, left, mid, right);
            }
        }
    }

    void sort_shell(int[] a) {
        int i, j, k, h, m = 0, b = a.length;
        int[] d = {1, 4, 10, 23, 57, 145, 356, 911, 1968, 4711, 11969, 27901,
                84801, 213331, 543749, 1355339, 3501671, 8810089, 21521774,
                58548857, 157840433, 410151271, 1131376761, 2147483647};
        while (d[m] < b) ++m;
        while (--m >= 0) {
            k = d[m];
            for (i = k; i < b; i++) {
                j = i;
                h = a[i];
                while ((j >= k) && (a[j - k] > h)) {
                    a[j] = a[j - k];
                    j -= k;
                }
                a[j] = h;
            }
        }
    }

    static final int LP[] = {1, 1, 3, 5, 9, 15, 25, 41, 67, 109,
            177, 287, 465, 753, 1219, 1973, 3193, 5167, 8361, 13529, 21891,
            35421, 57313, 92735, 150049, 242785, 392835, 635621, 1028457,
            1664079, 2692537, 4356617, 7049155, 11405773, 18454929, 29860703,
            48315633, 78176337, 126491971, 204668309, 331160281, 535828591,
            866988873 // the next number is > 31 bits.
    };

    public void smooth_sort(int[] m, int lo, int hi) {
        int head = lo;
        int p = 1;
        int pshift = 1;

        while (head < hi) {
            if ((p & 3) == 3) {
                sift(m, pshift, head);
                p >>>= 2;
                pshift += 2;
            } else {

                if (LP[pshift - 1] >= hi - head) {

                    trinkle(m, p, pshift, head, false);
                } else {

                    sift(m, pshift, head);
                }

                if (pshift == 1) {

                    p <<= 1;
                    pshift--;
                } else {

                    p <<= (pshift - 1);
                    pshift = 1;
                }
            }
            p |= 1;
            head++;
        }

        trinkle(m, p, pshift, head, false);

        while (pshift != 1 || p != 1) {
            if (pshift <= 1) {
                // block of length 1. No fiddling needed
                int trail = Integer.numberOfTrailingZeros(p & ~1);
                p >>>= trail;
                pshift += trail;
            } else {
                p <<= 2;
                p ^= 7;
                pshift -= 2;

                // This block gets broken into three bits. The rightmost
                // bit is a block of length 1. The left hand part is split into
                // two, a block of length LP[pshift+1] and one of LP[pshift].
                // Both these two are appropriately heapified, but the root
                // nodes are not necessarily in order. We therefore semitrinkle
                // both of them

                trinkle(m, p >>> 1, pshift + 1, head - LP[pshift] - 1, true);
                trinkle(m, p, pshift, head - 1, true);
            }

            head--;
        }
    }

    private void sift(int[] m, int pshift, int head) {

        int val = m[head];

        while (pshift > 1) {
            int rt = head - 1;
            int lf = head - 1 - LP[pshift - 2];

            if (Integer.compare(val, m[lf]) >= 0 && Integer.compare(val, m[rt]) >= 0)
                break;
            if (Integer.compare(m[lf], m[rt]) >= 0) {
                m[head] = m[lf];
                head = lf;
                pshift -= 1;
            } else {
                m[head] = m[rt];
                head = rt;
                pshift -= 2;
            }
        }

        m[head] = val;
    }

    private void trinkle(int[] m, int p, int pshift, int head, boolean isTrusty) {

        int val = m[head];

        while (p != 1) {
            int stepson = head - LP[pshift];

            if (Integer.compare(m[stepson], val) <= 0)
                break;
            if (!isTrusty && pshift > 1) {
                int rt = head - 1;
                int lf = head - 1 - LP[pshift - 2];
                if (Integer.compare(m[rt], m[stepson]) >= 0
                        || Integer.compare(m[lf], m[stepson]) >= 0)
                    break;
            }

            m[head] = m[stepson];

            head = stepson;
            int trail = Integer.numberOfTrailingZeros(p & ~1);
            p >>>= trail;
            pshift += trail;
            isTrusty = false;
        }

        if (!isTrusty) {
            m[head] = val;
            sift(m, pshift, head);
        }
    }

    public void create(int size, int max, int min){
        this.size = size;
        this.max = max;
        this.min = min;
    }
}