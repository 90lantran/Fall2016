import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

import javax.naming.spi.DirStateFactory.Result;

public class RunningMedian {
	enum Suite{
		
	}
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        
        /*
         * Naive solution
         * Create subarray of the original array, sort it, take median
         * For some reason, there are error and time out when running test case.
         */
//        double[] medians = new double[n];
//        for(int i = 1; i <= a.length; i++){
//        	int[] temp = Arrays.copyOfRange(a, 0, i);
//        	Arrays.sort(temp);
//        	if (temp.length == 1){
//        		medians[i-1] = temp[0];
//        	} else if (temp.length % 2 == 0){
//        		medians[i-1] = (a[temp.length/2 - 1] + a[temp.length /2])/2.0;
//        	} else {
//        		medians[i-1] = a[temp.length/2] /1.0;
//        	}
//        }
//        
//        for (double d : medians){
//        	System.out.println(d);
//        }
        
        /*
         * Using two heap
         */
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(100, Collections.reverseOrder());
        
        if (a.length == 1){
        	System.out.println(a[0]);
        } else if (a.length == 2){
        	System.out.println((a[0] + a[1])/2.0);
        } else {
        	double[] answer = new double[n];
        	if (a[0] > a[1]){
        		maxHeap.add(a[1]);
        		minHeap.add(a[0]);
        	} else {
        		maxHeap.add(a[0]);
        		minHeap.add(a[1]);
        	}
        	answer[0] = a[0];
        	answer[1] = (a[0] + a[1])/2;
        	for (int i = 2; i < a.length; i++){
        		if(a[i] > minHeap.peek()){
        			minHeap.add(a[i]);
        		} else {
        			maxHeap.add(a[i]);
        		}
        		if (minHeap.size() - maxHeap.size() >= 2){
        			int movedItem = minHeap.poll();
        			maxHeap.add(movedItem);
        		} else if (maxHeap.size() - minHeap.size() >= 2){
        			int movedItem = maxHeap.poll();
        			minHeap.add(movedItem);
        		}
        		if (minHeap.size() == maxHeap.size()){
        			answer[i] = (minHeap.peek() + maxHeap.peek())/2.0;
        		} else if (minHeap.size() > maxHeap.size()){
        			answer[i] = minHeap.peek()/1.0;
        		} else {
        			answer[i] = maxHeap.peek()/1.0;
        		}
        		
        	}
        	
        	for (double d: answer){
        		System.out.println(d);
        	}
        }
        
        
    }
}
