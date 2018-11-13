/**
 * 内存分配与回收策略
 * @author devinkin
 */
public class AllocateGC {
    private static final int _1MB = 1024 * 1024;

    /**
     * VM 参数: -XX:+UseSerialGC -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     */
    public static void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        // 6M,eden区对象没有被垃圾回收成功,Minor GC时候,就把这6M转移到空的Survivor区域
        // SUrvivor由from to两个
        // 但Survivor只有1M,GC期间虚拟机又发现已有的3个2MB大小对象全部无法放入Survivor空间
        // 所以只好通过分配担保机制提前转移到老年区(tenured generation)
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        // 出现一次Minor GC,年轻代到达了10M
        allocation4 = new byte[4 * _1MB];
    }

    public static void main(String[] args) {
        testAllocation();
    }
}
