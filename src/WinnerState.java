public class WinnerState implements State{
    GumballMachine gumballMachine;

    public WinnerState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("Please wait. Already dispensing a gumball");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Sorry, you already turned the crank");
    }

    @Override
    public void turnCrank() {
        System.out.println("Turning twice nothing");
    }

    @Override
    public void dispense() {
        if(gumballMachine.count > 1){
            gumballMachine.setCount(gumballMachine.count-2);
            System.out.println("Dispensing two gumballs");
            gumballMachine.setState(gumballMachine.getSoldState());
            gumballMachine.setState(gumballMachine.getNoQuarterState());
        } else if (gumballMachine.count == 1) {
            gumballMachine.setCount(0);
            System.out.println("Dispensing one of two gumballs");
            System.out.println("Insufficient gumballs, hold on for refill");
            gumballMachine.setState(gumballMachine.getSoldOutState());
            gumballMachine.setState(gumballMachine.getHasQuarterState());
            gumballMachine.setCount(gumballMachine.count-1);
            System.out.println("Dispensing remaining gumball");

        } else{
            System.out.println("Oops, no gumballs");
            gumballMachine.setState(gumballMachine.getSoldOutState());
            gumballMachine.setState(gumballMachine.getHasQuarterState());
        }

    }

    @Override
    public void win() {

    }
}
