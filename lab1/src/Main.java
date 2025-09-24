import model.Apartment;
import model.Tenant;
import model.LeaseAgreement;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Тестовые данные
        List<Apartment> apartments = new ArrayList<>();
        apartments.add(new Apartment(1, "ул. Ленина, 10", 25000));
        apartments.add(new Apartment(2, "пр. Мира, 25", 35000));
        apartments.add(new Apartment(3, "ул. Гагарина, 5", 20000));

        List<Tenant> tenants = new ArrayList<>();
        tenants.add(new Tenant(1, "Иван Петров"));
        tenants.add(new Tenant(2, "Мария Сидорова"));

        List<LeaseAgreement> agreements = new ArrayList<>();
        agreements.add(new LeaseAgreement(1, apartments.get(0), tenants.get(0),
                LocalDate.of(2024, 1, 15), LocalDate.of(2025, 1, 14)));
        agreements.add(new LeaseAgreement(2, apartments.get(1), tenants.get(1),
                LocalDate.of(2024, 3, 1), LocalDate.of(2024, 8, 31)));

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== СИСТЕМА АРЕНДЫ ЖИЛЬЯ (ОСНОВНАЯ ВЕТКА) ===");
        System.out.println("1. Поиск квартир по максимальной цене");
        System.out.println("2. Фильтрация арендаторов по минимальному сроку договора (в днях)");
        System.out.print("Выберите операцию (1 или 2): ");

        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.print("Введите максимальную цену аренды: ");
            double maxPrice = scanner.nextDouble();
            System.out.println("\nПодходящие квартиры:");
            apartments.stream()
                    .filter(a -> a.getRentPrice() <= maxPrice)
                    .forEach(System.out::println);
        } else if (choice == 2) {
            System.out.print("Введите минимальный срок договора (в днях): ");
            long minDuration = scanner.nextLong();
            System.out.println("\nАрендаторы с договорами не короче " + minDuration + " дней:");
            agreements.stream()
                    .filter(a -> a.getDurationDays() >= minDuration)
                    .map(LeaseAgreement::getTenant)
                    .distinct()
                    .forEach(System.out::println);
        } else {
            System.out.println("Неверный выбор.");
        }

        scanner.close();
    }
}