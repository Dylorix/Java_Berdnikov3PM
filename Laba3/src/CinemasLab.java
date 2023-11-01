import java.util.Arrays;
import java.util.Scanner;

public class CinemasLab {
    class cinemas
    {
        public void CinemaInfo()
        {
            System.out.println("-");
            System.out.print("Имеет ли парковку? ");
            if (hasParking)
                System.out.println("Да");
            else
                System.out.println("Нет");
            System.out.println("");

            System.out.println("В этом кинотеатре " + halls.length + " холла(-ов):");
            for(int i = 0; i < halls.length;i++)
            {
                int n = i+1;
                System.out.println("Информация о " + n +" холле: ");
                halls[i].HallInfo();
            }
            System.out.println("---");
        }
        CinemasLab.halls[] halls;
        boolean hasParking;
        int price;
    }

    static class halls
    {

        public void HallInfo()
        {
            System.out.println("В этом холе " + places.length + " рядов по " + places[0].length + " мест в каждом.");
            System.out.println("Этот холл имеет следующие сеансы: ");

            for(int i = 0; i< session.length; i++)
            {
                int n = i+1;
                int beginHour = session[i][0];
                int duration = session[i][1];
                System.out.println("Сеанс № " + n +". Начало в " + beginHour + " часов. Длится " + duration + " часа(-ов).");
            }

            System.out.println("");
        }

        public void MarkPlaces()
        {
            for (int i = 0; i < places.length; i++)
                Arrays.fill(places[i],false);
        }

        int[][] session;
        boolean [][] places;
    }
    public static void Info(cinemas[] cinemas)
    {
        for (int i  = 0; i<cinemas.length;i++)
        {
            int n = i+1;
            System.out.println("Информация о " + n + " кинотеатре: " );
            cinemas[i].CinemaInfo();
        }
    }

    public void prog()
    {
        halls hall1 = new halls();
        hall1.session = new int[][] {{10,2}, {13,3}, {17,1}};
        hall1.places = new boolean[10][10];
        hall1.MarkPlaces();
        halls hall2 = new halls();
        hall2.session = new int[][]{{11,2}};
        hall2.places = new boolean[7][40];
        hall2.MarkPlaces();
        halls hall3 = new halls();
        hall3.session = new int[][]{{14,4}, {13,2}};
        hall3.places = new boolean[5][5];
        hall3.MarkPlaces();

        cinemas cinema1 = new cinemas();
        cinema1.halls = new halls[]{hall1, hall2, hall3};
        cinema1.hasParking = false;
        cinema1.price = 250;

        halls hall4 = new halls();
        hall4.session = new int[][]{{19,2}};
        hall4.places = new boolean[8][10];
        hall4.MarkPlaces();
        halls hall5 = new halls();
        hall5.session = new int[][]{{8,5}, {14,2}, {16,1}};
        hall5.places = new boolean[9][9];
        hall5.MarkPlaces();

        cinemas cinema2 = new cinemas();
        cinema2.halls = new halls[]{hall4, hall5};
        cinema2.hasParking = true;
        cinema2.price = 350;

        cinemas[] cinemas = {cinema1, cinema2};
        Scanner in = new Scanner(System.in);

        System.out.println("У нас есть 2 кинотеатра, информация о них: ");
        Info(cinemas);

        while(true)
        {
            System.out.println("Выберите кинотеатр (чтобы выйти нажмите 0) ");
            int c = in.nextInt();

            if(c == 0)
                break;
            else if (c!=1 && c!=2) {
                System.out.println("Ошибка, кинотеатра " + c + " не существет");
                continue;
            }

            CinemasLab.cinemas currCinema = cinemas[c-1];

            System.out.println("Выберите один холл из " + currCinema.halls.length + "-х");
            int h = in.nextInt();

            if(h==0)
                break;

            while(h!=0)
            {
                if(h <= currCinema.halls.length && h>0)
                    break;
                else {
                    System.out.println("Ошибка, холла " + c + "не существет");
                    h = in.nextInt();
                }
            }

            halls currHall = currCinema.halls[h-1];

            System.out.println("Сколько билетов вы хотите купить по цене " + currCinema.price + " рублей за штуку");
            int count = in.nextInt();

            while(count!=0)
            {
                System.out.println("Выберите место, введя сначала ряд, а затем место:");
                int column = in.nextInt();
                int row = in.nextInt();

                if(currHall.places[column][row])
                {
                    System.out.println("Это место занято. Список всех купленных позиций: ");

                    for(int i =0 ; i <currHall.places.length;i++)
                        for(int j = 0; j<currHall.places[i].length;j++)
                            if(currHall.places[i][j])
                                System.out.println("Ряд: " + i + ", Место: " + j);
                }
                else
                {
                    currHall.places[column][row] = true;
                    count--;
                }
            }
            System.out.println("Вы успешно преобрели билет(-ы)");
            in.nextInt();
        }
    }
}