package br.com.cubotecnologia.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

/**
 * 
 * @author william.s.soares
 * 
 *         Class to support work with maps
 */
public class MapUtils {

	/**
	 * Method to sort a Map of String by key values
	 * 
	 * @param unsortMap
	 *            Unsort Map
	 * @return Sort Map
	 */
	public static Map<String, Integer> sortByKey(final Map<String, Integer> unsortMap) {
		return new TreeMap<String, Integer>(unsortMap);
	}

	/**
	 * Method to sort a Map of String by Values
	 * 
	 * @param unsortMap
	 *            Unsort Map
	 * @return Sort Map
	 */
	public static Map<String, Integer> sortByValue(final Map<String, Integer> unsortMap) {

		final List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(unsortMap.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			/**
			 * Method to compare two register of a Map
			 */
			public int compare(final Map.Entry<String, Integer> o1, final Map.Entry<String, Integer> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
		});

		final Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();

		for (final Map.Entry<String, Integer> entry : list) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}

		return sortedMap;
	}

	/**
	 * Method to return one register by index
	 * 
	 * @param map
	 *            Map
	 * @param index
	 *            Index of map register
	 * @return Value refers to index
	 */
	public static Entry<String, Integer> getEntryByIndex(final Map<String, Integer> map, final int index) {
		final List<Entry<String, Integer>> entryList = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
		return entryList.get(index);
	}

	/**
	 * Generic method to clear Maps
	 * 
	 * @param map
	 */
	public static <K, V extends Comparable<? super V>> void clearMap(final Map<K, V> map) {
		if (map != null) {
			map.clear();
		}
	}
}
