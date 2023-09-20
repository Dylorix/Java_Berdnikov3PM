import java.util.Locale;
import java.util.Scanner;

public class Main {
    //Класс пятого задания:
    public static class DoubleEven {
        public boolean EvenTest(int number) {
            boolean res = false;
            int sum = (number / 100 + (number / 10) % 10 + number % 100);
            int mul = (number / 100 * (number / 10) % 10 * number % 100);

            if (sum % 2 == 0 && mul % 2 == 0) {
                res = true;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        //Первое задание:
        /*
        Scanner in = new Scanner(System.in);
        System.out.println("Введите число: ");
        int base = in.nextInt();
        int steps = 0;
        in.close();

        while (base != 1) {
            if (base % 2 == 0) {
                base /= 2;
                steps++;
            } else {
                base = 3 * base + 1;
                steps++;
            }
        }
        System.out.println(steps);
        */

        //Второе задание:
        /*
        Scanner in = new Scanner(System.in);
        System.out.println("Введите n: ");
        int n = in.nextInt();
        int result = 0;
        int temp = 0;

        for (int i = 0; i < n; i++) {
            temp = in.nextInt();
            if (i%2==0) {
                result+=temp;
            } else {
                result-=temp;
            }
        }
        in.close();
        System.out.println(result);
        */

        //Третье задание:
        /*
        Scanner in = new Scanner(System.in);
        System.out.println("Введите координаты клада: ");
        int x_chest = in.nextInt();
        int y_chest = in.nextInt();
        int x=0,y=0,steps=0,result=9999999;
        String temp = null;
        boolean flag = true;
        System.out.println("Введите карту: ");
        while (flag) {
            temp = in.nextLine();
            switch (temp) {
                case ("север"):
                    y+=in.nextInt();
                    steps++;
                    if (x == x_chest && y == y_chest)
                    {
                        if (steps < result)
                            result = steps;
                    }
                    break;
                case ("юг"):
                    y-=in.nextInt();
                    steps++;
                    if (x == x_chest && y == y_chest)
                    {
                        if (steps < result)
                            result = steps;
                    }
                    break;
                case ("запад"):
                    x-=in.nextInt();
                    steps++;
                    if (x == x_chest && y == y_chest)
                    {
                        if (steps < result)
                            result = steps;
                    }
                    break;
                case ("восток"):
                    x+=in.nextInt();
                    steps++;
                    if (x == x_chest && y == y_chest)
                    {
                        if (steps < result)
                            result = steps;
                    }
                    break;
                case ("стоп"):
                    flag = false;
                    break;
            }
        }
        in.close();
        System.out.println(result);
        */

        //Четвёртое задание:
        /*
        Scanner in = new Scanner(System.in);
        System.out.println("Введите количество дорог: ");
        int road_count = in.nextInt();
        int tunnel_count, tunnel_temp, temp_result = 0, temp_road_result = 0;
        int result = 0, road_result = 0;

        for (int i = 0; i < road_count; i++) {
            System.out.println("Введите количество тунеллей: ");
            tunnel_count = in.nextInt();
            for (int j = 0; j < tunnel_count; j++) {
                System.out.println("Введите высоту туннеля " + (j+1) + ": ");
                tunnel_temp = in.nextInt();
                if (temp_result == 0) {
                    temp_result = tunnel_temp;
                    temp_road_result = i+1;
                } else if (tunnel_temp < temp_result){
                    temp_result = tunnel_temp;
                    temp_road_result = i+1;
                }
            }
            if (result == 0) {
                result = temp_result;
                road_result = temp_road_result;
            } else if (result < temp_result){
                result = temp_result;
                road_result = temp_road_result;
            }
            temp_result = 0;
        }

        in.close();
        System.out.println(road_result + " " + result);
        */

        //Пятое задание:
        /*
        Scanner in = new Scanner(System.in);
        System.out.println("Введите число:");
        int num = in.nextInt();
        DoubleEven myClass = new DoubleEven();
        in.close();
        System.out.println(myClass.EvenTest(num));
        */
    }
}