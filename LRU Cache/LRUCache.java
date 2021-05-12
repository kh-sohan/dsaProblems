import java.util.*; 

/*
Parameters: for linkedHashMap constructor
initialCapacity - the initial capacity
loadFactor - the load factor
accessOrder - the ordering mode - true for access-order, false for insertion-order
*/

// map.remove(map.keySet().iterator().next());    // to remove first ele of lhm

public class LRUCache {
    Map<Integer, Integer> map;

    public LRUCache(int capacity) {
        map = new LinkedHashMap<>(capacity, 0.75f, true){
                protected boolean removeEldestEntry(Map.Entry eldest) {
                    return size() > capacity;
                }
            };
    }
    
    public int get(int key) {
        return map.getOrDefault(key, -1);
        
    }
    
    public void put(int key, int value) {
        map.put(key, value);
    }
}
/*
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

 // Another approach :

 class LRUCache2 extends LinkedHashMap<Integer, Integer> {
    
    private int capacity;
    
    public LRUCache2(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }
    
    public int get(int key) {
        return super.getOrDefault(key, -1);
    }
    
    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > capacity;
    }
}