package org.perfcake.arquillian;

import org.junit.Assert;
import org.perfcake.scenario.PerfCakeController;
import org.perfcake.perfcontrol.api.PerfControl;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;

import org.junit.*;
import org.junit.runner.RunWith;


@RunWith(Arquillian.class)
@RunAsClient
public class PerfControlTest {

    @Deployment
    public static JavaArchive createDeployment() {
        JavaArchive jar = ShrinkWrap.create(JavaArchive.class)
                .addClass(PerfControl.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "perfcake.xml");
        System.out.println(jar.toString(true));
        return jar;
    }

    @PerfControl(scenario = "perfcake.xml")
    private static PerfCakeController perfCake;

    @Test
    public void firstPerformanceTest() throws InterruptedException {
        long tm = System.currentTimeMillis();
        perfCake.run();
        tm = System.currentTimeMillis() - tm;
        Thread.sleep(10);
        perfCake.close();
        org.testng.Assert.assertTrue(tm < 10000, String.format("The scenario did not fail fast enough. Time needed to fail: %d", tm));

    }

    @BeforeClass
    public static void assertContainerControllerExistInBeforeClass()
    {
    }

    @Before
    public void assertContainerControllerExistInBefore()
    {
    }

    @Test
    public void assertThatContainerControllerExistInTest() throws IllegalAccessException {
        Assert.assertEquals("Ahoj",
                perfCake.hello());
        System.out.println(perfCake);
    }

    @After
    public void assertContainerControllerExistInAfter()
    {
    }

    @AfterClass
    public static void assertContainerControllerExistInAfterClass()
    {
    }

}

