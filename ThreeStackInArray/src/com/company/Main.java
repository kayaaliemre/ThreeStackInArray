package com.company;

public class Main {
        public static void main(String[] args)
        {
            int n = 10;
            ThreeStackInSingleArray threeStackInSingleArray = new ThreeStackInSingleArray(n);

            threeStackInSingleArray.push(20, 2);
            threeStackInSingleArray.push(40, 2);

            // Let us put some items in stack number 1
            threeStackInSingleArray.push(18, 1);
            threeStackInSingleArray.push(50, 1);
            threeStackInSingleArray.push(38, 1);

            // Let us put some items in stack number 0
            threeStackInSingleArray.push(12, 0);
            threeStackInSingleArray.push(10, 0);
            threeStackInSingleArray.push(8, 0);

            System.out.println("Popped element from stack 2 is " + threeStackInSingleArray.pop(2));
            System.out.println("Popped element from stack 1 is " + threeStackInSingleArray.pop(1));
            System.out.println("Popped element from stack 0 is " + threeStackInSingleArray.pop(0));
        }

    static class ThreeStackInSingleArray
    {
        int[] array;
        int[] top;
        int[] next;
        int arraySize;
        int stackSize = 3;
        int free;

        ThreeStackInSingleArray(int size)
        {
            arraySize = size;
            array = new int[arraySize];
            top = new int[stackSize];
            next = new int[arraySize];

            for (int i = 0; i < stackSize; i++)
                top[i] = -1;

            free = 0;
            for (int i = 0; i < arraySize - 1; i++)
                next[i] = i + 1;
            next[arraySize - 1] = -1;
        }
        boolean isFull()
        {
            return (free == -1);
        }
        void push(int item, int stackNumber)
        {
            // Overflow check
            if (isFull())
            {
                System.out.println("Stack is full!!");
                return;
            }

            int i = free; 

            free = next[i];

            next[i] = top[stackNumber];
            top[stackNumber] = i;

            array[i] = item;
        }

        int pop(int stackNumber)
        {
            // Underflow check
            if (isEmpty(stackNumber))
            {
                System.out.println("Stack Underflow");
                return Integer.MAX_VALUE;
            }

            int i = top[stackNumber];

            top[stackNumber] = next[i]; 

            next[i] = free;
            free = i;

            return array[i];
        }

        boolean isEmpty(int stackNumber)
        {
            return (top[stackNumber] == -1);
        }

    }
}
