package first;

public interface SimpleTreeNode 
{
    public void addChild (SimpleTreeNode child);
    public int getChildCnt();
    public SimpleTreeNode getChild (int pos);
}