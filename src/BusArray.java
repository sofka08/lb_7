import java.util.Scanner;

public class BusArray {
    private String fio;
    private String numberBus;
    private int numberRoute;
    private String brand;
    private int startYear;
    private int mileage;

    public BusArray(String fio, String numberBus, int numberRoute, String brand, int startYear, int mileage) {
        this.fio = fio;
        this.numberBus = numberBus;
        this.numberRoute = numberRoute;
        this.brand = brand;
        this.startYear = startYear;
        this.mileage = mileage;
    }

    public String getFio() {
        return fio;
    }

    public String getNumberBus() {
        return numberBus;
    }

    public int getNumberRoute() {
        return numberRoute;
    }

    public String getBrand() {
        return brand;
    }

    public int getStartYear() {
        return startYear;
    }

    public int getMileage() {
        return mileage;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "fio='" + fio + '\'' +
                ", numberBus='" + numberBus + '\'' +
                ", numberRoute=" + numberRoute +
                ", brand='" + brand + '\'' +
                ", startYear=" + startYear +
                ", mileage=" + mileage +
                '}';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Создание массива объектов Bus (заполнение данными)
        BusArray[] buses = new BusArray[5];
        buses[0] = new BusArray("Дейцев В. С.", "А777БВ", 10, "Mercedes", 2015, 150000);
        buses[1] = new BusArray("Лисин М. А.", "В456ГД", 20, "MAN", 2018, 80000);
        buses[2] = new BusArray("Сидоров С. В.", "Е111ЖЗ", 10, "Mercedes", 2017, 120000);
        buses[3] = new BusArray("Собакин Н. С.", "И333КЛ", 30, "Volvo", 2020, 50000);
        buses[4] = new BusArray("Зернов К. М.", "М345НО", 20, "MAN", 2022, 180000);

        // а) Список автобусов для заданного номера маршрута
        System.out.print("Введите номер маршрута для поиска: ");
        int searchRoute = scanner.nextInt();
        scanner.nextLine();

        boolean routeFound = false;
        System.out.println("Автобусы для маршрута " + searchRoute + ":");
        for (BusArray bus : buses) {
            if (bus.getNumberRoute() == searchRoute) {
                System.out.println(bus);
                routeFound = true;
            }
        }

        if (!routeFound) {
            System.out.println("Номер маршрута " + searchRoute + " не найден.");
        }

        // б) Список автобусов, пробег у которых больше заданного количества км
        System.out.print("\nВведите пробег для поиска автобусов: ");
        int targetMileage = scanner.nextInt();
        scanner.nextLine();

        boolean mileageFound = false;
        System.out.println("\nАвтобусы с пробегом больше " + targetMileage + " км:");
        for (BusArray bus : buses) {
            if (bus.getMileage() > targetMileage) {
                System.out.println(bus);
                mileageFound = true;
            }
        }

        if (!mileageFound) {
            System.out.println("Автобусы с пробегом больше " + targetMileage + " км не найдены.");
        }

        scanner.close();
    }
}
