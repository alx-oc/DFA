import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class State {

    private String nameOfState;
    private Map<String, String> transition = new HashMap<>(); // alphabet input, name of state

    public State(String name) {
        this.nameOfState = name;
    }

    public String toString() {
        return this.nameOfState;
    }

    public void createTransition(String[] alphabet) {
        Scanner s = new Scanner(System.in);
        for( String a : alphabet ) {
            System.out.println("Which state should >" + a + "< go to (for state " + this.nameOfState + ")?");
            String nextState = s.nextLine();
            if ( nextState != "null" || nextState != "" ) {
                this.transition.put(a, nextState );
            } else {
                this.transition.put(a, null);
            }
        }
    }

    public String getTransition(String a) {
        return this.transition.get(a);
    }
    // each state has a map that points to a different state based on the input
}
