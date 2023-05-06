public interface StateMachine {
    public StateOfVendingMachine getState();
    public void setState(StateOfVendingMachine state);
}
