package org.vaadin.addons.badge;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.interactions.Actions;

import com.vaadin.flow.component.html.testbench.DivElement;
import com.vaadin.flow.component.html.testbench.SpanElement;
import com.vaadin.testbench.TestBenchElement;
import com.vaadin.testbench.screenshot.ImageFileUtil;

public class BadgeIT extends AbstractViewTest {

    public BadgeIT() {
        super("");
    }

    @Override
    public void setup() throws Exception {
        super.setup();

        // Hide dev mode gizmo, it would interfere screenshot tests
        $("vaadin-dev-tools").first().setProperty("hidden", true);
        $("copilot-main").first().setProperty("hidden", true);
    }

    @Test
    public void themePropagationWorksEtc() {
        BadgeElement badge = $(BadgeElement.class).first();
        SpanElement internalSpan = badge.$(SpanElement.class).first();
        Assert.assertEquals("text",internalSpan.getText());
        Assert.assertTrue(internalSpan.getDomAttribute("theme").contains("badge"));
        badge = $(BadgeElement.class).all().get(1);
        internalSpan = badge.$(SpanElement.class).first();
        Assert.assertTrue(internalSpan.getDomAttribute("theme").contains("success"));
        badge = $(BadgeElement.class).all().get(2);
        internalSpan = badge.$(SpanElement.class).first();
        Assert.assertTrue(internalSpan.getDomAttribute("theme").contains("error"));
        badge = $(BadgeElement.class).all().get(4);
        internalSpan = badge.$(SpanElement.class).first();
        Assert.assertTrue(internalSpan.getDomAttribute("theme").contains("contrast"));
        badge = $(BadgeElement.class).all().get(5);
        internalSpan = badge.$(SpanElement.class).first();
        Assert.assertTrue(internalSpan.getDomAttribute("theme").contains("primary"));
        badge = $(BadgeElement.class).all().get(10);
        internalSpan = badge.$(SpanElement.class).first();
        Assert.assertTrue(internalSpan.getDomAttribute("theme").contains("pill"));
        badge = $(BadgeElement.class).all().get(15);
        internalSpan = badge.$(SpanElement.class).first();
        Assert.assertTrue(internalSpan.getDomAttribute("theme").contains("small"));
        badge = $(BadgeElement.class).all().get(25);
        TestBenchElement icon = badge.$("vaadin-icon").first();
        Assert.assertEquals("lumo:clock",icon.getDomAttribute("icon"));
        badge = $(BadgeElement.class).all().get(55);
        DivElement htmlDiv = badge.$(DivElement.class).first();
        Assert.assertEquals("bold",htmlDiv.getText());
        Assert.assertEquals("700",htmlDiv.getCssValue("font-weight"));
    }

    @Test
    public void tooltipWorks() {
        BadgeElement badge = $(BadgeElement.class).first();
        Actions action = new Actions(getDriver());
        action.moveToElement(badge).perform();
        TestBenchElement tooltip = badge.$("vaadin-tooltip").first();
        waitUntil(driver -> tooltip.getDomAttribute("opened") != null);
        Assert.assertNotNull(tooltip.getDomAttribute("opened"));
        Assert.assertEquals("Correct tooltip was not found",
                "normal  text", tooltip.getText());
    }

    @Test
    public void visualScreenShotTest() throws IOException {
        Assert.assertTrue(testBench().compareScreen(
                ImageFileUtil.getReferenceScreenshotFile("badges.png")));        
    }
}
