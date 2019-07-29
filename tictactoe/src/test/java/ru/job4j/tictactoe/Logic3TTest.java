package ru.job4j.tictactoe;

import org.junit.Test;

import java.util.function.Predicate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class Logic3TTest {

    @Test
    public void whenHasXWinner() {
        Predicate<Figure3T> pr = Figure3T::hasMarkX;
        Figure3T[][] table = {
                {new Figure3T(true, false), new Figure3T(), new Figure3T()},
                {new Figure3T(), new Figure3T(true, false), new Figure3T()},
                {new Figure3T(), new Figure3T(), new Figure3T(true, false)},
        };
        Logic3T login = new Logic3T(table);
        //assertThat(login.isWinnerX(), is(true));
        assertThat(login.whoIsWinner(pr), is(true));
    }


    @Test
    public void whenNotFill() {
        Predicate<Figure3T> pr = Figure3T::hasMarkX;
        Figure3T[][] table = {
                {new Figure3T(true, false), new Figure3T(), new Figure3T()},
                {new Figure3T(), new Figure3T(), new Figure3T()},
                {new Figure3T(), new Figure3T(), new Figure3T()},
        };
        Logic3T login = new Logic3T(table);
        //assertThat(login.isWinnerX(), is(false));
        //assertThat(login.isWinnerX(), is(false));
        assertThat(login.whoIsWinner(pr), is(false));
    }

    @Test
    public void whenHasXHorizontalWinner() {
        Predicate<Figure3T> pr = Figure3T::hasMarkX;
        Figure3T[][] table = {
                {new Figure3T(), new Figure3T(), new Figure3T()},
                {new Figure3T(true, false), new Figure3T(true, false), new Figure3T(true, false)},
                {new Figure3T(), new Figure3T(), new Figure3T()},
        };
        Logic3T login = new Logic3T(table);
        //assertThat(login.isWinnerX(), is(true));
        assertThat(login.whoIsWinner(pr), is(true));
    }

    @Test
    public void whenHasXVerticalWinner() {
        Predicate<Figure3T> pr = Figure3T::hasMarkX;
        Figure3T[][] table = {
                {new Figure3T(), new Figure3T(true, false), new Figure3T()},
                {new Figure3T(), new Figure3T(true, false), new Figure3T()},
                {new Figure3T(), new Figure3T(true, false), new Figure3T()},
        };
        Logic3T login = new Logic3T(table);
        //assertThat(login.isWinnerX(), is(true));
        assertThat(login.whoIsWinner(pr), is(true));
    }

    @Test
    public void whenHasXBackDiagonalWinner() {
        Predicate<Figure3T> pr = Figure3T::hasMarkX;
        Figure3T[][] table = {
                {new Figure3T(), new Figure3T(), new Figure3T(true, false)},
                {new Figure3T(), new Figure3T(true, false), new Figure3T()},
                {new Figure3T(true, false), new Figure3T(), new Figure3T()},
        };
        Logic3T login = new Logic3T(table);
        //assertThat(login.isWinnerX(), is(true));
        assertThat(login.whoIsWinner(pr), is(true));
    }

    @Test
    public void whenHasOWinner() {
        Predicate<Figure3T> pr = Figure3T::hasMarkO;
        Figure3T[][] table = {
                {new Figure3T(false, true), new Figure3T(), new Figure3T()},
                {new Figure3T(false, true), new Figure3T(), new Figure3T()},
                {new Figure3T(false, true), new Figure3T(), new Figure3T()},
        };
        Logic3T login = new Logic3T(table);
        //assertThat(login.isWinnerO(), is(true));
        assertThat(login.whoIsWinner(pr), is(true));
    }

    @Test
    public void whenHasGas() {
        Figure3T[][] table = {
                {new Figure3T(true, false), new Figure3T(), new Figure3T()},
                {new Figure3T(), new Figure3T(true, false), new Figure3T()},
                {new Figure3T(), new Figure3T(), new Figure3T(true, false)},
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.hasGap(), is(true));
    }
}