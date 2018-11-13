/**
 * 动态对象年龄判定
 */
public class AllocateGC4 {
    private static final int _1MB = 1024 * 1024;
    /**
     * VM 参数:
     * -XX:+UseSerialGC
     * -verbose:gc
     * -Xms20M
     * -Xmx20M
     * -Xmn10M
     * -XX:+PrintGCDetails
     * -XX:SurvivorRatio=8
     * -XX:MaxTenuringThreshold=15
     * -XX:+PrintTenuringDistribution
     */
    public static void testTenuringThreeshold2() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[_1MB / 4];
        // allocation1 + allocation2大于survivor空间一半
        allocation2 = new byte[_1MB / 4];
        allocation3 = new byte[4 * _1MB];
        // 第一次Minor GC
        allocation4 = new byte[4 * _1MB];
        allocation4 = null;
        // 第二次Minor GC
        allocation4 = new byte[4 * _1MB];
    }

    public static void main(String[] args) {
        testTenuringThreeshold2();
    }
}
