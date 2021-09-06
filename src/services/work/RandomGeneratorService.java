package services.work;

public class RandomGeneratorService extends ConsoleService{
    private static final String TYPE_NAME = "генерация случайных чисел";

    public RandomGeneratorService() {
        super(TYPE_NAME);
    }

    @Override
    public void initMatrix() {
        double[][] matrixA = new double[super.getSize()][super.getSize()];
        double[] matrixB = new double[super.getSize()];

        for(int i = 0; i < super.getSize(); i++){
            for (int j = 0; j < super.getSize(); j++){
                matrixA[i][j] = (Math.round(Math.random() * 100000) / 1000.0);
            }

            matrixB[i] = Math.round(Math.random() * 100000) / 1000.0;
        }

        super.setMatrixA(matrixA);
        super.setMatrixB(matrixB);
    }
}
