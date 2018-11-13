/**
 * 长期存活的对象进入老年代
 */
public class AllocateGC3 {
    private static final int _1MB = 1024 * 1024;
    /**
     * VM参数: -XX:+UseSerialGC -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1 -XX:+PrintTenuringDistribution
     */
    @SuppressWarnings("unused")
    public static void testTenuringThreshold() {
        byte[] allocation1, allocation2, allocation3;
        allocation1 = new byte[_1MB / 4];
        // 什么时候进入老年代取决于XX:MaxTenuringThreshold设置
        allocation2 = new byte[4 * _1MB];
        allocation3 = new byte[4 * _1MB];
        // Minor GC,年龄为allocation1,2,3都被移动到Survivor空间,年龄为1
        //由于年龄为1,所以allocation1,2,3直接晋升为老年代,移动到tenured gen空间中
        allocation3 = null;
        allocation3 = new byte[4 * _1MB];
    }
    public static void main(String[] args) {
        testTenuringThreshold();
    }
}
