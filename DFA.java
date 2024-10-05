import java.util.*; 

public class DFA {

    private int noOfStates;

    public String[] alphabet;
    public State[] states;
    public State currentState;

    public DFA(int noOfStates, String[] alphabet) {
        this.noOfStates = noOfStates;
        this.alphabet = alphabet;
        this.states = createStates();
    }

    public void setup() {
        printTransitionTable();
    }

    public String returnInfo() {
        return "Number of States >> " + this.noOfStates + "\nAlphabet >> " + Arrays.toString(this.alphabet) + "\nStates >> " + Arrays.toString(this.states);
    }

    private State[] createStates(){
        State[] s = new State[this.noOfStates];
        for( int i=0; i<noOfStates; i++ ) {
            s[i] = new State("q"+i);
            s[i].createTransition(this.alphabet);
        }

        return s;
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
