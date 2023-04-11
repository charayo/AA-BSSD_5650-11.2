public class GumballMachine {
    State soldOutState;
    State noQuarterState;
    State hasQuarterState;
    State soldState;
    State state = soldOutState;
    State winnerState;
    int count = 0;
    public GumballMachine(int count){
        this.count = count;
        soldOutState = new SoldOutState(this);
        soldState = new SoldState(this);
        hasQuarterState = new HasQuarterState(this);
        noQuarterState = new NoQuarterState(this);
        winnerState = new WinnerState(this);
        if(count > 0){
            state = noQuarterState;
        }
    }

    public void setState(State state) {
        this.state = state;
    }
    public void insertQuarter(){state.insertQuarter();}
    public void ejectQuarter(){state.ejectQuarter();}
    public void turnCrank(){
        state.turnCrank();
        state.dispense();

    }
    public void win(){
        state.win();
        state.dispense();
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }
    public State getSoldOutState() {
        return soldOutState;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getSoldState() {
        return soldState;
    }

    public State getWinnerState(){
        return winnerState;
    }




}
