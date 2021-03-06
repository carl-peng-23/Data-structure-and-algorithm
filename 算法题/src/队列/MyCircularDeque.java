package 队列;
// 641. 设计循环双端队列 https://leetcode-cn.com/problems/design-circular-deque/
class MyCircularDeque {

    // 队列
    private int[] queue;

    // 队头
    private int front = 0;

    // 队尾
    private int rear = 0;

    //队列的长度
    private int size = 0;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        queue = new int[k];
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()) return false;
        // 要插入的索引
        int insertIndex = front == 0 ? queue.length - 1 : front - 1;
        queue[insertIndex] = value;
        front = front == 0 ? queue.length - 1 : front - 1;
        size++;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()) return false;
        // 要插入的索引
        int insertIndex = (front + size) % queue.length;
        queue[insertIndex] = value;
        rear = (rear + 1) % queue.length;
        size++;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()) return false;
        front = (front + 1) % queue.length;
        size--;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()) return false;
        rear = rear > 0 ? rear - 1 : queue.length - 1;
        size--;
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if (isEmpty()) return -1;
        return queue[front];
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        if (isEmpty()) return - 1;
        return queue[rear > 0 ? rear - 1 : queue.length - 1];
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == queue.length;
    }
}

/*
MyCircularDeque(k)：构造函数,双端队列的大小为k。
insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
isEmpty()：检查双端队列是否为空。
isFull()：检查双端队列是否满了。
 */