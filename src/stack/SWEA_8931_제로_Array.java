package stack;

import java.util.Arrays;
import java.util.Scanner;

// 250213
public class SWEA_8931_제로_Array {
	static int MAX_SIZE = 1000;
	static int top = -1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 0; tc < T; tc++) {
			top = -1;
			// 부를 숫자의 개수
			int N = sc.nextInt();

			int[] arr = new int[MAX_SIZE];
			for (int i = 0; i < N; i++) {
				int input = sc.nextInt();
				if (input == 0) {
					arr = pop(arr);
				} else {
					arr = push(arr, input);
				}

				System.out.println(tc + " >> " + Arrays.toString(arr));
			}

			int sum = 0;
			for (int i = 0; i < arr.length; i++) {

				sum += arr[i];
			}
			System.out.println("#" + (tc + 1) + " " + sum);
		}
		sc.close();
	}

	static int[] push(int[] stack, int value) {
		if (top == stack.length - 1) {
			int[] newStack = Arrays.copyOf(stack, stack.length + MAX_SIZE);
			newStack[++top] = value;
			return newStack;
		} else {
			stack[++top] = value;
			return stack;
		}
	}

	static int[] pop(int[] stack) {
		if (top < 0)
			return stack;
		stack[top--] = 0;
		if (top < stack.length / 2 - 1 && stack.length >= MAX_SIZE * 2) {
			int[] newStack = Arrays.copyOf(stack, stack.length / 2);
			return newStack;
		}
		return stack;
	}
}
