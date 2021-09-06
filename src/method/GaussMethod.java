package method;

import exceptions.CannotSolveException;
import exceptions.EndlessSolutionException;
import services.message.SolvingMessageService;

/**
 * This class implements Gaussian method.
 * @author ilusha
 * @version 1.1
 */
public class GaussMethod {
    private double[][] matrixA;
    private double[] matrixB;
    private int size;
    private SolvingMessageService ms;
    private double detA = 1.0;
    private double[] result;
    private double[] residual;

    public GaussMethod(double[][] matrixA, double[] matrixB, int size){
        this.matrixA = matrixA;
        this.matrixB = matrixB;
        this.size = size;
        result = new double[size];
        residual = new double[size];
        ms = new SolvingMessageService();
    }

    public void solve(){
        try {
            //строки которые вычитаем
            for (int i = 0; i < size - 1; i++)
            {
                checkLeader(i);

                //строки из которой вычитаем
                for (int j = i + 1; j < size; j++){
                    double c = matrixA[j][i] / matrixA[i][i];
                    matrixA[j][i] = 0;

                    for (int k = i + 1; k < size; k++){
                        matrixA[j][k] -= c * matrixA[i][k];
                    }

                    matrixB[j] -= c * matrixB[i];
                }
                //ms.showMatrixMessage(matrix, true);
            }

            if(matrixA[size - 1][size - 1] == 0.0 && matrixB[size - 1] != 0.0) throw new EndlessSolutionException();
            checkLeader(size - 1);

            for(int i = size - 1; i >= 0; i--){
                double s = 0.0;

                for(int j = i + 1; j < size; j++) s += matrixA[i][j] * result[j];

                result[i] = (matrixB[i] - s) / matrixA[i][i];
            }

            calculateDeterminant();
            calculateResidual();

            ms.showMatrixMessage(matrixA, matrixB, true);
            ms.showDeterminant(detA);
            ms.showUnknowns(result);
            ms.showResidual(residual);

        } catch (CannotSolveException e){
            ms.cannotSolveMessage();
        } catch (EndlessSolutionException e) {
            ms.infinitySolutionMessage();
        }
    }

    public void checkLeader(int it) throws CannotSolveException {
        boolean status = false;

        if (matrixA[it][it] == 0){
            for(int i = it + 1; i < size; i++){
                if(matrixA[i][it] != 0){
                    swapLine(i, it);
                    status = true;
                    detA *= -1;
                    break;
                }
            }

            if(!status) throw new CannotSolveException();
        }
    }


    public void swapLine(int line1, int line2){
        double temp;
        for(int j = 0; j < size; j++){
            temp = matrixA[line1][j];
            matrixA[line1][j] = matrixA[line2][j];
            matrixA[line2][j] = temp;
        }

        temp = matrixB[line1];
        matrixB[line1] = matrixB[line2];
        matrixB[line2] = temp;
    }

    public void calculateDeterminant(){
        for(int i = 0; i < size; i++)
            detA *= matrixA[i][i];
    }

    public void calculateResidual(){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                residual[i] += matrixA[i][j] * result[j];
            }

            residual[i] = matrixB[i] - residual[i];
        }
    }
}
