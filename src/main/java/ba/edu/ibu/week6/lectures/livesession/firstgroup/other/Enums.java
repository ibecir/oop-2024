package ba.edu.ibu.week6.lectures.livesession.firstgroup.other;

class TicketPrices {
    public static final double SINGLE_TICKET_ADULT = 2.50;
    public static final double TRAM_TICKET_ADULT = 2.50;

    public static double getSingleTicketAdult() {
        return TicketPrices.SINGLE_TICKET_ADULT;
    }
}

enum Tickets {
    SINGLE_TICKET_ADULT(2.5), TRAM_TICKET_ADULT(3.3);

    Tickets(double value) {}
}

public class Enums {

    public static void main(String[] args) {

    }
}
