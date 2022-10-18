package Exercise8;

public class Test {

    public static void main(String[] args) {
        TicketCounter ticketCounter = new TicketCounter();
        TicketBookingThread t1 = new TicketBookingThread(ticketCounter,"John",2);
        TicketBookingThread t2 = new TicketBookingThread(ticketCounter,"Martin",2);
        
        t1.start();
        t2.start();
    }
}
class TicketBookingThread extends Thread {

	private TicketCounter ticketCounter;
	private String passengerName;
	private int noOfSeatsToBook;

	public TicketBookingThread(TicketCounter ticketCounter,String passengerName, int noOfSeatsToBook) {
		this.ticketCounter = ticketCounter;
		this.passengerName = passengerName;
		this.noOfSeatsToBook = noOfSeatsToBook;
	}
	
        @Override
	public void run() {
		ticketCounter.bookTicket(passengerName, noOfSeatsToBook);
	}
}
class TicketCounter 
{
    private int availableSeats = 10;

	public synchronized void bookTicket(String pname, int numberOfSeats) {
		if ((availableSeats >= numberOfSeats) && (numberOfSeats > 0)) {
			System.out.println("Hi," + pname + " : " + numberOfSeats+ " Seats booked Successfully..");
			availableSeats = availableSeats- numberOfSeats;
		} else
			System.out.println("Hi," + pname + " : Seats Not Available");
	}
}
