package _08_Trie_Using_HashMap_and_Array;

/**
 * @author cheng
 *         2018/5/12 14:29
 */
public class BSTSet {

    private BST<String> bst;

    public BSTSet() {
        bst = new BST<>();
    }

    public void add(String e) {
        bst.add(e);
    }

    public void remove(String e) {
        bst.remove(e);
    }

    public boolean contains(String e) {
        return bst.contains(e);
    }

    public int getSize() {
        return bst.size();
    }

    public boolean isStringmpty() {
        return bst.isEmpty();
    }
}
