package com.charter.tonym.spectrumrewards.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class MyRewardsServiceImplTest {

    @Mock
    CustomerService customerService;

    @Mock
    TransactionService transactionService;

    //fixture under test
    MyRewardsServiceImpl myRewardsService;
    private
    @BeforeEach
    void setUp() {
        myRewardsService = new MyRewardsServiceImpl(customerService, transactionService);
    }

    @Test
    public void testCalculateRewardsPoints_ZeroPoints() throws Exception {

        Double value = 20.00;

        Integer result = myRewardsService.calculateRewardsPoints(value);

        assertEquals(0, result);

    }

    @Test
    public void testCalculateRewardsPoints_CorrectPoints() throws Exception {

        Double value = 350.00;

        Integer result = myRewardsService.calculateRewardsPoints(value);

        assertEquals(550, result);

    }

    @Test
    public void testCalculateRewardsPoints_IncorrectExpectedPoints() throws Exception {

        Double value = 120.00;

        Integer result = myRewardsService.calculateRewardsPoints(value);

        assertNotEquals(80, result);

    }
}