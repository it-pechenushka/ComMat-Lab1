package services.message;

public class ConsoleMessageService extends MessageService {
    public void initSizeMessage(){
        System.out.println("Введите размерность матрицы(количество уравнений {n<=20, n - целое число}).");
    }

    public void invalidFormatSizeMessage(){
        System.err.println("Введенное значение должно быть целочисленным и содержать только цифры от 0 до 9!");
    }

    public void wrongSizeMessage(){
        System.err.println("Количество уравнений должно быть положительным и меньше 20");
    }

    public void initMatrixMessage(){
        System.out.println("Введите элементы расширенной матрицы по следующему приципу:" + MessageColor.BLUE +
                "\n*Каждый элемент должен быть разделен пробелом!" +
                "\n*Запись производится по-строчно (строка должна содержать n + 1 элементов)!" +
                "\n*Запись не должна содержать букв!" +
                "\n*Целая часть должна отделяться от дробной точкой {.}!" + MessageColor.RESET);
    }

    public void invalidFormatMatrixMessage(){
        System.err.println("Веденные вами данные не соответсвуют условиям! Попробуйте ввести строку снова.");
    }

    public void invalidMatrixLineMessage(){
        System.err.println("Количество элементов в строке расширенной матрицы не соответствует действительному! Попробуйте ввести строку снова.");
    }

}
