package c.k.dp.composite;

/**
 * 组合模式（Composite）
 * 组合模式有时又叫部分-整体模式在处理类似树形结构的问题时比较方便
 * 使用场景：将多个对象组合在一起进行操作，常用于表示树形结构中，例如二叉树，数等
 */
public class Tree {
    TreeNode root = null;

    public Tree(String name) {
        root = new TreeNode(name);
    }
}
