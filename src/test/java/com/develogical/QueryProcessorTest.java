package com.develogical;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class QueryProcessorTest {

    QueryProcessor queryProcessor = new QueryProcessor();

    @Test
    public void returnsEmptyStringIfCannotProcessQuery() throws Exception {
        assertThat(queryProcessor.process("test"), is(""));
    }


    @Test public void plus() throws Exception {
        assertThat(queryProcessor.process("what is 2 plus 3"), is("5"));
    }
    @Test public void mult() throws Exception {
        assertThat(queryProcessor.process("what is 2 multiplied by 3"), is("6"));
    }

    @Test public void largest() throws Exception {
        assertThat(queryProcessor.process("which of the following numbers is the largest: 153, 63, 47, 846"), is("846"));
    }

//    @Test public void cubeThing() throws Exception {
//        assertThat(queryProcessor.process("which of the following numbers is both a square and a cube: 729, 695, 576, 1764"), is("846"));
//    }

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
