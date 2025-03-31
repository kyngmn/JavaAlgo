package linkedlist;

import java.util.LinkedList;
import java.util.Scanner;

//79,792 kb
//메모리
//422 ms
//실행시간
//1,918
//코드길이
public class SWEA_1230_암호문3_다른모양풀이 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = 0;
        while (tc++ < 10) {
            // 암호문 길이
            int N = sc.nextInt();

            // 암호문
            LinkedList<Integer> cipher = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                cipher.add(sc.nextInt());
            }

            // 명령어 개수
            int C = sc.nextInt();

            int execute = 0;
            while (execute < C) {
                // 새로운 명령어 시작
                String command = sc.next();
                
                switch (command) {
                    case "D": { // Delete
                        int x = sc.nextInt();
                        int y = sc.nextInt();
                        while (y-- > 0) {
                            cipher.remove(x);
                        }
                        break;
                    }
                    case "A": { // Add
                        int y = sc.nextInt();
                        for (int j = 0; j < y; j++) {
                            cipher.addLast(sc.nextInt());
                        }
                        break;
                    }
                    default: { // Insert ("I")
                        int x = sc.nextInt();
                        int y = sc.nextInt();
                        for (int j = 0; j < y; j++) {
                            cipher.add(x + j, sc.nextInt());
                        }
                        break;
                    }
                }
                execute++;
            }

            System.out.print("#" + tc);
            for (int j = 0; j < 10; j++) {
                System.out.print(" " + cipher.get(j));
            }
            System.out.println();
        }

        sc.close();
    }
}
