package com.lisandro.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.lisandro.app.classes.recursion.Cells;
import com.lisandro.app.classes.recursion.GroupSumClump;
import com.lisandro.app.classes.recursion.Grouping;

// Tests for GroupSumClump and Grouping classes
public class GroupSumTest {
    int[] test;

    @Before
    public void setup() {
        test = new int[]{1,1,2,3,3,2,4,5,4,4};
    }

    @Test
    public void groupingShouldReturnCorrectCellList() {
        List<Cells> result = Grouping.groupArr(test);
        final String expected = "[(Sum: 2, Nums: [1, 1]), (Sum: 2, Nums: [2]), (Sum: 6, Nums: [3, 3]), (Sum: 2, Nums: [2]), (Sum: 4, Nums: [4]), (Sum: 5, Nums: [5]), (Sum: 8, Nums: [4, 4])]";
        assertEquals(expected, result.toString());
    }

    @Test
    public void sumCheckShouldReturnProperly() {
        GroupSumClump gsc1 = new GroupSumClump(test, 20);
        assertTrue(gsc1.startSumCheck());
    }
}
