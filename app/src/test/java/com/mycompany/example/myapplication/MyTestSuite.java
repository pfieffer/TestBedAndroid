package com.mycompany.example.myapplication;

import com.mycompany.example.myapplication.categories.FastTests;
import com.mycompany.example.myapplication.categories.GoogleMapsIntegrationTests;
import com.mycompany.example.myapplication.categories.SlowTests;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/*
A test suite is a collection of tests that might include or exclude test categories
 */
@RunWith(Categories.class)
@Categories.IncludeCategory({FastTests.class}) //This test suite includes all tests from FastTests Category
@Categories.ExcludeCategory({SlowTests.class}) //This test suite includes all tests from  SlowTests Category
@Suite.SuiteClasses({SimpleMathTest.class, AnotherTest.class}) //This test suite has all tests from SimpleMathTest and AnotherTest
public class MyTestSuite {
}
