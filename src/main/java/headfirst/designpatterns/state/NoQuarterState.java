
package headfirst.designpatterns.state;

public class NoQuarterState implements State {
    GumballMachine machine;
    public NoQuarterState(GumballMachine m){ this.machine=m; }
    public void insertQuarter(){ System.out.println("Quarter inserted"); machine.setState(machine.getHasQuarterState()); }
    public void ejectQuarter(){ System.out.println("No quarter to eject"); }
    public void turnCrank(){ System.out.println("Turned but no quarter"); }
    public void dispense(){ System.out.println("Insert quarter first"); }
}
