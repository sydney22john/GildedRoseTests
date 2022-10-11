package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void unmutatedName() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void sellInBoundaryLow() {
        Item[] items = new Item[] {new Item("lowBoundary", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, items[0].sellIn);
    }

    @Test
    void sellInBoundaryHigh() {
        Item[] items = new Item[] {new Item("lowBoundary", 11, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(10, items[0].sellIn);
    }

    @Test
    void happyPathBrie() {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 49) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(50, items[0].quality);
        assertEquals(9, items[0].sellIn);
    }

    @Test
    void HappyPathBackstage() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(50, items[0].quality);
        assertEquals(9, items[0].sellIn);
    }

    @Test
    void negativeTest() {
        Item[] items = new Item[] { new Item("Aged Brie", 10, -50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals("Aged Brie", items[0].name);
        assertEquals(9, items[0].sellIn);
        assertEquals(-49, items[0].quality);
    }

    @Test
    void qualityLowerBoundary() {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(1, items[0].quality);
    }

    @Test
    void qualityHighBoundary() {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(50, items[0].quality);
    }

    @Test
    void happyPathBrieBoundariesLow() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(-1, items[0].sellIn);
        assertEquals(2, items[0].quality);
    }

    @Test
    void happyPathBrieBoundariesHigh() {
        Item[] items = new Item[] { new Item("Aged Brie", 11, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(10, items[0].sellIn);
        assertEquals(50, items[0].quality);
    }

    @Test
    void happyPathBackstageBoundariesLow() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(-1, items[0].sellIn);
        assertEquals(0, items[0].quality);
    }

    @Test
    void happyPathBackstageBoundariesHigh() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 11, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(10, items[0].sellIn);
        assertEquals(50, items[0].quality);
    }

    @Test
    void happyPathSulfurasBoundariesHigh() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 11, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(11, items[0].sellIn);
        assertEquals(50, items[0].quality);
    }

    @Test
    void happyPathSulfurasBoundariesLow() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(0, items[0].sellIn);
        assertEquals(0, items[0].quality);
    }
}
