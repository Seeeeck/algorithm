package m09.d27;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给一个项目列表,在做k次项目内 如何利益最大化
 */
public class Greedy1 {
    /**
     *
     * @param k 最大可做项目数
     * @param W 启动资金
     * @param profits 项目利润列表
     * @param costs 项目花费列表
     * @return 最大 本金加利润
     */
    public static int findMaximizedCapital(int k,int W,int[] costs,int[] profits) {
        // 以花费排序的小根堆
        PriorityQueue<Project> minCostQueue = new PriorityQueue<>(Comparator.comparingInt(p -> p.cost));
        // 以收益排序的大根堆
        PriorityQueue<Project> maxProfitQueue = new PriorityQueue<>((p1, p2) -> p2.profit - p1.profit);
        for (int i = 0; i < costs.length; i++) {
            minCostQueue.add(new Project(costs[i],profits[i]));
        }
        for (int i = 0; i < k; i++) {
            while (!minCostQueue.isEmpty() && minCostQueue.peek().cost <= W){
                maxProfitQueue.add(minCostQueue.poll());
            }
            if(maxProfitQueue.isEmpty()){
                return W;
            }
            W += maxProfitQueue.poll().profit;
        }
        return W;
    }

    /**
     * 项目
     */
    private static class Project{
        // 花费
        private final int cost;
        // 利润
        private final int profit;

        public Project(int cost, int profit) {
            this.cost = cost;
            this.profit = profit;
        }
    }
}
