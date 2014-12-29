package pack1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import org.junit.Test;

class Vertex {
    String label;
    boolean wasVisited;
    List<Vertex> listOfFriends = new ArrayList<Vertex>();

    Vertex(final String label, final boolean wasVisited) {
        this.label = label;
        this.wasVisited = wasVisited;
    }
}

public class Friendship {

    List<Vertex> listOfVertex = new ArrayList<Vertex>();

    void makeFriends(final String name1, final String name2) {
        Vertex newVertex1 = null;
        Vertex newVertex2 = null;

        for (final Vertex v : listOfVertex) {
            if (v.label.equals(name1)) {
                newVertex1 = v;
            }
        }
        if (newVertex1 == null) {
            newVertex1 = new Vertex(name1, false);
            listOfVertex.add(newVertex1);
        }

        for (final Vertex v : listOfVertex) {
            if (v.label.equals(name2)) {
                newVertex2 = v;
            }
        }
        if (newVertex2 == null) {
            newVertex2 = new Vertex(name2, false);
            listOfVertex.add(newVertex2);
        }

        newVertex1.listOfFriends.add(newVertex2);
        newVertex2.listOfFriends.add(newVertex1);

    }

    void unmakeFriend(final String name1, final String name2) {
        Vertex newVertex1 = null;
        Vertex newVertex2 = null;

        for (final Vertex v : listOfVertex) {
            if (v.label.equals(name1)) {
                newVertex1 = v;
                break;
            }
        }

        for (final Vertex v : listOfVertex) {
            if (v.label.equals(name2)) {
                newVertex2 = v;
                break;
            }
        }

        newVertex1.listOfFriends.remove(newVertex2);
        newVertex2.listOfFriends.remove(newVertex1);

    }

    Set<String> getDirectFriends(final String name) {

        Vertex newVertex = null;
        for (final Vertex v : listOfVertex) {
            if (v.label.equals(name)) {
                newVertex = v;
            }
        }

        final Set<String> nameOfDirectFriends = new HashSet<String>();

        for (final Vertex v : newVertex.listOfFriends) {

            nameOfDirectFriends.add(v.label);
        }
        return nameOfDirectFriends;

    }

    Set<String> doBFS(final Vertex friend) {
        friend.wasVisited = true;
        final Set<String> listOfIndirectFriends = new HashSet<String>();
        // listOfIndirectFriends.add(friend.label);
        final Queue<Vertex> queue = new java.util.LinkedList<Vertex>();
        queue.add(friend);

        while (!queue.isEmpty()) {
            final Vertex v2 = queue.remove();
            for (final Vertex v : v2.listOfFriends) {
                if (!v.wasVisited) {
                    v.wasVisited = true;
                    listOfIndirectFriends.add(v.label);
                    queue.add(v);
                }
            }
        }

        for (final Vertex v : listOfVertex) {
            v.wasVisited = false;
        }

        return listOfIndirectFriends;

    }

    Set<String> getIndirectFriends(final String name) {

        final Set<String> listOfAllIndirectFriends = new HashSet<String>();

        Vertex newVertex = null;
        for (final Vertex v : listOfVertex) {
            if (v.label.equals(name)) {
                newVertex = v;
            }
        }
        for (final Vertex v : newVertex.listOfFriends) {
            listOfAllIndirectFriends.addAll(doBFS(v));
        }
        listOfAllIndirectFriends.remove(name);
        for (final Vertex v : newVertex.listOfFriends) {
            listOfAllIndirectFriends.remove(v.label);
        }

        return listOfAllIndirectFriends;

    }

    @Test
    public void testGetDirectFriends() {
        makeFriends("A", "B");
        makeFriends("B", "C");
        makeFriends("B", "D");
        makeFriends("D", "E");
        makeFriends("C", "F");
        for (final String s : getDirectFriends("D")) {
            // System.out.println(s);
        }

        for (final String s : getIndirectFriends("B")) {
            System.out.println(s);
        }
    }

    public static void main(final String args[]) {
        final Friendship friendship = new Friendship();
        // friendship.testGetDirectFriends();
    }
}
