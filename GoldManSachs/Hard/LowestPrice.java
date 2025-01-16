package GoldManSachs.Hard;

/**
 * *Lowest Price or Least Price
 * 
 * Question: A popular online retailer allow vendors to specify different price
 * in advance for the same throught the day. We now need to design the algorithm that
 * helps to identify the lowest price for the item at any point of the day.
 * 
 * *Assumptions:
 * 1. For algorithm, assume all vendors are selling the same product being sold.
 * Given a list that has vendor information - (startTime, endTime, Price) of the
 * deal, return a sorted list with different possible intervals and the least price
 * or the lowest of the product.
 * 
 *  *The intervals are:
 * Input:
 * (startTime, endTime, Price)
 * (1, 5, 20)
 * (3, 8, 15)
 * (7, 10, 8)
 * 
 * *Output:
 * (1, 3, 20)
 * (3, 7, 15)
 * (7, 10, 8)
 * 
 */
import java.util.*;

public class LowestPrice {

    public static class Interval {
        private int startTime;
        private int endTime;
        private int price;

        Interval(int startTime, int endTime, int price) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.price = price;
        }

        public int getStart() {
            return this.startTime;
        }

        public int getEnd() {
            return this.endTime;
        }

        public int getPrice() {
            return this.price;
        }

        public void setStart(int startTime) {
            this.startTime = startTime;
        }

        public void setEnd(int endTime) {
            this.endTime = endTime;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public String toString() {
            return "Start: '" + this.startTime + "', End: '" + this.endTime + "' Price: '" + this.price + "'";
        }
    }

    /**
     * *GetMinimumPriceIntervals
     * 
     * @param args
     */
    public static List<Interval> getMinimumPricePIntervals(List<Interval> pricIntervals) {

        var result = new ArrayList<Interval>();

        var map = new TreeMap<Integer, Integer>();

        for (Interval interval : pricIntervals) {
            var currentPrice = interval.getPrice();
            for (int i = interval.getStart(); i < interval.getEnd(); i++) {
                if (map.containsKey(i)) {
                    var currentValue = map.get(i);
                    if (currentValue < currentPrice) {
                        map.put(i, currentValue);
                    } else {
                        map.put(i, currentPrice);
                    }
                } else {
                    map.put(i, currentPrice);
                }
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (result.size() > 0) {
                Interval latestItem = result.get(result.size() - 1);
                if (latestItem.getPrice() != entry.getValue()) {
                    latestItem.setEnd(entry.getKey());
                    result.add(new Interval(entry.getKey(), entry.getKey() + 1, entry.getValue()));
                } else {
                    latestItem.setEnd(entry.getKey() + 1);
                }
            } else {
                result.add(new Interval(entry.getKey(), entry.getKey() + 1, entry.getValue()));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<Interval>() {
            {
                add(new Interval(0, 4, 5));
                add(new Interval(2, 8, 3));
                add(new Interval(7, 11, 10));
            }
        };

        // result new Intervals(0, 1, 5), new Intervals(1, 2, 3), new Intervals(2, 3, 5)
        getMinimumPricePIntervals(intervals).stream().forEach(System.out::println);
    }
}

