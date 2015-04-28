// LinkedList1 class
//
// CONSTRUCTION: with no initializer
// Access is via LinkedList1Iterator class
//
// ******************PUBLIC OPERATIONS*********************
// boolean isEmpty( )     --> Return true if empty; else false
// void makeEmpty( )      --> Remove all items
// LinkedList1Iterator zeroth( )
//                        --> Return position to prior to first
// LinkedList1Iterator first( )
//                        --> Return first position
// void insert( x, p )    --> Insert x after current iterator position p
// void remove( x )       --> Remove x
// LinkedList1Iterator find( x )
//                        --> Return position that views x
// LinkedList1Iterator findPrevious( x )
//                        --> Return position prior to x
// ******************ERRORS********************************
// No special errors

/**
 * Linked list implementation of the list
 *    using a header node.
 * Access to the list is via LinkedList1Iterator.
 * @author Mark Allen Weiss
 * @see LinkedList1Iterator
 */
public class LinkedList1 {
    /**
     * Construct the list
     */
    public LinkedList1( ) {
        header = new ListNode( null );
    }
    
    /**
     * Test if the list is logically empty.
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty( ) {
        return header.next == null;
    }
    
    /**
     * Make the list logically empty.
     */
    public void makeEmpty( ) {
        header.next = null;
    }
    
    /**
     * Return an iterator representing the header node.
     */
    public LinkedList1Iterator zeroth( ) {
        return new LinkedList1Iterator( header );
    }
    
    /**
     * Return an iterator representing the first node in the list.
     * This operation is valid for empty lists.
     */
    public LinkedList1Iterator first( ) {
        return new LinkedList1Iterator( header.next );
    }
    
    /**
     * Insert after p.
     * @param x the item to insert.
     * @param p the position prior to the newly inserted item.
     */
    public void insert( Object x, LinkedList1Iterator p ) {
        if( p != null && p.current != null )
            p.current.next = new ListNode( x, p.current.next );
    }
    
    /**
     * Return iterator corresponding to the first node containing an item.
     * @param x the item to search for.
     * @return an iterator; iterator is not valid if item is not found.
     */
    public LinkedList1Iterator find( Object x ) {
        ListNode itr = header.next;
        
        while( itr != null && !itr.element.equals( x ) )
            itr = itr.next;
        
        return new LinkedList1Iterator( itr );
    }
    
    /**
     * Return iterator prior to the first node containing an item.
     * @param x the item to search for.
     * @return appropriate iterator if the item is found. Otherwise, the
     * iterator corresponding to the last element in the list is returned.
     */
    public LinkedList1Iterator findPrevious( Object x ) {
        ListNode itr = header;
        
        while( itr.next != null && !itr.next.element.equals( x ) )
            itr = itr.next;
        
        return new LinkedList1Iterator( itr );
    }
    
    /**
     * Remove the first occurrence of an item.
     * @param x the item to remove.
     */
    public void remove( Object x ) {
        LinkedList1Iterator p = findPrevious( x );
        
        if( p.current.next != null )
            p.current.next = p.current.next.next;  // Bypass deleted node
    }
    
    public ListNode findKthFromLast(int k)
    {
    	ListNode fast = header;
    	ListNode slow = header;
    	if(header == null || k == 0)
    		return null;
    	for(int i = 0;i<k-1;i++){
    		if(fast == null)
    			return null;
    		fast = fast.next;
    	}
    	while(fast.next != null)
    	{
    		slow = slow.next;
    		fast = fast.next;
    	}
    	System.out.println("kth node is "+slow.element);
    	return slow;
    }
    // Simple print method
    public static void printList( LinkedList1 theList ) {
        if( theList.isEmpty( ) )
            System.out.print( "Empty list" );
        else {
            LinkedList1Iterator itr = theList.first( );
            for( ; itr.isValid( ); itr.advance( ) )
                System.out.print( itr.retrieve( ) + " " );
        }
        
        System.out.println( );
    }
    
    private ListNode header;
    
    // In this routine, LinkedList1 and LinkedList1Iterator are the
    // classes written in Section 17.2.
    public static int listSize( LinkedList1 theList ) {
        LinkedList1Iterator itr;
        int size = 0;
        
        for( itr = theList.first(); itr.isValid(); itr.advance() )
            size++;
        
        return size;
    }
    
    public static void main( String [ ] args ) {
        LinkedList1         theList = new LinkedList1( );
        LinkedList1Iterator theItr;
        int i;
        
        theItr = theList.zeroth( );
        printList( theList );
        
        for( i = 1; i < 10; i++ ) {
            theList.insert( new Integer( i ), theItr );
            //printList( theList );
            theItr.advance( );
        }
        System.out.println( "Size was: " + listSize( theList ) );
        
//        for( i = 0; i < 10; i += 2 )
//            theList.remove( new Integer( i ) );
//        
//        for( i = 0; i < 10; i++ )
//            if( ( i % 2 == 0 ) == ( theList.find( new Integer( i ) ).isValid( ) ) )
//                System.out.println( "Find fails!" );
//        
//        System.out.println( "Finished deletions" );
        printList( theList );
        theList.findKthFromLast(4);
        theList.swapKthNodes(4);
        theList.moveLastToBegin();
        printList(theList);
    }

	private void swapKthNodes(int k) {
		ListNode last = findKthFromLast(k);
		ListNode head = header;
		for(int i = 0;i < k; i++)
			head = head.next;
		int temp = (int) last.element;
		last.element = head.element;
		head.element = temp;
	}
	
	private void moveLastToBegin(){
		ListNode last = null;
		ListNode head = header;
		ListNode itr = header;
		while(itr.next.next != null)
			itr = itr.next;
		last = itr.next;
		itr.next = null;
		last.next = header.next;
		header.next = last;
	}
    
}


// LinkedList1Iterator class; maintains "current position"
//
// CONSTRUCTION: Package visible only, with a ListNode
//
// ******************PUBLIC OPERATIONS*********************
// void advance( )        --> Advance
// boolean isValid( )     --> True if at valid position in list
// Object retrieve        --> Return item in current position

/**
 * Linked list implementation of the list iterator
 *    using a header node.
 * @author Mark Allen Weiss
 * @see LinkedList1
 */
class LinkedList1Iterator {
    /**
     * Construct the list iterator
     * @param theNode any node in the linked list.
     */
    LinkedList1Iterator( ListNode theNode ) {
        current = theNode;
    }
    
    /**
     * Test if the current position is a valid position in the list.
     * @return true if the current position is valid.
     */
    public boolean isValid( ) {
        return current != null;
    }
    
    /**
     * Return the item stored in the current position.
     * @return the stored item or null if the current position
     * is not in the list.
     */
    public Object retrieve( ) {
        return isValid( ) ? current.element : null;
    }
    
    /**
     * Advance the current position to the next node in the list.
     * If the current position is null, then do nothing.
     */
    public void advance( ) {
        if( isValid( ) )
            current = current.next;
    }
    
    ListNode current;    // Current position
}


// Basic node stored in a linked list
// Note that this class is not accessible outside
// of package weiss.nonstandard

class ListNode {
    // Constructors
    public ListNode( Object theElement ) {
        this( theElement, null );
    }
    
    public ListNode( Object theElement, ListNode n ) {
        element = theElement;
        next    = n;
    }
    
    public Object   element;
    public ListNode next;
}