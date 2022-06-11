package com.yang.linkedlist;

import java.util.Objects;

/**
 * @author YangFeng
 * @create 2021-08-01 9:45
 */
public class CircleNode {
    int id;
    CircleNode next;

    public CircleNode(){

    }

    public CircleNode(int id, CircleNode next) {
        this.id = id;
        this.next = next;
    }

    @Override
    public String toString() {
        return "CircleNode{" +
                "id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CircleNode that = (CircleNode) o;
        return id == that.id && Objects.equals(next, that.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, next);
    }
}
