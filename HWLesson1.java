import java.sql.Array;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



// 1. Выбросить случайное целое число в диапазоне от -1000 до 1000 и сохранить в i
// 2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
// 3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1
// 4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2
// 5. Сохранить оба массива в файлы с именами m1 и m2 соответственно.

// Пункты реализовать в методе main

// *Пункты реализовать в разных методах

/**
 * HWLesson1
 */
public class HWLesson1 {

    public static void main(String[] args) {
        int iMin = -1000;
        int iMax = 1000;
        int i = Rand (iMin, iMax);
        int n = Msb (i);
        String nBin = Integer.toBinaryString(i); // для наглядности
        int m1Max = Short.MAX_VALUE;
        int m2Min = Short.MIN_VALUE;
        String m1 = m(i,m1Max, n);
        String m2 = m(m2Min,i, n);
        System.out.println("При i = " + i + "\n" + "n = " + n + " (" + nBin + ")");
        System.out.println(i + " => " + m1Max + " => "+ "m1.txt");
        //System.out.println(m1);
        System.out.println(m2Min + " => " + i+ " => "+ "m2.txt");
        //System.out.println(m2);
        
        File fileM1 = new File ("m1.txt");
        if (!fileM1.exists()) {
            try {
                fileM1.createNewFile();
                FileWriter fileWriter = new FileWriter(fileM1.getAbsoluteFile());
                fileWriter.append(m1);
                fileWriter.flush();
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        File fileM2 = new File ("m2.txt");
        if (!fileM2.exists()) {
            try {
                fileM2.createNewFile();
                FileWriter fileWriter = new FileWriter(fileM2.getAbsoluteFile());
                fileWriter.append(m2);
                fileWriter.flush();
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
}
    // Метод получения целочисленного псевдослучайного числа
    public static int Rand (int min, int max) {
        int rnd = (int)(Math.random() * ((max - min) + 1 ) + min);
        return rnd;
    }

// Метод нахождения номера старшего бита
    public static int  Msb (int x) {
        int numMsb = Math.abs (x);
        return Integer.toBinaryString(numMsb).length(); 
    }

//Метод заполнения списка и приведения его в массив строк
    public static  String  m (int min, int max, int num) {
        ArrayList <Integer> arrayList = new ArrayList();
        int x = min;
        for (int i = 0; i <= (Math.abs(min) + max); i++) {
            if (x<=max & x%num == 0)
            arrayList.add(x);
        x+=1;}
        
        int [] m = arrayList.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();
        return Arrays.toString (m);
    }

}  

    

     
    

    
      
    
        
 


