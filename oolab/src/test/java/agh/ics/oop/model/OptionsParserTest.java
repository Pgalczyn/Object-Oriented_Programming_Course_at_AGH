package agh.ics.oop.model;

import agh.ics.oop.OptionsParser;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static agh.ics.oop.model.MoveDirection.BACKWARD;
import static agh.ics.oop.model.MoveDirection.FORWARD;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OptionsParserTest {

    @Test
    public void testParseOptions() {


        List<MoveDirection> expectedMoves = new ArrayList<>();
        expectedMoves.add(FORWARD);
        expectedMoves.add(FORWARD);
        expectedMoves.add(BACKWARD);
        expectedMoves.add(BACKWARD);

        String[] args = {"f", "f", "b","b"};

        List<MoveDirection> parsedMoves = OptionsParser.parse(args);
        
        assertEquals(expectedMoves, parsedMoves);

    }


}
