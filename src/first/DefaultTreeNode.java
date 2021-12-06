package first;

public class DefaultTreeNode implements SimpleTreeNode 
{
    private int CAPACITY;
    private String name;
    private SimpleTreeNode[] childs;
    private int childcnt;

    public DefaultTreeNode (String name)    //Konstruktor
    {
        CAPACITY = 1;
        this.name = name;
        childs = new SimpleTreeNode [CAPACITY];
        childcnt = 0;
    }

    public void addChild (SimpleTreeNode child)
    {
        if (childcnt >= CAPACITY) 
        {
            CAPACITY *= 2; // Kapazitaets-Verdopplung
            SimpleTreeNode[] newchilds = new SimpleTreeNode [CAPACITY];

            for (int i = 0; i < childcnt; i++) 
            {
                newchilds[i] = childs[i]; // alte Kinder eintragen
            }
            
            childs = newchilds;
        }
        
        childs[childcnt++] = child; // neues Kind einfuegen
    }

    public int getChildCnt()
    {
        return childcnt;
    }

    public SimpleTreeNode getChild(int pos)
    {
        return childs[pos];
    }
    
    public String toString()
    {
        return name;        
    }
}