package dom;
interface IPaymentStrategy {
    void Pay(double dengi);
}
class Credit implements IPaymentStrategy {
    private String carta;

    public Credit(String carta) {
        this.carta = carta;
    }

    public void Pay(double amount) {
        System.out.println("Nomer karty:" + carta+"\nDengi: "  + amount);
    }
}

class PaymentContext {
    private IPaymentStrategy paymentStrategy;

    public void setPaymentStrategy(IPaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void executePayment(double dengi) {
        if (paymentStrategy == null) {
            System.out.println("Стратегия оплаты не выбрана");
        } else {
            paymentStrategy.Pay(dengi);
        }
    }
}
class Client {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        context.setPaymentStrategy(new Credit("5615496"));
        context.executePayment(100.0);
    }
}
interface IObserver{
    void info();
}
interface ISubject{
    void message();
}
class CurrencyExchange implements ISubject{
    int curse;

    public CurrencyExchange(int curse) {
        this.curse = curse;
    }

    @Override
    public void message() {
        System.out.println("new message");
    }
}
class Client_cuse implements IObserver{
    int nomer;

    public Client_cuse(int nomer) {
        this.nomer = nomer;
    }

    @Override
    public void info() {
        System.out.println("nomer: "+ nomer);
    }
}
class CurrencyExchangeClient {
    public static void main(String[] args) {
        CurrencyExchange exchange = new CurrencyExchange(450);
        exchange.message();
        IObserver consoleObserver = new Client_cuse(874746);
        consoleObserver.info();
    }
}
