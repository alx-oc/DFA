public class main{
    public static void main(String[] args) {
        int s = 4;
        String[] n = new String[] {"a", "b", "c"};

        DFA test = new DFA(s, n);
        System.out.println(test.returnInfo());

        test.setup();
        test.runInputTape("ccabcac");

        System.out.println(test.getCurrentState());
    }
}