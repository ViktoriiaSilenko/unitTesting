package com.study.integerDivision;

import org.junit.Test;
import static org.junit.Assert.*;

public class DivisionTest {

    @Test
    public void testComposeDivisionOutput() {
        String actual = new Division(1118, 2).composeDivisionOutput();
        String expected = " 1118 |2" + "\n" +
                "-     -----" + "\n" +
                " 10   |559" + "\n" +
                " __" + "\n" +
                "  11" + "\n" +
                " -" + "\n" +
                "  10" + "\n" +
                "  __" + "\n" +
                "   18" + "\n" +
                "  -"+ "\n" +
                "   18" + "\n" +
                "   __" + "\n" +
                "    0" + "\n";
        assertEquals(expected, actual);
    }

    @Test(expected=ArithmeticException.class)
    public void testComposeDivisionOutput_DivideByZero() {
        new Division(1118, 0).composeDivisionOutput();
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void testComposeDivisionOutput_DividentIsBMax() {
        new Division(Integer.MAX_VALUE + 2, 2).composeDivisionOutput();
    }

    @Test
    public void testComposeDivisionOutput_DividerIsNegative() {
        new Division(1118, -3).composeDivisionOutput().equals("");
    }


    @Test
    public void testComposeDivisionOutput_PeriodDivision() {
        String [] actual = new Division(1118, 9).composeDivisionOutput().split("\n");
        assertEquals(" 9    |124.(2)", actual[2]);
    }

    @Test
    public void testComposeDivisionOutput_NotIntegerDivision() {
        String actual = new Division(11, 5).composeDivisionOutput();
        String expected = " 11 |5" + "\n" +
                "-   -----" + "\n" +
                " 10 |2.2" + "\n" +
                " __" + "\n" +
                "  10" + "\n" +
                " -" + "\n" +
                "  10" + "\n" +
                "  __" + "\n" +
                "   0" + "\n";

        assertEquals(expected, actual);
    }

}
