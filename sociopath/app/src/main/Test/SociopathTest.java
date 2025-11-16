package app.src.main.Test;
import app.src.main.java.Sociopath;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class SociopathTest {
    private Sociopath sociopath = new Sociopath();

    /**
     * Test 1: Simple case with 2 people
     * Person 1 likes person 2, person 2 likes no one
     * Expected: 2 is the sociopath
     */
    @Test
    public void testTwoPersonSociopath() {
        int groupSize = 2;
        List<int[]> likeList = new ArrayList<>();
        likeList.add(new int[]{1, 2});

        int result = sociopath.findTheSociopath(groupSize, likeList);
        assertEquals("Person 2 should be the sociopath", 2, result);
    }

    /**
     * Test 2: Incomplete information case
     * Person 1 likes person 2, but we don't know about person 3
     * Expected: -1 (cannot identify sociopath)
     */
    @Test
    public void testIncompleteInformation() {
        int groupSize = 3;
        List<int[]> likeList = new ArrayList<>();
        likeList.add(new int[]{1, 2});

        int result = sociopath.findTheSociopath(groupSize, likeList);
        assertEquals("Should return -1 due to incomplete information", -1, result);
    }

    /**
     * Test 3: Three people all liking person 3
     * Expected: 3 is the sociopath
     */
    @Test
    public void testThreePersonSociopath() {
        int groupSize = 3;
        List<int[]> likeList = new ArrayList<>();
        likeList.add(new int[]{1, 2});
        likeList.add(new int[]{1, 3});
        likeList.add(new int[]{2, 3});

        int result = sociopath.findTheSociopath(groupSize, likeList);
        assertEquals("Person 3 should be the sociopath", 3, result);
    }

    /**
     * Test 4: Each person likes someone else (no sociopath)
     * Expected: -1 (no sociopath)
     */
    @Test
    public void testNoSociopath() {
        int groupSize = 3;
        List<int[]> likeList = new ArrayList<>();
        likeList.add(new int[]{1, 3});
        likeList.add(new int[]{2, 3});
        likeList.add(new int[]{3, 1});  // Person 3 likes someone

        int result = sociopath.findTheSociopath(groupSize, likeList);
        assertEquals("Should return -1, person 3 likes person 1", -1, result);
    }

    /**
     * Test 5: Invalid group size (0)
     * Expected: -1 (invalid group size)
     */
    @Test
    public void testInvalidGroupSizeZero() {
        int groupSize = 0;
        List<int[]> likeList = new ArrayList<>();
        likeList.add(new int[]{1, 2});

        int result = sociopath.findTheSociopath(groupSize, likeList);
        assertEquals("Should return -1 for invalid group size", -1, result);
    }

    /**
     * Test 6: Invalid person (person 0 doesn't exist)
     * Expected: -1 (invalid person)
     */
    @Test
    public void testInvalidPerson() {
        int groupSize = 3;
        List<int[]> likeList = new ArrayList<>();
        likeList.add(new int[]{1, 0});  // Person 0 is invalid

        int result = sociopath.findTheSociopath(groupSize, likeList);
        assertEquals("Should return -1 for invalid person 0", -1, result);
    }

    /**
     * Test 7: Empty likes list (no information)
     * Expected: -1 (incomplete information)
     */
    @Test
    public void testEmptyLikesList() {
        int groupSize = 3;
        List<int[]> likeList = new ArrayList<>();

        int result = sociopath.findTheSociopath(groupSize, likeList);
        assertEquals("Should return -1 with no information", -1, result);
    }

    /**
     * Test 8: Sociopath in larger group (5 people)
     * Everyone except person 5 likes person 5
     * Expected: 5
     */
    @Test
    public void testLargerGroupSociopath() {
        int groupSize = 5;
        List<int[]> likeList = new ArrayList<>();
        likeList.add(new int[]{1, 5});
        likeList.add(new int[]{2, 5});
        likeList.add(new int[]{3, 5});
        likeList.add(new int[]{4, 5});
        // Person 5 likes no one

        int result = sociopath.findTheSociopath(groupSize, likeList);
        assertEquals("Person 5 should be the sociopath", 5, result);
    }

    /**
     * Test 9: Negative group size
     * Expected: -1 (invalid group size)
     */
    @Test
    public void testNegativeGroupSize() {
        int groupSize = -5;
        List<int[]> likeList = new ArrayList<>();
        likeList.add(new int[]{1, 2});

        int result = sociopath.findTheSociopath(groupSize, likeList);
        assertEquals("Should return -1 for negative group size", -1, result);
    }

    /**
     * Test 10: Person likes themselves (edge case)
     * Expected: -1 (sociopath likes no one)
     */
    @Test
    public void testPersonLikesSelf() {
        int groupSize = 2;
        List<int[]> likeList = new ArrayList<>();
        likeList.add(new int[]{1, 2});
        likeList.add(new int[]{2, 2});  // Person 2 likes themselves

        int result = sociopath.findTheSociopath(groupSize, likeList);
        assertEquals("Should return -1, person 2 likes themselves", -1, result);
    }
}
