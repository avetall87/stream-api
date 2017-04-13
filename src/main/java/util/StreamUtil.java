package util;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

/**
 * Created by avetall  13.04.17.
 */
public abstract class StreamUtil {

    protected static List<Long> findDuplicates(List<Map<String, Long>> mapList){
        return mapList.stream()
                .collect(groupingBy(i->i.get("ID"), counting()))
                .entrySet()
                .stream()
                .filter(entry->entry.getValue()>1)
                .map(Map.Entry::getKey).collect(toList());
    }
}
