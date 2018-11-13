/**
 * 空间分配担保
 *
 * @author devinkin
 */
public class AllocateGC5 {
    private static final int _1MB = 1024 * 1024;

    /**
     * VM参数:
     * -XX:UseSerialGC
     * -Xms20M
     * -Xmx20M
     * -Xmn10M
     * -XX:+PrintGCDetails
     * -XX:SurvivorRatio=8
     * -XX:+HandlePromotionFailure
     */
    public static void testHandlePromotion() {
        byte[] allocation1, allocation2, allocation3, allocation4, allocation5, allocation6, allocation7;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        // 回收allocation1进入了老年代,因为Survivor内存为1M,不足以存放2M的内容
        allocation1 = null;
        // 第一次Minor GC,回收了allocation1
        allocation4 = new byte[2 * _1MB];
        // 第二次Minor GC,allocation5直接进入老年代
        allocation5 = new byte[2 * _1MB];
        // 第三次Minor GC,allocation6直接进入老年代
        allocation6 = new byte[2 * _1MB];

        allocation4 = null;
        allocation5 = null;
        allocation6 = null;
        // 在老年代分配allocation7,可能会导致Full GC的进行
        allocation7 = new byte[2 * _1MB];
    }

    public static void main(String[] args) {
        testHandlePromotion();
    }
}
