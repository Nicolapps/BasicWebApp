package com.develogical;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class QueryProcessorTest {

    QueryProcessor queryProcessor = new QueryProcessor();

    @Test public void minus() throws Exception {
        assertThat(queryProcessor.process("what is 2 minus 3"), is("-1"));
    }    @Test public void hiuasfdiuhasdfihuafds() throws Exception {
        assertThat(queryProcessor.process("what is 13 multiplied by 17 plus 10"), is("231"));
    }

        @Test
    public void returnsEmptyStringIfCannotProcessQuery() throws Exception {
        assertThat(queryProcessor.process("test"), is(""));
    }

    @Test public void theresa() throws Exception {
        assertThat(queryProcessor.process("which year was Theresa May first elected as the Prime Minister of Great Britain"), is("2016"));
    }


    @Test public void fib() throws Exception {
        assertThat(queryProcessor.process("what is the 12th number in the Fibonacci sequence"), is("144"));
    }
    @Test public void pow() throws Exception {
        assertThat(queryProcessor.process("what is 0 to the power of 16"), is("0"));
    }

@Test public void plus() throws Exception {
    assertThat(queryProcessor.process("what is 2 plus 3"), is("5"));
}
  @Test public void plusplus() throws Exception {
        assertThat(queryProcessor.process("what is 13 plus 1 plus 8"), is("22"));
    }
    @Test public void mult() throws Exception {
        assertThat(queryProcessor.process("what is 2 multiplied by 3"), is("6"));
    }
    @Test public void eifel() throws Exception {
        assertThat(queryProcessor.process("which city is the Eiffel tower in"), is("Paris"));
    }
    @Test public void primes() throws Exception {
        assertThat(queryProcessor.process("which of the following numbers are primes: 41, 283, 679, 617"), is("41, 283, 617"));
    }

    @Test public void banana() throws Exception {
        assertThat(queryProcessor.process("what colour is a banana"), is("Yellow"));
    }

    @Test public void largest() throws Exception {
        assertThat(queryProcessor.process("which of the following numbers is the largest: 153, 63, 47, 846"), is("846"));
    }

    @Test public void cubeThing() throws Exception {
        assertThat(queryProcessor.process("which of the following numbers is both a square and a cube: 729, 695, 576, 1764"), is("729"));
    }

    @Test
    public void knowsAboutShakespeare() throws Exception {
        assertThat(queryProcessor.process("Shakespeare"), containsString("playwright"));
    }

    @Test
    public void isNotCaseSensitive() throws Exception {
        assertThat(queryProcessor.process("shakespeare"), containsString("playwright"));
    }


    @Test
    public void knowsLorem() throws Exception {
        assertThat(queryProcessor.process("lorem ipsum"), containsString("dolor sit amet"));
    }

}
