package me.jerrywang.scala.study.algorithms.leetcode

import scala.collection.mutable

// LC 146
case class DoubleLinkedNode(var key: Int = 0, var value: Int = 0, var prev: DoubleLinkedNode = null, var next: DoubleLinkedNode = null)

class LRUCache(cache: mutable.HashMap[Int, DoubleLinkedNode], size: Int, capacity: Int, head: DoubleLinkedNode, tail: DoubleLinkedNode) {

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

  def this(capacity: Int) {
    this(cache = mutable.HashMap.empty, size = 0, capacity = capacity, head = DoubleLinkedNode(), tail = DoubleLinkedNode())

    head.prev = null
    tail.next = null

    head.next = tail
    tail.prev = head
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

  def main(args: Array[String]): Unit = {
    val lruCache = new LRUCache(10)

    for (i <- 0 until 12)
      lruCache.put(i, i + 10)

    println(lruCache.get(1))
    println(lruCache.get(11))
    println(lruCache.get(12))
  }
}
