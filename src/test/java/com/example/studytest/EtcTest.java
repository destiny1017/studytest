package com.example.studytest;

import org.junit.jupiter.api.Test;

import java.util.*;

public class EtcTest {

    @Test
    void regex() {
        String a = "도화-2길";
        System.out.println(a.replaceAll("[^\uAC00-\uD7A30-9a-zA-Z]", ""));
    }

    @Test
    void asdasd() {
        Solution solution = new Solution();
        int result = solution.solution(2, "1A 2F 1C");
        System.out.println("result = " + result);
    }

    class Solution {

        boolean seat[][];
        int count = 0;

        public int solution(int N, String S) {
            seat = new boolean[N][10];
            StringTokenizer st = new StringTokenizer(S);
            // 이미 앉아있는 좌석에 대한 처리

            while(st.hasMoreTokens()) {
                unableSeat(st.nextToken());
            }

            for(int i = 0; i < N; i++) {
                if(checkLeftSeat(i)) {
                    checkRightSeat(i);
                } else {
                    checkMiddleSeat(i);
                }
            }

            return count;
        }

        public boolean checkLeftSeat(int n) {
            if(!seat[n][1] && !seat[n][2] && !seat[n][3] && !seat[n][4]) {
                count++;
                return true;
            } else {
                return false;
            }
        }

        public boolean checkMiddleSeat(int n) {
            if(!seat[n][3] && !seat[n][4] && !seat[n][5] && !seat[n][6]) {
                count++;
                return true;
            } else {
                return false;
            }
        }

        public boolean checkRightSeat(int n) {
            if(!seat[n][5] && !seat[n][6] && !seat[n][7] && !seat[n][8]) {
                count++;
                return true;
            } else {
                return false;
            }
        }

        public void unableSeat(String value) {
            int x = Integer.parseInt(value.substring(0, value.length() - 1)) - 1;
            int y = ((int) value.toCharArray()[value.length() - 1]) - 65;
            seat[x][y] = true;
        }

    }


    @Test
    void testest() {
        int[] abc = {3,4,6,2};
        Arrays.sort(abc);
        System.out.println(Arrays.toString(abc));
    }

    class ttt extends eee implements iii {
        public void run() {}
    }

    class eee {

    }

    interface iii {

    }

//    class Solution
//    {
//
//        public int solution(String s)
//        {
//            char str[] = s.toCharArray();
//
//            Stack<Character> stack = new Stack<>();
//            for(int i = 0; i < str.length; i++) {
//                if(!stack.isEmpty()) {
//                    if(stack.peek() == str[i]) {
//                        stack.pop();
//                    } else {
//                        stack.push(str[i]);
//                    }
//                } else {
//                    stack.push(str[i]);
//                }
//            }
//
//            return 1;
//        }
//    }

//    class Solution
//    {
//        public int solution(String s)
//        {
//            char str[] = s.toCharArray();
//            char prev = str[0];
//            int prevIdx = 0;
//            int i = 1;
//
//            while(i != str.length) {
//                if(str[i] == '-') {
//                    i++;
//                } else if(str[i] == prev) {
//                    str[i] = '-';
//                    str[prevIdx] = '-';
//                    // 문자열 제거 후 초기화
//                    i = 1;
//                    prev = str[0];
//                    prevIdx = 0;
//                } else {
//                    prev = str[i];
//                    prevIdx = i;
//                    i++;
//                }
//            }
//
//            for(char c : str) {
//                if(c != '-') return 0;
//            }
//            return 1;
//        }
//    }


    @Test
    void queueTest() {
        int[] priorities = new int[] {1, 1, 2, 3, 2, 1};
        int target = 0;
        PriorityQueue<priorObject> queue = new PriorityQueue<>((o1, o2) -> {
            if(o1.getValue() < o2.getValue()) {
                return 1;
            } else if(o1.getValue() > o2.getValue()) {
                return -1;
            } else {
                return 0;
            }
        });


        for (int i = 0; i < priorities.length; i++) {
            queue.add(new priorObject(priorities[i], i));
        }

        for (int i = 1; i <= priorities.length; i++) {
            priorObject poll = queue.poll();
//            System.out.println("poll.getIndex() = " + poll.getIndex());
//            System.out.println("poll.getValue() = " + poll.getValue());
            if(poll.getIndex() == target) {
                System.out.println("i = " + i);
            }
        }

    }

    class priorObject {
        Integer value;
        int index;

        public priorObject(Integer value, int index) {
            this.value = value;
            this.index = index;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }

    @Test
    void queueTest2() {
        int[] priorities = new int[] {1, 1, 2, 3, 2, 1};
        int location = 0;

        Queue<priorObject> queue = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            queue.add(new priorObject(priorities[i], i));
        }
        int cnt = 0;
        while(!queue.isEmpty()) {
            int top = 0;
            for (priorObject prior : queue) {
                int val = prior.getValue();
                if(top < val) {
                    top = val;
                }
            }
            priorObject peek = queue.peek();
            if(peek.getValue() >= top) {
                priorObject poll = queue.poll();
                cnt++;
                if(poll.getIndex() == location) {
//                    return cnt;
                    System.out.println(cnt);
                    break;
                }
            } else {
                queue.offer(queue.poll());
            }
        }

    }

    @Test
    void keySet() {
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.keySet();
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.keySet();
    }

}
