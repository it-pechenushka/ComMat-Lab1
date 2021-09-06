package services.message;

public class FileMessageService extends MessageService {

    private static final String TRY_AGAIN_MESSAGE = "Проверьте правильность данных в файле и повторите попытку снова.";

    public void initFileName(){
        System.out.println("Введите абсолютный путь до файла. Если файл находится в директории с проектом, то можно ввести название файла.");
    }

    public void fileNotFoundMessage(){
        System.err.println("Введенный вами файл не существует или в его названии ошибка! " + MessageColor.WHITE + TRY_AGAIN_MESSAGE + MessageColor.RESET);
    }

    public void getWriteInstruction() {
        System.out.println(MessageColor.RED + "*******************************************************************" + MessageColor.RESET +
                "\nДанные файла должны соответствовать следующим требованиям: " + MessageColor.BLUE +
                "\n*Первая строка должна содержать количество уравнений {n<=20}." + MessageColor.PURPLE +
                "\n         #n - целое число." +
                "\n         #Строка не должна содержать букв. Только цифры от 0 до 9." + MessageColor.BLUE +
                "\n*Далее следует n строк, содержащие элементы расширенной матрицы. (Каждая строка содержит n + 1 элементов)" + MessageColor.PURPLE +
                "\n         #Каждый элемент разделен пробелом от другого пробелом." +
                "\n         #Запись не должна содержать букв." +
                "\n         #Целая часть должна отделяться от дробной точкой {.}!" + MessageColor.RESET);
        System.out.println("Пример:" + MessageColor.GREEN +
                "\n4" +
                "\n1 2 3 4 10" +
                "\n5 6 7 8 11" +
                "\n9 8 7 6 13" +
                "\n5 4 3 2 14" +
                "\n" + MessageColor.RED + "*******************************************************************" + MessageColor.RESET);
    }

    public void confirmMessage(){
        System.out.println("Проверьте название файла и выполнение всех условий. Хотите продолжить? ({да} | {нет})");
    }

    public void invalidConfirmMessage(){
        System.err.println("Ведите корректный ответ!");
    }

    public void invalidMatrixLineMessage(int num){
        System.err.println("Количество элементов в строке №" + num + " расширенной матрицы не соответствует действительному! " + MessageColor.WHITE + TRY_AGAIN_MESSAGE + MessageColor.RESET);
    }

    public void invalidFormatMatrixMessage(){
        System.err.println("Недопустимые символы в элементах матрицы!" + MessageColor.WHITE + TRY_AGAIN_MESSAGE + MessageColor.RESET);
    }

    public void notSetMatrixElementMessage(){
        System.err.println("В файле заданы не все элементы расширенной матрицы!" + MessageColor.WHITE + TRY_AGAIN_MESSAGE + MessageColor.RESET);
    }

    public void wrongSizeMessage(){
        System.err.println("Количество уравнений должно быть положительным и меньше 20. " + MessageColor.WHITE + TRY_AGAIN_MESSAGE + MessageColor.RESET);
    }

    public void notSetSizeMessage(){
        System.err.println("В файле не установлен размер! " + MessageColor.WHITE + TRY_AGAIN_MESSAGE + MessageColor.RESET);
    }

    public void invalidFormatSizeMessage(){
        System.err.println("Недопустимые символы в размере матрицы!" + MessageColor.WHITE + TRY_AGAIN_MESSAGE + MessageColor.RESET);
    }

}
