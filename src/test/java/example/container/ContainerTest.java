package example.container;

import junit.framework.TestCase;
import org.junit.Assert;

public class ContainerTest extends TestCase {

    public void testAdd() {
        Container container = new Container();
        Item newItem = new Item(1);
        container.add(newItem);
        Assert.assertTrue(container.contains(newItem));
    }

    public void testRemove() {
        Container container = new Container();
        Item newItem = new Item(1);
        container.add(newItem);
        container.remove(newItem);
        Assert.assertFalse(container.contains(newItem));
    }

    public void testGet() {
        Container container = new Container();
        Item firstItem = new Item(1);
        container.add(firstItem);
        Assert.assertEquals(1, container.get(0).getId());
    }

    public void testSize() {
        Container container = new Container();
        Item firstItem = new Item(1);
        Item secondItem = new Item(2);
        container.add(firstItem);
        container.add(secondItem);
        Assert.assertEquals(2, container.size());
    }
}