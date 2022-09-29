import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int earnings = 0;
        int spendings = 0;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите операцию и введите её номер:\n" +
                    "1. Добавить новый доход\n" +
                    "2. Добавить новый расход\n" +
                    "3. Выбрать ситему налогооблажения");
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }
            int operation = Integer.parseInt(input);
            switch (operation) {
                case 1:
                    System.out.println("Введите сумму дохода:");
                    String moneyStr = scanner.nextLine();
                    int money1 = Integer.parseInt(moneyStr);
                    earnings += money1;
                    break;
                case 2:
                    System.out.println("Введите сумму рассхода:");
                    String cashFlow = scanner.nextLine();
                    int money2 = Integer.parseInt(cashFlow);
                    spendings += money2;
                    break;
                case 3:
                    if (taxEarningsMinusSpendings(earnings, spendings) > taxEarnings(earnings)) {
                        System.out.println("Мы советуем вам УСН доходы" + "\n" +
                                "Ваш налог составит: " + taxEarnings(earnings) + "\n" +
                                "Налог на другой системе: " + taxEarningsMinusSpendings(earnings, spendings) + "\n" +
                                "Экономия: " + (taxEarningsMinusSpendings(earnings, spendings) - taxEarnings(earnings)));
                    } else {
                        System.out.println("Мы советуем вам УСН доходы минус расходы" + "\n" +
                                "Ваш налог составит: " + taxEarningsMinusSpendings(earnings, spendings) + "\n" +
                                "Налог на другой системе: " + taxEarnings(earnings) + "\n" +
                                "Экономия: " + (taxEarnings(earnings) - taxEarningsMinusSpendings(earnings, spendings)));
                    }
                    break;
                default:
                    System.out.println("Такой операции нет");
            }
        }
    }

    public static int taxEarnings(int earnings) {
        int tax = (earnings) * 6 / 100;
        if (tax >= 0) {
            return tax;
        } else {
            return 0;
        }
    }

    public static int taxEarningsMinusSpendings(int earnings, int spendings) {
        int tax = (earnings - spendings) * 15 / 100;
        if (tax >= 0) {
            return tax;
        } else {
            return 0;
        }
    }
}