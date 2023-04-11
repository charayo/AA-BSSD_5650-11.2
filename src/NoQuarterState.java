public class NoQuarterState implements State{
    GumballMachine gumballMachine;

    public NoQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("Quarter inserted");
        gumballMachine.setState(gumballMachine.getHasQuarterState());
    }

    @Override
    public void ejectQuarter() {
        System.out.println("There is no quarter to eject");
    }

    @Override
    public void turnCrank() {
        System.out.println("Please insert a quarter first");
    }

    @Override
    public void dispense() {
        System.out.println("No dispensing for no quarter");
    }

    @Override
    public void win() {
        System.out.println("No quarter no winning");
    }
}
