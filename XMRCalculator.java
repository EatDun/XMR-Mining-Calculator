import java.lang.Math;
import java.util.Scanner;

class Calculator {
    
    public static double netHashRateMeth (double nd, double bt) {
        return (nd * 1e9) / bt;
    }
    
    public static double reward (double hr, double nhr, double bd, double br) {
        return (hr / nhr) * bd * br;
    }
    
    public static void main(String[] args) {
        
        //Constant values
        double blockTime = 120;
        double blocksDay = 86400 / 120;
        double blockReward = .6;
        
        Scanner hashRateScan = new Scanner(System.in);
        System.out.print("Hashrate (H/s): ");
        double hashRate = hashRateScan.nextDouble();
        
        Scanner netDifScan = new Scanner(System.in);
        System.out.print("Network Difficulty (Gigahash): ");
        double netDif = netDifScan.nextDouble();
        
        Scanner xmrPriceScan = new Scanner(System.in);
        System.out.print("XMR Price (USD): ");
        double xmrPrice = xmrPriceScan.nextDouble();
        
        double netHashRate = netHashRateMeth(netDif, blockTime);
        double dailyRewardXMR = reward(hashRate, netHashRate, blocksDay, blockReward);
        double dailyRewardUSD = dailyRewardXMR * xmrPrice;
        
        System.out.printf("\nYou earn %.12f XMR ($%.2f USD) per day%n", dailyRewardXMR, dailyRewardUSD);
    }
}
