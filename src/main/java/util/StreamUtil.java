package util;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;
import static java.util.stream.LongStream.rangeClosed;

/**
 * Created by avetall  13.04.17.
 */
public abstract class StreamUtil {

    private static final String IDENTITY_FIELD="ID";

    public enum ActionType{
        findDuplicates,
        findMissing
    }

    public static List<Long> find(List<Map<String, Long>> mapList, ActionType actionType){
        if ((mapList==null || mapList.size()==0) || (actionType==null)) return Collections.emptyList();
        List<Long> result;
        switch (actionType){
            case findDuplicates: result=findDuplicates(mapList); break;
            case findMissing: result=findMissing(mapList); break;
            default: result=Collections.emptyList(); break;
        }
        return result;
    }


    private static List<Long> findDuplicates(List<Map<String, Long>> mapList){
        return mapList
                .stream()
                .collect(groupingBy(i->i.get(IDENTITY_FIELD), counting()))
                .entrySet()
                .stream()
                .filter(entry->entry.getValue()>1)
                .map(Map.Entry::getKey).collect(toList());
    }

    private static List<Long> findMissing(List<Map<String, Long>> mapList){
        return rangeClosed(1, mapList.size())
                .filter(id->
                        !mapList.stream()
                                .mapToLong(value -> value.get(IDENTITY_FIELD))
                                .sorted()
                                .boxed()
                                .collect(toList())
                                .contains(id))
                .boxed().collect(toList());
    }


}
