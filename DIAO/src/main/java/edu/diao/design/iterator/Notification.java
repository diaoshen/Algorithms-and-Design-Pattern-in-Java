package edu.diao.design.iterator;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

//A Java program to demonstrate implementation 
//of iterator pattern with the example of 
//notifications 

/*
 * This uses iterator interface provided by java
 * the 2 collection used to store Notification Object are:
 * 1. ArrayList
 * 2. List
 * 
 * Both uses java iterator to iterator the collection ArrayList and List
 * 
 * See Version 2 for writing your own iterator 
 */

//A simple Notification class 
class Notification 
{ 
	// To store notification message 
	String notification; 

	public Notification(String notification) 
	{ 
		this.notification = notification; 
	} 
	public String getNotification() 
	{ 
		return notification; 
	} 
} 

//Collection interface 
interface Collection<T>
{ 
	public  Iterator<T> createIterator(); 
} 

//Collection of notifications 
class NotificationCollection implements Collection<Notification>
{ 
	static final int MAX_ITEMS = 6; 
	int numberOfItems = 0; 
	ArrayList<Notification> notificationList;
	public NotificationCollection() 
	{ 
		notificationList = new ArrayList<Notification>(MAX_ITEMS);

		// Let us add some dummy notifications 
		addItem("Notification 1"); 
		addItem("Notification 2"); 
		addItem("Notification 3"); 
	} 

	public void addItem(String str) 
	{ 
		Notification notification = new Notification(str); 
		if (numberOfItems >= MAX_ITEMS) 
			System.err.println("Full"); 
		else
		{ 
			notificationList.add(notification);
		} 
	} 

	public  Iterator<Notification> createIterator() 
	{ 
		return notificationList.iterator();
		//return  new NotificationIterator(notificationList); 
	} 
} 

class NotificationCollectionV2 implements Collection<Notification> 
{ 
	static final int MAX_ITEMS = 6; 
	int numberOfItems = 0; 
	Notification notificationList[];
	public NotificationCollectionV2() 
	{ 
		notificationList = new Notification[MAX_ITEMS];

		// Let us add some dummy notifications 
		addItem("Notification 4"); 
		addItem("Notification 5"); 
		addItem("Notification 6"); 
	} 

	public void addItem(String str) 
	{ 
		Notification notification = new Notification(str); 
		if (numberOfItems >= MAX_ITEMS) 
			System.err.println("Full"); 
		else
		{ 
			notificationList[numberOfItems++] = notification;
		} 
	} 

	public Iterator<Notification> createIterator() 
	{ 
		List<Notification> list =  Arrays.asList(notificationList);
		return list.iterator();
		//return new NotificationIteratorV2(notificationList); 
	} 
} 

//We could also use Java.Util.Iterator 
/*interface Iterator
{ 
	// indicates whether there are more elements to 
	// iterate over 
	boolean hasNext(); 

	// returns the next element 
	Object next(); 
} 
*/


/*
 * Use ArrayList to Implement Notification Iterator
 * 
 */
//Notification iterator 
/*class NotificationIterator implements Iterator
{ 
	ArrayList<Notification> notificationList;

	// maintains curr pos of iterator over the array 
	int pos = 0; 

	// Constructor takes the array of notifiactionList are 
	// going to iterate over. 
	public NotificationIterator (ArrayList<Notification> notificationList) 
	{ 
		this.notificationList = notificationList; 
	} 

	public Object next() 
	{ 
		// return next element in the array and increment pos 
		Notification notification = notificationList.get(pos);
		pos += 1; 
		return notification; 
	} 

	public boolean hasNext() 
	{ 
		if (pos >= notificationList.size() || 
			notificationList.get(pos) == null) 
			return false; 
		else
			return true; 
	} 
} */

/*class NotificationIteratorV2 implements Iterator<Object> 
{ 
    Notification[] notificationList; 
  
    // maintains curr pos of iterator over the array 
    int pos = 0; 
  
    // Constructor takes the array of notifiactionList are 
    // going to iterate over. 
    public  NotificationIteratorV2 (Notification[] notificationList) 
    { 
        this.notificationList = notificationList; 
    } 
  
    public Object next() 
    { 
        // return next element in the array and increment pos 
        Notification notification =  notificationList[pos]; 
        pos += 1; 
        return notification; 
    } 
  
    public boolean hasNext() 
    { 
        if (pos >= notificationList.length || 
            notificationList[pos] == null) 
            return false; 
        else
            return true; 
    } 
} */


//Contains collection of notifications as an object of 
//NotificationCollection 
class NotificationBar
{ 
	NotificationCollection notifications; 
	NotificationCollectionV2 notificationsV2;

	public NotificationBar(NotificationCollection notifications , NotificationCollectionV2 noticationsV2) 
	{ 
		this.notifications = notifications; 
		this.notificationsV2 = noticationsV2;
	} 

	public void printNotifications() 
	{ 
		Iterator<Notification> iterator = notifications.createIterator(); 
		Iterator<Notification> iteratorV2 = notificationsV2.createIterator();
		System.out.println("-------NOTIFICATION BAR------------"); 
		while (iterator.hasNext()) 
		{ 
			Notification n = (Notification)iterator.next(); 
			System.out.println(n.getNotification()); 
		} 
		while (iteratorV2.hasNext()) 
		{
			Notification n = (Notification)iteratorV2.next(); 
			if(n != null)
			System.out.println(n.getNotification()); 
		} 
	} 
} 

//Driver class 
class Main 
{ 
	public static void main(String args[]) 
	{ 
		NotificationCollection nc = new NotificationCollection(); 
		NotificationCollectionV2  nc2 = new NotificationCollectionV2();
		NotificationBar nb = new NotificationBar(nc,nc2); 
		nb.printNotifications(); 
	} 
} 

