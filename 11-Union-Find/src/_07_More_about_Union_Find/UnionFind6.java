package _07_More_about_Union_Find;

import utils.UF;

/**
 * Quick Union
 *
 * @author cheng
 *         2018/5/17 16:12
 */
public class UnionFind6 implements UF {

    private int[] parent;
    /**
     * rank[i] 表示以i为根的集合所表示的树的
     */
    private int[] rank;

    public UnionFind6(int size) {

        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    /**
     * 合并元素p和元素q所属的集合
     * O(h)复杂度，h为树的高度
     *
     * @param p
     * @param q
     */
    @Override
    public void unionElements(int p, int q) {

        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) {
            return;
        }

        // 根据两个元素所在树的元素个数不同判断合并方向
        // 将元素个数少的集合合并到元素个数多的集合上
        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else if (rank[pRoot] > rank[qRoot]) {
            parent[qRoot] = pRoot;
        } else {
            parent[qRoot] = pRoot;
            rank[pRoot] += 1;
        }
    }

    /**
     * 查看元素p和元素q是否所属一个集合
     * O(h)复杂度，h为树的高度
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
     * O(h)复杂度，h为树的高度
     *
     * @param p
     * @return
     */
    private int find(int p) {

        if (p < 0 || p >= parent.length) {
            throw new IllegalArgumentException("p is not of bound.");
        }

        if (p != parent[p]) {
            parent[p] = find(parent[p]);
        }
        return parent[p];
    }

    @Override
    public int getSize() {
        return parent.length;
    }
}
