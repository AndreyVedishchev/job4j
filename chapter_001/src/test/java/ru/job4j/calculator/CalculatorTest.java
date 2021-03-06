package ru.job4j.calculator;


import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Andrey Vedishchev (avedishchev@list.ru)
 * @version $Id$
 * @since 0.1
 */

public class CalculatorTest  {

    /**
     * Test add.
     */
    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        double result = calc.add(1D, 1D);
        double expected = 2D;
        assertThat(result, is(expected));
    }

    /**
     * Test subtract.
     */
    @Test
    public void whenSubstract5Minus2Then3() {
        Calculator calc = new Calculator();
        double result = calc.subtract(5D, 2D);
        double expected = 3D;
        assertThat(result, is(expected));
    }

    /**
     * Test div.
     */
    @Test
    public void whenDiv2On2Then1() {
        Calculator calc = new Calculator();
        double result = calc.div(2D, 2D);
        double expected = 1D;
        assertThat(result, is(expected));
    }

    /**
     * Test multiple.
     */
    @Test
    public void whenMultiple5On2Then10() {
        Calculator calc = new Calculator();
        double result = calc.multiple(5D, 2D);
        double expected = 10D;
        assertThat(result, is(expected));
    }
}