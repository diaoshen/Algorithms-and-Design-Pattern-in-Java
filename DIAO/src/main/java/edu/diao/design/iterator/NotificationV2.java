package edu.diao.design.iterator;

import java.util.ArrayList;

//A Java program to demonstrate implementation 
//of iterator pattern with the example of 
//notifications 



//A simple Notification class 
class NotificationV2
{ 
	// To store notification message 
	String notification; 

	public NotificationV2(String notification) 
	{ 
		this.notification = notification; 
	} 
	public String getNotification() 
	{ 
		return notification; 
	} 
} 

//Collection interface that provides the method that returns iterator
interface iterable
{ 
	public  Iterator createIterator(); 
} 

//Collection of notifications 
class NotificationCollectionV3 implements iterable
{ 
	static final int MAX_ITEMS = 6; 
	int numberOfItems = 0; 
	ArrayList<Notification> notificationList; //Stores Notification using ArrayList
	
	public NotificationCollectionV3() 
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

	public  Iterator createIterator() 
	{ 
		return  new NotificationIteratorV3(notificationList); 
	} 
} 

class NotificationCollectionV4 implements iterable
{ 
	static final int MAX_ITEMS = 6; 
	int numberOfItems = 0; 
	Notification notificationList[];
	
	public NotificationCollectionV4() 
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

	public Iterator createIterator() 
	{ 
		return new NotificationIteratorV4(notificationList); 
	} 
} 

//We could also use Java.Util.Iterator which looks exactly the same as the one I'm making
interface Iterator
{ 
	// indicates whether there are more elements to 
	// iterate over 
	boolean hasNext(); 

	// returns the next element 
	Object next(); 
} 



/*
 * Use ArrayList to Implement Notification Iterator
 * 
 */
//Notification iterator 
class NotificationIteratorV3 implements Iterator
{ 
	ArrayList<Notification> notificationList;

	// maintains curr pos of iterator over the array 
	int pos = 0; 

	// Constructor takes the array of notifiactionList are 
	// going to iterate over. 
	public NotificationIteratorV3 (ArrayList<Notification> notificationList) 
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
} 

class NotificationIteratorV4 implements Iterator
{ 
    Notification[] notificationList; 
  
    // maintains curr pos of iterator over the array 
    int pos = 0; 
  
    // Constructor takes the array of notifiactionList are 
    // going to iterate over. 
    public  NotificationIteratorV4 (Notification[] notificationList) 
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
} 


//Contains collection of notifications as an object of 
//NotificationCollection 
class NotificationBarV2
{ 
	NotificationCollectionV3 notifications; 
	NotificationCollectionV4 notificationsV2;

	public NotificationBarV2(NotificationCollectionV3 notifications , NotificationCollectionV4 noticationsV2) 
	{ 
		this.notifications = notifications; 
		this.notificationsV2 = noticationsV2;
	} 

	public void printNotifications() 
	{ 
		Iterator iterator = notifications.createIterator(); 
		Iterator iteratorV2 = notificationsV2.createIterator();
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
class MainV2
{ 
	public static void main(String args[]) 
	{ 
		NotificationCollection nc = new NotificationCollection(); 
		NotificationCollectionV2  nc2 = new NotificationCollectionV2();
		NotificationBar nb = new NotificationBar(nc,nc2); 
		nb.printNotifications(); 
	} 
} 

