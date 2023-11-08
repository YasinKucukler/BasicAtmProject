import java.util.Objects;
import java.util.Scanner;
import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        String userName ,password,checkPassword, key;
        boolean check;
        int balance = 100000;
        while (true) {
            System.out.println("Kullanıcı adı giriniz:");
            userName = input.nextLine();
            System.out.println("Şifre giriniz:");
            password = input.nextLine();
            System.out.println("Lütfen şifrenizi tekrar giriniz:");
            checkPassword = input.nextLine();
            check = !Objects.equals(password, checkPassword);
            if (!check)
            {
                System.out.println("Tebrikler sisteme kaydınız başarıyla tamamlanmıştır");
                break;
            }
            else
            {
                System.out.println("Giriş yaptığınız şifreler eşleşmiyor." +
                        "Lütfen tekrar deneyiniz!");
            }
        }
        int count = 3;
        boolean entered = false;
        System.out.println("Lütfen biraz bekleyiniz!");
        sleep(3000);

        while(true)
        {
            System.out.println(" ");
            System.out.println("Sayın " + userName);
            System.out.println("Lütfen şifrenizi giriniz:");
            key = input.nextLine();
            check = Objects.equals(key, password);
            if (check)
            {
                System.out.println("Giriş yapılıyor");
                entered = true;
                break;
            }
            else {
                count --;
                System.out.println("Şifrenizi yanlış girdiniz. " +
                        "Kalan deneme hakkınız: " + count);
                if (count == 0)
                {
                    System.out.println("Tüm deneme haklarınızı kullandınız! " +
                            "Lütfen bankanız ile iletişime geçiniz.");
                    break;
                }
            }
        }
        if (entered) {
            int operation;
            do {
                System.out.println("""
                        Lütfen yapcağınız işlemi seçiniz:\s
                        Para yatırma işleminiz için 1'i tuşlayınız.\s
                        Para çekme işleminiz için 2'yi tuşlayınız.
                        Bakiye sorgulama işlemi için 3 ü tuşlayınız.\s
                        Çıkış yapmak için 4'ü  tuşlayınız.""");
                operation = input.nextInt();
                balance = atmOperations(operation, balance);
            }while(operation != 4);
        }
    }
    private static int atmOperations(int n,int balance)
    {
        Scanner input = new Scanner(System.in);
        int price;
        switch (n){
            case 1:
                System.out.println("Lütfen yatıracağınız tutarı giriniz:");
                price = input.nextInt();
                System.out.println("Yatırılacak tutar: " + price);
                balance += price;
                break;
            case 2:
                System.out.println("Lütfen çekeceğiniz tutarı giriniz:");
                price = input.nextInt();
                if (price > balance)
                {
                    System.out.println("yetersiz bakiye");
                }
                else{
                    System.out.println(price +  " TL çekiliyor");
                    balance -= price;
                }
                break;
            case 3:
                System.out.println("Bakiyeniz: " + balance);
            case 4:
                System.out.println("Çıkış yapılıyor");
                break;
        }
        return balance;
    }
}