package com.gildedrose;

import org.junit.jupiter.api.*;


import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class GildedRoseTest {

    static Item[] items;
    static GildedRose gildedRose;
    @BeforeAll
    static void setUp() {
        items = new Item[] {
            new Item("+5 Dexterity Vest", 10, 20), //
            new Item("Aged Brie", 2, 0), //
            new Item("Elixir of the Mongoose", 5, 7), //
            new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
            new Item("Sulfuras, Hand of Ragnaros", -1, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
            new Item("Conjured Mana Cake", 3, 6),
            new Item("Conjured More Cake", 1, 24) };
        gildedRose = new GildedRose(items);
    }

    @Test
    @Order(1)
    void testOneDay() {
        gildedRose.updateQuality();

        assertEquals(9, gildedRose.items[0].sellIn);
        assertEquals(19, gildedRose.items[0].quality);

        assertEquals(1, gildedRose.items[1].sellIn);
        assertEquals(1, gildedRose.items[1].quality);

        assertEquals(4, gildedRose.items[2].sellIn);
        assertEquals(6, gildedRose.items[2].quality);

        assertEquals(2, gildedRose.items[8].sellIn);
        assertEquals(4, gildedRose.items[8].quality);

        assertEquals(0, gildedRose.items[9].sellIn);
        assertEquals(22, gildedRose.items[9].quality);
    }

    @Test
    @Order(2)
    void testSecondDay() {
        gildedRose.updateQuality();

        assertEquals(gildedRose.items[0].sellIn,8);
        assertEquals(gildedRose.items[0].quality,18);

        assertEquals(0, gildedRose.items[1].sellIn);
        assertEquals(2, gildedRose.items[1].quality);

        assertEquals(3, gildedRose.items[2].sellIn);
        assertEquals(5, gildedRose.items[2].quality);

        assertEquals(1, gildedRose.items[8].sellIn);
        assertEquals(2, gildedRose.items[8].quality);

        assertEquals(-1, gildedRose.items[9].sellIn);
        assertEquals(18, gildedRose.items[9].quality);
    }

    @Test
    @Order(3)
    void testThirdDay() {
        gildedRose.updateQuality();

        assertEquals(gildedRose.items[0].sellIn,7);
        assertEquals(gildedRose.items[0].quality,17);

        assertEquals(-1, gildedRose.items[1].sellIn);
        assertEquals(4, gildedRose.items[1].quality);

        assertEquals(2, gildedRose.items[2].sellIn);
        assertEquals(4, gildedRose.items[2].quality);

        assertEquals(0, gildedRose.items[8].sellIn);
        assertEquals(0, gildedRose.items[8].quality);

        assertEquals(-2, gildedRose.items[9].sellIn);
        assertEquals(14, gildedRose.items[9].quality);
    }

    @Test
    @Order(4)
    void testFourthDay() {
        gildedRose.updateQuality();

        assertEquals(gildedRose.items[0].sellIn,6);
        assertEquals(gildedRose.items[0].quality,16);

        assertEquals(-2, gildedRose.items[1].sellIn);
        assertEquals(6, gildedRose.items[1].quality);

        assertEquals(-1, gildedRose.items[8].sellIn);
        assertEquals(0, gildedRose.items[8].quality);
    }

    @Test
    @Order(5)
    void testFifthDay() {
        gildedRose.updateQuality();

        assertEquals(gildedRose.items[0].sellIn,5);
        assertEquals(gildedRose.items[0].quality,15);

        assertEquals(-3, gildedRose.items[1].sellIn);
        assertEquals(8, gildedRose.items[1].quality);

        assertEquals(-2, gildedRose.items[8].sellIn);
        assertEquals(0, gildedRose.items[8].quality);
    }
}
