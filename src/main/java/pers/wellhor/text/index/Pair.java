package pers.wellhor.text.index;

/**
 * 二元组
 *
 * @author wellhor Zhao
 * @version 1.0
 * @date 2020/8/26 3:17 下午
 **/
public class Pair<K,V> {

    private K left;

    private V right;

    public Pair(K left, V right) {
        this.left = left;
        this.right = right;
    }

    public K getLeft() {
        return left;
    }

    public V getRight() {
        return right;
    }
}
