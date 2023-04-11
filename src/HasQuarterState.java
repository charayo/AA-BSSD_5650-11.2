public class HasQuarterState implements State{
    GumballMachine gumballMachine;

    public HasQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("You cannot insert another quarter");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Quarter returned");
        gumballMachine.setState(gumballMachine.getNoQuarterState());
    }

    @Override
    public void turnCrank() {
        System.out.println("Crank turned");
        gumballMachine.setState(gumballMachine.getSoldState());
    }

    @Override
    public void dispense() {
        System.out.println("Cannot dispense without crank");
    }

    @Override
    public void win() {
        double randomNum = Math.random();
        int randomInt = (int) (randomNum * 2);
        if(randomInt == 1){
            System.out.println("You won two gumballs!!!");
            gumballMachine.setState(gumballMachine.getWinnerState());
        }else{
            System.out.println("You got one gum, better luck next time");
            gumballMachine.setState(gumballMachine.getSoldState());
        }
    }

}
