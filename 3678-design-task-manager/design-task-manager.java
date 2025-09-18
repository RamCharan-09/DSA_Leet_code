class Pair {
    int userId, taskId, priority;
    Pair(int userId, int taskId, int priority) {
        this.userId = userId; this.taskId = taskId; this.priority = priority;
    }
}

class TaskManager {
    PriorityQueue<Pair> pq; Map<Integer, Integer> taskIdToPriority; Map<Integer, Integer> taskIdToUserId;
    public TaskManager(List<List<Integer>> tasks) {
        pq = new PriorityQueue<>((a, b) -> b.priority == a.priority ? b.taskId - a.taskId : b.priority - a.priority);
        taskIdToPriority = new HashMap<>(); taskIdToUserId = new HashMap<>();

        for(List<Integer> arr : tasks) {
            int userid = arr.get(0), taskid = arr.get(1), priority = arr.get(2);
            pq.add(new Pair(userid, taskid, priority));
            taskIdToPriority.put(taskid, priority);
            taskIdToUserId.put(taskid, userid);
        }
    }
    
    public void add(int userId, int taskId, int priority) {
        pq.add(new Pair(userId, taskId, priority));
        taskIdToPriority.put(taskId, priority);
        taskIdToUserId.put(taskId, userId);
    }
    
    public void edit(int taskId, int newPriority) {
        taskIdToPriority.put(taskId, newPriority);
        int userid = taskIdToUserId.get(taskId);
        pq.add(new Pair(userid, taskId, newPriority));
    }
    
    public void rmv(int taskId) {
        taskIdToPriority.remove(taskId);
        taskIdToUserId.remove(taskId);
    }
    
    public int execTop() {
        while(true) {
            if(pq.isEmpty() || taskIdToPriority.isEmpty() || taskIdToUserId.isEmpty()) return -1;
            Pair p = pq.poll();
            if(taskIdToPriority.get(p.taskId) == null || taskIdToUserId.get(p.taskId) == null) continue;

            if(p.priority == taskIdToPriority.get(p.taskId) && p.userId == taskIdToUserId.get(p.taskId)) {
                taskIdToPriority.remove(p.taskId);
                taskIdToUserId.remove(p.taskId);
                return p.userId;
            }
        }
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */