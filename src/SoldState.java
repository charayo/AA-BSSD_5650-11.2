public class SoldState implements State{
    GumballMachine gumballMachine;

    public SoldState(GumballMachine gumballMachine) {
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
        if(gumballMachine.count > 0){
            gumballMachine.setCount(gumballMachine.count-1);
            System.out.println("Dispensing gumball");
            gumballMachine.setState(gumballMachine.getNoQuarterState());
        }else{
            System.out.println("Oops, no gumballs");
            gumballMachine.setState(gumballMachine.getSoldOutState());
            gumballMachine.setState(gumballMachine.getHasQuarterState());
        }

    }

    @Override
    public void win() {
        System.out.println("You have to start again");
    }
}
