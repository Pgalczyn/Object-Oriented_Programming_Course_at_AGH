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


        MoveDirection[] expectedMoves = {FORWARD, FORWARD,BACKWARD, BACKWARD};

        String[] args = {"f", "f", "b","b"};

        MoveDirection[] parsedMoves = OptionsParser.parse(args);
        
        assertArrayEquals(expectedMoves, parsedMoves);

    }


}
