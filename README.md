data-structures
===============

This repo is inspired by my data structures class. It's my implentation of a postfix calculator using some basic provided files.

Use it by initializing a new PostFix with a QueueList as an argument, as in:

 QueueList<String> q = new QueueList<String>();
	    
	    q.enqueue("1");
	    q.enqueue("2");
	    q.enqueue("+");
	    q.enqueue("3");
	    q.enqueue("*");
	    q.enqueue("6");
	    q.enqueue("+");
	    q.enqueue("2");
	    q.enqueue("3");
	    q.enqueue("+");
	    q.enqueue("/");

	
	    PostFix pf = new PostFix(q);
	    
	    
and then calling any of the methods from the PostFix class.
