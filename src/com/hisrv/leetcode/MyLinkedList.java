package com.hisrv.leetcode;

public class MyLinkedList<T> {

	private Node<T> mHead = null;
	private Node<T> mRear = null;

	public static class Node<T> {
		public Node<T> next;
		public T value;

		public Node(T value, Node<T> next) {
			this.value = value;
			this.next = next;
		}
	}
	
	public void print() {
		if (mHead == null) {
			System.out.print("null\n");
			return;
		}
		Node<T> p = mHead;
		while (p != null) {
			System.out.print(p.value);
			System.out.print(" ");
			p = p.next;
		}
		System.out.print("\n");
	}
	
	public void pushBack(Node<T> node) {
		if (mHead == null) {
			mHead = node;
			mRear = mHead;
		} else {
			mRear.next = node;
			mRear = mRear.next;
		}
	}

	public void reverse() {
		if (mHead == null) {
			return;
		}
		Node<T> p, q, r = null;
		p = mHead;
		q = p.next;
		p.next = null;
		while (q != null) {
			r = q.next;
			q.next = p;
			p = q;
			q = r;
		}
		mHead = p;
	}

}
