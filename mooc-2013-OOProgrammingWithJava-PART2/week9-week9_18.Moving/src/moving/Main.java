package moving;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import moving.domain.Box;
import moving.domain.Item;
import moving.domain.Thing;
import moving.logic.Packer;

public class Main {

    public static void main(String[] args) {
        // test your program here
//        List<Item> items = new ArrayList<Item>();
//        items.add(new Item("passport", 2));
//        items.add(new Item("toothbrush", 1));
//        items.add(new Item("circular saw", 100));
//
//        Collections.sort(items);
//        System.out.println(items);
//
//        Box box = new Box(101);
//
//        for (Item item : items) {
//            System.out.println(box.addThing(item));
//        }
//        System.out.println(box);

        List<Thing> things = new ArrayList<Thing>();
        things.add(new Item("passport", 2));
        things.add(new Item("toothbrash", 1));
        things.add(new Item("book", 4));
        things.add(new Item("circular saw", 8));

        // we create a packer which uses boxes whose valume is 10
        Packer packer = new Packer(10);

        // we ask our packer to pack things into boxes
        List<Box> boxes = packer.packThings(things);

        System.out.println("number of boxes: " + boxes.size());

        for (Box box : boxes) {
            System.out.println("  things in the box: " + box.getVolume() + " dm^3");
        }

    }
}
