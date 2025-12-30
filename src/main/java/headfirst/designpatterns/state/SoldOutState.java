
package headfirst.designpatterns.state;

public class SoldOutState implements State {
    GumballMachine machine;
    public SoldOutState(GumballMachine m){ this.machine=m; }
    public void insertQuarter(){ System.out.println("Sold out"); }
    public void ejectQuarter(){ System.out.println("No quarter"); }
    public void turnCrank(){ System.out.println("Sold out"); }
    public void dispense(){ System.out.println("No gumball"); }
}
