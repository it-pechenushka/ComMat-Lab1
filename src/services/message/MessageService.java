package services.message;

public class MessageService extends AbstractMessageService{
    class MessageColor {
        public static final String RESET = "\u001B[0m";
        public static final String RED = "\u001B[31m";
        public static final String GREEN = "\u001B[32m";
        public static final String BLUE = "\u001B[34m";
        public static final String PURPLE = "\u001B[35m";
        public static final String CYAN = "\u001B[36m";
        public static final String WHITE = "\u001B[37m";
    }

    public void printDataEntryMethodMessage(){
        System.out.println("Выберите способ ввода данных (консоль {к}| файл {ф}| случайная генерация чисел {г})");
    }

    public void printWrongInputDataTypeMessage(){
        System.err.println("Проверьте название способа ввода данных! Запись должна содержать едиственный символ.");
    }

    public void selectedTypeMessage(String type){
        System.out.println("Ввод данных осуществляется через: " + MessageColor.RED + type + MessageColor.RESET);
    }

    public void showMatrixMessage(double[][] matrixA, double[] matrixB, boolean conversion){
        if(conversion)
            System.out.println("..............................................\nРасширенная матрица элементов после преобразования:");
        else
            System.out.println("..............................................\nРасширенная матрица элементов будет выглядеть следующим образом: ");

        for(int i = 0; i < matrixA.length; i++){
            System.out.print("| ");
            for (int j = 0; j < matrixA.length; j++)
                System.out.printf(MessageColor.GREEN + "%.3f ", matrixA[i][j]);

            System.out.printf(MessageColor.RESET + "| " + MessageColor.CYAN + "%.3f" + MessageColor.RESET + "|\n", matrixB[i]);
        }
    }


    public void showSizeMessage(int size){
        System.out.println(".............................................." +
                "\nРазмерность: "  + MessageColor.GREEN + size + MessageColor.RESET);
    }

    @Override
    public void doing() {
        System.out.println("Добро пожаловать!\nДанная программа решает СЛАУ методом Гаусса.");
    }
}
