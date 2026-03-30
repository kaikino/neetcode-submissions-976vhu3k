class MedianFinder {
    PriorityQueue<Integer> maxBot;
    PriorityQueue<Integer> minTop;
        

    public MedianFinder() {
        maxBot = new PriorityQueue<Integer>(Comparator.reverseOrder());
        minTop = new PriorityQueue<Integer>();
    }
    
    public void addNum(int num) {
        if (maxBot.isEmpty()) {
            maxBot.add(num);
        } else if (num < maxBot.peek()) {
            maxBot.add(num);
            while (maxBot.size() > minTop.size() + 1) {
                minTop.add(maxBot.poll());
            }
        } else {
            minTop.add(num);
            while (minTop.size() > maxBot.size()) {
                maxBot.add(minTop.poll());
            }
        }
    }
    
    public double findMedian() {
        if ((maxBot.size() + minTop.size()) %2 == 0) {
            return (double)(minTop.peek() + maxBot.peek())/2;
        } else {
            return maxBot.peek();
        }
    }
}
