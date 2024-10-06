import java.util.HashMap;
import java.util.Map;

public class State {

    private String nameOfState;
    private Map<String, State> transition = new HashMap<>(); // alphabet input, name of state

    public State(String name) {
        this.nameOfState = name;
    }

    public String toString() {
        return this.nameOfState;
    }

    public void createTransition(String c, State s) { // the path c to the next state s
        this.transition.put(c, s);
    }

    public State getTransition(String a) {
        return this.transition.get(a);
    }

    public State[] getTransitions(String[] alphabet) {
        State[] transitions = new State[alphabet.length];
        for( int i=0; i<alphabet.length; i++ ) {
            transitions[i] = this.transition.get(alphabet[i]);
        }

        return transitions;
    }
}
