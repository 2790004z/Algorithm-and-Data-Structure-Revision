#include <stdio.h>
#include <stdlib.h>

typedef struct stack{
    int* bottom; // Address of the first element
    int top; // location of the last element
    int capacity; // capacity of the stack
} Stack_t;

void init_stack(Stack_t* stack, int capacity){
    stack->capacity = capacity;
    stack->bottom = (int*)malloc(sizeof(int)*capacity);
    stack->top = 0;
}

void free_stack(Stack_t* stack, int capacity){
    stack->capacity = 0;
    stack->top = 0;
    free(stack->bottom);
}

int is_full(Stack_t* stack){
   return stack->top >= stack->capacity;
}

int is_empty(Stack_t* stack){
    return !stack->top;
}

int push(Stack_t* stack, int data){
    if (is_full(stack)) return -1;
    stack->bottom[(stack->top)++] = data;
    return 0;
}

int pop(Stack_t* stack){
    if (is_empty(stack)) return -1;
    return stack->bottom[--(stack->top)];
}

int get_stack_size(Stack_t* stack){
    return stack->top;
}

void print_stack(Stack_t* stack){
    for (int i = stack->top-1; i >= 0; i--) {
        printf("%d ", stack->bottom[i]);
    }
    printf("\n");
}

int main() {
    Stack_t stack;
    init_stack(&stack, 10);
    for (int i = 0; i < 10; ++i) {
        push(&stack, i);
    }
    printf("Stack size: %d\n", get_stack_size(&stack));
    print_stack(&stack);
    for (int i = 0; i < 10; ++i) {
        printf("%dth pop: %d\n", i+1, pop(&stack));
    }
    printf("\n");
    free_stack(&stack, 10);

    return 0;
}
