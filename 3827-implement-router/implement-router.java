import java.util.*;

class Router {
    private int memoryLimit;
    private Deque<int[]> queue; // FIFO queue: [source,dest,timestamp]
    private Set<String> set;    // Detect duplicates
    private Map<Integer, List<Integer>> map; // destination -> timestamps list

    public Router(int memoryLimit) {
        this.memoryLimit = memoryLimit;
        this.queue = new ArrayDeque<>();
        this.set = new HashSet<>();
        this.map = new HashMap<>();
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        String key = source + "," + destination + "," + timestamp;
        if (set.contains(key)) return false; // duplicate check O(1)

        // Evict oldest if memory full
        if (queue.size() == memoryLimit) forwardPacket();

        // Add packet
        queue.addLast(new int[]{source, destination, timestamp});
        set.add(key);

        map.putIfAbsent(destination, new ArrayList<>());
        map.get(destination).add(timestamp);

        return true;
    }

    public int[] forwardPacket() {
        if (queue.isEmpty()) return new int[]{};

        int[] oldest = queue.pollFirst();
        String key = oldest[0] + "," + oldest[1] + "," + oldest[2];
        set.remove(key);

        List<Integer> times = map.get(oldest[1]);
        times.remove(0); // still O(n) but timestamps per destination are small in practice
        if (times.isEmpty()) map.remove(oldest[1]);

        return oldest;
    }

    public int getCount(int destination, int startTime, int endTime) {
        if (!map.containsKey(destination)) return 0;

        List<Integer> times = map.get(destination);

        // Binary search to find first index >= startTime
        int left = 0, right = times.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (times.get(mid) >= startTime) right = mid - 1;
            else left = mid + 1;
        }

        int l = left;

        // Binary search to find last index <= endTime
        left = 0;
        right = times.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (times.get(mid) <= endTime) left = mid + 1;
            else right = mid - 1;
        }

        int r = right;
        return r >= l ? r - l + 1 : 0;
    }
}

/**
 * Your Router object will be instantiated and called as such:
 * Router obj = new Router(memoryLimit);
 * boolean param_1 = obj.addPacket(source,destination,timestamp);
 * int[] param_2 = obj.forwardPacket();
 * int param_3 = obj.getCount(destination,startTime,endTime);
 */