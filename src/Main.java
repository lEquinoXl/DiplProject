public class Main {
    public static void main(String[] args) {
        int size = 1000000;
        int max = 1000000;
        int min = 1;
        int count = 100;

        long result = 0;
        Experiment experiment;
        experiment = new Experiment(size, max, min);
        for (int i = 0; i<count; i++){
            System.out.println("Try "+ (i+1));

//            result += experiment. Обрати алгоритм сортування;

        }
        result /=count;
        System.out.println(result);
    }
}