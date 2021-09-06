package services.work;

import method.GaussMethod;
import services.Service;
import services.message.ConsoleMessageService;

import java.util.Scanner;

public class ConsoleService implements Service{

    private static final String TYPE_NAME = "консоль";
    private ConsoleMessageService ms;
    private int size;
    private double matrixA[][];
    private double matrixB[];

    public ConsoleService(){
        ms = new ConsoleMessageService();
        ms.selectedTypeMessage(getTypeName());
    }

    protected ConsoleService(String type){
        ms = new ConsoleMessageService();
        ms.selectedTypeMessage(type);
    }

    public static String getTypeName() {
        return TYPE_NAME;
    }

    public void initSize(){
        Scanner scanner = new Scanner(System.in);
        ms.initSizeMessage();

        while (true) {
            try {
                size = Integer.parseInt(scanner.nextLine());
                if (size <= 20 && size > 0)
                    break;
                else
                    ms.wrongSizeMessage();
            }catch (NumberFormatException e){
                ms.invalidFormatSizeMessage();
            }
        }
    }

    public void initMatrix(){
        Scanner scanner = new Scanner(System.in);
        matrixA = new double[size][size];
        matrixB = new double[size];

        ms.initMatrixMessage();

        for(int i = 0; i < size; i++) {
            int count = 0;

            while (count < size + 1) {
                String supMatrix[] = scanner.nextLine().trim().split(" ");

                if(supMatrix.length == size + 1) {
                    try {
                    for (int j = 0; j < size; j++) {
                        matrixA[i][j] = Double.parseDouble(supMatrix[j]);
                        count++;
                    }

                    matrixB[i] = Double.parseDouble(supMatrix[size]);
                    count++;

                } catch (NumberFormatException e){
                    ms.invalidFormatMatrixMessage();
                    count = 0;
                }

                } else ms.invalidMatrixLineMessage();
            }

        }
    }


    @Override
    public void doing() {
        initSize();
        initMatrix();

        ms.showSizeMessage(size);
        ms.showMatrixMessage(matrixA, matrixB, false);

        new GaussMethod(matrixA, matrixB, size).solve();
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public double[][] getMatrixA() {
        return matrixA;
    }

    public void setMatrixA(double[][] matrixA) {
        this.matrixA = matrixA;
    }

    public double[] getMatrixB() {
        return matrixB;
    }

    public void setMatrixB(double[] matrixB) {
        this.matrixB = matrixB;
    }
}
