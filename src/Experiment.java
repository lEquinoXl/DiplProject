public class Experiment {
    private static ArrayManager manager = new ArrayManager();
    private boolean toSort = false;

    public Experiment(int size, int max, int min) {
        manager.create(size, max, min);
    }
    public Experiment(int[] arr) {
        manager.create(arr.length, 1, 1);
        toSort = true;
        manager.forSort(arr);
    }

    public long shuffle() {
        if(!toSort) manager.generate();
        long time = System.nanoTime();
        manager.shuffle();
        time = System.nanoTime() - time;
        return time;
    }
    // стохастичне сортування
    public long shuffleRec() {
        if(!toSort) manager.generate();
        long time = System.nanoTime();
        manager.shuffleRec();
        time = System.nanoTime() - time;
        return time;
    }

    public long bubble() {
        if(!toSort) manager.generate();
        long time = System.nanoTime();
        manager.bubbleSort();
        time = System.nanoTime() - time;
        return time;
    }
    // сортування міхуром
    public long shuffleBubble() {
        if(!toSort) manager.generate();
        long time = System.nanoTime();
        manager.shuffleRec();
        manager.bubbleSort();
        time = System.nanoTime() - time;
        return time;
    }

    public long tim() {
        if(!toSort) manager.generate();
        long time = System.nanoTime();
        manager.timSort(manager.arr, manager.arr.length - 1);
        time = System.nanoTime() - time;
        return time;
    }
    // сортування Тіма
    public long shuffleTim() {
        if(!toSort) manager.generate();
        long time = System.nanoTime();
        manager.shuffle();
        manager.timSort(manager.arr, manager.arr.length - 1);
        time = System.nanoTime() - time;
        return time;
    }

    public long smooth() {
        if(!toSort) manager.generate();
        long time = System.nanoTime();
        manager.smooth_sort(manager.arr, 0, manager.arr.length - 1);
        time = System.nanoTime() - time;
        return time;
    }
    // плавне сортування
    public long shuffleSmooth() {
        if(!toSort) manager.generate();
        long time = System.nanoTime();
        manager.shuffle();
        manager.smooth_sort(manager.arr, 0, manager.arr.length - 1);
        time = System.nanoTime() - time;
        return time;
    }

    public long quick() {
        if(!toSort) manager.generate();
        long time = System.nanoTime();
        manager.quickSort(manager.arr, 0, manager.arr.length - 1);
        time = System.nanoTime() - time;
        return time;
    }
    // швидке сортування
    public long shuffleQuick() {
        if(!toSort) manager.generate();
        long time = System.nanoTime();
        manager.shuffle();
        manager.quickSort(manager.arr, 0, manager.arr.length - 1);
        time = System.nanoTime() - time;
        return time;
    }

    public long insert() {
        if(!toSort) manager.generate();
        long time = System.nanoTime();
        manager.insertionSort(manager.arr, 0, manager.arr.length - 1);
        time = System.nanoTime() - time;
        return time;
    }
    // сортування вставками
    public long shuffleInsert() {
        if(!toSort) manager.generate();
        long time = System.nanoTime();
        manager.shuffle();
        manager.insertionSort(manager.arr, 0, manager.arr.length - 1);
        time = System.nanoTime() - time;
        return time;
    }

    public long selection() {
        if(!toSort) manager.generate();
        long time = System.nanoTime();
        manager.selectionSort(manager.arr, 0, manager.arr.length - 1);
        time = System.nanoTime() - time;
        return time;
    }
    // сортування вибором
    public long shuffleSelection() {
        if(!toSort) manager.generate();
        long time = System.nanoTime();
        manager.shuffle();
        manager.selectionSort(manager.arr, 0, manager.arr.length - 1);
        time = System.nanoTime() - time;
        return time;
    }

    public long merge() {
        if(!toSort) manager.generate();
        long time = System.nanoTime();
        manager.mergeSort(manager.arr, 0, manager.arr.length - 1);
        time = System.nanoTime() - time;
        return time;
    }
    // сортування злиттям
    public long shuffleMerge() {
        if(!toSort) manager.generate();
        long time = System.nanoTime();
        manager.shuffle();
        manager.mergeSort(manager.arr, 0, manager.arr.length - 1);
        time = System.nanoTime() - time;
        return time;
    }

    public long heap() {
        if(!toSort)  manager.generate();
        long time = System.nanoTime();
        manager.heapSort();
        time = System.nanoTime() - time;
        return time;
    }
    // сортування злиттям
    public long shuffleHeap() {
        if(!toSort) manager.generate();
        long time = System.nanoTime();
        manager.shuffle();
        manager.heapSort();
        time = System.nanoTime() - time;
        return time;
    }

    public long shell() {
        if(!toSort) manager.generate();
        long time = System.nanoTime();
        manager.sort_shell(manager.arr);
        time = System.nanoTime() - time;
        return time;
    }
    // сортування Шелла
    public long shuffleShell() {
        if(!toSort) manager.generate();
        long time = System.nanoTime();
        manager.shuffle();
        manager.sort_shell(manager.arr);
        time = System.nanoTime() - time;
        return time;
    }
}
