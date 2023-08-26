#include <stdio.h>
#include <stdlib.h>

typedef struct queue{
    int* queue;
    int head;
    int tail;
    int size;
    int capacity;
} Queue_t;

void init_queue(Queue_t* queue, int capacity){
    queue->capacity = capacity;
    queue->queue = (int*)malloc(sizeof(int )*capacity);
    queue->size = 0;
    queue->head = 0;
    queue->tail = 0;
}

void free_queue(Queue_t* queue){
    free(queue->queue);
    queue->capacity = 0;
    queue->tail = 0;
    queue->head = 0;
    queue->size = 0;
    queue->capacity = 0;
}

int is_full(Queue_t* queue){
    return queue->size >= queue->capacity;
}

int is_empty(Queue_t* queue){
    return !queue->size;
}

int enqueue(Queue_t* queue, int data){
    if (is_full(queue)) return -1;
    queue->size++;
    queue->queue[(queue->tail)++] = data;
    return 0;
}

int dequeue(Queue_t* queue){
    if (is_empty(queue)) return -1;
    queue->size--;
    return queue->queue[queue->head++];
}

int get_queue_size(Queue_t* queue){
    return queue->size;
}

void print_queue(Queue_t* queue){
    for (int i = queue->head; i < queue->tail; ++i) {
        printf("%d ", queue->queue[i]);
    }
    printf("\n");
}

int main() {
    Queue_t queue;
    init_queue(&queue, 10);
    for (int i = 0; i < 10; ++i) {
        enqueue(&queue, i);
    }
    printf("queue size: %d\n", get_queue_size(&queue));
    print_queue(&queue);
    for (int i = 0; i < 10; ++i) {
        printf("%dth dequeue: %d\n", i+1, dequeue(&queue));
    }
    printf("\n");
    free_queue(&queue);

    return 0;
}
