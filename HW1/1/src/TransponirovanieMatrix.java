import java.util.Random;

/**
 * Created by Yoko on 01.11.2016.
 */
public class TransponirovanieMatrix {


    public static int[][] TransponirovanieMatrixs(int[][]array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                int line = array[i][j];
                array[i][j] = array[j][i];
                array[j][i] = line;
            }
        }
        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < array.length; j++)
            {
                System.out.print(array[i][j] + " ");
            }
            System.out.print("\n");
        }
        return array;
    }

    public static void InitializeArray(int[][] array)
    {
        Random random = new Random();
        for (int i=0;i<array.length;i++)
        {
            for (int j=0;j<array.length;j++)
            {
                array[i][j]= random.nextInt(100);
                System.out.print(array[i][j]+" ");
            }
            System.out.print("\n");
        }
    }


    public static void main(String[] args)
    {
        int [][] massiv=new int[3][3];
        InitializeArray(massiv);
        System.out.print("\n");
        TransponirovanieMatrixs(massiv);

    }

}