package org.example;

import org.example.models.DPK03;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class DPK02_impl_1Test {

    Map<String, DPK03> dataMap = Map.of(
            "001", new DPK03("001", "Alice"),
            "002", new DPK03("002", "Bob"),
            "003", new DPK03("003", "Charlie"),
            "004", new DPK03("004", "Diana"),
            "005", new DPK03("005", "Ethan"),
            "006", new DPK03("006", "Fiona")
    );

    @Test
    public void lookupById() {

        String searchId = "002";
        DPK03 result = DPK02_impl_1.lookupById(dataMap, searchId);
        assertNotNull(result);
        assertEquals("Bob", result.getName());
        System.out.println(result);
    }

    @Test
    public void lookupByName() {
        String searchName = "Charlie";
        DPK03 result = DPK02_impl_1.lookupByName(dataMap, searchName);
        assertNotNull(result);
        assertEquals("003", result.getId());
        System.out.println(result);
    }
}