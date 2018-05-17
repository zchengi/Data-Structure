package _02_Quick_Find;

import utils.UF;

/**
 * Quick Find
 *
 * @author cheng
 *         2018/5/17 14:00
 */
public class UnionFind1 implements UF {

    private int[] id;

    public UnionFind1(int size) {

        id = new int[size];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    /**
     * 合并元素p和元素q所属的集合
     *
     * @param p
     * @param q
     */
    @Override
    public void unionElements(int p, int q) {

        int pId = find(p);
        int qId = find(q);

        if (pId == qId) {
            return;
        }

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pId) {
                id[i] = qId;
            }
        }
    }

    /**
     * 查看元素p和元素q是否所属一个集合
     *
     * @param p
     * @param q
     * @return
     */
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 查找元素p所对应的集合编号
     *
     * @param p
     * @return
     */
    private int find(int p) {

        if (p < 0 || p >= id.length) {
            throw new IllegalArgumentException("p is not of bound.");
        }

        return id[p];
    }

    @Override
    public int getSize() {
        return id.length;
    }
}
