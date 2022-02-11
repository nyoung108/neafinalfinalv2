/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraryFunctions;

import java.util.ArrayList;


public class upcomingEventsSort {
    public static void mergedList(ArrayList<String> unsortedList, String sortRequested) {
        int size = unsortedList.size();
        String[] unsortedEvents = new String[size];
        for (int i = 0; i < size; i++) {
            unsortedEvents[i] = unsortedList.get(i);
           
        }
        System.out.println("");
        int maxSize = unsortedEvents.length;
        if (sortRequested.equals("az")){
                splitListAZ(unsortedEvents, maxSize);
        }
       else if (sortRequested.equals("za")) {
           ArrayList<String> sortedEvents = new ArrayList<>();
           splitListAZ(unsortedEvents, maxSize);
           for (int i = 0; i < unsortedEvents.length; i++) {

            sortedEvents.add(unsortedEvents[i]);
            

        }
            stack.reverseList(sortedEvents);
        }
       else if(sortRequested.equals("date")){
           splitListDate(unsortedEvents, maxSize);
       }
               ArrayList<String> sortedEvents = new ArrayList<>();
               
        for (int i = 0; i < unsortedEvents.length; i++) {

            sortedEvents.add(unsortedEvents[i]);
            System.out.println(sortedEvents.get(i));

        }
        
        
    }

    public static void splitListAZ(String[] unsortedEvents, int maxSize) {

        if (maxSize <= 1) {
            return;
        }
        int midpoint = maxSize / 2;
        String[] leftList = new String[midpoint];

        String[] rightList = new String[maxSize - midpoint];
        for (int i = 0; i < midpoint; i++) {
            leftList[i] = unsortedEvents[i];
        }
        for (int i = midpoint; i < maxSize; i++) {
            rightList[i - midpoint] = unsortedEvents[i];
        }
        splitListAZ(leftList, midpoint);
        splitListAZ(rightList, maxSize - midpoint);  
        mergedAZ(leftList, rightList, unsortedEvents, midpoint, maxSize - midpoint);
         
    }
    public static void splitListDate(String[] unsortedEvents, int maxSize) {

        if (maxSize <= 1) {
            return;
        }
        int midpoint = maxSize / 2;
        String[] leftList = new String[midpoint];

        String[] rightList = new String[maxSize - midpoint];
        for (int i = 0; i < midpoint; i++) {
            leftList[i] = unsortedEvents[i];
        }
        for (int i = midpoint; i < maxSize; i++) {
            rightList[i - midpoint] = unsortedEvents[i];;
        }
        splitListDate(leftList, midpoint);
        splitListDate(rightList, maxSize - midpoint);

        
            mergedDate(leftList, rightList, unsortedEvents, midpoint, maxSize - midpoint);
        
    }

    public static void mergedAZ(String[] leftList, String[] rightList, String[] unsortedEvents, int left, int right) {
       int leftPointer = 0;
        int rightPointer = 0;
        int sortedPointer = 0;

        while (leftPointer < left && rightPointer < right) {

            if (leftList[leftPointer].compareToIgnoreCase(rightList[rightPointer]) < 0) {
                unsortedEvents[sortedPointer++] = leftList[leftPointer++];

            } else {
                unsortedEvents[sortedPointer++] = rightList[rightPointer++];

            }

        }
        while (leftPointer < left) {
            unsortedEvents[sortedPointer++] = leftList[leftPointer++];

        }
        while (rightPointer < right) {
            unsortedEvents[sortedPointer++] = rightList[rightPointer++];

        }

    }   
    public static void mergedDate(String[] leftList, String[] rightList, String[] unsortedEvents, int left, int right) {
        int leftPointer = 0;
        int rightPointer = 0;
        int sortedPointer = 0;

        while (leftPointer < left && rightPointer < right) {

            
                System.out.println(databaseOrders.getDate(leftList[leftPointer]));
                if (databaseOrders.getDate(leftList[leftPointer]).isBefore(databaseOrders.getDate(rightList[rightPointer++]))) {
                    unsortedEvents[sortedPointer++] = leftList[leftPointer++];
                    
                } else {
                    unsortedEvents[sortedPointer++] = rightList[rightPointer++];
                    
                }
                
            
        }
        while (leftPointer < left) {
            unsortedEvents[sortedPointer++] = leftList[leftPointer++];
            
        }
        while (rightPointer < right) {
            unsortedEvents[sortedPointer++] = rightList[rightPointer++];
            
        }
        
    }
}
