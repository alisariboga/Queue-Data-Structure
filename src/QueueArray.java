public class QueueArray<T> {
    Object[] arrayQueue;
    int rear, front, maxSize, nItems;

    public QueueArray(int size) {
        this.maxSize = size;
        arrayQueue = new Object[this.maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public void enqueue(Object o) {
        if (isFull()) {
            return;
        }
        rear++;
        arrayQueue[rear] = o;
        nItems++;


    }

    public T dequeue() {
        if (isEmpty()) {
            return null;
        }

        T objectOut = (T) arrayQueue[front];
        for (int i = 1; i < rear + 1; i++) {
            T tmp;
            tmp = (T) arrayQueue[i];
            arrayQueue[i - 1] = tmp;
        }
        arrayQueue[rear] = null;
        nItems--;
        rear--;
        return objectOut;
    }

    private boolean isEmpty() {
        return (nItems == 0);
    }

    public boolean isFull() {
        return (nItems == maxSize);
    }

    public void display() {
        System.out.println("Listing the elements in the queue");
        for (int i = 0; i < arrayQueue.length; i++) {
            if (isFull()) {
                System.out.println("Queue is full");
                return;
            }
            if (isEmpty()) {
                System.out.println("Queue is empty ");
                return;
            }
            System.out.println("Element order [" + (i + 1) + "]" + arrayQueue[i]);
        }
    }
}
