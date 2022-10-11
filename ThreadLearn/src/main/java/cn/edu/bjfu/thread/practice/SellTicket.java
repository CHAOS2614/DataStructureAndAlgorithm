package cn.edu.bjfu.thread.practice;

/**
 * @author chaos
 * @date 2022-10-08 13:58
 * <p>
 * 卖票
 */
public class SellTicket {

    public static void main(String[] args) {
        Ticket ticket = new Ticket(100);
        Window windowA = new Window(ticket, "A");
        Window windowB = new Window(ticket, "B");
        Window windowC = new Window(ticket, "C");

        new Thread(windowA).start();
        new Thread(windowB).start();
        new Thread(windowC).start();
    }

}


class Window implements Runnable {

    private Ticket ticket;
    private String name;

    public Window(Ticket ticket, String name) {
        this.ticket = ticket;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (ticket) {
                if (ticket.getCount() > 0) {
                    System.out.println(name + " sell :" + ticket.decr());
                } else {
                    System.out.println("卖光了");
                    break;
                }
            }
        }
    }
}

class Ticket {
    private int count;

    public Ticket(int count) {
        this.count = Math.max(count, 0);
    }

    public int decr() {
        return count--;
    }

    public int getCount() {
        return count;
    }
}
