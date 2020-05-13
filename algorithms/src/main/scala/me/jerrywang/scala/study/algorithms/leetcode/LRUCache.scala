package me.jerrywang.scala.study.algorithms.leetcode

import scala.collection.mutable

// LC 146
case class DoubleLinkedNode(var key: Int = 0, var value: Int = 0, var prev: DoubleLinkedNode = null, var next: DoubleLinkedNode = null)

case class LRUCache(cache: mutable.HashMap[Int, DoubleLinkedNode] = mutable.HashMap.empty, capacity: Int = 0, head: DoubleLinkedNode = null, tail: DoubleLinkedNode = null) {

  private def addNode(node: DoubleLinkedNode): Unit = {
    node.prev = head
    node.next = head.next

    head.next.prev = node
    head.next = node
  }

  private def removeNode(node: DoubleLinkedNode): Unit = {
    val prev = node.prev
    val next = node.next

    prev.next = next
    next.prev = prev
  }

  private def moveToHead(node: DoubleLinkedNode): Unit = {
    removeNode(node)
    addNode(node)
  }

  private def popTail(): DoubleLinkedNode = {
    val node = tail.prev
    removeNode(node)
    node
  }

  def get(key: Int): Int = {
    cache.get(key) match {
      case None => -1
      case Some(node) =>
        moveToHead(node)
        node.value
    }
  }

  def put(key: Int, value: Int): Unit = {
    cache.get(key) match {
      case None =>
        val newNode = DoubleLinkedNode(key, value)
        cache.put(key, newNode)
        addNode(newNode)

        if (cache.size > capacity) {
          val tail = popTail()
          cache.remove(tail.key)
        }
      case Some(node) =>
        node.value = value
        moveToHead(node)
    }
  }
}

object LRUCache {

  def apply(capacity: Int): LRUCache = {
    val lruCache = new LRUCache(capacity = capacity, head = DoubleLinkedNode(), tail = DoubleLinkedNode())
    lruCache.head.next = lruCache.tail
    lruCache.tail.prev = lruCache.head
    lruCache
  }

  def main(args: Array[String]): Unit = {
    val lruCache = LRUCache(10)

    for (i <- 0 until 12)
      lruCache.put(i, i + 10)

    println(lruCache.get(1))
    println(lruCache.get(11))
    println(lruCache.get(12))
  }
}
