package util;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import util.PrintSupport;

public class CollectionSupport {
	
	public static <K, V extends Comparable<V>> V maxUsingCollectionsMax(Map<K, V> map) {
	    Entry<K, V> maxEntry = Collections.max(map.entrySet(), new Comparator<Entry<K, V>>() {
	        public int compare(Entry<K, V> e1, Entry<K, V> e2) {
	            return e1.getValue()
	                .compareTo(e2.getValue());
	        }
	    });
	    return maxEntry.getValue();
	}
}
