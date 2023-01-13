import java.net.URI;
import java.util.Scanner;
import java.io.IOException;
import static java.lang.Math.pow;

public class CalculateDeposit {
    double CalculateComplexPercentFunction(double a, int d) {
        double pay = a * pow((1 + 0.06 / 12), 12 * d);
        return round(pay);
    }

    double calculateSimplePercentFunction(double amount, int depositPeriod) {
        return round(amount + amount * 0.06 * depositPeriod);
    }

    double round(double value) {
        double scale = pow(10, 2);
        return Math.round(value * scale) / scale;
    }

    void depositAmount() {
        int period;
        int action;

        Scanner scan = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scan.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scan.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scan.nextInt();
        double sumDepositAmount = 0;
        if (action == 1){
            sumDepositAmount = calculateSimplePercentFunction(amount, period);
        }else if (action == 2) {
            sumDepositAmount = CalculateComplexPercentFunction(amount, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + sumDepositAmount);
    }

    public static void main(String[] args) {
        new CalculateDeposit().depositAmount();
    }


}