package util;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static util.StreamUtil.ActionType.*;

/**
 * Created by avetall  14.04.17.
 */
public class StreamUtilTest {


    private List<Map<String,Long>> ints;
    private Map<String,Long> emptyMap1;
    private Map<String,Long> emptyMap2;
    private Map<String,Long> emptyMap3;


    @Before
    public void setUp() throws Exception {
        ints = new ArrayList<>();
        emptyMap1 = new HashMap<>();
        emptyMap1.put("ID",1L);
        emptyMap2 = new HashMap<>();
        emptyMap2.put("ID",3L);
        emptyMap3 = new HashMap<>();
        emptyMap3.put("ID",1L);
        ints.add(emptyMap1);
        ints.add(emptyMap2);
        ints.add(emptyMap3);

    }

    @Test
    public void findDuplicatesPositive() throws Exception {
        assertNotNull(StreamUtil.find(null,findDuplicates));
        assertNotNull(StreamUtil.find(null,null));
        assertNotNull(StreamUtil.find(ints,null));
        assertEquals(1L, (long)StreamUtil.find(ints,findDuplicates).get(0));
    }

    @Test
    public void findMissingPositive() throws Exception {
        assertNotNull(StreamUtil.find(null,findMissing));
        assertNotNull(StreamUtil.find(null,null));
        assertNotNull(StreamUtil.find(ints,null));
        assertEquals(2L, (long)StreamUtil.find(ints,findMissing).get(0));
    }

}