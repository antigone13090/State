
package headfirst.designpatterns.state;

public class HasQuarterState implements State {
    GumballMachine machine;
    public HasQuarterState(GumballMachine m){ this.machine=m; }
    public void insertQuarter(){ System.out.println("Already have a quarter"); }
    public void ejectQuarter(){ System.out.println("Quarter returned"); machine.setState(machine.getNoQuarterState()); }
    public void turnCrank(){ System.out.println("You turned..."); machine.setState(machine.getSoldState()); }
    public void dispense(){ System.out.println("No gumball dispensed"); }
}
