import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumberSecondary;
import components.stack.Stack;
import components.stack.Stack1L;

/**
 * {@code NaturalNumber} represented as a {@code String} with implementations of
 * primary methods.
 *
 * @convention <pre>
 * [all characters of $this.rep are '0' through '9']  and
 * [$this.rep does not start with '0']
 * </pre>
 * @correspondence <pre>
 * this = [if $this.rep = "" then 0
 *         else the decimal number whose ordinary depiction is $this.rep]
 * </pre>
 *
 * @author Aaron Heishman, Sam Espanioly
 *
 */
public class NaturalNumber3 extends NaturalNumberSecondary {

    /*
     * Private members --------------------------------------------------------
     */

    /**
     * Representation of {@code this}.
     */
    private String rep;

    /**
     * Stack representation of {@code this}.
     */
    private Stack<Integer> digits;

    /**
     * Creator of initial representation.
     */
    private void createNewRep() {
        this.rep = "0";
        this.digits = new Stack1L<>();
    }

    /*
     * Constructors -----------------------------------------------------------
     */

    /**
     * No-argument constructor.
     */
    public NaturalNumber3() {
        this.createNewRep();
    }

    /**
     * Constructor from {@code int}.
     *
     * @param i
     *            {@code int} to initialize from
     */
    public NaturalNumber3(int i) {
        assert i >= 0 : "Violation of: i >= 0";
        this.createNewRep();
        // Turn entry to a string
        this.rep = Integer.toString(i);
        // loop to push integers inside the stack digits
        for (int j = 0; j < this.rep.length(); j++) {
            int x = Character.getNumericValue(this.rep.charAt(j));
            this.digits.push(x);
        }
    }

    /**
     * Constructor from {@code String}.
     *
     * @param s
     *            {@code String} to initialize from
     */
    public NaturalNumber3(String s) {
        assert s != null : "Violation of: s is not null";
        assert s.matches("0|[1-9]\\d*") : ""
                + "Violation of: there exists n: NATURAL (s = TO_STRING(n))";
        this.createNewRep();
        this.rep = s;
        for (int j = 0; j < this.rep.length(); j++) {
            int x = Character.getNumericValue(this.rep.charAt(j));
            this.digits.push(x);
        }
    }

    /**
     * Constructor from {@code NaturalNumber}.
     *
     * @param n
     *            {@code NaturalNumber} to initialize from
     */
    public NaturalNumber3(NaturalNumber n) {
        assert n != null : "Violation of: n is not null";
        this.createNewRep();
        // Turn entry to a string
        this.rep = n.toString();
        // loop to push integers inside the stack digits
        for (int j = 0; j < this.rep.length(); j++) {
            int x = Character.getNumericValue(this.rep.charAt(j));
            this.digits.push(x);
        }
    }

    /*
     * Standard methods -------------------------------------------------------
     */

    @Override
    public final NaturalNumber newInstance() {
        try {
            return this.getClass().getConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new AssertionError(
                    "Cannot construct object of type " + this.getClass());
        }
    }

    @Override
    public final void clear() {
        this.createNewRep();
    }

    @Override
    public final void transferFrom(NaturalNumber source) {
        assert source != null : "Violation of: source is not null";
        assert source != this : "Violation of: source is not this";
        assert source instanceof NaturalNumber3 : ""
                + "Violation of: source is of dynamic type NaturalNumberExample";
        /*
         * This cast cannot fail since the assert above would have stopped
         * execution in that case.
         */
        NaturalNumber3 localSource = (NaturalNumber3) source;
        this.rep = localSource.rep;
        localSource.createNewRep();
    }

    /*
     * Kernel methods ---------------------------------------------------------
     */

    @Override
    public final void multiplyBy10(int k) {
        assert 0 <= k : "Violation of: 0 <= k";
        assert k < RADIX : "Violation of: k < 10";
        if (this.rep.equals("0")) {
            /*
             * Push k onto this.digits and replace this.rep with k
             */
            this.digits.push(k);
            this.rep = Integer.toString(k);
        } else {
            /*
             * Push k onto this.digits and add k to the end of this.digits
             */
            this.digits.push(k);
            this.rep += k;
        }
    }

    @Override
    public final int divideBy10() {
        int r = 0;
        /*
         * Checks if this.digits is not empty and pops the top value off and
         * removes the value at the end of the string.
         */
        if (this.digits.length() > 0) {
            r = this.digits.pop();
            this.rep = this.rep.substring(0, this.rep.length() - 1);
            /*
             * Check if this.rep is an empty string. Updates it to have it
             * contain "0" if this.rep is empty.
             */
            if (this.rep.length() == 0) {
                this.rep = "0";
            }
        }
        return r;
    }

    @Override
    public final boolean isZero() {
        return this.rep.equals("0");
    }

}
