
package headfirst.designpatterns.state;

public class SoldState implements State {
    GumballMachine machine;
    public SoldState(GumballMachine m){ this.machine=m; }
    public void insertQuarter(){ System.out.println("Please wait"); }
    public void ejectQuarter(){ System.out.println("Already turned"); }
    public void turnCrank(){ System.out.println("Turning twice doesn't help"); }
    public void dispense(){
        machine.releaseBall();
        if(machine.getCount()>0) machine.setState(machine.getNoQuarterState());
        else machine.setState(machine.getSoldOutState());
    }
}
