import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierTest {

//implement tests to test Sudokuverifier with boundary values.  Use templates from Task 1 to derive and document test cases.
	
// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891
String c = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
String i = "123456789912345678891234567789123456678912345567891234456789123345678912234567891";

//Invalid Sudoku strings for equivalence classes and boundary values
String invalidRowDuplicate = "417369825632158947958724316825437169791586432346912758289643571573291684164875164"; // Duplicate in the last row
String invalidColumnDuplicate = "417369825632158947958724316825437169791586432346912758289643571573291684464875293"; // Duplicate in the last column
String invalidSubgridDuplicate = "417369825632158947958724316825437169791586432346912758289643571573291664164875293"; // Duplicate in a subgrid
String tooShortGrid = "41736982563215894795872431682543716979158643234691275828964357157329168416487529"; // 80 characters
String tooLongGrid = "4173698256321589479587243168254371697915864323469127582896435715732916841648752931"; // 82 characters
String outOfRangeValue = "417369825632158947958724316825437169791586432346912758289643571573291684064875293"; // Contains 0
String unicodeCharacter = "41736982563215894795872431682543716979158643234691275𝟏289643571573291684164875293";
SudokuVerifier v = new SudokuVerifier();

	@Test
	public void testCorrectString() {
		int a = v.verify(c);
		assertEquals("correct string", a, 0);
	}

	@Test
	public void testIncorrectString() {
		int a = v.verify(i);
		assertEquals("incorrect string", a, -2);
		
	}
	
	@Test
    public void testColumnDuplicate() {
        int result = v.verify(invalidColumnDuplicate);
        assertEquals("Sudoku with column duplicate should return -2", -2, result);
    }

    @Test
    public void testSubgridDuplicate() {
        int result = v.verify(invalidSubgridDuplicate);
        assertEquals("Sudoku with subgrid duplicate should return -2", -2, result);
    }


    @Test
    public void testTooShortGrid() {
        int result = v.verify(tooShortGrid);
        assertEquals("Sudoku with too short grid should return -1", -1, result);
    }
//
    @Test
    public void testTooLongGrid() {
        int result = v.verify(tooLongGrid);
        assertEquals("Sudoku with too long grid should return -1", -1, result);
    }

    @Test
    public void testOutOfRangeValue() {
        int result = v.verify(outOfRangeValue);
        assertEquals("Sudoku with out-of-range value should return -1", -1, result);
    }
    
    @Test
    public void testUnicodeCharacter() {
        int result = v.verify(unicodeCharacter);
        assertEquals("Sudoku with a Unicode character should return -1", -1, result);
    }
	
	
}
