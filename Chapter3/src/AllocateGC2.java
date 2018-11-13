/**
 * 大对象直接进入老年代
 */
public class AllocateGC2 {
    private static final int _1MB = 1024 * 1024;

    /**
     * VM参数: -XX:+UseSerialGC -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728
     */
    public static void testPretenureSizeThreshold() {
        byte[] allocation;
        // 直接分配在老年代
        allocation = new byte[4 * _1MB];
    }
    public static void main(String[] args) {
        testPretenureSizeThreshold();
    }
}
