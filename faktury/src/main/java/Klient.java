public class Klient {   //klasa Klient, zawiera nazwe klienta; w przyszłości można dodać np NIP
    private String klient;

    Klient(String klient) {
        this.klient = klient;
    }

    @Override
    public String toString() {
        return klient;
    }

    public String getKlient() {
        return klient;
    }
}
