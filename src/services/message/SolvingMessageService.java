package services.message;

public class SolvingMessageService extends MessageService {
    public void cannotSolveMessage(){
        System.err.println("Данную СЛАУ невозможно решить методом Гаусса! Увы и ах...");
    }

    public void noSolutionMessage(){
        System.err.println("Данная СЛАУ не имеет решений!");
    }

    public void infinitySolutionMessage(){
        System.err.println("Данная СЛАУ имеет бесконечное множество решений!");
    }

    public void showDeterminant(double det){
        System.out.printf(".............................................." +
                "\nОпределитель матрицы: " + MessageColor.GREEN + "%.3f\n" + MessageColor.RESET, det);
    }

    public void showUnknowns(double res[]){
        System.out.println(".............................................." +
                "\nТаблица неизвестных:");

        for(int i = 0; i < res.length; i++) System.out.printf("x" + (i + 1) + " = " + MessageColor.GREEN + "%.4f\n" + MessageColor.RESET, res[i]);
    }

    public void showResidual(double red[]){
        System.out.println(".............................................." +
                "\nТаблица невязок:");

        for(int i = 0; i < red.length; i++) System.out.println("|" + MessageColor.GREEN + red[i] + MessageColor.RESET + "|");
    }
}
