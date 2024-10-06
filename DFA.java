import java.util.*; 

public class DFA {

    private int noOfStates;
    private String[] alphabet;
    private State[] states;
    private State currentState;
    private State[] acceptanceStates;

    public DFA(int noOfStates, String[] alphabet) {
        this.noOfStates = noOfStates;
        this.alphabet = alphabet;
        this.states = createStates();
        this.currentState = this.states[0];
    }

    public void setup() {
        this.states = createStates();
        this.currentState = this.states[0];
        
        printTransitionTable();
        userInputTransitions();
        
        this.acceptanceStates = userInputAcceptanceStates();
    }

    public void runInputTape(String tape) {
        State nextState;
        for( int i=0; i<tape.length(); i++ ) {
            nextState = this.currentState.getTransition(tape.substring(i, i+1));
            if( nextState != null ) {
                this.currentState = nextState;
            } else {
                this.currentState = null;
                break;
            }
        }
    }

    public State getCurrentState() {
        return this.currentState;
    }

    public String returnInfo() {
        return "Number of States >> " + this.noOfStates + "\nAlphabet >> " + Arrays.toString(this.alphabet) + "\nStates >> " + Arrays.toString(this.states);
    }

    public boolean hasReachedAcceptState() {
        for( State s : this.acceptanceStates ) {
            if( s == this.currentState ) {
                return true;
            }
        }

        return false;
    }

    private State[] createStates() {
        State[] s = new State[this.noOfStates];
        for( int i=0; i<noOfStates; i++ ) {
            s[i] = new State("q"+i);
            // s[i].createTransition(this.alphabet);
        }

        return s;
    }

    private void userInputTransitions() {
        Scanner scan = new Scanner(System.in);

        for( State s : this.states ) {
            for( String c : this.alphabet ) {
                System.out.println("Which state should >" + c + "< go to (for state " + s + ")?");
                String nextState = scan.nextLine();
                s.createTransition(c, checkIfValidState(nextState));
            }
        }
    }

    private State checkIfValidState(String state) {
        for( State s : this.states ) {
            if( s.toString().equals(state) ) {
                return s;
            }
        }
        return null;
    }

    private State[] userInputAcceptanceStates() {
        Scanner scan = new Scanner(System.in);
        int nextIndex = 0;

        System.out.println("How many acceptance states are there");
        State[] acceptanceStates = new State[scan.nextInt()];
        scan.nextLine();

        System.out.println("Enter the acceptance states (seperated by a space)");
        String s = scan.nextLine();
        String[] acceptanceStatesInput = s.split(" ");

        for( String as : acceptanceStatesInput ) {
            acceptanceStates[nextIndex++] = checkIfValidState(as);
        }
        return acceptanceStates;
    }

    private String[][] printTransitionTable() {
        System.out.print("x  | ");
        for( String a : alphabet ) {
            System.out.print(a + " ");
        }
        System.out.println("");
        for(int i = 0; i<this.noOfStates; i++) {
            System.out.print("---");
        }
        System.out.println("");
        for( State state : this.states ) {
            System.out.print(state.toString() + " | ");
            for( String a : alphabet ) {
                System.out.print(state.getTransition(a) + " ");
            }
            System.out.println("");
        }

        return new String[1][1];
    }
}
