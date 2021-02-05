package test;

import main.Calculator;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class NewCalculatorTest {

    private Calculator calculator;

    @Before
    public void createCalculator(){ calculator = new Calculator(); }

    @Test
    public void testNewCalculatorHasAnAccumulatorOfZero(){
        assertEquals(BigDecimal.ZERO, calculator.getAccumulator());
    }

    @Test
    public void testSettingAccumulated(){
        BigDecimal value = new BigDecimal(23);
        calculator.setAccumulator(value);
        assertEquals(value, calculator.getAccumulator());
    }

}
