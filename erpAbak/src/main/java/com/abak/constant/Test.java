package com.abak.constant;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.out.println(new String("a")=="a");
		
	}

	
	public Node rotateList(Node head, int n) {
		
		int slowPointer = 0;
		int fastpointer = 0;
		Node fastNode=new Node();
		Node sloNode=new Node();
		
		fastNode.setNext(head);
		sloNode.setNext(head);
		
		while (fastNode!=null) {
			
			fastNode.setNext(head.getNext());
			
			if(fastpointer < 1) {
				slowPointer++;
				sloNode.setNext(head.getNext());
			}
		
			fastpointer++;
		};
		
		
		for(int i=0;i<slowPointer;i++) {
			
			sloNode.setNext(head);
			head.setNext(head);
			
		}
		
		
		return sloNode;
	}
	
	
}
