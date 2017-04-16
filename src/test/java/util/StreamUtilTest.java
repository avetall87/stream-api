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


    private List<Map<String,Long>> result;


    @Before
    public void setUp() throws Exception {
        result = new ArrayList<>();
        Map<String, Long> emptyMap1 = new HashMap<>();
        emptyMap1.put("ID",1L);
        Map<String, Long> emptyMap2 = new HashMap<>();
        emptyMap2.put("ID",3L);
        Map<String, Long> emptyMap3 = new HashMap<>();
        emptyMap3.put("ID",1L);
        result.add(emptyMap1);
        result.add(emptyMap2);
        result.add(emptyMap3);

    }

    @Test
    public void findDuplicatesPositive() throws Exception {
        assertNotNull(StreamUtil.find(null,findDuplicates));
        assertNotNull(StreamUtil.find(null,null));
        assertNotNull(StreamUtil.find(result,null));
        assertEquals(1L, (long)StreamUtil.find(result,findDuplicates).get(0));
    }

    @Test
    public void findMissingPositive() throws Exception {
        assertNotNull(StreamUtil.find(null,findMissing));
        assertNotNull(StreamUtil.find(null,null));
        assertNotNull(StreamUtil.find(result,null));
        assertEquals(2L, (long)StreamUtil.find(result,findMissing).get(0));
    }

}